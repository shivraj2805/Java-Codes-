import java.util.*;

public class ass9_A {
    public static void main(String args[]){

        int val[]={60,100,120};
        int weights[]={10,20,30};
        int W=50;

        double ratio[][]=new double[val.length][2];

        for(int i=0;i<val.length;i++){

            //0th col => index , 1st col=> ratio of val/wt
            ratio[i][0]=i;
            ratio[i][1]= (double)(val[i]/weights[i]);
        }

        Arrays.sort(ratio , Comparator.comparingDouble(o -> o[1]));
       
        int capacity=W;
        int finalVal=0;

        for(int i=ratio.length-1;i>=0;i--){
                int idx=(int)ratio[i][0];
                 if(capacity >= weights[idx] ){
                    //Include all 
                    finalVal+=val[idx];
                    capacity -=weights[idx];
                   
                 }else{
                    finalVal+=(ratio[i][1]*capacity);
                    capacity=0;
                    break;
                 }
        }
        
        System.out.println("Maximum Profit is "+finalVal);

    }
}
