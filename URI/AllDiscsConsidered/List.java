package AllDiscsConsidered;


public class List {
	
	Node head = null; //Empty List
	
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}
	
	public int sizeList ()
	{
		if(isEmpty())
			return 0;
		else
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
	}
	
	public void deleteAtBegin ()
	{
		if(head == null)
			head = null;
		else
		{
			Node temp = head;
			head = head.next;
			temp = null;
			System.gc();
		}
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
	
	public Node getNode (int index) 
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
			
	public boolean isOn (int valor)
	{
		boolean flag = false;
		
		for(int i = 0; i < sizeList(); i++)
		{
			Node temp = this.getNode(i);
			
			if(temp.value == valor)
				flag = true;
		}
		
		return flag;
		
	}
	
	public int binarySearch (int n, List students)  
	{
		int max = sizeList()-1, min = 0;
		int index = -1;
		
		try {
			
			while(min <= max)
			{		
				int middle = (max + min) / 2;
				
				if(n == students.getNode(middle).value)
				{
					index = middle;
					break;
				}
				else
				{
					if(n < students.getNode(middle).value)
						max = middle-1;
					else
						min = middle+1;
				}
			}
			
		}catch (Exception ex) {}
		
		return index;
	}
	
}
