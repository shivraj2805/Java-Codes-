import java.util.*;

public class QueueQueshions {
    public static void printFirstReapeatingChar(String str) {
        Queue<Character> q = new LinkedList<>();

        int freq[] = new int[26]; // a-z charchters

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    //interleave
    public static void interleave(Queue<Integer> q){
        Queue<Integer> FirstHalf =new LinkedList<>();
        int size=q.size();

        for(int i=0;i<size/2;i++){
            FirstHalf.add(q.remove());
        }

        while(!FirstHalf.isEmpty()){
            q.add(FirstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void QueueReversal(Queue<Integer> q){
        Stack<Integer> s =new Stack<>();

        while(!q.isEmpty()){
            s.push(q.remove());
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    public static void ReverseKElements(Queue<Integer>q , int k){
        Stack<Integer> FirstEle = new Stack<>();
        int size=q.size();

        for(int i=0;i<k;i++){
            FirstEle.push(q.remove());
        }

        while (!FirstEle.isEmpty()) {
            q.add(FirstEle.pop());            
        }

        for(int i=k;i<size;i++){
            q.add(q.remove());
        }


    }
    public static void main(String[] args) {
       /*  String str = "aabccxb";
        printFirstReapeatingChar(str);
        */

        Queue<Integer> q=new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

       // interleave(q);
      // QueueReversal(q);

      ReverseKElements(q, 5);

        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
}
