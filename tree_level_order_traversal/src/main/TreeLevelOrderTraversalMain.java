package main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeLevelOrderTraversalMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Number of nodes: ");
		int t = scan.nextInt();

		Node root = null;

		int i = 1;
		while (t-- > 0) {
			System.out.print("Node " + i++ + ": ");
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		levelOrder(root);
	}

	public static void levelOrder(Node root) {
		if (root == null) {
			return; // If the tree is empty, nothing to print.
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node current = queue.poll(); // Dequeue the current node.
			System.out.print(current.getData() + " "); // Print the current node's data.

			// Enqueue the left child.
			if (current.getLeft() != null) {
				queue.add(current.getLeft());
			}

			// Enqueue the right child.
			if (current.getRight() != null) {
				queue.add(current.getRight());
			}
		}

	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.getData()) {
				cur = insert(root.getLeft(), data);
				root.setLeft(cur);
			} else {
				cur = insert(root.getRight(), data);
				root.setRight(cur);
			}
			return root;
		}
	}

}
