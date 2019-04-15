import java.util.ArrayList;
import java.util.List;

public class DFSP{
    public static List<Integer> dfs(List<Integer> g, int v) {
        int n = g.length;
        List<Integer> traversal = new ArrayList<>(n);
        boolean[] visited = new boolean[n];
        recursiveBFS(g,v,visited, traversal);
    }

    public static List<Integer>[] dfs(List<Integer> g){
        int n = g.length;
        List<Integer> traversals[] = new ArrayList<>();
        for(int v = 0; v < n; n++){
            traversals = dfs(g, v);
        }
        return traversals;
    }

    public static void recursiveBFS(List<Integer> g, int v, boolean[] visited, List<Integer> traversal){
        visited[v] = true;
        traversal.add(v);
        for(int adj: traversals){
            if(!visited[adj]){
                recursiveBFS(g, adj, visited, traversal);
            }
        }
    }
}