
public class Queue {
	
Node head = null; //Empty List
	
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}

	public void enqueue(Node newNode)
	{
		Node temp = head;
		
		while(temp.next != null)
			temp = temp.next;
		
		temp.next = newNode;
	}
	
	public Node dequeue()
	{
		Node pre = head;
		Node temp = pre.next;
		
		while(temp.next != null)
		{
			pre = temp;
			temp = temp.next;
		}
		
		pre.next = null;
		return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
