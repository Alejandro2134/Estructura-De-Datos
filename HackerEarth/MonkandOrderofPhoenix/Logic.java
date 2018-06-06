package MonkandOrderofPhoenix;

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
	
	public static void main(String[] args) {
		
		
		Logic rows = new Logic ();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			
			int n = Integer.parseInt(br.readLine());
			int tam [] = new int[n];
			
			for(int i = 0; i < n; i++)
			{
				String input = br.readLine();
				String input2 [] = input.split(" ");
	
				tam[i] = Integer.parseInt(input2[0]);
				
				for(int j = 1; j <= Integer.parseInt(input2[0]); j++)
					rows.insertAtEnd(new Node(Integer.parseInt(input2[j])));			
			}
			
			int q = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < q; i++)
			{
				String v = br.readLine();
				String input [] = v.split(" ");
				
				if(input[0].equals("1"))
				{
					 if(Integer.parseInt(input[1]) == 1)
					 {
						 for(int j = 0; j < tam[0]; j++)
						 {
							 if(j == tam[0]-1)
							 {
								 rows.insertAtIndex(new Node(Integer.parseInt(input[2])), j+1);
								 tam[0] += 1;
								 break;
							 }
								
						 }
					 }
					 else
					 {
						for(int j = tam[(Integer.parseInt(input[1]))-2]; j < tam[Integer.parseInt(input[1])-2] + tam[Integer.parseInt(input[1])-1]; j++ ) 
						{
							if(j == tam[Integer.parseInt(input[1])-2] + tam[Integer.parseInt(input[1])-1]-1)
							{
								rows.insertAtIndex(new Node(Integer.parseInt(input[2])), j+1);
								tam[Integer.parseInt(input[1])-1] += 1;
								break;
							}
						}
					 }
				}
				else
					if(input[0].equals("0"))
					{
						
					}
					else
						if(v.equals("2"))
						{
							bw.write("YES");
							bw.write("\n");
						}
				
				bw.flush();
			}
			
		}catch (Exception ex) {}

	}

}
