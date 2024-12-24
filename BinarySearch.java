public class BinarySearch {
    public static int binarySearch(int numbers[], int key){
        int start =0;
        int end = numbers.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            //comparision
            if(numbers[mid] == key){return mid;}

            if(mid < key){
                start = mid+1;
            }
            else{
                end=mid-1;
            }
        }
            return 0;
    }
    public static void main(String[] args) {
        int numbers[] = {2,4,6,8,70,79};
       System.out.print(binarySearch(numbers, 70)) ;
    }
}
