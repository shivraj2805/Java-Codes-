import java.time.LocalDate;
import java.util.*;

class User {
    String name;
    String dateOfBirth; // "YYYY-MM-DD"
    int comments;
    List<User> friends = new ArrayList<>();

    User(String name, String dateOfBirth, int comments) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.comments = comments;
    }
}

public class SocialNetwork {
    List<User> users = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    void addUser(User user) {
        users.add(user);
    }

    void addFriend(User user1, User user2) {
        user1.friends.add(user2);
        user2.friends.add(user1);
    }

    User findUserByName(String name) {
        for (User user : users) {
            if (user.name.equals(name)) {
                return user;
            }
        }
        return null;
    }

    // 1. Find user with the most friends
    User findMaxFriends() {
        User maxUser = users.get(0);
        int maxFriends = maxUser.friends.size();

        for (User user : users) {
            if (user.friends.size() > maxFriends) {
                maxFriends = user.friends.size();
                maxUser = user;
            }
        }

        System.out.println("User with maximum friends: " + maxUser.name + " (" + maxFriends + " friends)");
        System.out.print("Friends: ");
        for (User friend : maxUser.friends) {
            System.out.print(friend.name + " ");
        }
        System.out.println(); // For a new line after printing friends
        return maxUser;
    }

    // 2. Find users with maximum and minimum comments
    User[] findMaxMinComments() {
        User maxUser = users.get(0);
        User minUser = users.get(0);

        for (int i = 1; i < users.size(); i++) {
            User user = users.get(i);
            if (user.comments > maxUser.comments) {
                maxUser = user;
            }
            if (user.comments < minUser.comments) {
                minUser = user;
            }
        }

        return new User[]{maxUser, minUser};
    }

    // 3. Find users with birthdays this month
    List<User> findBirthdayThisMonth() {
        List<User> birthdayUsers = new ArrayList<>();
        int currentMonth = LocalDate.now().getMonthValue();

        for (User user : users) {
            LocalDate birthDate = LocalDate.parse(user.dateOfBirth);
            if (birthDate.getMonthValue() == currentMonth) {
                birthdayUsers.add(user);
            }
        }

        return birthdayUsers;
    }

    // DFS Traversal
    void performDFS(User user, Set<User> visited) {
        if (visited.contains(user)) return;

        visited.add(user);
        System.out.println(user.name);

        for (User friend : user.friends) {
            performDFS(friend, visited);
        }
    }

    // BFS Traversal
    void performBFS(User startUser) {
        Queue<User> queue = new LinkedList<>();
        Set<User> visited = new HashSet<>();

        queue.add(startUser);
        visited.add(startUser);

        while (!queue.isEmpty()) {
            User user = queue.poll();
            System.out.println(user.name);

            for (User friend : user.friends) {
                if (!visited.contains(friend)) {
                    visited.add(friend);
                    queue.add(friend);
                }
            }
        }
    }

    void run() {
        while (true) {
            System.out.println("\n--- Social Network Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend");
            System.out.println("3. Find User with Maximum Friends");
            System.out.println("4. Find Users with Maximum and Minimum Comments");
            System.out.println("5. Find Users with Birthdays this Month");
            System.out.println("6. Perform DFS Traversal");
            System.out.println("7. Perform BFS Traversal");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter date of birth (YYYY-MM-DD): ");
                    String dob = scanner.nextLine();
                    System.out.print("Enter number of comments: ");
                    int comments = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    User user = new User(name, dob, comments);
                    addUser(user);
                    System.out.println("User added successfully!");
                    break;

                case 2:
                    System.out.print("Enter first user's name: ");
                    String user1Name = scanner.nextLine();
                    System.out.print("Enter second user's name: ");
                    String user2Name = scanner.nextLine();
                    User user1 = findUserByName(user1Name);
                    User user2 = findUserByName(user2Name);
                    if (user1 != null && user2 != null) {
                        addFriend(user1, user2);
                        System.out.println("Friendship added successfully!");
                    } else {
                        System.out.println("One or both users not found.");
                    }
                    break;

                case 3:
                    User maxFriendsUser = findMaxFriends();
                    break;

                case 4:
                    User[] maxMinCommentsUsers = findMaxMinComments();
                    System.out.println("User with maximum comments: " + maxMinCommentsUsers[0].name);
                    System.out.println("User with minimum comments: " + maxMinCommentsUsers[1].name);
                    break;

                case 5:
                    List<User> birthdayUsers = findBirthdayThisMonth();
                    System.out.println("Users with birthday this month:");
                    for (User birthdayUser : birthdayUsers) {
                        System.out.println(birthdayUser.name);
                    }
                    break;

                case 6:
                    System.out.print("Enter starting user for DFS: ");
                    String dfsStartUserName = scanner.nextLine();
                    User dfsStartUser = findUserByName(dfsStartUserName);
                    if (dfsStartUser != null) {
                        System.out.println("DFS Traversal from " + dfsStartUser.name + ":");
                        performDFS(dfsStartUser, new HashSet<>());
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 7:
                    System.out.print("Enter starting user for BFS: ");
                    String bfsStartUserName = scanner.nextLine();
                    User bfsStartUser = findUserByName(bfsStartUserName);
                    if (bfsStartUser != null) {
                        System.out.println("BFS Traversal from " + bfsStartUser.name + ":");
                        performBFS(bfsStartUser);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 8:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();
        network.run();
    }
}
