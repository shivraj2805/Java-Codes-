import java.util.*;
public class MaxOf2No{
    public static void main(String args[]){
    Scanner sc  = new Scanner(System.in);
    System.out.println("Enter a nnumber a : ");
    int a=sc.nextInt();
    System.out.println("Enter a nnumber b : ");
    int b=sc.nextInt();

    if (a>b){
        System.out.println(a + "is greater .");
    }
    else {
        System.out.println(b + "is greater .");
    }

}
}