import java.util.*;
public class subarray {
    public static void SubArray(int numbers[]){
        int sum=0;
        for(int i=0; i<numbers.length ;i++){
            for(int j=i;j<numbers.length ; j++){
                sum=0;
                for(int k =i ; k<=j;k++){
                    System.out.print(numbers[k]+ " ");
                    sum+=numbers[i];
                }
                System.out.print("Sum = "+sum);
                System.out.println();
                
                
              
            }
            
        }
    }
    public static void main(String[] args) {
        int numbers[] ={2,4,6,8,10};

        SubArray(numbers);

    }
}
