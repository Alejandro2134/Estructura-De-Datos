package MirrorImage;


public class Node_Tree {
	
	public int value;
	
	public Node_Tree left = null;
	public Node_Tree right = null;
	
	public Node_Tree () {}
	
	public Node_Tree (int value)
	{
		this.value = value;
	}
	
	public Node_Tree clone()
	{
		Node_Tree temp = new Node_Tree(this.value);
		return temp;
	}
	
	public String toString()
	{
		return "Valor: "+ this.value;
	}

}
