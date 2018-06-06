import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Logic {
	
	Node head = null; //Empty List
	
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
	
	public int gcd (int num, int den) 
	{
		if (num != 0)
		{
			int mcd = 0;
			int resto = 0;
			
			do {
				
				resto = num % den;
				num = den;
				
				if(resto != 0)
					den = resto;
			
				if(resto == 0)
					mcd = den;
				
			}while(resto != 0);
					
			return mcd;
		}
		
		return 1;		
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

	public static void main(String[] args) {
		
		Logic p = new Logic(); //Lista "a" vacia
		Logic a = new Logic(); //Lista "p" vacia
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int x = 0;
			int n = Integer.parseInt(br.readLine());	
			
			for(int i = n; i > 0; i--)
				p.insertAtEnd(new Node(i));	//Se llena la lista de forma en que sus valores son decrecientes	
			
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < p.sizeList(); j++)	//Ciclo que recorrer la lista "p"
				{
					if(p.getNode(j).number > x)	//Si la lista en su posición j es mayor a el valor de la variable x
					{
						x = p.getNode(j).number;	//Ahora la variable x va a tomar de valor el número mayor	
						a.insertAtEnd(new Node(x));	//Se inserta el valor de x en la lista "a"	
						p.deleteAtIndex(j); //Se elimina el nodo en la posición j de la lista "p"
					}
					
					if(p.isEmpty()) //Si la lista p queda vacia se rompe el for
						break;
				
				}
				
				if(p.isEmpty()) //Si la lista p queda vacia se rompe el for
					break;
				
				for(int j = 0; j < p.sizeList(); j++) //Ciclo que recorre la lista p
				{
					if(p.gcd(x, p.getNode(j).number) != 1)	//Se halla el maximo comun divisor de la variable x con todos los elementos de la lista "p"
					{
						a.insertAtEnd(new Node(p.getNode(j).number));	//Si el maximo comun divisor es diferente de 1 se inserta 
						p.deleteAtIndex(j); //Se elimina el nodo en la posición j de la lista "p"
						j = 0; //La variable j vuelve a tomar el valor de 0 para evitar que se quede sin hallar el maximo comun divisor a algunos elementos
						
						if(p.isEmpty()) //Si la lista p queda vacia se rompe el for
							break;
					}
				}
				
				if(p.isEmpty()) //Si la lista p queda vacia se rompe el for
					break;
				
				x = 0; // Cada que termina el ciclo la variable x vuelve a tomar el valor de 0
			}
			
			a.printList(); //Se imprime la lista a
			
		}catch (Exception ex) {}

	}

}
