public class DoublyLL {
    public class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;

    //add first
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }

        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }

    //add last

    public void addLast(int data){
        Node newNode = new Node(data);
         size++;
        if(head==null){
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
   
    }

    //Remove first
    public int removeFirst(){
        if(head==null){
            System.out.println("Dll is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }

        int val=head.data;
        head=head.next;
        head.prev=null;
        return val;
    }

//remove last

    public int removeLast(){
        if(head == null || head.next ==null){
           return removeFirst();
        }

        int val=tail.data;
        tail=tail.prev;
        tail.next=null;
        return val;
    }

    //reverse Linked list

    public void reverse(){
        Node curr=head;
        Node prev=null;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" <--> ");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public static void main(String args[]){
        DoublyLL dll =new DoublyLL();
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(5);
        dll.print();

       // dll.removeFirst();
        //dll.print();

        //dll.removeLast();
        //dll.print();

        dll.reverse();
        dll.print();


    }
}
