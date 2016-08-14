package com.graph.www;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private Stack<Integer> stack;
	private Queue<Integer> queue;
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int i = 0;i<MAX_VERTS;i++){
			for(int j = 0;j<MAX_VERTS;j++){
				adjMat[i][j] = 0;
			}
		}
		stack = new Stack<>();
		queue = new LinkedList<>();
	}
	public void addVertex(char lab){
		vertexList[nVerts++] = new Vertex(lab);
	}
	public void addEdge(int start,int end){
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	public void displayVertex(int v){
		System.out.println(vertexList[v].label);
	}
	//depth-first search
	public void dfs(){
		vertexList[0].wasVisited = true;
		displayVertex(0);
		stack.push(0);
		
		while(!stack.isEmpty()){
			int v = getAdjUnvisitedVertex(stack.peek());
			if(v==-1)
				stack.pop();
			else{
				vertexList[v].wasVisited = true;
				displayVertex(v);
				stack.push(v);
			}
		}
		for(int i = 0;i<nVerts;i++){
			vertexList[i].wasVisited = false;
		}
	}
	private int getAdjUnvisitedVertex(int v) {
		for(int i = 0;i<nVerts;i++){
			if(adjMat[v][i]==1 && vertexList[i].wasVisited==false)
				return i;
		}
		return -1;
	}
	//breadth-first search
	public void bfs(){
		vertexList[0].wasVisited = true;
		displayVertex(0);
		queue.add(0);
		int v2;
		
		while(!queue.isEmpty()){
			int v1 = queue.remove();
			while((v2 = getAdjUnvisitedVertex(v1))!=-1){
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				queue.add(v2);
			}
		}
		for(int i =0;i<nVerts;i++){
			vertexList[i].wasVisited = false;
		}
	}
}
