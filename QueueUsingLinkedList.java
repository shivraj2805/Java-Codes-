public class QueueUsingLinkedList {
    static public class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }


    static public class  QueueB {
        static Node head=null;
        static Node tail=null;

        public static boolean isEmpty(){
            return head==null && tail==null;
        }

        public static void add(int data){
            Node neewNode=new Node(data);

            if(isEmpty()){
                head=tail=neewNode;
                return;
            }

            tail.next=neewNode;
            tail=neewNode;
        }

        public static int remove(){
            if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
            }
            
            int front =head.data;
            
            //single element
            if(head==tail){
                head=tail=null;
            }else{
                head=head.next;
            }
            return front;

        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
                }

                return head.data;
        }    
    }

    public static void main(String[] args) {
        QueueB q=new QueueB();

        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
