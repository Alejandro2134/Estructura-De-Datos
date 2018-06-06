package AllDiscsConsidered;



public class Node {


	public int value;
	
	public Node next;
	
	public Node () {}
	
	public Node (int value)
	{
		this.value = value;
	}
	
	public Node clone()
	{
		Node clone = new Node(this.value);
		return clone;
	}
	

}
