package a.dictionary;
// to use map.entry method to iterate the hashmap
import java.util.Map;
// in order to run program from commandline
import a.dictionary.DictionaryManagement;


public class DictionaryCommandline {
	//define dictionary management
	static DictionaryManagement dicMan;
	
	public DictionaryCommandline() {
		//create new instance of DictionaryManagement
		this.dicMan = new DictionaryManagement();
	}
	
	/* show the words to screen
	 * 
	 */
	public void showAllWords() {
		System.out.printf("No  |%-15s|Vietnamese","English");
						        
		// Iterating and printing out all the words
		int i =1;
		for(Map.Entry m : dicMan.dict.dic.entrySet()) {
			Word subject = (Word)m.getValue();
			System.out.printf("\n%-4d|%-15s|%s",i,m.getKey(), subject.word_explain);
			i++;
		}
	}
	
	/*Insert words from command line
	 *Print all the words into command line
	 */
	public void dictionaryBasic() {
		dicMan.insertFromCommandline();
		showAllWords();
	}
	
	/* Initialize the app
	 * 
	 */
	public static void main(String[] args) {
		//Create an instance of dictionary command line
		DictionaryCommandline dicCom = new DictionaryCommandline();
		
		//Using the dictionary
		dicCom.dictionaryBasic();
	}
	
}
