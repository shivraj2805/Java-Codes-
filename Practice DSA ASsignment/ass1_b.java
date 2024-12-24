import java.util.LinkedList;
import java.util.Queue;

public class ass1_b {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Insert
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Inorder Traversal
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Delete
    public static Node delete(Node root, int data) {
        if (root == null) {
            return null;
        }

        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            // Case 1: Leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: Single child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data); // Remove Inorder Successor
        }
        return root;
    }

    // Find Inorder Successor
    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Search
    public static boolean search(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (data < root.data) {
            return search(root.left, data);
        } else if (data > root.data) {
            return search(root.right, data);
        }
        return true; // Found
    }

    // BFS Level-wise Traversal
    public static void bfs(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.remove();
                System.out.print(curr.data + " ");

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            System.out.println(); // Move to the next level
        }
    }

    public static void main(String[] args) {
        Node root = null;

        // Insert nodes into the tree
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);

        // Inorder Traversal
        System.out.println("Inorder Traversal:");
        inorder(root);
        System.out.println();

        // BFS Traversal
        System.out.println("Level-wise Traversal:");
        bfs(root);

        // Search
        System.out.println("\nSearching for 40:");
        System.out.println(search(root, 40) ? "Found" : "Not Found");

        // Delete a node
        System.out.println("\nDeleting 50:");
        root = delete(root, 50);

        // Inorder after Deletion
        System.out.println("Inorder Traversal After Deletion:");
        inorder(root);
        System.out.println();
    }
}
