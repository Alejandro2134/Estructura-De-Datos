import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Logic {

	Node head = null;
	
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
	
	public Node peek ()
	{
		Node temp = head;
		
		if(isEmpty())
			return null;
		else
			return temp;
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
	
	public static void main(String[] args) {
		
		Logic spidersQueue = new Logic();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		try {
			
			String input = br.readLine();
			String input2 = br.readLine();
			
			String[] stringinput = input.split(" ");
			String[] stringinput2 = input2.split(" ");
			
			int n = Integer.parseInt(stringinput[0]), x = Integer.parseInt(stringinput[1]), maxPower = -1, x2 = Integer.parseInt(stringinput[1]), position = 0, counter = 0;
			
			for(int i = 0; i < n; i++)
				spidersQueue.enqueue(new Node(Integer.parseInt(stringinput2[i]), i+1));
									
			for(int i = 0; i < x; i++)
			{
				if(x2 >= spidersQueue.sizeList())
					x2 = spidersQueue.sizeList();
				
				for(int j = 0; j < x2; j++)
				{
					if(spidersQueue.getNode(j).number > maxPower)
					{
						maxPower = spidersQueue.getNode(j).number;
						position = spidersQueue.getNode(j).position;
					}					
				}
				
				bw.write(position+" ");
				bw.flush();
								
				for(int j = 0; j < x2; j++)
				{
					int number = spidersQueue.peek().number;
					
					if(number != maxPower && number != 0)		
						spidersQueue.enqueue(new Node(number-1, spidersQueue.peek().position));
					
					if(number == 0 && maxPower != 0)
						spidersQueue.enqueue(new Node(number, spidersQueue.peek().position));
					
					if(number == maxPower)
					{	
						if(counter != 0)
							spidersQueue.enqueue(new Node(number-1, spidersQueue.peek().position));
						
						counter += 1;
					}
					
					if(maxPower == 0)
					{
						spidersQueue.dequeue();
						
						for(int k = 0; k < spidersQueue.sizeList(); k++)
						{
							spidersQueue.enqueue(new Node(spidersQueue.getNode(k).number, spidersQueue.peek().position));
							spidersQueue.dequeue();
						}
												
						break;
					}
					
					spidersQueue.dequeue();
				}
				
				counter = 0;
				maxPower = -1;
			}
										
		}catch (Exception ex) {}
		
	}

}
