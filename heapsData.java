import java.util.*;

public class heapsData {
    static class heap{
        ArrayList<Integer> arr=new ArrayList<>();

        public void add(int data){
            //add at last index
            arr.add(data);

            int x=arr.size()-1;  //child idx
            int par=(x-1)/2;   //par idx

            while(arr.get(x) < arr.get(par)){
                //swap
                int temp=arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x=par;
                par=(x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        public void heapify(int i){
            int left=2*i+1;
            int right=2*i+2;
            int minIdx=i;

            if(left < arr.size() && arr.get(left) < arr.get(minIdx)){
                minIdx=left;
            }

            if(right < arr.size() && arr.get(right) < arr.get(minIdx)){
                minIdx=right;
            }

            if(minIdx != i){
                //swap
                int temp=arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }
        public int remove(){
            int data=arr.get(0);

            //s1-swap first and last
            int temp=arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //s2- delete last node
            arr.remove(arr.size()-1);

            //s3-heapify -> Fix the heap
            heapify(0);

            return data;
        }

        public boolean isEmpty(){
            return arr.size()==0;
        }
    }

    public static void main(String[] args) {
        heap h=new heap();
        
        h.add(3);
        h.add(4);
        h.add(2);
        h.add(7);

        while (!h.isEmpty()) {
            System.out.println(h.peek());      
            h.remove();      
        }
    }
}
