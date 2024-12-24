import java.util.*;

public class graphBasics{
    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

   public  static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
        graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1,1));
        graph[0].add(new Edge(0, 2,1));

        graph[1].add(new Edge(1, 0,1));
        graph[1].add(new Edge(1, 3,1));

        graph[2].add(new Edge(2, 0,1));
        graph[2].add(new Edge(2, 4,1));
        
        graph[3].add(new Edge(3, 1,1));
        graph[3].add(new Edge(3, 4,1));
        graph[3].add(new Edge(3, 5,1));

        graph[4].add(new Edge(4, 2,1));
        graph[4].add(new Edge(4, 3,1));
        graph[4].add(new Edge(4, 5,1));
        
        graph[5].add(new Edge(5, 3,1));
        graph[5].add(new Edge(5, 4,1));
        graph[5].add(new Edge(5, 6,1));

        graph[6].add(new Edge(6, 5,1));
        }

    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q =new LinkedList<>();
        boolean vis[] = new boolean[graph.length];

        q.add(0);  //source =0

        while(!q.isEmpty()){
            int curr=q.remove();

            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;

                for(int i=0;i<graph[curr].size() ; i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void neighbour(ArrayList<Edge>[] graph, int k){
        for(int i=0;i<graph[k].size();i++){
            Edge e=graph[k].get(i);
            System.out.println(e.dest);
        }

    }

    public static void dfs(ArrayList<Edge>[] graph , int curr, boolean vis[]){
        //visited
        System.out.print(curr+" ");
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);

            if(!vis[e.dest]){
                dfs(graph,e.dest, vis);
            }

        }
        
    }

    public static boolean hasPath(ArrayList<Edge>[] graph,int src , int dest, boolean vis[]){
        if(src==dest){
            return true;
        }

        vis[src]=true;

        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);

            if(!vis[e.dest] && hasPath(graph,e.dest, dest, vis)){
                return true;
            }
        }
            return false;
        }
    

        public static void printAllPath(ArrayList<Edge> [] graph , boolean vis[],int curr, String path, int tar){
            if(curr==tar){
                System.out.println(path);
                return;
            }

            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);

                if(!vis[e.dest]){
                    vis[curr]=true;
                    printAllPath(graph, vis,e.dest, path+e.dest, tar);
                    vis[curr]=false;
                }
            }
        }

        public static void createGraphForCycle(ArrayList<Edge> graph[]) {
            for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
            }
            graph[0].add(new Edge(0, 2,1));
            graph[1].add(new Edge(1, 0,1));
            graph[2].add(new Edge(2, 3,1));
            graph[3].add(new Edge(3, 0,1));
            }

        public static boolean isCycleDirected(ArrayList<Edge>[] graph , boolean vis[], int curr,boolean rec[]){
            vis[curr]=true;
            rec[curr]=true;

            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);

                if(rec[e.dest]){
                    return true;       //cycle exists
                }else if(!vis[e.dest]){

                    if(isCycleDirected(graph, vis, e.dest, rec)){
                        return true;
                    }
                }
            }

            rec[curr]=false;
            return false;
            }

        public static void topSortUtil(ArrayList<Edge> [] graph , int curr, boolean vis[],Stack<Integer> stack){
            vis[curr]=true;

            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);

                if(!vis[e.dest]){
                    topSortUtil(graph,e.dest, vis, stack);
                }
            }
            stack.push(curr);
        }

        public static void topSort(ArrayList<Edge> [] graph,int v){
            boolean vis[]=new boolean[v];
            Stack<Integer> stack = new Stack<>();

            for(int i=0;i<v;i++){
                if(!vis[i]){
                    topSortUtil(graph, i, vis, stack);
                }
            }

            while(!stack.isEmpty()){
                System.out.print(stack.pop()+" ");
            }
        }

    static void createGraphForUndirectedCycle(ArrayList<Edge> graph[]) {
            for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
            }
            graph[0].add(new Edge(0, 1,1));
            graph[0].add(new Edge(0, 2,1));
            graph[0].add(new Edge(0, 3,1));
            graph[1].add(new Edge(1, 0,1));
            graph[1].add(new Edge(1, 2,1));
            graph[2].add(new Edge(2, 0,1));
            graph[2].add(new Edge(2, 1,1));
            graph[3].add(new Edge(3, 0,1));
            graph[3].add(new Edge(3, 4,1));
            graph[4].add(new Edge(4, 3,1));
            }

    public static boolean isCycleNotDirected(ArrayList<Edge> [] graph,boolean vis[] , int curr, int par){
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);

            if(vis[curr] && e.dest!=par){
                return true;
            }
            else if(!vis[curr]){
                if(isCycleNotDirected(graph, vis, e.dest, curr)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void createGraphForDijktrisAlgorithm(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
        graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
        }

    public static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        public Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph,int src , int v){
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int dist[]=new int[v];
        for(int i=0;i<v;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        boolean vis[] =new boolean[v];
        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            
            if(!vis[curr.node]){
                vis[curr.node]=true;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    
                    int u=e.src;
                    int vDest=e.dest;

                    if(dist[u] +e.wt < dist[vDest]){          //relaxation
                        dist[vDest]=dist[u]+e.wt;
                        pq.add(new Pair(vDest,dist[vDest]));

                    }
                }
            }
        

        for(int i=0;i<v;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
}

public static void createGraphForBelmanFordAlgorithm(ArrayList<Edge> graph[]) {
    for(int i=0; i<graph.length; i++) {
    graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1, 2));
    graph[0].add(new Edge(0, 2, 4));
    graph[1].add(new Edge(1, 2, -4));
    graph[2].add(new Edge(2, 3, 2));
    graph[3].add(new Edge(3, 4, 4));
    graph[4].add(new Edge(4, 1, -1));
    }

public static void belmanFordAlgoritham(ArrayList<Edge>[] graph,int src, int v){
    int dist[] = new int[v];

    for(int i=0;i<v;i++){
        if(i!=src){
            dist[i]=Integer.MAX_VALUE;
        }
    }

    //v-1 times roatating or calculating the distnce to get the corect the distnce
    for(int k=0;k<v-1;k++){

        for(int i=0;i<v;i++){

            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);

                int u=e.src;
                int w=e.dest;

                if(dist[u]!=Integer.MAX_VALUE && dist[u]+e.wt < dist[w]){
                    dist[w]=dist[u]+e.wt;
                }
            }
        }
    }
    for(int i=0;i<v;i++){
        System.out.print(dist[i]+" ");
    }
    System.out.println();
}

public static void createGraphForPrismAlgorithm(ArrayList<Edge> graph[]) {
    for(int i=0; i<graph.length; i++) {
    graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1, 10));
    graph[0].add(new Edge(0, 2, 15));
    graph[0].add(new Edge(0, 3, 30));
    graph[1].add(new Edge(1, 0, 10));
    graph[1].add(new Edge(1, 3, 40));
    graph[2].add(new Edge(2, 0, 15));
    graph[2].add(new Edge(2, 3, 50));
    graph[3].add(new Edge(3, 1, 40));
    graph[3].add(new Edge(3, 2, 50));
    
    }

public static class Pairs1 implements Comparable<Pairs1> {
    int node;
    int cost;

    public Pairs1(int n , int c){
        this.node =n;
        this.cost=c;
    }

    @Override
    public int compareTo(Pairs1 p2){
        return this.cost - p2.cost;
    }
}


public static void prismAlgo(ArrayList<Edge> [] graph, int v){
    PriorityQueue<Pairs1> pq= new PriorityQueue<>();   //non mst set
    boolean vis[]=new boolean[v];  //mst set

    pq.add(new Pairs1(0, 0));

    int mstCost=0;

    while(!pq.isEmpty()){
        Pairs1 curr=pq.remove();

        if(!vis[curr.node]){
            vis[curr.node]=true;
            mstCost+=curr.cost;

            for(int i=0;i<graph[curr.node].size();i++){
                Edge e=graph[curr.node].get(i);

                if(!vis[e.dest]){
                    pq.add(new Pairs1(e.dest, e.wt));
                }
            }
        }
    }
    System.out.println("Cost of the MST is : "+mstCost);

}
public static void main(String[] args) {
        int v=5;

        ArrayList<Edge> [] graph=new ArrayList[v];

        //createGraph(graph);
       // neighbour(graph, 2);
      // bfs(graph);
      // dfs(graph, 0,new boolean[v]);
     //  System.out.println(hasPath(graph, 0, 5, new boolean[v]));
      // printAllPath(graph, new boolean[v], 0, "0", 5);
     //createGraphForCycle(graph);
     //System.out.println( isCycleDirected(graph, new boolean[v], 0, new boolean[v]));
     //topSort(graph, v);
     //createGraphForUndirectedCycle(graph);
     //System.out.println(isCycleNotDirected(graph, new boolean[v], 0, -1));

     //createGraphForDijktrisAlgorithm(graph);
     //dijkstra(graph, 0, v);

    // createGraphForBelmanFordAlgorithm(graph);
     //belmanFordAlgoritham(graph, 0, v);
    createGraphForPrismAlgorithm(graph);
     prismAlgo(graph, v);

    }
}