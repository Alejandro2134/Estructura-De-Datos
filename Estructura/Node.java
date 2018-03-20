/**
* Esta clase representa la creacion de un objeto de tipo nodo con sus contructores y diferentes metodos 
*
*/
public class Node {
	
	public String name;
	public int age;
	public int id;
	
	public Node next;
	
	//Constructor vacio
	public Node () {}
	
	/**
	*Esta función permite crear e inicializar el constructor
	*@param name, age , id
	*/
	public Node (String name, int age, int id)
	{
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	
	public String toString ()
	{
		return "Name: "+this.name+"\tAge: "+this.age+" \tID: "+this.id+"\n";
	}
	
	public Node clone()
	{
		Node clone = new Node(this.name,this.age,this.id);
		return clone;
	}

}
