package Lists;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class List {
	
	Node head = null; //Empty List
	
	public boolean isEmpty()
	{
		return head == null ? true : false;
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
	
	public void deleteAtBegin ()
	{
		Node temp = head;
		head = head.next;
		temp = null;
		System.gc();
	}
	
	public void deleteAtEnd ()
	{
		Node temp;
		Node pre = head;
		
		while(pre.next.next != null)
			pre = pre.next;
		
		temp = pre.next;
		pre.next = null;
		temp = null;
		System.gc();
	}
	
	public void deleteAtIndex (int index)
	{
		Node temp;
		Node pre = head;
		
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
		}		
		
	}
	
	public void inserAtBegin (Node newNode)
	{
		newNode.next = head;
		head = newNode;
	}
	
	public void insertAtEnd (Node newNode)
	{
		if(isEmpty())
		{
			head = newNode;
		}
		else
		{
			Node temp = head;
			while(temp.next != null) 
				temp = temp.next;
			
			temp.next = newNode;
		}
	}
	
	public void insertAtIndex (Node newNode, int index)
	{
		Node temp;
		Node pre = head;
		
		for(int i = 0; i < index-1; i++)
			pre = pre.next;
		
		temp = pre.next;
		pre.next = newNode;
		newNode.next = temp;
		
	}
	
	public void updateAge (int update,int index) throws IOException
	{
		Node temp = head;
		
		for(int i = 0; i < index; i++)
			temp = temp.next;
		
		temp.age = update;
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
	
	public void reverse ()
	{
		Stack tempList = new Stack ();
		Node temp = head;
		
		while(temp != null)
		{
			tempList.push(temp.clone());
			temp = temp.next;
		}
		
		while(!tempList.isEmpty())
			System.out.print(tempList.pop());
		
		head = tempList.head;
	}
	
	public void quickSort () throws IOException
	{
		if(!isEmpty())
		{
			List leftSet = new List();
			List rightSet = new List();

			Node temp = head.next;
			Node pivot = head;

			while(temp != null)
			{		
				if(temp.age < pivot.age)
					leftSet.insertAtEnd(temp.clone());
				else
					if(temp.age > pivot.age)
						rightSet.insertAtEnd(temp.clone());
									
				temp = temp.next;
			}
				
			leftSet.quickSort();
			rightSet.quickSort();
			pivot.next = rightSet.head;
			leftSet.insertAtEnd(pivot);
			head = leftSet.head;		
		}
				
	}
	
	public int binarySearch (int n, List students)  
	{
		int max = sizeList()-1, min = 0;
		int index = -1;
		
		try {
			
			while(min <= max)
			{		
				int middle = (max + min) / 2;
				
				if(n == students.getNode(middle).age)
				{
					index = middle;
					break;
				}
				else
				{
					if(n < students.getNode(middle).age)
						max = middle-1;
					else
						min = middle+1;
				}
			}
			
		}catch (Exception ex) {}
		
		return index;
	}
	
	public void updateNode (Node update, int index)
	{
		Node temp = head;
		
		for (int i = 0; i < index; i++)
			temp = temp.next;
		
		temp.name = update.name;
		temp.age = update.age;
		temp.id = update.id;
		
	}
							
	public static void main(String[] args) throws IOException {
	
		List students = new List();

		students.inserAtBegin(new Node("Julian", 28 , 593434));
		students.inserAtBegin(new Node("Diego", 22 , 593434));
		students.insertAtEnd(new Node("Paula", 21, 578890));
		students.insertAtEnd(new Node("Andres", 25, 578890));
		students.insertAtEnd(new Node("Andrea", 20, 578890));
		students.insertAtIndex(new Node("Maria", 18 , 593434), 2);
		
		students.updateAge(30, 1);
		students.updateNode(new Node("Jorge", 24, 698809), 2);
		
		students.getNode(3);
		System.out.println("Size list: "+students.sizeList());
		students.printList();
		System.out.println("-------");
		students.quickSort();
		students.printList();	
		System.out.println("Binary search: "+students.binarySearch(18, students));
		System.out.println("-------");
		System.out.println("Reverse:");
		students.reverse();

	}

}
