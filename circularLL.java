public class circularLL {
    public class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //add first

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head=tail=newNode;
            tail.next=head;
            return;
        }

        newNode.next=head;
        head=newNode;
        tail.next=head;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head=tail=newNode;
            tail.next=head;
            return;
        }
        
        tail.next=newNode;
        tail=newNode;
        tail.next=head;
    }

    public int removeFirst(){
        if(head==null){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(head==tail){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }

        int val=head.data;
        head=head.next;
        tail.next=head;
        size--;
        return val;
    }

    public int removeLast(){
        if(head==null){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(head==tail){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
         
        size--;
        Node temp=head;
        while(temp.next!=tail){
            temp=temp.next;
        }
        int val=temp.next.data;
        temp.next=head;
        tail=temp;
        return val;
    }

    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("head");
    }


    public static void main(String[] args) {
        circularLL cll=new circularLL();
        cll.addFirst(2);
        cll.addFirst(1);
        cll.addLast(3);
        cll.addLast(4);
        cll.print();

        cll.removeFirst();
        cll.print();

        cll.removeLast();
        cll.print();
    }
}
