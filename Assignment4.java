import java.util.*;

public class Assignment4 {
    private Map<String, List<Edge>> adjacencyList;

    public Assignment4() {
        adjacencyList = new HashMap<>();
    }

   
    public void addFlight(String city1, String city2, double cost) {
        adjacencyList.putIfAbsent(city1, new ArrayList<>());
        adjacencyList.putIfAbsent(city2, new ArrayList<>());
        adjacencyList.get(city1).add(new Edge(city2, cost));
        adjacencyList.get(city2).add(new Edge(city1, cost)); // Since it's an undirected graph
    }

    public boolean isConnected() {
        if (adjacencyList.isEmpty()) return true;
        
        Set<String> visited = new HashSet<>();
        String startCity = adjacencyList.keySet().iterator().next();
        dfs(startCity, visited);
        
        return visited.size() == adjacencyList.size();
    }

    private void dfs(String city, Set<String> visited) {
        visited.add(city);
        for (Edge edge : adjacencyList.get(city)) {
            if (!visited.contains(edge.city)) {
                dfs(edge.city, visited);
            }
        }
    }

    public void showConnectivity() {
        System.out.println("Graph Connectivity (Adjacency List):");
        for (String city : adjacencyList.keySet()) {
            System.out.print(city + " -> ");
            for (Edge edge : adjacencyList.get(city)) {
                System.out.print(edge.city + " (" + edge.cost + "), ");
            }
            System.out.println();
        }
    }

    private static class Edge {
        String city;
        double cost;

        Edge(String city, double cost) {
            this.city = city;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Assignment4 graph = new Assignment4();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of flights: ");
        int flights = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < flights; i++) {
            System.out.print("Enter city 1: ");
            String city1 = scanner.nextLine();
            System.out.print("Enter city 2: ");
            String city2 = scanner.nextLine();
            System.out.print("Enter cost (time or fuel) between " + city1 + " and " + city2 + ": ");
            double cost = scanner.nextDouble();
            scanner.nextLine(); 

            graph.addFlight(city1, city2, cost);
        }

        if (graph.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
        }

        graph.showConnectivity();

        scanner.close();
    }
}
