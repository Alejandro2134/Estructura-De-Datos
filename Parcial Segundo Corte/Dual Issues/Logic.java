import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Logic {
	
	public static boolean primo (int number)
	{
		 int raizCuadrada = (int)Math.sqrt(number);
		 
		 if(number < 2)
			 return false;
		 else
		 {
			 for(int i = 2; i <= raizCuadrada; i++)
		     {
				 if((number % i) == 0)
					 return false;
		     }
		
		     return true;	     
		 }   
	} 
	
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
	
	public void quickSort () throws IOException
	{
		if(!isEmpty())
		{
			Logic leftSet = new Logic();
			Logic rightSet = new Logic();

			Node temp = head.next;
			Node pivot = head;

			while(temp != null)
			{		
				if(temp.num < pivot.num)
					leftSet.insertAtEnd(temp.clone());
				else
					if(temp.num > pivot.num)
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
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			
			int t = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < t; i++)
			{
				Logic mulPrimos = new Logic();
				int n = Integer.parseInt(br.readLine());
				int a [] = new int [n];
				String input [] = br.readLine().split(" ");
				
				for(int j = 0; j < n; j++)
					a[j] = Integer.parseInt(input[j]);					
				
				for(int j = 0; j < a.length; j++)
				{
					if(primo(a[j]))
					{
						mulPrimos.insertAtEnd(new Node(a[j] * a[j]));
						
						for(int k = j+1; k < a.length; k++)
						{
							if(primo(a[k]))
								mulPrimos.insertAtEnd(new Node(a[j] * a[k]));
						}
					}
				}
				
				if(mulPrimos.isEmpty())
					bw.write(-1+"\n");
				else
				{
					mulPrimos.quickSort();
					bw.write(mulPrimos.getNode(mulPrimos.sizeList()-1).num+"\n");
				}
				
				bw.flush();
			}
	
		}catch (Exception ex) {}

	}

}
