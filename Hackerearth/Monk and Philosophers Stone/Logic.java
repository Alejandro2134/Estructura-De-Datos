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
	
	public int peek ()
	{
		if(isEmpty())
			return -1;
		else
			return head.number;
	}
	
	public void push(Node newNode)
	{
		newNode.next = head;
		head = newNode;
	}
	
	public Node pop()
	{
		Node temp = head;
		head = head.next;
		return temp;
	}
			
	public static void main(String[] args) {
		
		Logic harrybag = new Logic();
		Logic monkbag = new Logic();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try
		{
			int n = Integer.parseInt(br.readLine()), counter = 0;
			String input = br.readLine();
			String input2 = br.readLine();
			
			String[] stringinput = input.split(" ");
			String[] stringinput2 = input2.split(" ");
			
			for(int i = n-1; i >= 0; i--)
				harrybag.push(new Node(Integer.parseInt(stringinput[i])));
					
			int q = Integer.parseInt(stringinput2[0]), x = Integer.parseInt(stringinput2[1]);
	
			for(int i = 0; i < q; i++)
			{
				String instruction = br.readLine();
				if(instruction.equals("Harry"))
				{
					monkbag.push(new Node(harrybag.peek()));
					harrybag.pop();
					
					counter += monkbag.peek();
					
					if(counter == x)
						break;
				}
				else
					if(instruction.equals("Remove"))
					{
						
						counter -= monkbag.peek();
						monkbag.pop();
					
						if(counter == x)
							break;
					}
					
			}
				
			if(counter == x)
				bw.write(monkbag.sizeList()+" ");
			else
				bw.write(-1+" ");
	
			bw.flush();
			
		}catch (Exception ex) {}
	
	}

}
