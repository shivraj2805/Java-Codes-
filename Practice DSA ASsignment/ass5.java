import java.util.*;
class Node{
        int node;
        int weight;

        Node(int node , int weight){
            this.node=node;
            this.weight=weight;
        }
    }

    class Graph{
        int vertices;
        public List<List<Node>> adjecencyList;

       public Graph(int vertices){
            this.vertices=vertices;
            adjecencyList=new ArrayList<>(vertices);

            for(int i=0;i<vertices;i++){
                adjecencyList.add(new ArrayList<>());
            }
        }

        public void addEdge(int src , int dest , int weight){
            adjecencyList.get(src).add(new Node(dest, weight));
            adjecencyList.get(dest).add(new Node(src, weight)); 

        }

        public void shortestPath(int src , int dest){

            PriorityQueue <Node> pq=new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

            int dist[]=new int[vertices];
            int par[]=new int[vertices];

            for(int i=0;i< vertices ;i++){
                dist[i]=Integer.MAX_VALUE;
                par[i]=-1;
            }

            dist[src]=0;

            pq.add(new Node(src, 0));

            while(!pq.isEmpty()){
                Node curr=pq.remove();

                int u=curr.node;

                if(u==dest){
                    System.out.println("The distance from "+ src +" to "+dest +" is : "+dist[dest]);
                    printPath(src ,dest,par);
                    return;
                }

                for(int i=0;i<adjecencyList.get(u).size();i++){
                    Node neighbour=adjecencyList.get(u).get(i);
                    int newDist=dist[u]+neighbour.weight;

                    if(newDist < dist[neighbour.node]){
                        dist[neighbour.node ]=newDist;
                        par[neighbour.node]=u;
                        pq.add(new Node(neighbour.node , newDist));
                    }
                }
            }
        }

        public void printPath(int src , int dest, int par[]){
            if(src == dest ){
                System.out.print(src);
                return;
            }

            printPath(src, par[dest],par);
            System.out.println("-> "+dest);

        }
        
    }

    public class  ass5 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            System.out.print("Enter the number of vertices: ");
            int vertices = scanner.nextInt();
    
            System.out.print("Enter the number of edges: ");
            int edgesCount = scanner.nextInt();
    
            Graph graph = new Graph(vertices);
    
            System.out.println("Enter each edge in the format: src dest weight");
            for (int i = 0; i < edgesCount; i++) {
                int src = scanner.nextInt();
                int dest = scanner.nextInt();
                int weight = scanner.nextInt();
                graph.addEdge(src, dest, weight);
            }
    
            System.out.print("Enter the source vertex: ");
            int source = scanner.nextInt();
    
            System.out.print("Enter the destination vertex: ");
            int destination = scanner.nextInt();
    
            graph.shortestPath(source, destination);
            scanner.close();
        }
    
        
    }
    
   

