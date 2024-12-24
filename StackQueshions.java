import java.util.*;

public class StackQueshions{
    public  static boolean isValid(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0;i<str.length();i++){

            char ch=str.charAt(i);
             //opening condition

             if(ch=='(' ||  ch=='{' || ch=='['){
                s.push(ch);
             }else{
                //closing condition

                if(s.isEmpty()){
                    return false;
                }

                if( (s.peek()=='(' && ch==')') || (s.peek()=='{' && ch=='}') || (s.peek()=='[' && ch==']')){
                    s.pop();
                }else{
                    return false;
                }
             }


        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
       
       
    }

    public static boolean isDuplicate(String str){
        Stack<Character> s= new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            //closing condition
            
            if(ch==')'){
                int count=0;
                while(s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }else{
                    s.pop();
                }
            }else{

                //opening condition
                s.push(ch);
            }
        }
        return false;
    }

    public static void maxAreaInHistogram(int arr[]){
        int maxArea=0;
        int nsr[]=new int[arr.length];
        int nsl[]=new int[arr.length];

        //s1-Next smaller right

        Stack<Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){

            while (!s.isEmpty() && arr[s.peek()]>=arr[i]) {
                s.pop();
            }

            if(s.isEmpty()){
                nsr[i]=arr.length;  //n
            }
            else{
                nsr[i]=s.peek();
            }

            s.push(i);
        }

        //s2-next smaller left

        s=new Stack<>();  //stack becomes empty
        for(int i=0;i<arr.length;i++){

            while (!s.isEmpty() && arr[s.peek()]>=arr[i]) {
                s.pop();
            }

            if(s.isEmpty()){
                nsl[i]=-1;  //starting idx
            }
            else{
                nsl[i]=s.peek();
            }

            s.push(i);
        }

        //s3 - curr area step
        for(int i=0;i<arr.length;i++){
            int height=arr[i];
            int width=nsr[i]-nsl[i]-1;           //width=j-i-1=nsr[i]-nsl[i]-1

            int currArea=height*width;
            maxArea=Math.max(currArea, maxArea);
        }

        System.out.println("Max Area of Histogram is :  "+maxArea);

    }

    public static int trap(int height[]){

        if(height.length==0){
            return 0;
        }

        Stack<Integer> s=new Stack<>();
        int trepedWater =0;
        int current=0;

        while(current < height.length){
            while(!s.isEmpty() && height[current]>height[s.peek()]){
                int top=s.pop();

                if(s.isEmpty()){
                    break;
                }

                int distance = current -s.peek()-1;
                int boundedHeight =Math.min(height[current], height[s.peek()])-height[top];
                trepedWater+=distance*boundedHeight;
            }

            //push the current index on stack
            s.push(current);
            current++;
        }
        return trepedWater;
    }

public static void main (String args[]){
        /*String str = "({[]}())}";
        String str1="(((a+(b)))+(c+d))";
        String str2="((a+b)+(c+d))";
        System.out.println(isValid(str));
        System.out.println(isDuplicate(str1));
        System.out.println(isDuplicate(str2));   
        */

       /*  int arr[]={2,1,5,6,3};

        maxAreaInHistogram(arr);
        */
        int height[]={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("traped water : "+trap(height));
    }
}