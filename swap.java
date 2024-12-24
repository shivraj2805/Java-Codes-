import java.util.Scanner;

public class swap {
    public static void swapData(int a , int b){
       int temp = a;
       a =b;
       b=temp;

       System.out.println("a: " + a);
       System.out.println("b: " + b);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int d = sc.nextInt();
        swapData(c, d);
    }
}
