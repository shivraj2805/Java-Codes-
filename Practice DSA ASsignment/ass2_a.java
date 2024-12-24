import java.util.*;

public class ass2_a {
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

        Stack<Node> s =new Stack<>();

        for(int i=0;i<postfix.length();i++){
            char ch=postfix.charAt(i);

            //charchter or number
            if(Character.isLetterOrDigit(ch)){
                s.push(new Node(Character.toString(ch)));
            }else{

                //Operattor meand sign
                Node operatorNode=new Node(Character.toString(ch));
                operatorNode.right=s.pop();
                operatorNode.left=s.pop();
                s.push(operatorNode);
            }
        }

        return s.peek();
    }

public static  void inorderTraversal(Node root){
        if(root == null){
            return;
        }

        Stack<Node> s=new Stack<>();
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
}

public static void main(String[] args) {
    ass2_a tree=new ass2_a();

    Scanner sc =new Scanner(System.in);

    System.out.print("Enter postfix expression : ");
    String expression=sc.nextLine();

    Node root=tree.constructTree(expression);

    System.out.print("Inorder Traversal: ");
    tree.inorderTraversal(root);
}
}
