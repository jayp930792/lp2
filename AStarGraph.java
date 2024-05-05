//Implement A star Algorithm for any game search problem.
import java.util.*;
class Node implements Comparable<Node>{
    int vertex;
    int fScore;
    Node(int vertex, int fScore) {
        this.vertex = vertex;
        this.fScore = fScore;
    }
    public int compareTo(Node other) {
        return Integer.compare(this.fScore, other.fScore);
    }
}
public class AStarGraph {
    private int V;
    private LinkedList<Edge>[] adj;
    private int[] h;

    class Edge {
        int dest;
        int weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
    AStarGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
        h = new int[v];
    }
    void addEdge(int u, int v, int weight) {
        adj[u].add(new Edge(v, weight));
    }
    void setHeuristic(int[] heuristic) {
        h = heuristic;
    }
    void AStar(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(start, h[start]));
        boolean[] visited = new boolean[V];
        int[] gScore = new int[V];
        Arrays.fill(gScore, Integer.MAX_VALUE);
        gScore[start] = 0;
        System.out.print("The Shortest Path: ");
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.vertex;
            System.out.print(u+" ");
            if (u == end) {
                System.out.println("\nShortest path from " + start + " to " + end + " has cost of: " + gScore[u]);
                return;
            }
            visited[u] = true;
            for (Edge e : adj[u]) {
                int v = e.dest;
                int w = e.weight;
                if (!visited[v]) {
                    int fScore = gScore[u] + w + h[v];
                    if (fScore < gScore[v]) {
                        gScore[v] = fScore;
                        pq.add(new Node(v, fScore));
                    }
                }
            }
        }
        System.out.println("No path found from " + start + " to " + end);
    }
    public static void main(String args[]) {
        Scanner in= new Scanner(System.in);
        System.out.print("Enter the size of the graph: ");
        int n = in.nextInt();
        AStarGraph g = new AStarGraph(n);
        System.out.print("Enter the size of input: ");
        int size=in.nextInt();
        System.out.println("Enter edges of graph ");
        for(int i=0;i<size;i++){
            System.out.print("Enter "+(i+1)+ " edges and weight of that edges: ");
            int j=in.nextInt();
            int k=in.nextInt();
            int w=in.nextInt();
            if(j<n && k<n){
                g.addEdge(j, k,w);
            }
            else{
                System.out.println("Invalid Input");
            }
        }
        int[] heuristic = new int[n];
        System.out.println("Enter heuristic of the edges of graph ");
        for(int i=0;i<n;i++){
            System.out.print("Enter "+(i+1)+ " edges heuristic value: ");
            heuristic[i]=in.nextInt();
        }
        g.setHeuristic(heuristic);
        System.out.print("Enter the starting and the ending vertex where you want to find the shortest distance: ");
        int start=in.nextInt();
        int end=in.nextInt();
        g.AStar(start, end);
    }
}

   