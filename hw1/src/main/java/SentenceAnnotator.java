import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

/** SentenceAnnotator would process file and add features of sentences.
 * 
 * @author longh
 * @version 6.7 Sept 23, 2014 
 */
public class SentenceAnnotator extends JCasAnnotator_ImplBase {

	/** process would extract sentences from file and add features.
	 * 
	 * @param arg0
	 * @throws  AnalysisEngineProcessException
	 */
	@Override
	public void process(JCas arg0) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
		String DocumentText = arg0.getDocumentText();
		String[] sentences = DocumentText.split("\n");
		
		for (int i = 0; i < sentences.length; i++) {
			/** split sentences into id and text */
			String[] parts = sentences[i].split(" ", 2);
			String id = parts[0];
			String text = parts[1];
			
			/** set features */
			SentenceTag annotation = new SentenceTag(arg0);
			annotation.setId(id);
			annotation.setText(text);
			annotation.addToIndexes();
		}
	}
}
