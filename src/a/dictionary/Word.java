package a.dictionary;

/* class to store information of the word inserted
 *  
 */
public class Word {
	// spelling of the word
	String word_target;
	// meaning of the word
	String word_explain;
	
	/*
	 * Create word with spelling and meaning 
	 */
	public Word(String word_target, String word_explain) {
		this.word_explain = word_explain;
		this.word_target = word_target;
	}
	
}
