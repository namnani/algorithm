class BST3{
	class Node{
		int data;
		Node left, right;
		Node(int data){this.data = data;}
	}
	Node root;
	public void insert(int data){
		root = insert(root,data);
	}
	public Node insert(Node root,int data){
		if(root == null){
			root = new Node(data);
			return root;
		}
		if(data < root.data){
			root.left = insert(root.left, data);
		} else if(data > root.data){
			root.right = insert(root.right, data);
		}
		return root;
	}
	
	public Node search(Node root, int data){
		if(root == null || data == root.data) return root;
		if(data<root.data) return search(root.left, data);
		else return search(root.right, data);
	}
	
	public void inorder(){
		inorder(root);
		System.out.println();
	}
	
	public void inorder(Node root){
		if(root!=null){
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	
	public void preorder() {
		preorder(root);
		System.out.println();
	}
	public void preorder(Node root) {
		if(root!=null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void delete(int data){
		root = delete(root,data);
	}
	public Node delete(Node root, int data){
		if(root == null) return root;
		if(data < root.data){
			root.left = delete(root.left, data);
		} else if(data > root.data){
			root.right = delete(root.right, data);
		} else{
			//단말노드일때(leaf 노드일때)
			if(root.left == null && root.right == null) return null;
			else if(root.left == null) return root.right;
			else if(root.right == null) return root.left;
			
			root.data = findMin(root.right);
			root.right = delete(root.right, root.data);
		}
		return root;
	}
	
	public int findMin(Node root){
		int min = root.data;
		while(root.left != null){
			min = root.left.data;
			root = root.left;
		}
		return min;
	}
}
