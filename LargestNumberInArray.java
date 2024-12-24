public class LargestNumberInArray {
    public static void LargestNum(int nums[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<nums.length;i++){
            if(largest < nums[i]){
                largest = nums[i];
            }
        }
        System.out.println(largest);
    }
    public static void main(String[] args) {
        int nums[] ={1,45,78,520,96,63};
        LargestNum(nums);
    }
}
