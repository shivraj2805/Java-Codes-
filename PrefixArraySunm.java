public class PrefixArraySunm {
    public static void prefixArraySum(int numbers[]){
        int curSum=0;
        int maxSum=Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        prefix[0]=numbers[0];
        //calulate Prefix Array
        for(int i=1;i<prefix.length;i++){
            prefix[i]=numbers[i]+prefix[i-1];
        }

        for(int i=0;i<numbers.length;i++){
            int start =i;
            for(int j=i;j<numbers.length;j++){
                int end=j;

                curSum=start==0 ? prefix[end]:prefix[end]-prefix[start-1];

                if(curSum >= maxSum){
                    maxSum=curSum;

            }
        }
    }
    System.out.println(maxSum);
    }

    public static void main(String[] args) {
        int numbers[]={2,4,6,8,10};
        prefixArraySum(numbers);
    }
}
