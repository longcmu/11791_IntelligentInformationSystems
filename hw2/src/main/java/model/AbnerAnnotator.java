package model;
import abner.*;

import java.lang.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.util.AbstractExternalizable;

import edu.cmu.deiis.types.NameTag;

/** AbnerAnnotator would process sentences and add features to words.
 * 
 * @author longh
 * @version 3.1 Oct 9, 2014  
 */
public class AbnerAnnotator extends JCasAnnotator_ImplBase {
	
	/** process would convert sentences into words, split ids 
	 * from sentences and call abnerNER.
	 * 
	 * @param arg0
	 * 				information input
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
			abnerNER(sentences, arg0);
	}
	
	/** abnerNER would analyze words and give confidence
	 * 
	 * @param args
	 * 				sentences to be processed
	 * @param arg0
	 * 				information input
	 * @throws AnalysisEngineProcessException
	 */
	public static void abnerNER(String[] args, JCas arg0) {
		
		HashMap<String, Double> ConfMap = new HashMap<String, Double>();
		
		/** use abner to find gene names from words */
		Tagger t = new Tagger();
		for (int i = 1; i < args.length; ++i) {
			String s = args[i];
			String[][] ents = t.getEntities(s);
			
			/** use HashMap to store words selected by Abner */
			for (int j=0; j<ents[0].length; j++) {
				ConfMap.put(ents[0][j], 1.0);
			}
		}
		
		// TODO Auto-generated method stub
		FSIterator<org.apache.uima.jcas.tcas.Annotation> ite = 
				arg0.getAnnotationIndex(NameTag.type).iterator();
		
		while (ite.hasNext()) {
			/** get the words selected by LingPipe */
			String name = ((NameTag)ite.get()).getText();
			
			/** set the confidence for words selected by both LingPipe 
			 * and Abner as 1
			 */
			if (ConfMap.containsKey(name)) {
				((NameTag)ite.get()).setConfidenceAbner(1.0);
			} else {
				((NameTag)ite.get()).setConfidenceAbner(0.0);
			}
			ite.next();
		}		
		
	}
}