import java.util.*;
public class NumberPoisitiveOrNegetive {
    public static void main ( String args[]){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
         
        
        if(number > 0 ){
            System.out.println("Positive");
        }
        else if(number  < 0 ){
            System.out.println("Negetive");
        }
    }    
}
