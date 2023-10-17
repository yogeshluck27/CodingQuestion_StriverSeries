package TreeSeries;

public class TypeOfTraversals {
	//DFS
	//Root Left Right
	void preOrder(Node node){
		
		if(node == null) return;
		
		System.out.print(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	//Left Root Right
	void inOrder(Node node){
		if(node == null) return;

		inOrder(node.left);
		System.out.print(node.data);
		inOrder(node.right);
		
	}
	//Left  Right Root
	void postOrder(Node node){
		if(node == null) return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data);
	}
	
	//BFS 
	//Level Order Traversal
	
}
