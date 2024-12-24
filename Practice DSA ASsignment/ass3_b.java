import java.util.*;

class Graph{
    public class Edge {
        String city;
        int cost;

        Edge(String city , int cost){
            this.city=city;
            this.cost=cost;
        }
    }


    Map <String , List<Edge>> tickets;

    Graph(){
        tickets=new HashMap<>();
    }

    //add city
    public void addCity(String city ){
        if(!tickets.containsKey(city)){
            tickets.put(city, new ArrayList<>());
            System.out.println("City "+city+ " added .");
        }else{
            System.out.println("City "+city + " allready exists.");
        }
    }

    //add flight
    public void addFlight(String cityA , String cityB , int cost){
        if(!tickets.containsKey(cityA) | !tickets.containsKey(cityB)){
            System.out.println("Both cities must be added first");
        }else{
            tickets.get(cityA).add(new Edge(cityB, cost));
            tickets.get(cityB).add(new Edge(cityA, cost));
            System.out.println("Flights added Succesfully .");
        }
    }

    //graph is connected or not
    public boolean isConnected(){

        if(tickets.isEmpty()){
            return true;
        }


        Set <String> visited=new HashSet<>();
        Queue <String> q=new LinkedList<>();

        String startCity=null;
        for(String city : tickets.keySet()){
            startCity=city;
            break;
        }

        if(startCity!=null){
            q.add(startCity);    
            visited.add(startCity);
            }

        while (!q.isEmpty()) {
            String curr=q.remove();
            
            for(Edge neighbour : tickets.get(curr)){
                if(!visited.contains(neighbour.city)){
                    visited.add(neighbour.city);
                    q.add(neighbour.city);
                }
            }
        }

        //Graph is connectec or not
        return tickets.size()==visited.size();
    }

    public void displayGraph(){
        System.out.println("paths Between cities !");

        for(String city : tickets.keySet()){

            System.out.print(city + "->");

            
            for(int i=0;i<tickets.get(city).size();i++){
                Edge neighbour =tickets.get(city).get(i);
                System.out.print(neighbour.city+" ( "+neighbour.cost+" )");
            }
            System.out.println();
        }
    }
}

public class ass3_b {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph flightGraph = new Graph();

        while (true) {
            System.out.println("\n--- Flight Network Menu ---");
            System.out.println("1. Add City");
            System.out.println("2. Add Flight Path");
            System.out.println("3. Display Flight Network");
            System.out.println("4. Check if Graph is Connected");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    // Add a city
                    System.out.print("Enter city name: ");
                    String city = sc.nextLine();
                    flightGraph.addCity(city);
                    break;

                case 2:
                    // Add a flight path
                    System.out.print("Enter the source city: ");
                    String cityA = sc.nextLine();
                    System.out.print("Enter the destination city: ");
                    String cityB = sc.nextLine();
                    System.out.print("Enter the cost of flight (time or fuel): ");
                    int cost = sc.nextInt();
                    flightGraph.addFlight(cityA, cityB, cost);
                    break;

                case 3:
                    // Display the graph
                    flightGraph.displayGraph();
                    break;

                case 4:
                    // Check if the graph is connected
                    if (flightGraph.isConnected()) {
                        System.out.println("The graph is connected. All cities are reachable.");
                    } else {
                        System.out.println("The graph is NOT connected. Some cities are isolated.");
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting the program.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

    


