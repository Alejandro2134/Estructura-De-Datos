package AllDiscsConsidered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Logic {

	/**
	 * Función para añadir un nodo en el grafo 
	 * @param graph
	 * @param nList
	 * @param dest
	 */
	static void addEdge(Graph graph, int nList, int dest)
	{
		Node newNode = new Node(dest);

		graph.adjList[nList].insertAtEnd(newNode);
	}

	/**
	 * Funcion que srive para hacer una lista de el horden que se deben instalar los paquetes
	 * @param graph
	 * @param start
	 * @return List
	 */
	static List install (Graph graph, int start)
	{
		List installed = new List ();	//Se crea la lista
		
		Graph aux = graph.clone();		//Se crea un grafo auxiliar
		
		while(installed.sizeList() != graph.adjList.length) //Mientras que el tamaño de la lista de instalados sea diferente de el tamaño del grafo
		{
			int min = 0;
			int index = 0;
			
			for(int i = 0; i < graph.adjList.length; i++)
			{
				if(!aux.adjList[i].isEmpty())			//Se busca en cada posición de el arreglo de listas de adyacencia buscando cual no esta vacia
				{
					min = aux.adjList[i].head.value;	//Guarda el valor de la lista en una variable
					aux.adjList[i].deleteAtBegin();		//Se borra el valor de la lista auxiliar	
					index = i;							//Se guarda el indice
							
					break;
				}				
			}
			
			for(int i = min; i < graph.adjList.length; i++)					//Se recorre la lista desde la posición de la variable min
			{
				if(aux.adjList[i].sizeList() == 0 && !installed.isOn(i))	//Si la lista en su posición i es diferente de 0 y no esta en la lista de instalados
				{
					installed.insertAtEnd(new Node(i));						//Se mete la lista en su posición i 
					
					if(index < i && i < start && !installed.isOn(index))	//Si la variable indice es menor que i y y es menor que la variable start y no esta instalado
						installed.insertAtEnd(new Node(index));				//Se mete la variable indice en la lista de instalados
				}		
				else
					for(int j = 0; j < min; j++)							//Se busca que elementos faltan agrgar en la lista de instalados
						if(!installed.isOn(j))									
							installed.insertAtEnd(new Node(j));
			}
					
		}
		
		return installed;
		
	}
	
	/**
	 * 
	 * @param installed
	 * @param start
	 * @return int
	 */
	static int countDisc (List installed, int start) 
	{
		
	 	int counter = 2;
		boolean flag;										//Variable para ver si el valor esta en el primer o en el segundo disco		
		boolean[] disc = new boolean[installed.sizeList()];	//Se crea un arreglo de booleanos con el tamaño de la lista
	 	
	 	for(int i = 0; i < installed.sizeList(); i++)		//Se recorre la lista buscando si los valores se encuentran en el primer disco o en el segundo
	 	{
	 		Node node = installed.getNode(i);				//Se crea un nodo el cual contendra los diferentes valores de la lista de instalados en cada ciclo
	 		
	 		if(node.value == start)							//Y este se compara con la variable start la cual contiene el valor desde donde epmpieza el segundo disco 		
	 			flag = true;								//Por lo tanto la variable sera true ya que si es igual a la variable start esta en el segundo disco
	 		else
	 		{
	 			if(node.value < start)						//Si el valor es menor que la variable start es por que esta en el primer disco
		 			flag = false;							//Por lo tanto la variable sera false
		 		else										
		 			flag = true;							//Si el valor es mayor a la variable start la variable es true		
	 		}
	 			
	 		disc[i] = flag;									//Se va metiendo el valor de la bandera en cada posición del arreglo
	 		
	 	}
	 	
	 	for(int i = 0; i < disc.length-1; i++)				//Se recorre toda la lista de booleanos
	 	{	
	 		if(disc[i] != disc[i+1])						//Si en algun momento la posicion actual y lo que esta despues cambian es por que se hizo un cambio de disco
	 			counter++;									//Y se suma a un contador	
	 	}
	 	
		return counter;
	}

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {

			String input[] = br.readLine().split(" ");

			while (!input[0].equals("0") && !input[1].equals("0") && !input[2].equals("0")) 
			{
				Graph graph = new Graph(Integer.parseInt(input[0]) + Integer.parseInt(input[1]));

				for (int i = 0; i < Integer.parseInt(input[2]); i++) {
					String input1[] = br.readLine().split(" ");
					addEdge(graph, Integer.parseInt(input1[0]) - 1, Integer.parseInt(input1[1]) - 1);   //Se llena el grafo con la entrada por consola
				}

				bw.write(countDisc(install(graph, Integer.parseInt(input[0]) ), Integer.parseInt(input[0]))+"\n");	//Se imprime el menor numero de cambios hechos en
																													//los discos para instalar todos lo paquetes			
				bw.flush();
				input = br.readLine().split(" ");
			}
			
		} catch (Exception ex) {System.out.println(ex);}

	}

}
