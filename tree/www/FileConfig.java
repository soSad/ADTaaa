package com.tree.www;

import java.util.HashMap;
import java.util.PriorityQueue;

public class FileConfig {
	public static void main(String[] args){
		String s = "SUSIE SYAS IT IS EASY";
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0;i<s.length();i++){
			char temp = s.charAt(i);
			int num = 1;
			for(int j = 1;j<s.length();j++){
				if(temp == s.charAt(j))
					num++;
			}
			map.put(temp, num);
			
		}
		
		huffman huff = new huffman();
		PriorityQueue<Node> queue = huff.mapToQueue(map);
		Node tree = huff.queueToTree(queue);
		HashMap<Character, String> code = huff.treeToHuffman(tree);
		for(Character c:code.keySet()){
			
			System.out.println(code.get(c).toString());
		}
		
	}
}
