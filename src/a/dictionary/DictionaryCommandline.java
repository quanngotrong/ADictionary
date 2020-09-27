package a.dictionary;
// to use map.entry method to iterate the hashmap
import java.util.Map;
import java.util.Scanner;

// in order to run program from command line
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
	
	/*initialize the first advance dictionary
	 * it can read information from file and save it
	 * show all words and can find specified words
	 */
	public void dictionaryAdvanced() {
		String path = "assets/dictionary.txt";
		dicMan.insertFromFile(path);
		showAllWords();
		dicMan.dictionaryExportToFile();
		prefixSearch();
		dicMan.dictionaryLookup();
	}
	
	// auto-complete feature
	public void prefixSearch() {
		Scanner scanx = new Scanner(System.in);
		System.out.println("what prefix word you want to search?");
		String prefix = scanx.nextLine();
		dicMan.searchingAdvance(prefix);
//		scanx.close();
		
	}
	
	/* Initialize the app
	 * 
	 */
	public static void main(String[] args) {
		//Create an instance of dictionary command line
		DictionaryCommandline dicCom = new DictionaryCommandline();
		
		//Using the dictionary
		dicCom.dictionaryAdvanced();
	}
	
}
