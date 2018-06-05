import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Logic {
	
	Node_Tree root = null;
	
	public boolean isEmpty()
	{
		return root == null ? true : false;
	}
	
	/**
	 * Funcion que retorna true o false dependiendo de si el valor que se le pasa como parametro ya esta en el ábol si el nodo no esta lo inserta en el árbol
	 * @param value
	 * @return boolean
	 */
	public boolean twoEqualNodes (int value)
	{
		Node_Tree temp = root;
		
		while(temp != null)
		{
			if(temp.value == value)
				return true;
			
			if(value < temp.value)
				temp = temp.left;
			else
				temp = temp.right;	
		}
		
		insert(value);
		return false;
	}
	
	/**
	 * Dunción que inserta un nuevo nodo en el árbol
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
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			
			int t = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < t; i++)
			{
				Logic tree = new Logic();
				
				String [] input = br.readLine().split(" ");
				String [] input2 = br.readLine().split(" ");
				
				for(int j = 0; j < Integer.parseInt(input[0]); j++)	//Se ingresan los n nodos que ya estan por defecto
					tree.insert(Integer.parseInt(input2[j]));
				
				for(int j = Integer.parseInt(input[0]); j < Integer.parseInt(input[1]) + Integer.parseInt(input[0]); j++)	//Se ingresan los nuevos nodos y a medida en que se ingresan se 
				{																											//va mirando si ya estan en el árbol
					if(tree.twoEqualNodes(Integer.parseInt(input2[j])))	//Si ya estan en el árbol se imprime "YES"
						bw.write("YES"+"\n");
					else							//Si no estan en el árbol se imprime "NO" y se insertan en el árbol
						bw.write("NO"+"\n");
				}
				
				bw.flush();
			}
			
		}catch (Exception ex) {}

	}

}
