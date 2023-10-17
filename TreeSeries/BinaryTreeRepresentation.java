package TreeSeries;

class Node{
	int data;
	Node left;
	Node right;
	public Node(int key){
		data = key;
	}
}

public class BinaryTreeRepresentation {

	public static void main(String[] args) {
		Node root = new Node(1);
		Node left = new Node(2);
		Node rigt = new Node(3);
		root.right.left = new Node(5);
	}
	
}
