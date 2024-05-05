import java.util.Arrays;

public class GraphColoring {

    private static final int NO_COLOR = 0;

    // Check if it's safe to assign color c to vertex v
    private static boolean isSafe(int[][] graph, int[] colors, int vertex, int color, int numOfVertices) {
        for (int i = 0; i < numOfVertices; i++) {
            if (graph[vertex][i] == 1 && color == colors[i]) {
                return false; // Color conflict with adjacent vertex
            }
        }
        return true;
    }

    // Recursively assign colors to vertices
    private static boolean graphColoringUtil(int[][] graph, int[] colors, int vertex, int numOfColors,
            int numOfVertices) {
        if (vertex == numOfVertices) {
            return true; // All vertices colored
        }

        for (int c = 1; c <= numOfColors; c++) {
            if (isSafe(graph, colors, vertex, c, numOfVertices)) {
                colors[vertex] = c; // Assign color to vertex
                if (graphColoringUtil(graph, colors, vertex + 1, numOfColors, numOfVertices)) {
                    return true; // Color assignment successful
                }
                colors[vertex] = NO_COLOR; // Backtrack
            }
        }
        return false; // No valid color assignment
    }

    // Perform graph coloring
    public static int[] graphColoring(int[][] graph, int numOfColors) {
        int numOfVertices = graph.length;
        int[] colors = new int[numOfVertices];
        Arrays.fill(colors, NO_COLOR);

        if (graphColoringUtil(graph, colors, 0, numOfColors, numOfVertices)) {
            return colors; // Valid coloring found
        } else {
            return null; // No valid coloring possible
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 1, 1, 1 },
                { 1, 0, 1, 0 },
                { 1, 1, 0, 1 },
                { 1, 0, 1, 0 }
        };
        int numOfColors = 3;

        int[] colors = graphColoring(graph, numOfColors);

        if (colors != null) {
            System.out.println("Graph coloring:");
            for (int i = 0; i < graph.length; i++) {
                System.out.println("Vertex " + i + ": Color " + colors[i]);
            }
        } else {
            System.out.println("No valid coloring possible");
        }
    }
}
