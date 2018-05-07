
public class DoublyCircularLinkedList {
	
	Node head = null; //Empty list
	
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}
	
	public void insertAtEnd (Node newNode)
	{
		if(isEmpty())
		{
			head = newNode;
			newNode.next = head;
			newNode.prev = head;
		}
		else
		{
			Node temp = head;
			while(temp.next != head) 
				temp = temp.next;
			
			temp.next = newNode;
			newNode.prev = temp;
			newNode.next = head;
			head.prev = newNode;
			
		}
	}

	public static void main(String[] args) {
	
		DoublyCircularLinkedList doublycircularlinkedlist = new DoublyCircularLinkedList ();
		doublycircularlinkedlist.insertAtEnd(new Node("Daniel", 26, 596604));
		doublycircularlinkedlist.insertAtEnd(new Node("Andres", 30, 569987));
		doublycircularlinkedlist.insertAtEnd(new Node("Jorge", 30, 569987));
		doublycircularlinkedlist.insertAtEnd(new Node("Fabian", 30, 569987));
	}

}
