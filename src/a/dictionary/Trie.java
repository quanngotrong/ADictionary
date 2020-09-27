package a.dictionary;

public class Trie {
	//alphabet size
	static final int A_SIZE = 26;
	
	/*each node present for a character
	 * 
	 */
	static class TrieNode{
		TrieNode[]  childNodes = new TrieNode[A_SIZE];
		
		// is end of the word
		boolean last;
		
		// is end of the trie node
		boolean end;

		TrieNode() {
			last = false;
			end = true;
			for(int i = 0; i<A_SIZE; i++) {
				childNodes[i] = null;
			}
		}
	}
	
	// root node 
	static TrieNode root;
	
	//insert a word into trie
	static void insert(String key) {
		int level;
		int length = key.length();
		int index;
		
		TrieNode pCrawl = root;
		
		for(level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if(pCrawl.childNodes[index] == null) {
				pCrawl.end = false;
				pCrawl.childNodes[index] = new TrieNode();
				pCrawl.childNodes[index].end = true;
			}
			pCrawl = pCrawl.childNodes[index];
			
		}
		
		pCrawl.last = true;
	}
	
	// print all of the words begin with the prefix given
	static void prefixSearch(String prefix) {
		TrieNode node = root;
		boolean not_found = false;
		int level;
		int track;
		String temp_word = "";
		for(level=0; level < prefix.length(); level++) {
			track =prefix.charAt(level)- 'a';
			if(node.childNodes[track] == null){
				not_found = true;
				break;
			}
			temp_word += prefix.charAt(level);
			node = node.childNodes[track];
		}
		if(not_found) {
			System.out.println("word not found");
		}else {
			suggestions(node,temp_word);
		}
	}
	static void suggestions(TrieNode node, String temp_word) {
		if(node.last) {
			System.out.println("\n"+temp_word);
		}
		for(int i =0 ; i<A_SIZE; i++) {
			if(!node.end && node.childNodes[i] != null) {
				
				char x = Character.toChars(i+'a')[0];
				suggestions(node.childNodes[i],temp_word + Character.toString(x) );
			}
		}
	}
	
}
