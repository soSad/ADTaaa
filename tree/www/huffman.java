package com.tree.www;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class huffman {
	
	//����map����һ�����ȼ�����
	public PriorityQueue<Node> mapToQueue(HashMap<Character,Integer > map){
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		if(map!=null){
			Set<Character> set = map.keySet();
			for(Character c:set){
				Node node = new Node();
				node.cData = c;
				node.iData = map.get(c);
				queue.add(node);
			}
		}
		return queue;
	}
	//�������ȼ����У�����huffman��
	public Node queueToTree(PriorityQueue<Node> queue){
		if(queue.size()>1){
			Node n1 = queue.poll();
			Node n2 = queue.poll();
			Node newNode = new Node(n1.iData+n2.iData);
			newNode.leftChild = n1;
			newNode.rightChild = n2;
			n1.type = "0";
			n2.type = "1";
			queue.add(newNode);
		}
		return queue.poll();
	}
	//���ݴ���Ľڵ������
	public void ergodicTree(Node node){
		if(node!=null){
			System.out.println(node.iData);
			ergodicTree(node.leftChild);
			ergodicTree(node.rightChild);
		}
	}
	//����huffman������huffman����
	public HashMap<Character, String> treeToHuffman(Node root){
		HashMap<Character, String> hfmMap = new HashMap<>();
		getHuffmanCode(root,"",hfmMap);
		return hfmMap;
		
	}
	private void getHuffmanCode(Node node, String code, HashMap<Character, String> hfmMap) {
		if(node!=null){
			code += node.type;
			if(node.leftChild==null && node.rightChild==null)
				hfmMap.put(node.cData, code);
			
			getHuffmanCode(node.leftChild, code, hfmMap);
			getHuffmanCode(node.rightChild, code, hfmMap);
		}
		
	}
}
