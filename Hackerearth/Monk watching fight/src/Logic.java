import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Logic {
	
	Node_Tree root = null;	//Árbol vacio 
	
	/**
	 * Función que retorna true o false dependiendo de si el árbol esta vacio o no
	 * @return boolean
	 */
	public boolean isEmpty()
	{
		return root == null ? true : false;
	}
	
	/**
	 * Función que retorna true o false si el nodo pasado como parametro es una hoja
	 * @param node
	 * @return boolean
	 */
	public boolean isleaf(Node_Tree node)
	{
		return (node.left == null && node.right == null) ? true : false;
	}
	
	/**
	 * Función que retorna la altura de un nodo
	 * @param node
	 * @return int
	 */
	public int nodeHeigth (Node_Tree node)	//La altura del nodo es el número de nodos encontrados en el camino mas largo desde ese nodo hasta la hoja 
	{
		if(node == null || isleaf(node))
			return 1;
		else
		{	
			return nodeHeigth(node.left) > nodeHeigth(node.right) ? 
					 nodeHeigth(node.left) + 1 : nodeHeigth(node.right) + 1;
		}
		
	}
	
	/**
	 * Función que que sirve para insertar nodos en el árbol
	 * @param value
	 */
	public void insert(int value)
	{
		if(isEmpty())
		{
			Node_Tree NewNode = new Node_Tree(value);
			root = NewNode;		
		}
		else
		{
			Node_Tree temp = root;
			Node_Tree parent = root;
			
			while(temp != null)
			{
				parent = temp;
				if(value < temp.value)
					temp = temp.left;
				else
					temp = temp.right;
			}
			
			Node_Tree newNode = new Node_Tree(value);
			
			if(value < parent.value)
				parent.left = newNode;
			else
				parent.right = newNode;
		}
	}

	public static void main(String[] args) {
		
		try {
			
			Logic tree = new Logic();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());				//Tamaño del arreglo
			int a [] = new int [n];									//Se inicialaiza el arreglo
			String arrayElements [] = br.readLine().split(" ");		
			
			for(int i = 0; i < n; i++)
				a[i] = Integer.parseInt(arrayElements[i]);			//Se llena el arreglo
			
			for(int i = 0; i < n; i++)								//Se llena el árbol con los elementos del arreglo
				tree.insert(a[i]);
			
			bw.write(tree.nodeHeigth(tree.root)+" ");				//Se imprime la altura de la raiz
			bw.flush();
					
		}catch (Exception ex) {}

	}

}
