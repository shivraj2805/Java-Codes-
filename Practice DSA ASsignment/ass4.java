import java.util.*;

class Pair{
    int node;
    int weight;

    Pair(int node , int weight){
        this.node=node;
        this.weight=weight;
    }
}

class Graph{
    
    int v;
    public List<List<Pair>> adjList;

    Graph(int v){
        this.v=v;
        adjList=new ArrayList<>();

        for(int i=0;i<v ;i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest ,int wt){
        adjList.get(src).add(new Pair(dest, wt));
        adjList.get(dest).add(new Pair(src, wt));

    }

    public void prismMST(){

        PriorityQueue <Pair> pq=new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        Boolean vis[]=new Boolean[v];
        int par[]=new int[v];
        int dist[]=new int[v];

        for(int i=0;i<v ;i++){
            vis[i]=false;
            dist[i]=Integer.MAX_VALUE;
        }

        dist[0]=0;
        par[0]=-1;

        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            int u=curr.node;
            vis[u]=true;
            int wt=curr.weight;

            for(Pair neighbour : adjList.get(u)){
                    int w=neighbour.node;
                    int neighbourWT=neighbour.weight;

                    if(!vis[w] && neighbourWT < dist[w] ){
                        dist[w]=neighbourWT;
                        pq.add(new Pair(w, neighbourWT));
                        par[w]=u;
                    }
            }
        }

        printMST(par,dist);

    }

    public void printMST(int par[] , int dist[]){
        System.out.println("MST is ");
        System.out.println("Edge "+ " "+"weight");

        int totalWt=0;
        for(int i=1;i<v;i++){
            System.out.print(par[i]+"->"+i+"  "+dist[i]);
            totalWt+=dist[i];
            System.out.println();
        }
        System.out.println("Total cost is "+totalWt);
    }

}

public class ass4 {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number of Nodes : ");
        int n=sc.nextInt();
        Graph graph=new Graph(n);

        System.out.println("Enter the number of edges");
        int edgeCount=sc.nextInt();

        System.out.println("Type the input in the format of src dest wt :");
        for(int i=0;i<edgeCount;i++){
            int src=sc.nextInt();
            int dest= sc.nextInt();
            int wt=sc.nextInt();
            
            graph.addEdge(src, dest, wt);
        }

        graph.prismMST();
        sc.close();
    }
}
