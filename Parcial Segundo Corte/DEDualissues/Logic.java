package DEDualissues;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Logic {
	
	/**
	 * Funcion que realiza la operaci�n de mod para saber si un n�mero es primo o no, si la division es exacta en algun punto el n�mero no es primo, si la divisi�n no es exacta en todos los puntos significa que es primo
	 * @return boolean (true o false) dependiendo de si es primo o no
	 */
	public static boolean primo (int number)
	{
		 int raizCuadrada = (int)Math.sqrt(number);	//Se saca raiz cuadrada al numero 
		 
		 if(number < 2) //Si el numero es menir a 2 significa que no es primo 
			 return false; 
		 else // Si no
		 {
			 for(int i = 2; i <= raizCuadrada; i++) 
		     {
				 if((number % i) == 0) //Se hace la division del n�mero desde 2 has raiz de n�mero, si este resultado es exacto el n�mero no es primo
					 return false;
		     }
		
		     return true; //Si el resultado en ningun momento arroja un resultado exacto significa que el n�mero es primo	     
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
	
	/**
	 * Quicksort aplicado en listas
	 */
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
				Logic mulPrimos = new Logic();					//Creaci�n de lista vacia
				int n = Integer.parseInt(br.readLine());		
				int a [] = new int [n];							//Creaci�n de arreglo de tama�a n
				String input [] = br.readLine().split(" ");     
				
				for(int j = 0; j < n; j++)
					a[j] = Integer.parseInt(input[j]);			//Se llena el arreglo con la entrada por consola		
				
				for(int j = 0; j < a.length; j++)
				{
					if(primo(a[j]))								//Si el arreglo en su posici�n j es primo
					{
						mulPrimos.insertAtEnd(new Node(a[j] * a[j]));  //Se realiza una multiplicaci�n por si mismo y este se guarda en la lista
						
						for(int k = j+1; k < a.length; k++)		//Se buscan otros n�meros primos por el arreglo desde la posici�n j+1 hasta el final de la lista	
						{
							if(primo(a[k]))	//Si el arreglo en su posici�n k es primo  							
								mulPrimos.insertAtEnd(new Node(a[j] * a[k])); //Se multiplica el arreglo en su posici�n j por el arreglo en su posici�n k y se guarda en la lista
						}
					}
				}
				
				if(mulPrimos.isEmpty())	//Si la lista esta vacia significa que no hay n�meros primos en el arreglo 
					bw.write(-1+"\n"); //Se imprime -1
				else //Si la lista tiene algun elemento 
				{
					mulPrimos.quickSort(); //Se realiza un quicksort sobre la lista para saber cual es el n�mero mayor entre las multiplicaciones de los n�meros primos
					bw.write(mulPrimos.getNode(mulPrimos.sizeList()-1).num+"\n"); //Se imprime el ultimo nodo de la lista ya que es el n�mero mayor
				}
				
				bw.flush();
			}
	
		}catch (Exception ex) {}

	}

}
