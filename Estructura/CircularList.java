import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CircularList {

	Node head = null; //Empty list
	
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}
	
	public Node getNode (int index) throws IOException
	{

		if(sizeList() < index)
			return null;
		else
		{
			Node temp = head;
			for(int i = 0; i < index; i++)
				temp = temp.next;
			
			return temp;
		}
		
	}
	
	public void insertAtIndex (Node newNode, int index)
	{
		Node temp;
		Node pre = head;
		
		for(int i = 0; i < index-1; i++)
			pre.next = pre;
		
		temp = pre.next;
		newNode.next = temp;
		pre.next = newNode;
	
	}
	
	public int sizeList ()
	{
		int counter = 1;
		
		Node temp = head;
		while(temp.next != head) 
		{
			temp = temp.next;
			counter += 1;
		}
		return counter;
	}
	
	public void deleteAtIndex (int index)
	{
		Node temp;
		Node pre = head;
		Node temp2 = head;
		
		if(index != 0)
		{
			for(int i = 0; i < index-1; i++)
				pre = pre.next;
			
			temp = pre.next;
			pre.next = temp.next;
			temp = null;
			System.gc();
		}
		else
		{
			head = pre.next;
			pre = null;
			System.gc();
			
			while(temp2.next != head)
				temp2 = temp2.next;
			
			temp2.next = head;	
		}		
		
	}
	
	public void insertAtBegin (Node newNode)
	{
		if(isEmpty())
		{
			head = newNode;
			newNode.next = head;
		}
		else
		{
			Node temp = head;
			while(temp.next != head)
				temp = temp.next;
			
			newNode.next = head;
			head = newNode;
			temp.next = head;			
		}
		
	}
	
	public void insertAtEnd (Node newNode)
	{
		if(isEmpty())
		{
			head = newNode;
			newNode.next = head;
		}
		else
		{
			Node temp = head;
			while(temp.next != head) 
				temp = temp.next;
			
			temp.next = newNode;
			newNode.next = head;
		}
	}
	
	public void deleteAtBegin ()
	{
		Node temp = head;
		
		while(temp.next != head)
			temp = temp.next;
		
		temp.next = head.next;
		head = head.next;
		temp = null;
		System.gc();
	}
	
	public void deleteAtEnd ()
	{
		Node temp;
		Node pre = head;
		
		while(pre.next.next != head)
			pre = pre.next;
		
		temp = pre.next;
		pre.next = null;
		temp = null;
		pre.next = head;
		System.gc();
	}
	
	public void printList() throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Node temp = head;
		
		while(temp != null) {
			
			bw.write(temp.toString());
			temp = temp.next;
		}
		
		bw.flush();
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		CircularList list = new CircularList ();
		list.insertAtBegin(new Node ("Carlos", 28 , 593434));
		list.insertAtBegin(new Node ("Julian", 28 , 593434));
		list.insertAtBegin(new Node ("Andres", 28 , 593434));
		list.insertAtBegin(new Node ("Diego", 28 , 593434));
		list.insertAtBegin(new Node ("Felipe", 28 , 593434));
		list.insertAtEnd(new Node("Daniel", 12, 660982));
		System.out.println(list.sizeList());
		list.deleteAtBegin();
		list.deleteAtEnd();
		list.printList();
		

	}

}
