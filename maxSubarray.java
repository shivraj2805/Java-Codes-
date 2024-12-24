public class maxSubarray {
   
        public static void MaxSub(int numbers[]){
            int curSum=0;
            int max=Integer.MIN_VALUE;
            for(int i=0;i<numbers.length;i++){
                for(int j=i;j<numbers.length;j++){
                    curSum=0;
                    for(int k=i;k<=j;k++){
                        System.out.print(numbers[k]+" ");
                        curSum+=numbers[k];
                    }
                    System.out.print("||");
                    System.out.print("CurSum= "+curSum);
                    System.out.print("||");
                    if(curSum >= max){
                        max=curSum;
                    }
                }
                System.out.println();
            }
            System.out.println(max);
        }
        public static void main(String[] args) {
            int numbers[]={2,4,6,8,10};
            MaxSub(numbers);
        }
    }
    

