package AdjListGraph;
import java.io.IOException;

import Lists.*;

public class UnGraph {

	static void addEdge (Graph graph, int nList , int dest ) {
		
		Node newNode = new Node(dest);
		Node newNode1 = new Node(nList);
		
		graph.adjList[nList].insertAtEnd(newNode);
		graph.adjList[dest].insertAtEnd(newNode1);	
	}
	
	 static void printGraph(Graph graph) throws IOException
	 {       
		 for(int i = 0; i < graph.nNodes; i++)
		 {
			 System.out.println("Adjacency list of node "+ i);
			 System.out.print("head");
			 
			 for(int j = 0; j < graph.adjList[i].sizeList(); j++)
				 System.out.print(" -> "+graph.adjList[i].getNode(j).value);
			   
			 System.out.println("\n");
		 }
	 }
	
	public static void main(String[] args) throws IOException {
		
        int V = 5;
        Graph graph = new Graph(V);
        
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
      
        printGraph(graph);

	}

}
