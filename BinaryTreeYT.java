import java.util.*;
public class BinaryTreeYT {
    static class  Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data =data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree{
        static int idx=-1;

        public static Node BuildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode=new Node(nodes[idx]);
            newNode.left=BuildTree(nodes);
            newNode.right=BuildTree(nodes);

            return newNode;

        }
    }

    public static void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void InOrderTraversal(Node root){
        if(root==null){
            return;
        }
        InOrderTraversal(root.left);
        System.out.print(root.data+" ");
        InOrderTraversal(root.right);
    }

    public static void PostOrderTraversal(Node root){
        if(root==null){
            return;
        }

        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }

    public static void LevelOrder(Node root){
        if(root==null){
            return;
        }

        Queue<Node> q=new LinkedList<>();

        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode=q.remove();

            if(currNode==null){
                System.out.println();

                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data + " ");

                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }

            }
        }

    }
    public static int countOfNodes(Node root){
        if(root==null){
            return 0;
        }

        int leftNode = countOfNodes(root.left);
        int rightNode =countOfNodes(root.right);

        return leftNode+rightNode+1;
    }

    public static int SumOfNodes(Node root){
        if(root==null){
            return 0;
        }
        
        int leftSum = SumOfNodes(root.left);
        int rightSum =SumOfNodes(root.right);

        return leftSum+rightSum+root.data;
    }

    public static int height(Node root){
        if(root==null){
            return 0;
        }

        int leftheight= height(root.left);
        int rightheight = height(root.right);

        int myHeight = Math.max(leftheight, rightheight) + 1;
        return myHeight;
    }

    public static int diameterOfTree(Node root){
        if(root==null){
            return 0;
        }

        int diam1=diameterOfTree(root.left);
        int diam2=diameterOfTree(root.right);
        int diam3 =height(root.left)+height(root.right)+1;

        int diameter = Math.max(diam3, Math.max(diam1, diam2));

        return diameter;
    }

        //class for calculate height and diameter in one return type

    static class TreeInfo{
            int ht;
            int diam;

            TreeInfo(int diam,int ht){
                this.diam=diam;
                this.ht=ht;
            }
    }

    public static TreeInfo diameter2(Node root){
        if(root==null){
            return new TreeInfo(0, 0);
        }

        TreeInfo left=diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myDiameter=Math.max(Math.max(left.diam, right.diam),left.ht+right.ht+1);

        int myHeight=Math.max(left.ht, right.ht)+1;

        return new TreeInfo(myDiameter, myHeight);
    }

    public static boolean isIdentical(Node node , Node subRoot){
        if(node==null && subRoot==null){
            return true;
        }else if(node==null || subRoot == null || node.data != subRoot.data){
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }

        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }

        return true;
    }

    public static boolean isSubTree(Node root, Node subRoot){
        if(root==null){
            return false;
        }

        if(root.data == subRoot.data){

            if(isIdentical(root , subRoot)){
                return true;
            }
        }

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    //class to calculate the topView of a tree
     static class Info {
        Node node;
        int hd;

        public Info(Node node , int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public static void topView(Node root){
        //Level order Traversal
        Queue<Info> q=new LinkedList<>();
        HashMap<Integer , Node> map =new HashMap<>();

        int max=0, min=0;

        q.add(new Info(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();

            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{

                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }

                if(curr.node.left !=null){
                    q.add(new Info(curr.node.left, curr.hd-1));
                    min=Math.min(min, curr.hd-1);
                }

                if(curr.node.right!=null){
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max=Math.max(max, curr.hd+1);
                }
            }
        }

        for(int i=min ; i<=max ; i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }
        
    public static int sum=0;
    
    public static void kLevel(Node root , int level , int k){
        if(root==null){
            return;
        }

        if(level==k){
            System.out.print(root.data+" ");
            sum+=root.data;
            return;
        }

        kLevel(root.left, level+1, k);
        kLevel(root.right, level+1, k);
       
    }

    //function for lowest common ancestor

    public static boolean getPath(Node root , int n , ArrayList<Node> path){
        if(root==null){
            return false;
        }

        path.add(root);

        if(root.data ==n){
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
    public static Node lca(Node root, int n1 , int n2){
        ArrayList<Node> path1 =new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1 ,path1);
        getPath(root, n2 , path2);

        int i=0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }

        //last equal node ->i-1th
        Node lca =path1.get(i-1);
        return lca;
    }

    public static Node lca2(Node root , int n1 , int n2){
        if(root==null || root.data ==n1 || root.data ==n2){
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca =lca2(root.right, n1, n2);

        if(rightLca ==null){
            return leftLca;
        }

        if(leftLca == null){
            return rightLca;
        }

        return root;
    }

    public static int lcaDist(Node root ,int n){
        if(root==null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftDist=lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist ==-1 && rightDist==-1){
            return -1;
        }else if(leftDist==-1){
            return rightDist+1;
        }else{
            return leftDist+1;
        }
    }

    public static int minDist(Node root, int n1 , int n2){
        Node lca = lca2(root, n1, n2);

        int dist1=lcaDist(lca , n1);
        int dist2=lcaDist(lca , n2);

        return dist1+dist2;

    }

    public static int kthAncestor(Node root, int n , int k){
        if(root==null){
            return -1;
        }

        if(root.data ==n ){
            return 0;
        }

        int leftDist=kthAncestor(root.left, n, k);
        int rightDist=kthAncestor(root.right, n, k);

        if(leftDist==-1 && rightDist ==-1){
            return -1;
        }

        int max=Math.max(leftDist, rightDist);

        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;
    }
   

    public static int transform(Node root){
        if(root==null){
            return 0;
        }

        int leftChild = transform(root.left);
        int rightChild = transform(root.right);
        int data = root.data;

        int newLeftChild = root.left == null ? 0: root.left.data;
        int newRightChild = root.right==null ? 0 :root.right.data;

        root.data = newLeftChild + leftChild + newRightChild + rightChild;

        return data;
    }
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.BuildTree(nodes);

        //System.out.println(root.data);

        //preOrderTraversal(root);
        //InOrderTraversal(root);
       // PostOrderTraversal(root);
       //LevelOrder(root);
      // System.out.println("Count of Nodes is : "+countOfNodes(root));
       //System.out.println("Sum of Nodes is : "+ SumOfNodes(root));
       //System.out.println("height of Tree is : "+ height(root));
       //System.out.println("Diameter of Tree is "+ diameterOfTree(root));
        //System.out.println("Diameter of Tree {o(n)} : "+ diameter2(root).diam );


        //subTree creation
       // Node subRoot = new Node(2);
       //subRoot.left =new Node(4);
       //subRoot.right=new Node(5);
        
       //System.out.println(isSubTree(root, subRoot));

       //TopView function call
       //topView(root);

       //kth level
      /*  int k=3;
       kLevel(root, 1, k);
       System.out.println();
       System.out.println("The sum of kth Level is : "+ sum);
       */

      /*  int n1=4;
       int n2=6;
    System.out.println(lca(root, n1, n2).data);
    System.out.println(lca2(root, n1, n2).data);
        
    System.out.println(minDist(root, n1, n2));
    */

        /* int n=5;
        int k=1;
        kthAncestor(root, n, k);
        */

    transform(root);
    preOrderTraversal(root);
    }
}
