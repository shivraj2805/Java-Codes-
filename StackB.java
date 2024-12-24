import java.util.*;

public class StackB {

    public static void pushAtBottom(StackQueshions<Integer>s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top=s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverseString(String str){
        StackQueshions<Character> s=new StackQueshions<>();
        int idx=0;

        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result =new StringBuilder();
        
        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }

        return result.toString();
    }

    public static void reverseStack(StackQueshions<Integer> s){
        if(s.isEmpty()){
            return;
        }

        int top=s.pop();
        reverseStack(s);
        pushAtBottom(s,top);
    }

    public static void print(StackQueshions<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());

        }
    }
    public static void main(String[] args) {
        StackQueshions <Integer> s =new StackQueshions<>();
        
        s.push(1);
        s.push(2);
        s.push(3);
         
        
       // pushAtBottom(s,4 );


       /*  String str="abc";
        System.out.println(reverseString(str));
        */

        //print(s);
        reverseStack(s);
        print(s);

    }    
}
