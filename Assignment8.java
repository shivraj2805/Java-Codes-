import java.util.*;

public class Assignment8 {
   
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArray[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            rightArray[j] = arr[middle + 1 + j];

        int i = 0, j = 0, k = left;

        // Merge 
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // print the array
    public static void printArray(int[] arr) {
        for (int credit : arr) {
            System.out.print(credit + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] credits = new int[n];

        System.out.println("Enter the credits obtained by each student:");
        for (int i = 0; i < n; i++) {
            System.out.print("Credits for student " + (i + 1) + ": ");
            credits[i] = scanner.nextInt();
        }

        System.out.println("\nCredits before sorting:");
        printArray(credits);

        mergeSort(credits, 0, credits.length - 1);

        System.out.println("\nCredits after sorting:");
        printArray(credits);
    }
}
