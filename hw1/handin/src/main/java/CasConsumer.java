import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.FileUtils;

/** CasConsumer would use tags and features to write output file, 
 * evaluate and print precision, recall and F-1 measure.
 * 
 * @author longh
 * @version 6.7 Sept 23, 2014 
 */
public class CasConsumer extends CasConsumer_ImplBase {
	StringBuffer report = new StringBuffer();
	String result;
	String testRecall;
	int count = 0;
	
	/** CasConsumer would use tags and features to write output file, 
	 * evaluate and print precision, recall and F-1 measure.
	 * 
	 * @param arg0
	 * @throws ResourceProcessException
	 */
	@Override
	public void processCas(CAS arg0) throws ResourceProcessException {
		/** convert type of arg0 */
		JCas jcas = null;
		try {
			jcas = arg0.getJCas();
		} catch (CASException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// TODO Auto-generated method stub
		FSIterator<Annotation> ite = jcas.getAnnotationIndex(WordTag.type).iterator();
		
		while (ite.hasNext()) {
			/** collect features */
			String id = ((WordTag)ite.get()).getId();
			int begin = ((WordTag)ite.get()).getBegin0();
			int end = ((WordTag)ite.get()).getEnd0();
			String name = ((WordTag)ite.get()).getName();

			/** organize string for output */
			report.append(id);
			report.append("|");
			report.append(begin);
			report.append(" ");
			report.append(end);
			report.append("|");
			report.append(name);
			report.append("\n");
			
			/** count the length of output string */
			count++;
			ite.next();
		}
		
		result = report.toString();
		File sampleOut = new File("src/main/resources/data/sample.out");
		try {
			testRecall = FileUtils.file2String(sampleOut);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/** split strings from file into sentences */
		String[] resultSplit = result.split("\n");
		String[] recallSplit = testRecall.split("\n");
		PrecisionRecallCalculator (recallSplit,resultSplit);
		
		/** write the output file to the project root */
		String path = "hw1-longh.out";
	        File dirFile = new File(path);
	        
	        /** make sure no conflict */
	        if (dirFile.exists()) {
	        	dirFile.delete();
	        }

	        try {
	        	/** write file */
	            BufferedWriter bw1 = new BufferedWriter(new FileWriter(path, true));
	            bw1.write(report.toString());
	            bw1.flush();
	            bw1.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	}
	
	/** PrecisionRecallCalculator would calculate precision, recall and F-1 measure.
	 * 
	 * @param recallSplit processed data for calculate
	 * @param resultSplit processed data for calculate
	 */
	public void PrecisionRecallCalculator (String[] recallSplit, String[] resultSplit) {
		
		/** use hashmap to save compare strings */
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int hit = 0;
		float recall = 0;
		float precision = 0;
		
		/** put strings into hashmap */
		for (int i = 0; i < resultSplit.length; i++) {
			map.put(resultSplit[i], i);
		}
		
		/** compare strings and count */
		for (int j = 0; j < recallSplit.length; j++) {
			if (map.containsKey(recallSplit[j])) {
				hit++;
			}
		}
		
		/** calculate and print result */
		precision = (float)hit / (float)count * 100;
		System.out.println("");
		System.out.println("       ============================================== ");
		System.out.println("       ||******for sample.in and sample.out*******|| ");
		System.out.println("       ||                                          || ");

		System.out.println("       || Precision is " + hit + " / " + count + " = " + precision + "%  ||");
		System.out.println("       ||                                          || ");
		
		recall = (float)hit / (float)recallSplit.length * 100;
		System.out.println("       ||   Recall is " + hit + " / " + recallSplit.length + " = " + recall + "%    ||");
		System.out.println("       ||                                          || ");
		
		float f1 = (2 * precision * recall) / (precision + recall) / 100;
		
		System.out.println("       ||         F-1 Measure is " + f1 + "        ||");
		System.out.println("       ||                                          || ");
		System.out.println("       ============================================== ");
		System.out.println("");
	}
}