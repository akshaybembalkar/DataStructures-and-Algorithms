/*
 * Implementation of Trie Data Structure with Creation and search operations.
 */

import java.util.*;

public class ImplementTrie {

	static TrieNode root = null;
	
	public static void main(String[] args) {
		
		root = new TrieNode();
		insert(root,"abc");
		insert(root,"abef");
		System.out.println(search(root,"abef"));
	}
	
	//If not present, inserts key into trie
	// If the key is prefix of trie node, just marks leaf node
	public static void insert(TrieNode root,String input){
		TrieNode curr = root;
		
		for(int i=0;i<input.length();i++){
			char ip = input.charAt(i);
			if(!curr.children.containsKey(ip))
				curr.children.put(ip,new TrieNode());
			
			curr = curr.children.get(ip);
		}
		curr.isCompleteWord = true;
	}
	
	//Search for a given work within created Trie.
	//Return True if string present .
	public static boolean search(TrieNode root, String ip){
		
		TrieNode curr = root;
		
		for(int i=0;i<ip.length();i++){
			char t = ip.charAt(i);
			if(!curr.children.containsKey(t))
				return false;
			curr = curr.children.get(t);
		}
		return curr.isCompleteWord && curr!=null;
	}
}

//Node for each Trie element
class TrieNode{
	Map<Character,TrieNode> children;
	boolean isCompleteWord; //isCompleteWord is true if the node represents
							//end of a word
	
	public TrieNode(){
		children = new HashMap<>();
		isCompleteWord = false;
	}
}
