
public class Stack {
	
	Node head = null; //Empty List
	
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}

	public void push(Node newNode)
	{
		newNode.next = head;
		head = newNode;
	}
	
	public Node pop()
	{
		Node temp = head;
		head = head.next;
		return temp;
	}
	
	public static void main(String[] args) {
		
		Stack students = new Stack();
		
		students.push(new Node("Paula", 22, 565352));
		students.push(new Node("Juan", 25, 456987));
		students.push(new Node("Pedro", 27, 897654));
		
		System.out.println(students.pop().toString());
		System.out.println(students.pop().toString());
		
	}

}
