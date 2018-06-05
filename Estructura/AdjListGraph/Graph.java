package AdjListGraph;
import Lists.*;

public class Graph {
	
	public int nNodes;
	public List adjList [];
	
	public Graph () {}
	
	public Graph (int nNodes)
	{
		this.nNodes = nNodes;
		
		adjList = new List [nNodes];
		
		for(int i = 0; i < nNodes; i++)
			adjList[i] = new List();
	}
	
}
