import java.util.*;

public class ass3_a {
    public static class User{
        String name;
        String dob; //DD-MM-Year
        int comments;

        User(String name , String dob , int comments){
            this.name=name;
            this.dob=dob;
            this.comments=comments;
        }
    }

    Map <String , User> userData=new HashMap<>();
    Map <String , List<String>> friendsNetwork =new HashMap<>();

    public void addUser(String name, String dob ,int comments){
        User newUser =new User(name, dob, comments);
        userData.put(name , newUser);
        friendsNetwork.put(name ,new ArrayList<>());
        System.out.println("User added succesfully.");
    }

    public void addFriends(String user1 , String user2){
        if(!friendsNetwork.containsKey(user1) || !friendsNetwork.containsKey(user2)){
            System.out.println("Add both users first .");
        }else{
            friendsNetwork.get(user1).add(user2);
            friendsNetwork.get(user2).add(user1);
            System.out.println("Friends added succesfuly.");
        }
    }

    //maximum friends 
    public void findMaximumFreinds(){
        int maxFriend=0;
        String maxUser=null;

        for(String user : friendsNetwork.keySet()){
            
            int count=friendsNetwork.get(user).size();
            if(count > maxFriend){
                maxFriend=count;
                maxUser=user;
            }
        }

        if(maxUser != null){
            System.out.println("User having friends is "+maxUser +" ("+"Freinds count = "+maxUser+")");
        }
    }

    //maximum and minimum comments 
    public void maxAndMinComments(){
        String maxUser=null;
        String minUser=null;
        int maxComments=Integer.MIN_VALUE;
        int minComments=Integer.MAX_VALUE;

        for(String user : userData.keySet()){

            if(maxComments < userData.get(user).comments){
                maxComments=userData.get(user).comments;
                maxUser=user;
            }

            if(minComments > userData.get(user).comments){
                minComments=userData.get(user).comments;
                minUser=user;
            }
        }

        System.out.println("Maximum comments User : "+maxUser+"  ( "+maxComments+" )");
        System.out.println("Minimum comments User : "+minUser+"  ( "+minComments+" )");
    }

    //Birthdays in this month
    public void findBirthdayUser(){
        Calendar calendar=Calendar.getInstance();
        int currMonth=calendar.get(Calendar.MONTH)+1;

        System.out.println("Bithdays in this month");
        for(User user : userData.values()){
            String dob=user.dob;
            String dobparts[]=dob.split("-");
            int birthMonth=Integer.parseInt(dobparts[1]);

            if(birthMonth == currMonth){
                System.out.println("User name : "+user.name+" DOB : "+user.dob);
            }
        }
        
    }

    //bfs
    public void bfs(String startUser){
        Queue <String> q=new LinkedList<>();
        Set <String> visited=new HashSet<>();

        q.add(startUser);

        while(!q.isEmpty()){

            String curr=q.remove();

            if(!visited.contains(curr)){
                System.out.print(curr +" ");
                visited.add(curr);
            }

            for(String friends : friendsNetwork.get(curr) ){

                if(!visited.contains(friends)){
                    q.add(friends);
                    visited.add(friends);
                }
            }
        }
        System.out.println();
    }

    public void dfs(String startUser){
        Stack <String> s=new Stack<>();
        Set <String> visited=new HashSet<>();

        s.push(startUser);

        while(!s.isEmpty()){
            String curr=s.pop();

            if(!visited.contains(curr)){
                System.out.print(curr+" ");
                visited.add(curr);
            }

            for(String friend : friendsNetwork.get(curr)){

                if(!visited.contains(friend)){
                    s.push(friend);
                    visited.add(friend);
                }
            }
        }
        System.out.println();

    }

    // Menu-driven program
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Social Network Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Friendship");
            System.out.println("3. Find User with Maximum Friends");
            System.out.println("4. Find User with Maximum and Minimum Comments");
            System.out.println("5. Find Users Having Birthday in This Month");
            System.out.println("6. DFS Traversal");
            System.out.println("7. BFS Traversal");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1-8): ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter date of birth (DD-MM-YYYY): ");
                    String dob = scanner.nextLine();
                    System.out.print("Enter number of comments: ");
                    int comments = scanner.nextInt();
                    addUser(name, dob, comments);
                    break;

                case 2:
                    System.out.print("Enter first user name: ");
                    String user1 = scanner.nextLine();
                    System.out.print("Enter second user name: ");
                    String user2 = scanner.nextLine();
                    addFriends(user1, user2);
                    break;

                case 3:
                    findMaximumFreinds();
                    break;

                case 4:
                    maxAndMinComments();
                    break;

                case 5:
                    findBirthdayUser();
                    break;

                case 6:
                    System.out.print("Enter starting user for DFS: ");
                    String dfsUser = scanner.nextLine();
                    dfs(dfsUser);
                    break;

                case 7:
                    System.out.print("Enter starting user for BFS: ");
                    String bfsUser = scanner.nextLine();
                    bfs(bfsUser);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
            }

        } while (choice != 8);

        scanner.close();
    }

    public static void main(String[] args) {
        ass3_a socialNetwork = new ass3_a();

        // Display the menu
        socialNetwork.displayMenu();
    }

}
