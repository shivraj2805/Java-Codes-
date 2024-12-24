public class OptimizeBubbleSort {
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static void modifiedBubbleSort(int arr[]){
        for(int turns =0;turns <arr.length-1;turns++){
            boolean swapped = false;
            for(int j=0;j<arr.length -1 -turns;j++){
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped = true;
                }
            }
            if(swapped ==false){
                break;
            }
        }
        printArr(arr);
    }

    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        modifiedBubbleSort(arr);

    }
}
