package com.graph.www;

public class TopoGraph {
	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVertex;
	private char sortArray[];
	
	public TopoGraph(){
		vertexList = new Vertex[MAX_VERTS];
		
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVertex = 0;
		for(int i = 0;i<MAX_VERTS;i++){
			for(int j = 0;j<MAX_VERTS;j++){
				adjMat[i][j] = 0;
			}
		}
		sortArray = new char[MAX_VERTS];
	}
	public void addVertex(char ch){
		Vertex newV = new Vertex(ch);
		vertexList[nVertex] = newV;
		nVertex++;
		//vertexList[nVertex++] = new Vertex(ch);
	}
	public void addEdge(int start,int end){
		adjMat[start][end] = 1;
	}
	public void displayVertex(int v){
		System.out.println(vertexList[v].label);
	}
	public void topo(){
		int orig_nVerts = nVertex;
		while(nVertex>0){
			int currentVetex = noSuccessors();
			if(currentVetex==-1){
				System.out.println("error:graph has cycles");
				return;
			}
			sortArray[nVertex-1] = vertexList[currentVetex].label;
			deleteVertex(currentVetex);
		}
		for(int i = 0;i<orig_nVerts;i++){
			System.out.println(sortArray[i]);
		}
	}
	private void deleteVertex(int delVetex) {
		if(delVetex!=nVertex-1){	//if not last vertex
			//如果是最后一个，不需要移动，只需要nvertex--就可以了，想了好久:)
			for(int i=delVetex;i<nVertex-1;i++){
				vertexList[i] = vertexList[i+1];
			}
			for(int row = delVetex;row<nVertex-1;row++){
				moveRowup(row,nVertex);
			}
			for(int col = delVetex;col<nVertex-1;col++){
				moveColLeft(col,nVertex-1);
			}
		}
		nVertex--;
	}
	private void moveColLeft(int col, int length) {
		for(int row = 0;row<length;row++){
			adjMat[row][col] = adjMat[row][col+1];
		}
		
	}
	private void moveRowup(int row, int length) {
		for(int col = 0;col<length;col++){
			adjMat[row][col] = adjMat[row+1][col];
		}
	}
	private int noSuccessors() {
		boolean isEdge;
		for(int row=0;row<nVertex;row++){
			isEdge = false;
			for(int col=0;col<nVertex;col++){
				if(adjMat[row][col]>0){
					isEdge = true;
					break;
				}
			}
			if(!isEdge){
				return row;
			}
		}
		return -1;
	}
	
}
