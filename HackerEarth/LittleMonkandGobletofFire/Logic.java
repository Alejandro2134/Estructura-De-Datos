package LittleMonkandGobletofFire;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Logic {

	Node head = null;
	
	public Node peek ()
	{
		Node temp = head;
		
		if(isEmpty())
			return null;
		else
			return temp;
	}
		
	public boolean isEmpty()
	{
		return head == null ? true : false;
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
	
	public void deleteAtBegin ()
	{
		Node temp = head;
		head = head.next;
		temp = null;
		System.gc();
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
	
	public static void main(String[] args) {
		
		Logic studentsQueue = new Logic();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try{
			
			int q = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < q; i++)
			{	
				String input = br.readLine();
				String [] input2 = input.split(" ");
				
				if(input2[0].equals("E"))
				{	
					if(studentsQueue.isEmpty()) //Si la lista esta vacia simplemente se agrega el nuevo nodo
						studentsQueue.insertAtEnd(new Node(Integer.parseInt(input2[1]), Integer.parseInt(input2[2])));
					else //Si no se rrecorre toda la lista de atras hacia adelante
					{
						for(int j = studentsQueue.sizeList()-1; j >= -1; j--) 
						{
							if(Integer.parseInt(input2[1]) == studentsQueue.getNode(j).number && j != -1) //Se pregunta si el dato que se encuentra en la variable "number" del nodo ingresado es igual a algun nodo de la lista	  
							{
								if(j == studentsQueue.sizeList()-1) //Si el valor es igual al ultimo nodo que esta en la lista simplemente se hace una operación de insertar al final
								{
									studentsQueue.insertAtEnd(new Node(Integer.parseInt(input2[1]),Integer.parseInt(input2[2])));
									break; //Se rompe el ciclo
								}
								else //Si el valor al que es igual no es el del ultimo nodo de la lista se hace una operación de insertar en un indice especifico pasandole como indice el que esta despues del nodo encontrado 
								{
									studentsQueue.insertAtIndex(new Node(Integer.parseInt(input2[1]),Integer.parseInt(input2[2])), j+1);	
									break;// Se rompe el ciclo
								}
								
							}	
							
							if(j == -1)	// Si el for llega hasta el numero -1 significa que ningun nodo tiene el mismo valor que el nuevo nodo ingresado por lo tanto se hace una operación de insertar al final
							{
								studentsQueue.insertAtEnd(new Node(Integer.parseInt(input2[1]), Integer.parseInt(input2[2])));
								break; //Se rompe el ciclo
							}
										
						}	
					}
				}
				else
					if(input.equals("D"))
					{
						bw.write(studentsQueue.peek().number+" "+studentsQueue.peek().rollNumber); //Imprime los datos del primer nodo de la lista
						bw.write("\n");
						studentsQueue.deleteAtBegin(); //Elimina el primer nodo de la lista
					}
				
				bw.flush();	
			
			}
						
		}catch(Exception ex) {}

	}

}
