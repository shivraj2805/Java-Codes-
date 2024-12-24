import java.util.Scanner;

public class ass8_a {

    public static void merge(int credits[] , int left , int mid , int right){
        int leftArr[]=new int[mid-left+1];
        int rightArr[]=new int[right-mid];

        for(int i=0 ; i < leftArr.length;i++){
            leftArr[i]=credits[left+i];
        }

        for(int j=0; j< rightArr.length;j++){
            rightArr[j]=credits[mid+j+1];
        }

        int i=0,j=0,k=left;

        while(i<leftArr.length && j<rightArr.length){
            if(leftArr[i]<=rightArr[j]){
                credits[k++]=leftArr[i++];
            }else{
                credits[k++]=rightArr[j++];
            }
        }

        while(i<leftArr.length){
            credits[k++]=leftArr[i++];
        }

        
        while(j<rightArr.length){
            credits[k++]=rightArr[j++];
        }
    }

    public static void print(int credits[]) {
        for(int i=0;i<credits.length;i++){
            System.out.print(credits[i]+" ");
        }
    }

    public static void mergeSort(int credits[],int left , int right){
        if(right > left){
            int mid = (left+right)/2;


            mergeSort(credits,left,mid);
            mergeSort(credits, mid+1, right);
            merge(credits, left , mid ,right);
        }

      

    }

    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the number of students : ");
        int n=sc.nextInt();
        System.out.println();

        int credits[]=new int[n];

        System.out.print("Enter the credits : ");
        for(int i=0;i<credits.length;i++){
           credits[i]= sc.nextInt();
        }

        mergeSort(credits, 0, n-1);
        print(credits);

    }
}
