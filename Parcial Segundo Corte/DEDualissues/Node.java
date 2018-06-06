package DEDualissues;


public class Node {

	public int num;
	
	public Node next;
	
	public Node () {}
	
	public Node (int num)
	{
		this.num = num;
	}
	
	public Node clone()
	{
		Node clone = new Node(this.num);
		return clone;
	}
}
