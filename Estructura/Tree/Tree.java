package Tree;

public class Tree {
	
	Node_Tree root = null;
	
	public boolean isEmpty()
	{
		return root == null ? true : false;
	}
	
	public boolean isleaf(Node_Tree node)
	{
		return (node.left == null && node.right == null) ? true: false;
	}
	
	public boolean oneChild (Node_Tree node)
	{
		return ((node.left != null && node.right == null) || (node.left == null && node.right != null)) ? true : false;
	}
	
	public Node_Tree findParent (int value)
	{
		Node_Tree parent = root;;
		Node_Tree temp = root;
		
		while(temp != null)
		{
			if(temp.value == value)
				break;
			
			if(value < temp.value)
			{
				parent = temp;
				temp = temp.left;
			}			
			else
			{
				parent = temp;
				temp = temp.right;
			}
				
		}
		
		return parent;	
	}
	
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
	
	public void delete (int value)
	{
		Node_Tree temp = root; 
		Node_Tree parent = root;
		
		while(temp != null)
		{
			if(temp.value == value)
				break;
			
			parent = temp;
			if(value < temp.value)
				temp = temp.left;
			else
				temp = temp.right;
		}
		
		if(temp == null)
			System.out.println("No existe ese nodo");
		else
		{
			if(isleaf(temp))
			{
				if(value < parent.value)
					parent.left = null;
				else
					parent.right = null;
			}
			else
			{
				if(oneChild(temp))
				{
					if(temp.left != null)
					{
						if(value < parent.value)
							parent.left = temp.left;
						else
							parent.right = temp.left;
					}
					else
					{
						if(value < parent.value)
							parent.left = temp.right;
						else
							parent.right = temp.right;
					}
					
					temp = null;
				}
				else
				{
					Node_Tree temp2 = temp.right;
					
					if(temp2.left == null)
					{
						temp2.left = temp.left;
						
						if(value < parent.value)
							parent.left = temp2;
						else
							parent.right = temp2;
					}
					else
					{
						Node_Tree temp3 = temp2.left;
						
						while(temp3.left != null)
						{
							temp2 = temp2.left;
							temp3 = temp3.left;		
						}
						
						temp2.left = null;
													
						if(value < parent.value)
						{
							temp3.left = temp.left; 
							temp3.right = temp.right;
							parent.left = temp3;
						}
						else
						{
							temp3.left = temp.left; 
							temp3.right = temp.right;
							parent.right = temp3;
						}					
					}
					
					temp = null;
				}
			}
				
		}
	}
	
	public Node_Tree search (int value)
	{
		Node_Tree temp = root; 
		
		while(temp != null)
		{
			if(temp.value == value)
				break;
			
			if(value < temp.value)
				temp = temp.left;
			else
				temp = temp.right;
		}
		
		return temp;
	}
	
	public void leftRotation(int value)
	{
		if(value == root.value)
		{
			Node_Tree temp = root.right;
			temp.left = findParent(temp.value);
			temp.left.right = null;
			root = temp;
		}
	}
	
	public void rightRotation(int value)
	{
		if(value == root.value)
		{
			Node_Tree temp = root.left;
			temp.right = findParent(temp.value);
			temp.right.left = null;
			root = temp;
		}
	}
		
	public void preorder (Node_Tree node)
	{
		if(node != null)
		{
			System.out.print(node.toString()+" ");
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	public void inorder (Node_Tree node)
	{
		if(node != null)
		{
			inorder(node.left);
			System.out.print(node.toString()+" ");
			inorder(node.right);
		}
	}
	
	public void postorder (Node_Tree node)
	{
		if(node != null)
		{
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.toString()+" ");
		}
	}

	public static void main(String[] args) {
		
		Tree tree = new Tree ();
		tree.insert(8);
		tree.insert(7);
		tree.insert(6);
		tree.rightRotation(8);
		//tree.leftRotation(10);
		System.out.println(tree.findParent(13));
		System.out.println(tree.search(2));
		System.out.println("Preorder:");
		tree.preorder(tree.root);
		System.out.println("\n"+"Postorder: ");
		tree.postorder(tree.root);
		System.out.println("\n"+"Inorder:");
		tree.inorder(tree.root);
		
	}
}
