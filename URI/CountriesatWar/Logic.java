package CountriesatWar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Logic {
	/**
	 * Función que agrega un nuevo vertice en el grafo 
	 * @param graph
	 * @param inicio
	 * @param dest
	 * @param hour
	 */
	static void addEdge (Graph graph, int inicio, int dest, int hour)
	{
		graph.adjMatrix[inicio][dest] = hour;
	}
		
	/**
	 * Funcion que calcula la minima distancia de un nodo a otro 
	 * @param graph
	 * @param dist
	 * @param sptSet
	 * @return int
	 */
	static int minDistance(Graph graph, int dist[], boolean sptSet[])
    {
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < graph.nNodes; v++)
        	 if (sptSet[v] == false && dist[v] <= min)
             {
                 min = dist[v];
                 min_index = v;
             }
       
        return min_index;
    }
 
    /**
     * Función que implementa el algoritmo dijkstra para encontrar el camino mas corto de un punto a otro en un grafo
     * @param graph
     * @param src
     * @param dest
     * @return int[]
     */
    static int[] dijkstra(Graph graph, int src, int dest)
    {
        int dist[] = new int[graph.nNodes]; //Guarda la distancia mas corta desde src hasta el destino
                             
        boolean sptSet[] = new boolean[graph.nNodes]; //Sera true si el vertice dest esta incluido en el camino mas corte del árbol
 
        // Se inicializa el arreglo dist con valores infinitos
        for (int i = 0; i < graph.nNodes; i++)
            dist[i] = Integer.MAX_VALUE;
        
        // Distancia de src a el mismo es siempre 0
        dist[src] = 0;
 
        // Encunetra el camino mas corto para todos los nodos 
        for (int count = 0; count < graph.nNodes-1; count++)
        {
            // Se calcula la distancia minima de los nodos que
            // no han sido procesados 
            int u = minDistance(graph, dist, sptSet);
 
            // Se marca el nodo como procesado
            sptSet[u] = true;
            
            // Actualiza el valor de distanca de los nodos adyacentes de el 
            // nodo escogido.
            for (int v = 0; v < graph.nNodes; v++)
 
                // Actualiza dist[v] solo si no esta en sptSet
                if (!sptSet[v] && graph.adjMatrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph.adjMatrix[u][v] < dist[v])
                	if(graph.adjMatrix[u][v] != 0 && graph.adjMatrix[v][u] != 0)
                		dist[v] = 0;
                	else
                		dist[v] = dist[u] + graph.adjMatrix[u][v];
        }
        
        return dist; //Se retorna el arreglo con las distancias
        
    }
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			
			String input [] = br.readLine().split(" ");
			
			while(!input[0].equals("0") && !input[1].equals("0")) 
			{
				Graph graph = new Graph (Integer.parseInt(input[0]));
				
				for(int i = 0; i < Integer.parseInt(input[1]); i++)
				{
					String input1 [] = br.readLine().split(" ");
					addEdge(graph,Integer.parseInt(input1[0])-1,Integer.parseInt(input1[1])-1,Integer.parseInt(input1[2]));	 //Se llena el grafo con los valores ingresados por consola
				}
				
				int k = Integer.parseInt(br.readLine());
				
				for(int i = 0; i < k; i++)
				{
					String input1[] = br.readLine().split(" ");
					
					if(graph.adjMatrix[Integer.parseInt(input1[0])-1][Integer.parseInt(input1[1])-1] != 0 				//Si hay dos nodos conectados entre ellos se imprime 0
							&& graph.adjMatrix[Integer.parseInt(input1[1])-1][Integer.parseInt(input1[0])-1] != 0)
						bw.write(0+"\n");
					else
					{
						int counter = 0;
						int [] path = dijkstra(graph, Integer.parseInt(input1[0])-1, Integer.parseInt(input1[1])-1);	//Se guarda el arreglo con el camino a ese nodo
						
						for(int j = 0; j < path.length; j++)
						{
							if(path[j] != Integer.MAX_VALUE)	//Si alguna posición del arreglo es el mayor valor significa que no hay camino para ir a ese nodo si no se va sumando ese camino
								counter += path[j];
							else
								break;
						}
						
						if(counter == 0)	//Si el contador es 0 es por que no es posible entregar la carta
							bw.write("Nao e possivel entregar a carta \n");
						else  //Si no
							bw.write(counter+"\n"); //Se imprime la variable contador
						
					}
	
				}
				
				bw.write("\n");
				bw.flush();
				input = br.readLine().split(" ");
			}
			
			
		}catch (Exception ex) {}

	}

}
