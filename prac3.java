
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Define Edge class
class Edge {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

// Define Subset class
class Subset {
    int parent, rank;

    public Subset(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }
}

public class KruskalsMST {

    public static void main(String[] args) {
        int V = 4; // Number of vertices

        // Define the edges of each node
        List<Edge> graphEdges = new ArrayList<Edge>(List.of(
                new Edge(0, 1, 8), new Edge(0, 2, 6),
                new Edge(0, 3, 5), new Edge(1, 3, 15),
                new Edge(2, 3, 4)));

        // Sort the edges in non-decreasing order
        graphEdges.sort(Comparator.comparingInt(edge -> edge.weight));

        // Find MST using Kruskal's algorithm
        kruskals(V, graphEdges);
    }

    // Function to find the MST
    private static void kruskals(int V, List<Edge> edges) {
        int noOfEdges = 0;
        Subset[] subsets = new Subset[V];
        Edge[] results = new Edge[V];

        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset(i, 0);
        }

        int j = 0;
        while (noOfEdges < V - 1 && j < edges.size()) {
            Edge nextEdge = edges.get(j);
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if (x != y) {
                results[noOfEdges] = nextEdge;
                union(subsets, x, y);
                noOfEdges++;
            }
            j++;
        }

        // Print the MST
        int minCost = 0;
        System.out.println("Following are the edges of the constructed MST:");
        for (int i = 0; i < noOfEdges; i++) {
            System.out.println(results[i].src + " -- " + results[i].dest + " == " + results[i].weight);
            minCost += results[i].weight;
        }
        System.out.println("Total cost of MST: " + minCost);
    }

    // Function to unite two disjoint sets
    private static void union(Subset[] subsets, int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);

        if (subsets[rootY].rank < subsets[rootX].rank) {
            subsets[rootY].parent = rootX;
        } else if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    // Function to find parent of a set
    private static int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }
}
