package MirrorImage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Logic {
	
	Node_Tree root = new Node_Tree(1); //árbol con 1 como raiz genérica 
	
	/**
	 * Esta función realiza la inserción de un nodo dependiendo de las instrucciones pasadas como parametro
	 * @param node
	 * @param value
	 * @param value2
	 * @param direction
	 */
	public void insert(Node_Tree node, int parent, int child1, String direction)
	{
		if(parent == root.value)								//Si el padre es igual a la raiz
		{
			Node_Tree child = new Node_Tree(child1);			//Se crea el nuevo nodo pasandole el valor de la variable pasada como parametro "child1"
			
			if(direction.equals("L"))							//Se pregunta hacia que lado se debe insertar el nodo dependiendo del parametro "direction"
				root.left = child;
			else
				if(direction.equals("R"))
					root.right = child;
		}
		else												  	//Si no
			if(node != null) 									//Caso base para realizar la recursión 
			{
				insert(node.left, parent, child1, direction);	//Se busca de forma recursiva el ultimo nodo que esta a la izquierda
				insert(node.right, parent, child1, direction);	//Se busca de forma recursiva el ultimo nodo que esta a la derecha
				
				if(node.value == parent)						//Si el ultimo nodo es igual a la variable "parent" pasada como parametro
				{
					Node_Tree child = new Node_Tree(child1);	//Se crea un nuevo nodo pasandole el valor de la variable pasada como parametro "child1"
					
					if(direction.equals("L"))				    //Se pregunta hacia que lado se debe insertar el nodo dependiendo del parametro "direction"
						node.left = child;
					else
						if(direction.equals("R"))
							node.right = child;
					
				}
						
			}		
	}
	
	public int findMirrorNode(int target, Node_Tree left, Node_Tree right) {
		
		if(left == null || right == null)	//Se verifica que el nodo a la izquiera y a la derecha no se null
			return 0;
			
		if(left.value == target)	//Si el nodo a la izquierda es la variable "target" se retorna el nodo de la derecha y viceversa
			return right.value;
		
		if(right.value == target)
			return left.value;
		
		//Si el target es un nodo externo (no tiene hijos)
		int mirrorVal = findMirrorNode(target,left.left,right.right);
		
		if(mirrorVal != 0)
			return mirrorVal;
		
		//Si el target es un nodo interno (tiene hijos a la derecha y a la izquierda)
		return findMirrorNode(target,left.right,right.left);
	}
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Logic tree = new Logic();
		
		try {
			
			String [] input = br.readLine().split(" ");
			
			for(int i = 0; i < Integer.parseInt(input[0])-1; i++)
			{
				String input2 [] = br.readLine().split(" ");											
				tree.insert(tree.root, Integer.parseInt(input2[0]), Integer.parseInt(input2[1]), input2[2]);	//Se insertan los valores en el árbol
			}
			
			for(int i = 0; i < Integer.parseInt(input[1]); i++)
			{
				int input2 = Integer.parseInt(br.readLine());	
				
				if(input2 == 1)				//Si se esta buscando la imagen espejo de la raiz 
					bw.write(1+"\n");		//Se imprime 1 ya que la imagen espejo de la raiz es la misma raiz
				else						//Si no
				{
					if(tree.findMirrorNode(input2, tree.root.left, tree.root.right) != 0)				//Se llama a la función "finMirrorNode" y si esta retorna un resultado diferente de 0							
						bw.write(tree.findMirrorNode(input2, tree.root.left, tree.root.right)+"\n");	//Se imprime el valor que retorna la función
					else																				//Si retona 0				
						bw.write(-1+"\n");																//Se imprime -1 lo cuala significa que el nodo no tiene imagen espejo					
				}
				
				bw.flush();
			}
			
			
		}catch (Exception ex) {}
		
	}

}
