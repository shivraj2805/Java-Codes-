import java.util.*;
public class StackGreaterElementRight {
    
    public static void main(String[] args) {
        
        int arr[]={6,8,0,1,3};
        int nextGreater[] = new int[arr.length];

        StackQueshions<Integer> s = new StackQueshions<>();

        for(int i=arr.length-1 ; i>=0;i--){

            //s1- while loop

            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }

            //s2 - if else

            if(s.isEmpty()){
                nextGreater[i]=-1;
            }else{
                nextGreater[i]=arr[s.peek()];
            }

            //s3- push on stack

            s.push(i);
        }

        for(int i=0;i<nextGreater.length;i++){
            System.out.print(nextGreater[i]+" ");
        }
    }
}
