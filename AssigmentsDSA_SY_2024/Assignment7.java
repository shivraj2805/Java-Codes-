import java.util.*;

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

class ChainingHashTable {
    private static final int TABLE_SIZE = 10;
    private List<Contact>[] table;
    private int comparisons;

    @SuppressWarnings("unchecked")
    ChainingHashTable() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
        comparisons = 0;
    }

    private int hash(String key) {
        int sum = 0;
        for (char c : key.toCharArray()) {
            sum += c;
        }
        return sum % TABLE_SIZE;
    }

    void insert(String name, String phone) {
        int index = hash(name);
        table[index].add(new Contact(name, phone));
    }

    List<String> search(String name) {
        comparisons = 0;
        int index = hash(name);
        List<String> results = new ArrayList<>();

        for (Contact contact : table[index]) {
            comparisons++;
            if (contact.name.equals(name)) {
                results.add(contact.phone);
            }
        }
        return results;
    }

    int getComparisons() {
        return comparisons;
    }

    void display() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("Index " + i + ":");
            for (Contact contact : table[i]) {
                System.out.print(" (" + contact.name + ": " + contact.phone + ")");
            }
            System.out.println();
        }
    }
}

class ProbingHashTable {
    private static final int TABLE_SIZE = 10;
    private Contact[] table;
    private boolean[] occupied;
    private int comparisons;

    ProbingHashTable() {
        table = new Contact[TABLE_SIZE];
        occupied = new boolean[TABLE_SIZE];
        comparisons = 0;
    }

    private int hash(String key) {
        int sum = 0;
        for (char c : key.toCharArray()) {
            sum += c;
        }
        return sum % TABLE_SIZE;
    }

    void insert(String name, String phone) {
        int index = hash(name);
        while (occupied[index]) {
            index = (index + 1) % TABLE_SIZE;
        }
        table[index] = new Contact(name, phone);
        occupied[index] = true;
    }

    List<String> search(String name) {
        comparisons = 0;
        List<String> results = new ArrayList<>();
        int index = hash(name);
        int originalIndex = index;

        do {
            comparisons++;
            if (occupied[index] && table[index].name.equals(name)) {
                results.add(table[index].phone);
            }
            index = (index + 1) % TABLE_SIZE;
        } while (index != originalIndex);

        return results;
    }

    int getComparisons() {
        return comparisons;
    }

    void display() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("Index " + i + ": ");
            if (occupied[i]) {
                System.out.println("(" + table[i].name + ": " + table[i].phone + ")");
            } else {
                System.out.println("Empty");
            }
        }
    }
}

public class Assignment7 {
    public static void main(String[] args) {
        ChainingHashTable chainingTable = new ChainingHashTable();
        ProbingHashTable probingTable = new ProbingHashTable();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert new contact");
            System.out.println("2. Search contact");
            System.out.println("3. Compare methods with test data");
            System.out.println("4. Display both tables");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1: {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();

                    chainingTable.insert(name, phone);
                    probingTable.insert(name, phone);
                    System.out.println("Contact added to both tables!");
                    break;
                }
                case 2: {
                    System.out.print("Enter name to search: ");
                    String name = scanner.nextLine();

                    System.out.println("\nSeparate Chaining Results:");
                    List<String> results1 = chainingTable.search(name);
                    if (results1.isEmpty()) {
                        System.out.println("No contacts found");
                    } else {
                        System.out.println("Phone numbers found:");
                        for (String phone : results1) {
                            System.out.println(phone);
                        }
                    }
                    System.out.println("Comparisons needed: " + chainingTable.getComparisons());

                    System.out.println("\nLinear Probing Results:");
                    List<String> results2 = probingTable.search(name);
                    if (results2.isEmpty()) {
                        System.out.println("No contacts found");
                    } else {
                        System.out.println("Phone numbers found:");
                        for (String phone : results2) {
                            System.out.println(phone);
                        }
                    }
                    System.out.println("Comparisons needed: " + probingTable.getComparisons());
                    break;
                }
                case 3: {
                    System.out.print("Enter name to compare search methods: ");
                    String name = scanner.nextLine();

                    List<String> results1 = chainingTable.search(name);
                    System.out.println("\nSeparate Chaining Method:");
                    if (results1.isEmpty()) {
                        System.out.println("No contacts found");
                    } else {
                        System.out.println("Found " + results1.size() + " contact(s)");
                    }
                    System.out.println("Comparisons needed: " + chainingTable.getComparisons());

                    List<String> results2 = probingTable.search(name);
                    System.out.println("\nLinear Probing Method:");
                    if (results2.isEmpty()) {
                        System.out.println("No contacts found");
                    } else {
                        System.out.println("Found " + results2.size() + " contact(s)");
                    }
                    System.out.println("Comparisons needed: " + probingTable.getComparisons());
                    break;
                }
                case 4: {
                    System.out.println("\nSeparate Chaining Table:");
                    chainingTable.display();
                    System.out.println("\nLinear Probing Table:");
                    probingTable.display();
                    break;
                }
                case 5: {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
