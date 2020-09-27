package a.dictionary;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

import a.dictionary.Dictionary;

/* class to manage behavior of program
 */
public class DictionaryManagement {
	Dictionary dict;
	
	public DictionaryManagement() {
		// create dictionary
		this.dict = new Dictionary();
		
	}
	
	/* read file and write information into dictionary
	 * 
	 */
	public void insertFromFile(String path) {
		try {
			FileReader fr;
			try {
				fr = new FileReader(path);
			}catch(IOException e) {
				fr = new FileReader("src/assets/dictionary.txt");
			}
			BufferedReader br = new BufferedReader(fr);
			String s;
			String[] words = null;
			while((s=br.readLine()) !=null ) {
				words = s.split("\t");
				insertWord(words[0], words[1]);
				Trie.insert(words[0]);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/* find a specific word
	 * 
	 */
	public void dictionaryLookup() {
		Scanner scan = new Scanner(System.in);
		String workFind;
		Word w;
		char test[];
		while(true) {
			System.out.println("\n enter the word you searching for: ");
			workFind = scan.nextLine();
			Object wf = workFind;
			if((w=this.dict.dic.get(wf)) != null) {
				System.out.println("\nthe word: " +w.word_target+ " has the meaning is : "+ w.word_explain);
				fixWord(wf);
			}else {
				System.out.println("\nhave no word: " + wf + " in this dictionary");
			}
			
			System.out.println("\nDo you want to look for another word? Y/N");
			test = scan.next().toCharArray();
			if(test[0] == 'n'|| test[0] == 'N') {
				break;
			}
			scan.nextLine();
		}
		scan.close();
	}
	
	public void dictionaryExportToFile() {
		try {
			FileWriter myWriter = new FileWriter("dict.txt");
			String data= "";
			for(Map.Entry<String, Word> entry : dict.dic.entrySet()) {
				data+= entry.getKey() + "\t"+ entry.getValue().word_explain + "\n";
			}
			myWriter.write(data);
			myWriter.close();
			System.out.println("\nSuccessfully wrote to the file");
		}catch(IOException e) {
			System.out.println("an error occurred");
			e.printStackTrace();
		}
	}
	
	public void searchingAdvance(String prefix) {
		Trie.prefixSearch(prefix);
	}
	
	public void fixWord(Object key) {
		System.out.println("\nwhat do you want?fix word, meaning, or delete?choose f/m/d");
		Scanner scan = new Scanner(System.in);
		char answer = scan.nextLine().toCharArray()[0];
		if(answer == 'f') {
			System.out.println("fix the word");
			String newWord = scan.nextLine();
			Word w = this.dict.dic.get(key);
			Word wn = new Word(newWord, w.word_explain);
			this.dict.dic.put(newWord, wn);
			this.dict.dic.remove(key);
		}else if(answer== 'd') {
			this.dict.dic.remove(key);
		}else if(answer == 'm') {
			Word w = this.dict.dic.get(key);
			System.out.println("fix the meaning:");
			w.word_explain = scan.nextLine();
		}
		
	}
	
	/* enter words from command line
	 */
	public void insertFromCommandline() {
		//Create scanner for inserting information
		Scanner scan = new Scanner(System.in);
		
		//Enter number of words
		System.out.println("Enter the number of words you want to add ");
		int numberOfWords = scan.nextInt();
		scan.nextLine();
		
		//Insert words
		for(int i = 0; i < numberOfWords; i ++ ) {
			 //Enter word spell and meaning
			 System.out.println("Enter the word");
			 String word_spell = scan.nextLine();
			 System.out.println("Enter the word meaning:");
			 String word_meaning = scan.nextLine();
			 
			 //Store word spell and meaning in to dic
			 insertWord(word_spell.toLowerCase(), word_meaning);
			 Trie.insert(word_spell.toLowerCase());
		}
		
		//turn off the scanner
		scan.close();
	}
	
	/* store a word to memory
	 * 
	 */
	public void insertWord(String word_spell, String word_meaning) {
		Word word = new Word(word_spell, word_meaning);
		this.dict.dic.put(word_spell, word);
	}
}
