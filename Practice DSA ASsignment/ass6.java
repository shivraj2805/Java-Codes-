import java.util.*;

public class ass6 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> minHeap =new PriorityQueue<>();

        System.out.print("Enter the number of students : ");
        int n=sc.nextInt();
        System.out.println();

        System.out.print("Enter the marks of each student : ");
        for(int i=0;i<n;i++){
            int mark=sc.nextInt();
            maxHeap.add(mark);
            minHeap.add(mark);
        }

        int minMark = minHeap.peek();
        int maxMark = maxHeap.peek();

        System.out.println("The minimum marks is "+ minMark + " and maximum marks is "+ maxMark);

    }
}
