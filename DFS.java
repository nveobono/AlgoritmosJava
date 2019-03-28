package tema2;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static List<Integer> depthFirstSearch(List<Integer>[] g, int v) {
        int n = g.length;
        List<Integer> traversal = new ArrayList<>(n);
        boolean[] visited = new boolean[n];
        recursiveDFS(g, v, visited, traversal);
        return traversal;
    }

    public static List<Integer>[] depthFirstSearch(List<Integer>[] g) {
        int n = g.length;
        List<Integer> traversals[] = new ArrayList[n];
        for (int v = 0; v < n; v++) {
            traversals[v] = depthFirstSearch(g, v);
        }
        return traversals;
    }

    public static void recursiveDFS(List<Integer>[] g, int v, boolean[] visited, List<Integer> traversal) {
        visited[v] = true;
        traversal.add(v);
        for (int adj : g[v]) {
            if (!visited[adj]) {
                recursiveDFS(g, adj, visited, traversal);
            }
        }
    }
}
