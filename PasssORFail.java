import java.util.*;
public class PasssORFail {
    public static void main (String args[]){
        Scanner sc =new Scanner(System.in);
        int number = sc.nextInt();

        String type = (number >= 33) ? "Pass " : "Fail";
        System.out.println(type);
    }
}
 