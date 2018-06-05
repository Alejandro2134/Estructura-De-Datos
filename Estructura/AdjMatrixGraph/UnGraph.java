package AdjMatrixGraph;

public class UnGraph {
	
	static void addEdge (Graph graph, int in, int dest)
	{
		graph.adjMatrix[in][dest] = 1;
		graph.adjMatrix[dest][in] = 1;
	}
	
	static void printGraph (Graph graph)
	{
		for(int i = 0; i < graph.nNodes; i++)
		{
			for(int j = 0; j < graph.nNodes; j++)
			{
				System.out.print(graph.adjMatrix[i][j]+" ");
			}
			
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		
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
