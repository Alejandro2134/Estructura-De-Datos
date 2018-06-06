package DEStrangeOrder;


public class Node {
	
	public int number;
	public Node next;
	
	public Node () {}
	
	public Node (int number)
	{
		this.number = number;
	}
	
	public String toString ()
	{
		return this.number+" ";
	}

}
