import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.util.AbstractExternalizable;

/** WordAnnotator would process sentences and add features to words.
 * 
 * @author longh
 * @version 6.7 Sept 23, 2014 
 */
public class WordAnnotator extends JCasAnnotator_ImplBase {
	
	/** spaceBetween would return the number of white spaces in string input.
	 * 
	 * @param input
	 * @return len1 - len2
	 */
	public int spaceBetween(String input) {
		int len1 = input.length();
		String input2 = input.replace(" ", "");
		int len2 = input2.length();
		return len1 - len2;
	}

	/** process would convert sentences to words, split ids from sentences
	 *  and call ConfidenceNamedEntityChunking.
	 * 
	 * @param arg0
	 * @throws AnalysisEngineProcessException
	 */
	@Override
	public void process(JCas arg0) throws AnalysisEngineProcessException {
		
		/** collect features*/
		String DocumentText = arg0.getDocumentText();
		String[] texts = DocumentText.split("\n");
		String[] sentences = new String[texts.length];
		String[] ids = new String[texts.length];
		
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
	 * count offsets, extract gene words and add features to annotation .
	 * 
	 * @param sts denote sentences
	 * @param ids
	 * @param arg0 
	 * @throws ClassNotFoundException, IOException
	 */
	public void ConfidenceNamedEntityChunking(String[] sts, String[] ids, JCas arg0) throws ClassNotFoundException, IOException{
		File modelFile = new File("/home/ronhe/git/hw1-longh/src/main/resources/data/ne-en-bio-genetag.HmmChunker");
		int MAX_N_BEST_CHUNKS = 30;
		
		/** chunker based on a HMM model */
		ConfidenceChunker chunker = (ConfidenceChunker) AbstractExternalizable.readObject(modelFile);
		for (int i = 1; i < sts.length; ++i) {
			char[] cs = sts[i].toCharArray();
			Iterator<Chunk> it = chunker.nBestChunks(cs,0,cs.length,MAX_N_BEST_CHUNKS);
			
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
				end = start + (phrase.length() - 1) - spaceBetween(phrase);
				
				/** set features */
				WordTag annotation = new WordTag(arg0);
				
				/** set confidence threshold value */
				if (conf > 0.6) {
				if (phrase.length() != 1) {
				annotation.setId(id);
				annotation.setBegin0(start);
				annotation.setEnd0(end);
				annotation.setName(phrase);
				annotation.addToIndexes();}}
			}
		}
	}	
}