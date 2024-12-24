public class ass1_A {

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

    public static class BinaryTree {

        static int idx = -1;
        Node root;

        // Build tree from array (pre-order)
        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // Insert a new node into the tree
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

        // Display the nodes using inorder traversal
        public static void display(Node root) {
            if (root == null) {
                return;
            }

            display(root.left);
            System.out.println(root.data);
            display(root.right);
        }

        // Find the height of the tree
        public static int height(Node root) {
            if (root == null) {
                return 0;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }

        // Display leaf nodes
        public static void leafNodes(Node root) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {  // Use && for logical AND
                System.out.print(root.data + " ");
            }

            leafNodes(root.left);
            leafNodes(root.right);
        }

        // Create a copy of the tree
        public static Node copyOfTree(Node root) {
            if (root == null) {
                return null;
            }

            Node newNode = new Node(root.data);
            newNode.left = copyOfTree(root.left);
            newNode.right = copyOfTree(root.right);

            return newNode;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert nodes into the binary tree
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        // Display the tree in Inorder Traversal
        System.out.println("Inorder Traversal:");
        tree.display(tree.root);

        // Display the depth of the tree
        System.out.println("\nDepth of the tree:");
        System.out.println(tree.height(tree.root));

        // Create and display a copy of the tree
        System.out.println("\nCopy of the tree:");
        Node copiedTreeRoot = tree.copyOfTree(tree.root);
        tree.display(copiedTreeRoot);

        // Display leaf nodes of the tree
        System.out.println("\nLeaf Nodes:");
        tree.leafNodes(tree.root);
    }
}
