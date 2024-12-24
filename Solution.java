class Solution {
    public static int Search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;

        while(start <= end){
            int mid=start + end /2;

            if(nums[mid]==target){
                System.out.println(mid);
               return mid;
            }

            if(nums[mid]>target){
                end=mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int nums[]={-1,0,3,5,9,12};
        int target=9;
        System.out.println(Search(nums,target));
    }
}