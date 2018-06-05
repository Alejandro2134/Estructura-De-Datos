
public class Graph {
	
	public int nNodes;
	public int [][] adjMatrix;
	
	public Graph () {}
	
	public Graph (int nNodes) 
	{
		this.nNodes = nNodes;
		
		adjMatrix = new int [nNodes][nNodes];
	}

}
