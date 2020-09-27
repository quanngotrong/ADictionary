package a.dictionary;
import java.util.*;

import a.dictionary.Word;
import a.dictionary.Trie;


public class Dictionary {
	HashMap<String, Word> dic;
	
	//Create a trie for prefix searching 
	Trie trie;
	
	public Dictionary() {
		dic = new HashMap<String, Word>();
		trie = new Trie();
		
		//create trie root
		Trie.root = new Trie.TrieNode();
	}
	
}
