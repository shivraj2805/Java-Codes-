import java.util.LinkedList;
import java.util.Scanner;

public class ass7 {
    private static final int SIZE = 10; // Hash table size

    // Hash table using Separate Chaining
    private LinkedList<Entry>[] separateChainingTable;

    // Hash table using Linear Probing
    private String[] linearProbingNames;
    private String[] linearProbingPhones;

    // Constructor
    public ass7() {
        // Initialize Separate Chaining table
        separateChainingTable = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            separateChainingTable[i] = new LinkedList<>();
        }

        // Initialize Linear Probing table
        linearProbingNames = new String[SIZE];
        linearProbingPhones = new String[SIZE];
    }

    // Hash function
    private int hash(String key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    // Insert using Separate Chaining
    public void insertSeparateChaining(String name, String phoneNumber) {
        int index = hash(name);
        for (Entry entry : separateChainingTable[index]) {
            if (entry.name.equals(name)) {
                entry.phoneNumber = phoneNumber; // Update if already exists
                return;
            }
        }
        separateChainingTable[index].add(new Entry(name, phoneNumber));
    }

    // Insert using Linear Probing
    public void insertLinearProbing(String name, String phoneNumber) {
        int index = hash(name);
        while (linearProbingNames[index] != null) {
            if (linearProbingNames[index].equals(name)) {
                linearProbingPhones[index] = phoneNumber; // Update if already exists
                return;
            }
            index = (index + 1) % SIZE; // Linear probing
        }
        linearProbingNames[index] = name;
        linearProbingPhones[index] = phoneNumber;
    }

    // Search using Separate Chaining
    public int searchSeparateChaining(String name) {
        int index = hash(name);
        int comparisons = 0;
        for (Entry entry : separateChainingTable[index]) {
            comparisons++;
            if (entry.name.equals(name)) {
                return comparisons; // Return number of comparisons
            }
        }
        return comparisons; // Return comparisons even if not found
    }

    // Search using Linear Probing
    public int searchLinearProbing(String name) {
        int index = hash(name);
        int comparisons = 0;
        while (linearProbingNames[index] != null) {
            comparisons++;
            if (linearProbingNames[index].equals(name)) {
                return comparisons; // Return number of comparisons
            }
            index = (index + 1) % SIZE; // Linear probing
        }
        return comparisons; // Return comparisons even if not found
    }

    // Helper class for Separate Chaining entries
    private static class Entry {
        String name;
        String phoneNumber;

        Entry(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }

    // Main method
    public static void main(String[] args) {
        ass7 hashTable = new ass7();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Telephone Book Hash Table ===");
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add client");
            System.out.println("2. Search client");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add client
                    System.out.print("Enter client name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    hashTable.insertSeparateChaining(name, phone);
                    hashTable.insertLinearProbing(name, phone);
                    System.out.println("Client added successfully!");
                    break;

                case 2: // Search client
                    System.out.print("Enter client name to search: ");
                    String searchName = scanner.nextLine();
                    int scComparisons = hashTable.searchSeparateChaining(searchName);
                    int lpComparisons = hashTable.searchLinearProbing(searchName);

                    if (scComparisons > 0 || lpComparisons > 0) {
                        System.out.println("Results:");
                        System.out.println("Separate Chaining comparisons: " + scComparisons);
                        System.out.println("Linear Probing comparisons: " + lpComparisons);
                    } else {
                        System.out.println("Client not found!");
                    }
                    break;

                case 3: // Exit
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
