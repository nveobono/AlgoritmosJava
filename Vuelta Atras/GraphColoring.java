package tema5_bt;

import java.util.ArrayList;
import java.util.List;

public class GraphColoring {

    public static void printSolution(int[] solution) {
        for (int i = 0; i < solution.length; i++) {
            System.out.print("["+solution[i]+"]");
        }
        System.out.println();
    }

    public static boolean isFeasible(List<Integer>[] graph, int k, int[] solution) {
        for (int adj : graph[k]) {
            if (solution[adj] == solution[k]) {
                return false;
            }
        }
        return true;
    }

    public static void color(List<Integer>[] graph, int k, int m, int[] solution) {
        solution[k] = 0;
        while (solution[k] != m) {
            solution[k]++;
            if (isFeasible(graph, k, solution)) {
                if (k < solution.length-1) {
                    color(graph, k+1, m, solution);
                } else {
                    printSolution(solution);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer>[] graph = new List[4];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(1); graph[1].add(0);
        graph[0].add(2); graph[2].add(0);
        graph[0].add(3); graph[3].add(0);
        graph[2].add(3); graph[3].add(2);

        color(graph, 0, 3, new int[4]);
    }
}
