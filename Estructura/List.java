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
		
		for(int i = 0; i < index-1; i++)
			pre = pre.next;
		
		temp = pre.next;
		pre.next = temp.next;
		temp = null;
		System.gc();
		
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
			pre.next = pre;
		
		temp = pre.next;
		newNode.next = temp;
		pre.next = newNode;
	
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
		{
			System.out.print(tempList.pop());
		}
		
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
	
	public Node binarySearch ()
	{
		int max = sizeList()-1, min = 0;
		int middle = (max + min) / 2;
		
		while(max < min)
		{
			
			
		}
		
		return null;
	}
							

	public static void main(String[] args) throws IOException {
	
		List students = new List();

		students.inserAtBegin(new Node("Julian", 28 , 593434));
		students.inserAtBegin(new Node("Diego", 22 , 593434));
		students.insertAtEnd(new Node("Paula", 21, 578890));
		students.insertAtIndex(new Node("Maria", 18 , 593434), 1);
		students.insertAtEnd(new Node("Andres", 25, 578890));
		students.insertAtEnd(new Node("Andrea", 20, 578890));
		
		students.updateAge(18, 1);
		
		students.getNode(3);
		System.out.println(students.sizeList());
		students.printList();
		System.out.println("-------");
		students.quickSort();
		students.printList();			
	}

}
