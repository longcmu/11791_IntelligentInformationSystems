package model;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.util.AbstractExternalizable;

import edu.cmu.deiis.types.NameTag;
import edu.cmu.deiis.types.SentenceTag;

/** GeneNameAnnotator would process sentences and add features to words.
 * 
 * @author longh
 * @version 3.1 Oct 9, 2014  
 */
public class GeneNameAnnotator extends JCasAnnotator_ImplBase {
	public static ConfidenceChunker chunker;
	
	/** spaceBetween would return the number of white spaces 
	 * in string input.
	 * 
	 * @param input
	 * 				the string to be analyzed
	 * @return len1 - len2
	 */
	public int spaceBetween(String input) {
		int len1 = input.length();
		String input2 = input.replace(" ", "");
		int len2 = input2.length();
		/** compute the change after replacement */
		return len1 - len2;
	}
	
	/** initialize would import modelFile */
	public void initialize(UimaContext context){
		try {
			chunker = (ConfidenceChunker) AbstractExternalizable.
				readResourceObject(GeneNameAnnotator.class, 
					(String) context.getConfigParameterValue("input"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	/** process would convert sentences into words, split ids 
	 * from sentences and call ConfidenceNamedEntityChunking.
	 * 
	 * @param arg0
	 * 				information input
	 * @throws AnalysisEngineProcessException
	 */
	@Override
	public void process(JCas arg0) throws AnalysisEngineProcessException {
		
		/** collect features */
		String DocumentText = arg0.getDocumentText();
		String[] texts = DocumentText.split("\n");
		String[] sentences = new String[texts.length];
		String[] ids = new String[texts.length];
		
		/** split sentences */
		for (int i = 0; i < texts.length; i++) {
			String[] parts = texts[i].split(" ", 2);
			ids[i] = parts[0];
			sentences[i] = parts[1];
		}
		
		try {
			ConfidenceNamedEntityChunking(sentences, ids, arg0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/** ConfidenceNamedEntityChunking would chunk sentences without ids, 
	 * count offsets, extract gene words and add features to words.
	 * 
	 * @param sts 
	 * 				denote sentences
	 * @param ids
	 * @param arg0 
	 * @throws ClassNotFoundException, IOException
	 */
	public void ConfidenceNamedEntityChunking(String[] sts, String[] ids, 
			JCas arg0) throws ClassNotFoundException, IOException{
		
		/** set the max number of chunks as 30 */
		int MAX_N_BEST_CHUNKS = 30;
		
		/** construct chunker based on a HMM model */
		for (int i = 1; i < sts.length; ++i) {
			char[] cs = sts[i].toCharArray();
			Iterator<Chunk> it = 
					chunker.nBestChunks(cs,0,cs.length,MAX_N_BEST_CHUNKS);
			
			while(it.hasNext()) {
				/** collect information */
				Chunk chunk = it.next();
				double conf = Math.pow(2.0, chunk.score());
				int start = chunk.start();
				int end = chunk.end();			
				
				String phrase = sts[i].substring(start,end);
				String id = ids[i];
				
				/** calculate offsets */
				int beginOs = spaceBetween(sts[i].substring(0, start));
				start -= beginOs;
				end = start + (phrase.length() - 1) 
						- spaceBetween(phrase);
				
				/** set features */
				NameTag annotation = new NameTag(arg0);
				
				/** add more restrictions to exclude meaningless words */
				Pattern pattern = Pattern.compile("(\\d+)|(\\d+[-]+)"
						+ "|([-]+\\d+)|(\\d+[.]+)|([.]+\\d+)|(\\d+[']+)"
						+ "|([']+\\d+)|(\\d+[.]+\\d+)|(\\d+[/]+\\d+)"
						+ "|(\\d+[%]+)");
				Matcher isNum = pattern.matcher(phrase);
				
				/** exclude one-character words 
				 * and words with unmatched () "" 
				 **/
				if (phrase.length() != 1 && !isNum.matches() 
						&& !(phrase.contains("(")^phrase.contains(")")) 
						&& !(phrase.length() - 
								phrase.replace("\"","").length() == 1)) {
					annotation.setId(id);  // add annotations to words
					annotation.setBeginPos(start);
					annotation.setEndPos(end);
					annotation.setText(phrase);
					annotation.setConfidenceLingpipe(conf);
					annotation.addToIndexes();
				}
			}
		}
	}	
}