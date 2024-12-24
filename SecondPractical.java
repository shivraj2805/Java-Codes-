import java.util.*;

class Node {
    char data;
    Node left;
    Node right;

    Node(char val) {
        this.data = val;
        left = right = null;
    }
}

public class SecondPractical {
    
    public static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    public static String postfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (char ch : infix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // pop '('
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static Node construct(String postfix) {
        Stack<Node> stack = new Stack<>();

        for (char ch : postfix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                stack.push(new Node(ch));
            } else {
                Node rightNode = stack.pop();
                Node leftNode = stack.pop();
                Node newNode = new Node(ch);
                newNode.left = leftNode;
                newNode.right = rightNode;
                stack.push(newNode);
            }
        }

        return stack.pop();
    }

    public static void inorder(Node root) {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " ");

            current = current.right;
        }
    }

    public static void preorder(Node root) {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.data + " ");

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infix, c = "";

        while (!c.equals("exit")) {
            System.out.print("Enter an expression: ");
            infix = sc.nextLine();

            String postfix = postfix(infix);
            System.out.println("Postfix Expression: " + postfix);

            Node root = construct(postfix);

            System.out.print("In-order Traversal of the Expression Tree: ");
            inorder(root);
            System.out.println();

            System.out.print("Pre-order Traversal of the Expression Tree: ");
            preorder(root);
            System.out.println();

            System.out.println("Enter 'exit' to exit or any key to continue:");
            c = sc.nextLine();
        }

        sc.close();
    }
}
