import java.util.Scanner;
import java.util.Stack;

public class ass2_b {
    public static class Node{
        String data;
        Node left;
        Node right;

        Node(String data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static Node constructTree(String postfix){

        Stack<Node> s=new Stack<>();
        
        for(int i=0;i< postfix.length();i++){
            char ch=postfix.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                s.push(new Node(Character.toString(ch)));
            }else{
            Node newNode=new Node(Character.toString(ch));
            newNode.right=s.pop();
            newNode.left=s.pop();
            s.push(newNode);
        
        }
        }
        return s.peek();
    }

    public static void inorderTraversal(Node root){
        Stack<Node> s=new Stack<>();

        if(root==null){
            return;
        }

        Node curr=root;

        while(curr!=null || !s.isEmpty()){

            while(curr!=null){
                s.push(curr);
                curr=curr.left;
            }
            curr=s.pop();
            System.out.print(curr.data+" ");
            curr=curr.right;
        }
        System.out.println();

    }

    public static void postorderTraversal(Node root){
        if(root==null){
            return;
        }

        Stack<Node>s1 =new Stack<>();
        Stack<Node>s2 =new Stack<>();

        s1.push(root);

        while(!s1.isEmpty()){
            Node curr=s1.pop();
            s2.push(curr);

            if(curr.left!=null){
                s1.push(curr.left);
            }

            if(curr.right !=null){
                s1.push(curr.right);
            }


        }

        while(!s2.isEmpty()){
            Node curr=s2.pop();
            System.out.print(curr.data+" ");
        }

        System.out.println();
    }

    public static void preorderTravesal(Node root){
        Stack<Node> s=new Stack<>();
        if(root==null){
            return;
        }

        Node curr=root;
        s.push(curr);

        while(!s.isEmpty()){
            Node current=s.pop();
            System.out.print(current.data+" ");

            if(current.right!=null){
                s.push(current.right);
            }

            if(current.left!=null){
                s.push(current.left);
            }
        }
    }

    public static void main(String[] args) {
        ass2_b tree=new ass2_b();

        Scanner sc =new Scanner(System.in);
        
        System.out.print("Enter a postfix Expression : ");
        String postfix=sc.nextLine();

        Node root=tree.constructTree(postfix);

        System.out.print("Inorder Traversal : ");
        tree.inorderTraversal(root);

        System.out.print("Postorder Traversal : ");
        tree.postorderTraversal(root);

        System.out.print("Preorder Traversal : ");
        tree.preorderTravesal(root);

    }
}
