import java.util.Scanner;

public class productFunction{
        public static void productData(int a , int b){
         int productOfAb = a*b;
           System.out.println("Product :  " + productOfAb);
    
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int c = sc.nextInt();
            int d = sc.nextInt();
            productData(c, d);
        }
    }
    

