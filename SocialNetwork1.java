import java.time.LocalDate;
import java.util.*;

class User {
    String name;
    String dateOfBirth; // Format: YYYY-MM-DD
    int comments;
    List<User> friends = new ArrayList<>();

    User(String name, String dateOfBirth, int comments) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.comments = comments;
    }
}

public class SocialNetwork1 {
    List<User> users = new ArrayList<>();

    void addUser(User user) {
        users.add(user);
    }

    void addFriend(User user1, User user2) {
        user1.friends.add(user2);
        user2.friends.add(user1);
    }

    User findUserByName(String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).name.equals(name)) {
                return users.get(i);
            }
        }
        return null;
    }

    // 1. Find user with the most friends
    User findMaxFriends() {
        if (users.isEmpty()) return null;

        User maxUser = users.get(0);
        int maxFriends = users.get(0).friends.size();

        for (int i = 1; i < users.size(); i++) {
            User user = users.get(i);
            if (user.friends.size() > maxFriends) {
                maxFriends = user.friends.size();
                maxUser = user;
            }
        }
        return maxUser;
    }

    // 2. Find users with maximum and minimum comments
    User[] findMaxMinComments() {
        if (users.isEmpty()) return new User[]{null, null};

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
    public List<User> findBirthdayThisMonth() {
        List<User> birthdayUsers = new ArrayList<>();
        int currentMonth = LocalDate.now().getMonthValue();

        for (int i = 0; i < users.size(); i++) {
            LocalDate birthDate = LocalDate.parse(users.get(i).dateOfBirth);
            if (birthDate.getMonthValue() == currentMonth) {
                birthdayUsers.add(users.get(i));
            }
        }

        return birthdayUsers;
    }

    // DFS Traversal
    void performDFS(User user, Set<User> visited) {
        if (visited.contains(user)) return;

        visited.add(user);
        System.out.println(user.name);

        for (int i = 0; i < user.friends.size(); i++) {
            performDFS(user.friends.get(i), visited);
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

            for (int i = 0; i < user.friends.size(); i++) {
                User friend = user.friends.get(i);
                if (!visited.contains(friend)) {
                    visited.add(friend);
                    queue.add(friend);
                }
            }
        }
    }

    public static void main(String[] args) {
        SocialNetwork1 network = new SocialNetwork1();

        //  data
        User shivraj = new User("Shivraj", "1990-08-26", 5);
        User aashish = new User("Aashish", "1988-07-15", 2);
        User pranay = new User("Pranay", "1995-08-20", 8);
        User om = new User("Om", "1992-06-10", 3);
        User yash = new User("Yash", "1993-08-01", 6);

        network.addUser(shivraj);
        network.addUser(aashish);
        network.addUser(pranay);
        network.addUser(om);
        network.addUser(yash);

        network.addFriend(shivraj, aashish);
        network.addFriend(aashish, pranay);
        network.addFriend(pranay, om);
        network.addFriend(om, yash);


        System.out.println("User with maximum friends: " + network.findMaxFriends().name);

        User[] maxMinComments = network.findMaxMinComments();
        System.out.println("User with maximum comments: " + maxMinComments[0].name);
        System.out.println("User with minimum comments: " + maxMinComments[1].name);

        System.out.println("Users with birthdays this month:");
        for (User user : network.findBirthdayThisMonth()) {
            System.out.println(user.name);
        }

        System.out.println("DFS Traversal:");
        network.performDFS(shivraj, new HashSet<>());

        System.out.println("BFS Traversal:");
        network.performBFS(shivraj);
    }
}
