import java.util.*;

class Graph {

    //Edge class to reprsent the edge between two cities
    private static class Edge {
        String city;
        int cost;

        public Edge(String city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }
    
    private Map<String, List<Edge>> tickets;  // Map to store cities and their neighbors

    public Graph() {
        tickets = new HashMap<>();
    }


    //Add cities 
    public void addCity(String city) {
        if (!tickets.containsKey(city)) {
            tickets.put(city, new ArrayList<>());
            System.out.println("City '" + city + "' added.");
        } else {
            System.out.println("City '" + city + "' already exists.");
        }
    }

    // add flites between two cities and their cost
    public void addFlight(String cityA, String cityB, int cost) {
        if (!tickets.containsKey(cityA) || !tickets.containsKey(cityB)) {
            System.out.println("Both cities must be added first.");
            return;
        }
        tickets.get(cityA).add(new Edge(cityB, cost));  // Add an edge from cityA to cityB
        tickets.get(cityB).add(new Edge(cityA, cost));  // Add an edge from cityB to cityA (undirected graph)
        System.out.println("Flight path added between '" + cityA + "' and '" + cityB + "' with a cost of " + cost + ".");
    }

    // Check graph is connected or not
    public boolean isConnected() {

        //Base case
        if (tickets.isEmpty()) {
            return true;  
        }


        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        String startCity = null;  //Intilized city
        for (String city : tickets.keySet()) {
            startCity = city;
            break;  
        }

        // BFS
        if (startCity != null) {
            queue.add(startCity);
            visited.add(startCity);
        }

      
        while (!queue.isEmpty()) {
            String currentCity = queue.remove();

            for (Edge neighbor : tickets.get(currentCity)) {
                if (!visited.contains(neighbor.city)) {
                    visited.add(neighbor.city);
                    queue.add(neighbor.city);
                }
            }
        }

    //All cities visited then graph is connected
        return visited.size() == tickets.size();
    }

  
    public void displayGraph() {
        System.out.println("Flight paths (Tickets):");
      
        for (String city : tickets.keySet()) {
            System.out.print(city + " -> ");
            
     
            List<Edge> edges = tickets.get(city);
            

            for (int i = 0; i < edges.size(); i++) {
                Edge e = edges.get(i);  // Get the edge at index 'i'
                System.out.print(e.city + "(" + e.cost + ") ");
            }
            System.out.println(); 
        }
    }
    

    
}


public class Ass3_B {

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
