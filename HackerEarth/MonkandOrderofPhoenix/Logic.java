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
	
	public static void main(String[] args) {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			
			int n = Integer.parseInt(br.readLine());
			Logic arrayList [] = new Logic [n];			//Arreglo de listas de tamaño n
			
			for(int i = 0; i < n; i++)
			{
				String input [] = br.readLine().split(" ");
	
				arrayList[i] = new Logic();				//Se inicializa la lista en cada posición del arreglo
				
				for(int j = 0; j < Integer.parseInt(input[0]); j++)
					arrayList[i].insertAtEnd(new Node(Integer.parseInt(input[j+1]))); //Se ingresan los datos de ingresados por
																					  //consola en cada lista del arreglo
			}
			
			int q = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < q; i++)
			{
				String v = br.readLine();
				String input [] = v.split(" ");
				
				if(input[0].equals("1"))		
					arrayList[Integer.parseInt(input[1])-1].insertAtEnd(new Node(Integer.parseInt(input[2]))); //Se inserta un nuevo nodo	
				else																						 //dependiendo de la lista en a que se va a ingresar 		
					if(input[0].equals("0"))
						arrayList[Integer.parseInt(input[1])-1].deleteAtEnd();  //Se borra el ultimo nodo dependiendo de la lista en la que se va a quitar
					else
						if(v.equals("2"))
						{
							int min = Integer.MAX_VALUE;
							int aux = 0;
							
							for(int j = 0; j < arrayList[0].sizeList(); j++) 		//Se recorre la primera lista buscando el minimo valor 				
								if(arrayList[0].getNode(j).height < min)
								{
									min = arrayList[0].getNode(j).height;
									aux = arrayList[0].getNode(j).height;
								}
																		  																										
							for(int j = 1; j < arrayList.length; j++)				//Se compara el minimo valor con todas las demas listas
							{
								for(int k = 0; k < arrayList[j].sizeList(); k++)
								{
									if(arrayList[j].getNode(k).height == min+1)		//Si se encuentra un valor que sea una unidad mas grande que 
										min = arrayList[j].getNode(k).height;		//el valor con el que se esta comparando se toma ese como nuevo valor
								}
								
								if(aux == min)										//Si el valor "aux" es igual a el de la variable "min" es por que
								{													//no se encontro número mayor
									bw.write("NO \n");									
									break;
								}
								else
									aux = min;										//Si no el "aux" toma el valor del "min"
								
								if(j == arrayList.length-1)
									bw.write("YES \n");
							}
							
						}											  	
				
				bw.flush();
			}
			
		}catch (Exception ex) {}

	}

}
