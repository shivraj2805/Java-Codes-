import java.util.*;
public class Strings {

    public static void StringConcatanation(){
        String FirstName = "Shivraj ";
        String LastName = "Darekar";
        String FullName = FirstName + LastName;
        System.out.println(FullName);
    }

    public static void charAtMethod(String str){
        for(int i=0;i<str.length();i++){
            System.out.println(str.charAt(i));
        }
    }

    public static boolean palindrom(String str){
        int n=str.length();
        for(int i=0;i<n/2;i++){
            if(str.charAt(i)!=str.charAt(n-i-1)){
                System.out.println("Not Palindrome");
                return false;
            }else{
                System.out.println("Palindrome");
                return true;
            }
        }
        return true;
    }

    public static float getShortPath(String path){
        float x=0,y=0;
        for(int i=0;i<path.length();i++){
            char dir=path.charAt(i);

            if(dir=='N'){y++;}
            else if(dir=='S'){y--;}
            else if(dir=='W'){x--;}
            else if(dir=='E'){x++;}
        }
        float x2=x*x;
        float y2=y*y;

        return (float)Math.sqrt(x2+y2);
        }

    public static void compare(){
        String s1="Tony";
        String s2="Tony";
        String s3=new String("Tony");

        if(s1==s2){
            System.out.println("Strings s1 are equal to s2");
        }else{
            System.out.println("Strings s1 are not equal to s2");
        }

        
        if(s1==s3){
            System.out.println("Strings s1 are equal to s3");
        }else{
            System.out.println("Strings s1 are not equal to s3");
        }

        if(s1.equals(s3)){
            System.out.println("// Strings s1 are equal to s3");
        }else{
            System.out.println("// Strings s1 are not equal to s3");
        }

    }

    public static String SubString(String str,int si,int end){
        String subStr=" ";
        for(int i=si;i<end;i++){
            subStr+=str.charAt(i);
        }
        return subStr;
     
    }

    public static void stringBuilder(){
            StringBuilder sb = new StringBuilder(" ");
            for(char ch= 'a';ch<='z';ch++){
                sb.append(ch);
            }
            System.out.println(sb);
    }
    public static String toUpperCase(String str){
        StringBuilder sb=new StringBuilder(" ");

        char ch=Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static String compresion(String str){
        String newStr=" ";

        for(int i=0;i<str.length();i++){
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            newStr+=str.charAt(i);
            if(count>1){
                newStr+=count.toString();//count.toString means it convert intger to string
            }
        }
        return newStr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String name;
        String name2;
        String str=sc.nextLine();
       // name=sc.next();    //it prints word
      // name2=sc.nextLine();  //it prints line
       //System.out.println(name);
        //System.out.println(name2);
     // StringConcatanation();

    // charAtMethod(str);
    //palindrom(str);
   // System.out.println(getShortPath(str));
    // compare();
    //System.out.println(SubString(str, 3, 5));
       // stringBuilder();
      // System.out.println(toUpperCase(str));
      System.out.println(compresion(str));
}
}
