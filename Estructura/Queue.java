import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Queue {
	
Node head = null; //Empty List
	
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}

	public void enqueue(Node newNode)
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
	
	public void dequeue()
	{
		Node temp = head;
		head = head.next;
		temp = null;
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
		
		Queue queue = new Queue ();
		queue.enqueue(new Node("ola", 1, 2));
		queue.enqueue(new Node("ola", 1, 2));
		queue.enqueue(new Node("ola", 1, 2));
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(new Node("ola", 1, 2));
		queue.printList();

	}

}
