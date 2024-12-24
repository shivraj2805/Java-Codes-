import java.util.*;

public class BST {
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
        }
    }

    public static Node insert(Node root, int val){
        if(root==null){
            root=new Node(val);
            return root;
        }

        if(root.data > val){
            //left subtree
           root.left=insert(root.left, val);
        }else{
            //right subtree
            root.right=insert(root.right, val);

        }
        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right =delete(root.right, val);
        }else if (root.data > val) {
            root.left = delete(root.left, val);         
        }else{
            //voilla ->   root.data == val

            //case 1 - leaf node
            if(root.left==null && root.right==null){
                return null;
            }

            //case 2 - one child
            if(root.left==null){
                return root.right;
            }

            if(root.right==null){
                return root.left;
            }

            //case3 -2 child

            Node IS = findInorderSuccesor(root.right);
            root.data=IS.data;
            root.right=delete(root.right, val);
        }
        return root;
    }

    public static Node findInorderSuccesor(Node root){
        while (root.left==null) {
            root=root.left;          
        }
        return root;
    }

    public static void printInRAnge(Node root, int k1, int k2){
        if(root==null){
            return ;
        }

        if(root.data >=k1 && root.data <= k2){
            printInRAnge(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRAnge(root.right, k1, k2);
        }
        else if(root.data < k1){
            printInRAnge(root.left, k1, k2);
        }else{
            printInRAnge(root.right, k1, k2);
        }
    }
    public static boolean BSTSearch(Node root,int key){
        if(root==null){
            return false;
        }

        if(root.data ==key){
            return true;
        }

         if(root.data > key){
            return BSTSearch(root.left, key);
        }else if(root.data < key){
            return BSTSearch(root.right, key);
        }
    
        return false;

    }

    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }

    public static void printRoot2Path(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }

        path.add(root.data);

        if(root.left==null && root.right==null){
            printPath(path);
        }

        printRoot2Path(root.left, path);
        printRoot2Path(root.right, path);

        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root,Node min , Node max){
        if(root==null){
            return true;
        }

        if(min !=null && root.data <= min.data){
            return false;
        }else if(max !=null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left, min,root) && isValidBST(root.right, root, max);
    }

    public static Node MirrorInBST(Node root){
        if(root==null){
            return null;
        }

        Node leftSub = MirrorInBST(root.left);
        Node rightSub =MirrorInBST(root.right);

        root.left=rightSub;
        root.right=leftSub;

        return root;
    }

    public static Node createBalancedBST(int arr[] , int st,int end){
        if(st > end){
            return null;
        }

        int mid= (st+end)/2;

        Node root=new Node(arr[mid]);
        root.left=createBalancedBST(arr, st,mid-1);
        root.right=createBalancedBST(arr,mid+1, end);

        return root;
    }

    public static void preOrder(Node root){
        if(root==null){
            return ;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void getInorder(Node root,ArrayList<Integer>inorder){
        if(root==null){
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node CreateBSTforBAlANCED(ArrayList<Integer>inorder,int si , int end){
        if(si>end){
            return null;
        }

        int mid=(si+end)/2;
        Node root=new Node(inorder.get(mid));
        root.left=CreateBSTforBAlANCED(inorder,si,mid-1);
        root.right=CreateBSTforBAlANCED(inorder, mid+1, end);

        return root;

    }

    public static Node convertBSTtoBalancedBST(Node root){
        //inorder sequnce
        ArrayList<Integer>inorder=new ArrayList<>();
        getInorder(root,inorder);

        //BST create
        root=CreateBSTforBAlANCED(inorder,0,inorder.size()-1);
        return root;
    }
    public static void main(String[] args) {
        //int values[] ={5,1,3,4,2,7};
       // int values[]={8,5,3,1,4,6,10,11,14};
      // int values[]={3,5,6,8,10,11,12};

       /*  Node root=null;

        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        } 
        */
       // inorder(root);
       // System.out.println();
       // System.out.println(BSTSearch(root, 11));

      // delete(root, 10);
       //inorder(root);
       //printInRAnge(root, 5, 12);

      // printRoot2Path(root, new ArrayList<>());

     /*  if(isValidBST(root, null, null)){
        System.out.print("Valid");
      }else{
        System.out.println("Invalid");
      }
        */

  //  MirrorInBST(root);
    //inorder(root);
   
   // Node root=createBalancedBST(values, 0, values.length-1);
    //preOrder(root);


    //convert bst to balanced BST
    Node root=new Node(8);
    root.left=new Node(6);
    root.left.left=new Node(5);
    root.left.left.left=new Node(3);

    root.right=new Node(10);
    root.right.right=new Node(11);
    root.right.right.right=new Node(12);
    
   root= convertBSTtoBalancedBST(root);
   preOrder(root);
    

    }
}
