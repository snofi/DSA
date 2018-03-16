public class IPuritan {

	public static void main(String[] args) {
		Node<String> root = createTree();
		printTree(root, " ");

	}

	private static Node<String> createTree() {
		Node<String> root = new Node<>("root");

		Node<String> node1 = root.addChild(new Node<String>("node 1"));

		Node<String> node11 = node1.addChild(new Node<String>("node 11"));
		Node<String> node111 = node11.addChild(new Node<String>("node 111"));
		Node<String> node112 = node11.addChild(new Node<String>("node 112"));

		Node<String> node12 = node1.addChild(new Node<String>("node 12"));

		Node<String> node2 = root.addChild(new Node<String>("node 2"));

		Node<String> node21 = node2.addChild(new Node<String>("node 21"));
		Node<String> node22 = node2.addChild(new Node<String>("node 22"));

    Node<String> node3 = root.addChild(new Node<String>("node 3"));

		//node3.addChildren(node2.getChildren());
		Node<String> node31 = node3.addChild(new Node<String>("node 31"));
		Node<String> node311 = node31.addChild(new Node<String>("node 311"));

    System.out.println("\n"+ "The LCA of node12 and node112 is " + (root.findLCA(node12,node112).getData()));
    System.out.println("The LCA of node1 and node22 is " + (root.findLCA(node1,node22).getData()));
    System.out.println("The LCA of node3 and node111 is " + (root.findLCA(node3,node111).getData())+"\n");

		return root;
	}

	 private static <T> void printTree(Node<T> node, String appender) {
		  System.out.println(appender + node.getData());
		  node.getChildren().forEach(each ->  printTree(each, appender + appender));
	 }
}
