package consumers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import model.GeneNameAnnotator;

import org.apache.uima.UimaContext;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.FileUtils;

import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.util.AbstractExternalizable;

import edu.cmu.deiis.types.NameTag;

/** CasConsumer would use tags and features to write output file, 
 * evaluate and print precision, recall and F-1 measure.
 * 
 * @author longh
 * @version 3.1 Oct 9, 2014  
 */
public class CasConsumer extends CasConsumer_ImplBase {
	StringBuffer report = new StringBuffer();
	String result;
	String testRecall;
	int count = 0;
	File sampleOut;
	File hw2longhOut;
	
	/** initialize would read file from assigned path. */
	public void initialize(){
		sampleOut 
			= new File((String) getConfigParameterValue("sampleOut"));
        hw2longhOut 
        	= new File((String) getConfigParameterValue("hw2longhOut"));
	}
	
	/** CasConsumer would use tags and features to write output file, 
	 * evaluate and print precision, recall and F-1 measure.
	 * 
	 * @param arg0
	 * 				information input
	 * @throws ResourceProcessException
	 */
	@Override
	public void processCas(CAS arg0) throws ResourceProcessException {
		/** set parameters: shreshold and AbnerConf */
		double shreshold = 0.9;
		double AbnerConf = 0.5;
		
		/** convert type of arg0 */
		JCas jcas = null;
		try {
			jcas = arg0.getJCas();
		} catch (CASException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// TODO Auto-generated method stub
		FSIterator<org.apache.uima.jcas.tcas.Annotation> ite = 
				jcas.getAnnotationIndex(NameTag.type).iterator();
		
		/** collect processed information  from NameTag annotations*/
		while (ite.hasNext()) {
			/** collect features */
			String id = ((NameTag)ite.get()).getId();
			int begin = ((NameTag)ite.get()).getBeginPos();
			int end = ((NameTag)ite.get()).getEndPos();
			String name = ((NameTag)ite.get()).getText();
			Double ConfA = ((NameTag)ite.get()).getConfidenceAbner();
			Double ConfL = ((NameTag)ite.get()).getConfidenceLingpipe();
			
			/** the requirement for output */
			if (ConfA*AbnerConf + ConfL > shreshold) {
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
			}
			ite.next();
		}
		
		result = report.toString();
		
		/** for computing precision and recall */
		/*try {
			testRecall = FileUtils.file2String(sampleOut);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

		/** split strings from file into sentences */
		 /*String[] resultSplit = result.split("\n");
		 String[] recallSplit = testRecall.split("\n");
		 PrecisionRecallCalculator (recallSplit,resultSplit);*/
	        
	        /** make sure no conflict */
	        /*if (hw2longhOut.exists()) {
	        	hw2longhOut.delete();
	        }*/

	        try {
	        	/** write file */
	            BufferedWriter bw1 = 
	            	new BufferedWriter(new FileWriter(hw2longhOut, true));
	            bw1.write(report.toString());
	            bw1.flush();
	            bw1.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	}
	
	/** PrecisionRecallCalculator would calculate precision, 
	 * recall and F-1 measure.
	 * 
	 * @param recallSplit 
	 * 						processed data for calculate
	 * @param resultSplit 
	 * 						processed data for calculate
	 */
	public void PrecisionRecallCalculator 
	(String[] recallSplit, String[] resultSplit) {
		
		/** use HashMap to save compare strings */
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int hit = 0;
		float recall = 0;
		float precision = 0;
		
		/** put strings into HashMap */
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
		System.out.println();
		System.out.println("===========================================");
		System.out.println();
		
		System.out.println("Precision is "+hit+" / "+count+" = "
		+precision+"%");
		System.out.println();
		
		recall = (float)hit / (float)recallSplit.length * 100;
		System.out.println("Recall is "+hit+" / "+recallSplit.length
				+" = "+recall+"%");
		System.out.println();
		
		float f1 = (2 * precision * recall) / (precision + recall) / 100;
		
		System.out.println("F-1 Measure is "+f1);
		System.out.println();
		System.out.println("===========================================");
		System.out.println();
	}
}