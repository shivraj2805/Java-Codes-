import java.util.*;
public class calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number 1 : ");
        int a = sc.nextInt();
        System.out.println("Enter a operator : ");
        String operator = sc.next();
        System.out.println("Enter a number 2 : ");
        int b = sc.nextInt();
       

        switch(operator){
            case "+":
                System.out.println(a+b);
                break;
            case "-":
                System.out.println(a-b);
                break;
            case "*":
                System.out.println(a*b);
                break;
            case "/":
                System.out.println(a/b);
                break;
            case "%":
                System.out.println(a%b);
                break;
            default:
                System.out.println("Please Enter Other Operator");

            


        }
    }

}
