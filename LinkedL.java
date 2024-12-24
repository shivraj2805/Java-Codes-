import java.util.*;

public class LinkedL {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void addMiddle(int data , int idx){
        Node newNode = new Node(data);
        
        if(idx == 0){
            addFirst(data);
        }

        Node temp =head;
        int i=0;

        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        //temp is pointining to previsious position
        newNode.next = temp.next;
        temp.next=newNode;
        size++;
    }

    public int deleteFirst(){
        if(size==0){
            System.out.println("LL is empty !");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            head =tail = null;
            size--;
            return val;

        }
        int val = head.data;
        head=head.next;
        size--;
        return val;
    }
    public int deleteLast(){
        if(size==0){
            System.out.println("LL is empty !");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            head =tail = null;
            size--;
            return val;

        }
        //prev : size-2
        Node prev =head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        
        int val = prev.next.data;
        prev.next = null;
        tail=prev;
        size--;
        return val;
    }

    public int itrSearch(int key){
        Node temp = head;
        int i=0;

        while(temp!=null){
            if(temp.data==key){         //key Found
                return i;
            }
            i++;
            temp=temp.next;

        }
        return -1;  //key Not Found
    }

    public int helper(Node head , int key){
        if(head==null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx ==-1){
            return -1;
        }
        return idx+1;


    }

    public int recSearch(int key){
        return helper(head, key);
    }

    public void reverse(){
        Node prev= null;
        Node curr = tail =head;
        Node next;
        while(curr !=null){
            next = curr.next;
            curr.next =prev;
            prev =curr;
            curr =next;

        }
        head =prev;
    }

    public void deleteFromEndNthNode(int n){
        if(n==size){
            head =head.next;
            return;
        }

        Node prev =head;
        int i=1;
        int iToFind = size - n;
        
        while(i<iToFind){
            prev = prev.next;
            i++;
        }

        prev.next =prev.next.next;
        return;
    }

    public Node FindMidNode(Node head){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;       //+1
            fast=fast.next.next;   //+2

        }
        return slow;   //mid
    }

    public boolean CheckPalindrome(){
        if(head == null || head.next == null){
            return true;
        }

        Node mid = FindMidNode(head);             //s1 : To find mid node

        //s2:Reveres
        Node prev =null;
        Node curr =mid;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr =next;
        }
        
        Node right= prev ;      //head for right half
        Node left = head;

        if(left.data != right.data){
            return false;
        }
        return true;
    }

    public boolean isCycle(){
        Node slow = head;
        Node fast =head;

        while (fast!=null && fast.next !=null) {
            slow = slow.next;      //+1
            fast =fast.next.next;    //+2

            if(slow==fast){
                return true;             //cycle exits
            }
            
        }
        return false;     //cycle not exists
    }

    public static void removeCycle(){
        Node slow =head;
        Node fast = head;
        boolean cycleExists = false;

        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast =fast.next.next;

            if(slow==fast){
                cycleExists=true;
                break;
            }
        }

        if(cycleExists==false){
            return;
        }

        //find mitting point
        slow =head;
        Node prev=null;
        while(slow!=fast){
            slow=slow.next;
            prev =fast;
            fast=fast.next;
        }

        prev.next =null;   //cycle is removed
    }

    //Merge sort on Linked List

    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast!=null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }  
        return slow;   //mid
      }

    public Node merge(Node head1 , Node head2){
        Node mergLL = new Node(-1);
        Node temp = mergLL;

        while(head1!=null && head2!=null){

            if(head1.data <= head2.data){
                temp.next=head1;
                head1=head1.next;
                temp =temp.next;
            }else{
                temp.next=head2;
                head2=head2.next;
                temp =temp.next;
            }
        }

        while(head1!=null){
                temp.next=head1;
                head1=head1.next;
                temp =temp.next;
        }

        while(head2!=null){
                temp.next=head2;
                head2=head2.next;
                temp =temp.next;
        }

        return mergLL.next;     //it removes -1
    }

    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }

        //find mid
        Node mid =getMid(head);

        //leftRight MergeSort
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);

    }

    //ZigZag LinkedList Code
    public void ZigZag(){
        //To find mid
        Node slow=head;
        Node fast=head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;

        //Reverse 2nd half

        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
         
        //Alternate ZigZag concept
        Node left=head;
        Node right=prev;
        Node nextL, nextR;

        while(left!=null && right!=null){
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            //update step
            left=nextL;
            right=nextR;
        }
    }
    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
        System.out.println("Size = "+size);
    }

    public static void main(String[] args) {
        LinkedL ll = new LinkedL();
       // ll.addFirst(2);
        //ll.addFirst(1);
        //ll.addFirst(3);

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
       // ll.addLast(6);
        //ll.print();
       // ll.addMiddle(4, 3);
        ll.print();
       /*  ll.deleteFirst();
        ll.print();
        ll.deleteLast();
        ll.print();
       System.out.println( ll.itrSearch(4));
       System.out.println(ll.recSearch(4));  */
      // ll.deleteFromEndNthNode(3);
       //ll.print();

      //System.out.println( ll.CheckPalindrome());

      /*head =new Node(1);
      Node temp= new Node(2);
      head.next=temp;
      head.next.next = new Node(3);
      head.next.next.next =temp;
      //1->2->3->2
      System.out.println(ll.isCycle());
      ll.removeCycle();
      System.out.println(ll.isCycle()); */

      //ll.head =ll.mergeSort(ll.head);
      //ll.print();

      ll.ZigZag();
      ll.print();

    }
}
