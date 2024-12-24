public class reverseArray {
    public static void ReverseArrsay(int numbers[]){
        int first=0;
        int end=numbers.length-1;

        while (first < end) {
            int temp = first;
            first =end;
            end =temp;

            first++;
            end--;
        }
        //print array
        for(int i=numbers.length-1;i>=0;i--){
            System.out.print(numbers[i] + " ");
        }
    }

    public static void main(String[] args) {
       int numbers[]={0,2,3,4,5,6,7,8,9};
        ReverseArrsay(numbers);
    }
}
