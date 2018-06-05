package Lists;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class DoublyLinkedList {
	
	Node head = null; //Empty list
	
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}

	public void insertAtBegin (Node newNode)
	{
		if(isEmpty())
			head = newNode;
		else
		{	
			newNode.next = head;
			head.prev = newNode;
			head = newNode;		
		}
	}
	
	public void insertAtEnd (Node newNode)
	{
		if(isEmpty())
			head = newNode;
		else
		{
			Node temp = head;
			while(temp.next != null) 
				temp = temp.next;
			
			temp.next = newNode;
			newNode.prev = temp;
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
		newNode.prev = pre;
		temp.prev = newNode;
		
	}
	
	public void deleteAtBegin ()
	{
		Node temp = head;
		head = head.next;
		temp = null;
		head.prev = null;
		System.gc();
	}
	
	public void deleteAtEnd ()
	{
		Node temp;
		Node pre = head;
		
		while(pre.next.next != null)
			pre = pre.next;
		
		temp = pre.next;
		temp.prev = null;
		pre.next = null;
		temp = null;
		System.gc();
	}
	
	public void deleteAtIndex (int index)
	{
		Node temp2;
		Node temp;
		Node pre = head;
		
		if(index != 0)
		{
			for(int i = 0; i < index-1; i++)
				pre = pre.next;
			
			temp2 = pre.next.next;
			temp = pre.next;
			pre.next = temp.next;
			temp2.prev = pre;
			temp = null;
			System.gc();
		}
		else
		{
			head = pre.next;
			pre = null;
			head.prev = null;
			System.gc();
		}		
		
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
	
	public int sizeList ()
	{
		int counter = 1;
		
		Node temp = head;
		while(temp.next != null) 
		{
			temp = temp.next;
			counter += 1;
		}
		return counter;
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
		
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertAtBegin(new Node ("Carlos", 18 , 593434));
		list.insertAtBegin(new Node ("Andres", 30 , 593434));
		list.insertAtBegin(new Node ("Danilo", 25, 593434));
		list.deleteAtIndex(1);
		list.insertAtIndex(new Node("James", 57, 596604), 1);
		list.insertAtEnd(new Node("Daniel", 19, 998877));
		list.insertAtBegin(new Node("Julian", 20, 881125));
		list.insertAtEnd(new Node("Damian", 24, 998877));
		list.deleteAtBegin();
		list.deleteAtEnd();
		list.printList();
		
		

	}

}
