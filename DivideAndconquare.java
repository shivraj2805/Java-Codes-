public class DivideAndconquare {
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int si , int ei){
        if(si>=ei){
            return;
        }

        //kaam
        int mid = si+ (ei-si)/2;
        mergeSort(arr, si, mid);  //left part
        mergeSort(arr, mid+1, ei);  //right part
        merge(arr,si , mid,ei);
    }

    public static void merge(int arr[] , int si , int mid , int ei){
        int temp[]= new int[ei-si+1];

        int i=si; //left part iterator
        int j=mid+1; //right part iterator
        int k =0; //iterator for the temp array

        while (i<=mid &&  j<=ei){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }

        while(j<=ei){
            temp[k++]=arr[j++];
        }

        //copy to the orignal array
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }

    }

    public static void quickSort(int arr[] , int si, int ei){
        if(si>=ei){
            return;
        }

        //last element 
        int pIdx = partition(arr,si,ei);
        quickSort(arr, si, pIdx-1);
        quickSort(arr, pIdx+1, ei);
    }

public static int partition(int arr[] , int si ,int ei){
    int pivot=arr[ei];
    int i=si-1;

    for(int j=si;j<ei;j++){
        if(arr[j]<=pivot){
            i++;
            //swap
            int temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
          }
       
    }
    i++;
    int temp =pivot;
    arr[ei]=arr[i];
    arr[i]=temp;
    return i;

}
public static int serach(int arr[] ,int target, int si , int ei){
    if(si>ei){
        return -1;
    }

    //kaam
    int mid = si+(ei-si)/2;

    //case found .
    if(arr[mid]==target){
        return mid;
    }

    //mid on l1
    if(arr[si]<=arr[mid]){

        //case a : left
        if(arr[si]<=target && arr[mid]>= target){
            return serach(arr, target, si, mid-1);
        }else{
            //case b : right 
            return serach(arr, target, mid+1, ei);
        }
    }

    else{
        //mid on l2

        //case c: left

        if(arr[mid]<=target && target <= arr[ei]){
            return serach(arr, target, mid +1, ei);
        }
        else{
            //case d : right
            return serach(arr, target, si, mid-1);
        }
    }
}
    public static void main(String[] args) {
        int arr[]={6,3,9,8,2,5};
        int arr2[] ={4,5,6,7,0,1,2};
       // mergeSort(arr, 0,(arr.length-1));
        //printArr(arr);
        //quickSort(arr, 0, arr.length-1);
        //printArr(arr);
        System.out.println(serach(arr2, 0, 0, arr2.length));
    }
}
