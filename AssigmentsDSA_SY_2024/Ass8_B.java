import java.util.*;

class Student {
    String name;
    int credits;

    Student(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }
}

public class Ass8_B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        Student[] students = new Student[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter credits for " + name + ": ");
            int credits = scanner.nextInt();
            scanner.nextLine(); 
            students[i] = new Student(name, credits);
        }

        quickSort(students, 0, n - 1);

        System.out.println("Top 3 students based on credits:");
        for (int i = 0; i < Math.min(3, n); i++) {
            System.out.println((i + 1) + ". " + students[i].name + " - " + students[i].credits + " credits");
        }

        scanner.close();
    }

    public static void quickSort(Student[] students, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(students, low, high);
            quickSort(students, low, pivotIndex - 1);
            quickSort(students, pivotIndex + 1, high);
        }
    }

    private static int partition(Student[] students, int low, int high) {
        int pivot = students[high].credits;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (students[j].credits > pivot) { // For descending order
                i++;
                swap(students, i, j);
            }
        }
        swap(students, i + 1, high);
        return i + 1;
    }

    private static void swap(Student[] students, int i, int j) {
        Student temp = students[i];
        students[i] = students[j];
        students[j] = temp;
    }
}
