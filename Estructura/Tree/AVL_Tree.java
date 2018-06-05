package Tree;

public class AVL_Tree {
	
	Node_Tree root = null;
	
	public boolean isEmpty()
	{
		return root == null ? true : false;
	}
	
	public boolean isleaf(Node_Tree node)
	{
		return (node.left == null && node.right == null) ? true : false;
	}
	
	public boolean oneChild (Node_Tree node)
	{
		return ((node.left != null && node.right == null) || (node.left == null && node.right != null)) ? true : false;
	}
	
	public int nodeHeigth (Node_Tree node)	//La altura del nodo es el número de nodos encontrados en el camino mas largo desde ese nodo hasta la hoja 
	{
		if(node == null || isleaf(node))
			return 0;
		else
		{	
			return nodeHeigth(node.left) > nodeHeigth(node.right) ? 
					 nodeHeigth(node.left) + 1 : nodeHeigth(node.right) + 1;
		}
		
	}
	
	public int unbalance_factor (Node_Tree node)
	{
		if(node.left == null && node.right != null)
			return nodeHeigth(node.left) - nodeHeigth(node.right)-1;
		else
			if(node.left != null && node.right == null)
				return nodeHeigth(node.left)+1 - nodeHeigth(node.right);
			else
				if(node.left != null && node.right != null)
					return nodeHeigth(node.left)+1 - nodeHeigth(node.right)-1;
		
		return 0;
	}
	
	public void checkNode (Node_Tree node)
	{		
		if(unbalance_factor(node) < -1)
		{
			if(unbalance_factor(node.right) == 1 )
				double_rotation_RtoL(node.right);
			else
				left_rotation(node);
		}	
		else
			if(unbalance_factor(node) > 1)
			{
				if(unbalance_factor(node.left) == -1)
					double_rotation_LtoR(node.left);
				else
					right_rotation(node);		
			}
				
		if (node != root)
			checkNode(findParent(node));	
	}
	
	public void left_rotation (Node_Tree node)
	{
		if(node.value == root.value)
		{
			if(!oneChild(node.right))
			{
				Node_Tree temp = root.right;
				Node_Tree temp2 = temp.left;
				temp.left = null;
				temp.left = findParent(temp);
				temp.left.right = null;
				temp.left.right = temp2;
				root = temp;
			}
			else
			{
				Node_Tree temp = root.right;
				temp.left = findParent(temp);
				temp.left.right = null;
				root = temp;
			}
		}
		else
		{
			if(!oneChild(node.right))
			{
				Node_Tree temp = findParent(node);
				Node_Tree temp2 = node.right;
				Node_Tree temp3 = node.right.left;
				temp2.left = findParent(temp2);
				temp2.left.right = null;
				temp2.left.right = temp3;
				
				if(node.value < temp.value)
					temp.left = temp2;
				else
					temp.right = temp2;
			}
			else
			{
				Node_Tree temp = findParent(node);
				Node_Tree temp2 = node.right;
				temp2.left = findParent(temp2);
				temp2.left.right = null;
				
				if(node.value < temp.value)
					temp.left = temp2;
				else
					temp.right = temp2;
			}	
		}
	}
	
	public void right_rotation(Node_Tree node)
	{
		if(node.value == root.value)
		{
			if(!oneChild(node.left))
			{
				Node_Tree temp = root.left;
				Node_Tree temp2 = temp.right;
				temp.right = null;
				temp.right = findParent(temp);
				temp.right.left = null;
				temp.right.left = temp2;
				root = temp;
			}
			else
			{
				Node_Tree temp = root.left;
				temp.right = findParent(temp);
				temp.right.left = null;
				root = temp;
			}	
		}
		else
		{
			if(!oneChild(node.left))
			{
				Node_Tree temp = findParent(node);
				Node_Tree temp2 = node.left;
				Node_Tree temp3 = node.right.left;
				temp2.right = findParent(temp2);
				temp2.right.left = null;
				temp2.right.left = temp3;
				
				if(node.value > temp.value)
					temp.right = temp2;
				else
					temp.left = temp2;
			}
			else
			{
				Node_Tree temp = findParent(node);
				Node_Tree temp2 = node.left;
				temp2.right = findParent(temp2);
				temp2.right.left = null;
				
				if(node.value > temp.value)
					temp.right = temp2;
				else
					temp.left = temp2;
			}
		}
	}
	
	public void double_rotation_RtoL(Node_Tree node)
	{
		if(!oneChild(node.left) || oneChild(node.left))
		{
			Node_Tree temp = findParent(node); 	   
			Node_Tree temp2 = node;    			   
			Node_Tree temp3 = node.left;   	   
			Node_Tree temp4 = temp3.right;   	 
			temp.right = null;
			temp.right = temp3;
			temp3.right = null;
			temp3.right = temp2;
			temp2.left = temp4;
			
			left_rotation(temp);
		}
		else
		{
			Node_Tree temp = findParent(node);
			Node_Tree temp2 = node.left;
			temp2.right = findParent(temp2);
			temp2.right.left = null;
			temp.right = temp2;
			
			left_rotation(temp);
		}
		
	}
	
	public void double_rotation_LtoR (Node_Tree node)
	{
		if(!oneChild(node.right) || oneChild(node.right) )
		{
			Node_Tree temp = findParent(node); 	   
			Node_Tree temp2 = node;    			   
			Node_Tree temp3 = node.right;   	   
			Node_Tree temp4 = temp3.left;   	 
			temp.left = null;
			temp.left = temp3;
			temp3.left = null;
			temp3.left = temp2;
			temp2.right = temp4;
			
			right_rotation(temp);
		}
		else
		{
			Node_Tree temp = findParent(node);
			Node_Tree temp2 = node.right;
			temp2.left = findParent(temp2);
			temp2.left.right = null;
			temp.left = temp2;
			
			right_rotation(temp);
		}
		
	}
	
	public Node_Tree findParent (Node_Tree node)
	{
		if(node == root)
			return root;
		else
		{
			Node_Tree parent = null;
			Node_Tree temp = root;
			
			while(temp != null)
			{
				if(temp.value == node.value)
					break;
				else
				{
					parent = temp;
					
					if(node.value < temp.value)
						temp = temp.left;
					else
						temp = temp.right;	
				}
			
			}
			
			if(temp == null)
				parent = null;
			
			return parent;	
		}
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
			
			checkNode(findParent(newNode));
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
		
		AVL_Tree tree =  new AVL_Tree ();
	
		//tree.insert(15);
		//tree.insert(10);
		//tree.insert(20);
		//tree.insert(5);
		//tree.insert(13);
		//tree.insert(16);
		//tree.insert(8);
		//tree.insert(11);
		//tree.insert(14);
		//tree.insert(12);
		
		//tree.insert(30);
		//tree.insert(15);
		//tree.insert(40);
		//tree.insert(10);
		//tree.insert(20);
		//tree.insert(18);
		
		//tree.insert(50);
		//tree.insert(30);
		//tree.insert(89);
		//tree.insert(29);
		//tree.insert(32);
		//tree.insert(27);
		
		tree.insert(58);
		tree.insert(66);
		tree.insert(77);
		tree.insert(57);
		tree.insert(56);
		tree.insert(59);
		tree.insert(78);
		tree.insert(79);
		tree.insert(55);
		tree.insert(80);
		tree.insert(81);
		tree.insert(82);
		
		System.out.println(tree.nodeHeigth(tree.root));
		tree.inorder(tree.root);
		
	}

}
