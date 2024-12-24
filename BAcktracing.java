import java.util.*;
public class BAcktracing {
    public static void FindSubsets(String str ,String ans ,int i){
        if(i==str.length()){      //base case

            if(ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }

        //choices

        //yes choice
        FindSubsets(str, ans + str.charAt(i), i+1);

        //No Choice
        FindSubsets(str,ans,i+1);
    }

    public static void findPermutation(String str , String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        //recursion
        for(int i =0;i<str.length();i++){
            char curr = str.charAt(i);

            String Newstr=str.substring(0, i)+str.substring(i+1);
            findPermutation(Newstr, ans + curr);
        }
    } 

    public static void main(String[] args) {
        String str = "abc";
        //FindSubsets(str, " ", 0);
        //findPermutation(str, "");
    }
    }
    