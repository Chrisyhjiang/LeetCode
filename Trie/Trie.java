import java.util.*;
public class Trie {
	
	TrieNode root;
	class TrieNode {

	    // R links to node children
	    private TrieNode[] links;
	    private boolean isEnd;
	    // each array represents the 26 possible characters
	    // a link is defined as 
	    public TrieNode() {
	        links = new TrieNode[26];
	    }

	    public boolean containsKey(char ch) {
	        return links[ch -'a'] != null;
	    }
	    public TrieNode get(char ch) {
	        return links[ch -'a'];
	    }
	    public void put(char ch, TrieNode node) {
	        links[ch -'a'] = node;
	    }
	    public void setEnd() {
	        isEnd = true;
	    }
	    public boolean isEnd() {
	        return isEnd;
	    }
	}
	
	
	public Trie() {
		root = new TrieNode();
    }
    // inserts word into trienode
    public void insert(String word) {
    	TrieNode node = root; 
    	
    	for(int i = 0; i < word.length(); i++) {
    		char cur = word.charAt(i);
    		if(!node.containsKey(cur)) {
    			node.put(cur, new TrieNode());
    			
    		}
    		node = node.get(cur);
    	}
    	node.setEnd();
    }
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
           char curLetter = word.charAt(i);
           if (node.containsKey(curLetter)) {
               node = node.get(curLetter);
           } else {
               return null;
           }
        }
        return node;
    }
    
    public boolean search(String word) {
    	TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
    	TrieNode node = searchPrefix(prefix);
        return node != null;
    }
	
}
