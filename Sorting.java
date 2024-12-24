public class Sorting {
    public static void BubbleSort(int arr[]){
        for(int turns =0;turns<arr.length-1;turns++){
            for(int j=0;j<arr.length-1-turns;j++){
                if(arr[j]>arr[j+1]){
                    //Swap
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
                
            }
        }
    }

    public static void SelectionSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int minPos=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minPos]>arr[j]){
                    minPos=j;
                }
            }
            //Swap
            int temp = arr[minPos];
            arr[minPos]=arr[i];
            arr[i]=temp;
        }
    }
    public static void insertionSort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int currEle =arr[i];
            int prev=i-1;

            while(prev>=0 && arr[prev]>currEle){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=currEle;
        }
    }
    public static void countSort(int arr[]){
        
    }
    public static void main(String[] args) {
       int arr[]={2,7,1,4,3,8,5,1,5};
        //BubbleSort(arr);
        //SelectionSort(arr);
        //insertionSort(arr);
        // Print the sorted array
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
}
