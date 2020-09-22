package a.dictionary;
import java.util.Scanner;

import a.dictionary.Dictionary;

/* class to manage behavior of program
 */
public class DictionaryManagement {
	Dictionary dict;
	
	public DictionaryManagement() {
		// create dictionary
		this.dict = new Dictionary();
		
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
			 Word word = new Word(word_spell, word_meaning);
			 this.dict.dic.put(word_spell, word);
		}
		
		//turn off the scanner
		scan.close();
	}
}
