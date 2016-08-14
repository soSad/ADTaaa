package com.graph.www;

public class TopoApp {
	public static void main(String[] args){
		TopoGraph topoGraph = new TopoGraph();
		topoGraph.addVertex('A');
		topoGraph.addVertex('B');
		topoGraph.addVertex('C');
		topoGraph.addVertex('D');
		topoGraph.addVertex('E');
		topoGraph.addVertex('F');
		topoGraph.addVertex('G');
		topoGraph.addVertex('H');
		
		topoGraph.addEdge(0, 3);
		topoGraph.addEdge(0, 4);
		topoGraph.addEdge(1, 4);
		topoGraph.addEdge(2, 5);
		topoGraph.addEdge(3, 6);
		topoGraph.addEdge(4, 6);
		topoGraph.addEdge(5, 7);
		topoGraph.addEdge(6, 7);
		
		topoGraph.topo();
		
	}
}
