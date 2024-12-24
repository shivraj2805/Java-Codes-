import java.util.*;

class Pair {
    int node, weight;
    
    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Graph {
    int V;
    List<List<Pair>> adjList; 

    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Pair(dest, weight));
        adjList.get(dest).add(new Pair(src, weight));
    }

    public void primMST() {
        int[] distance = new int[V];  
        boolean[] visited = new boolean[V]; 
        int[] parent = new int[V]; 
        
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE; 
            visited[i] = false; 
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight)); 

        distance[0] = 0; 
        pq.add(new Pair(0, 0)); 
        parent[0] = -1; 

        while (!pq.isEmpty()) {
            Pair current = pq.remove();
            int u = current.node;
            visited[u] = true; 

            for (Pair neighbor : adjList.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.weight;


                if (!visited[v] && weight < distance[v]) {
                    distance[v] = weight; 
                    pq.add(new Pair(v, distance[v])); 
                    parent[v] = u; 
                }
            }
        }

        printMST(parent, distance);
    }

    public void printMST(int[] parent, int[] distance) {
        System.out.println("MST Graph -");
        System.out.println("Edge \tWeight");
        int totalWeight = 0;
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + distance[i]);
            totalWeight += distance[i];
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }
}

public class Assignment4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int nodes = scanner.nextInt();

        Graph graph = new Graph(nodes);

        System.out.print("Enter the number of edges: ");
        int edgesCount = scanner.nextInt();

        System.out.println("Enter each edge in the format: src dest weight");
        for (int i = 0; i < edgesCount; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(src, dest, weight);
        }

        graph.primMST();
        scanner.close();
    }
}
