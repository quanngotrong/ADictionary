package a.dictionary;
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
	
	public void insertFromFile(String path) {
		try {
			
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String s;
			String[] words = null;
			while((s=br.readLine()) !=null ) {
				words = s.split("\t");
				insertWord(words[0], words[1]);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
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
			 insertWord(word_spell, word_meaning);
		}
		
		//turn off the scanner
		scan.close();
	}
	
	public void insertWord(String word_spell, String word_meaning) {
		Word word = new Word(word_spell, word_meaning);
		this.dict.dic.put(word_spell, word);
	}
}
