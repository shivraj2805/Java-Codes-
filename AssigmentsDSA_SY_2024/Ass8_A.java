import java.util.Scanner;

public class Ass8_A {

    public static void merge(int[] credits, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                credits[k++] = left[i++];
            } else {
                credits[k++] = right[j++];
            }
        }

        while (i < left.length) {
            credits[k++] = left[i++];
        }

        while (j < right.length) {
            credits[k++] = right[j++];
        }
    }

    // Merge sort function
    public static void mergeSort(int[] credits) {
        if (credits.length < 2) {
            return; 
        }

        int mid = credits.length / 2;
        int[] left = new int[mid];
        int[] right = new int[credits.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = credits[i];
        }
        for (int i = mid; i < credits.length; i++) {
            right[i - mid] = credits[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(credits, left, right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] credits = new int[n];

        System.out.println("Enter the credits obtained by each student: ");
        for (int i = 0; i < n; i++) {
            credits[i] = scanner.nextInt();
        }

        mergeSort(credits);

        System.out.println("Sorted credits: ");
        for (int credit : credits) {
            System.out.print(credit + " ");
        }

        scanner.close();
    }
}
