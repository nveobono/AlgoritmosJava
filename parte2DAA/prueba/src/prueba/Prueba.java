/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author nveob
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static boolean isPromising(List<Integer>[] graph, int[] solution, int elem, int lim) {
        int j = 0;
        boolean found = false;
        while (j <= lim && !found) {
            if (solution[j] == elem) {
                found = true;
            } else {
                j++;
            }
        }
        return !found;
    }

    public static void printSolution(int[] solution) {
        for (int i = 0; i < solution.length; i++) {
            System.out.print("[" + solution[i] + "]");
        }
        System.out.println();
    }

    public static void hamiltonian(List<Integer>[] graph, int[] solution, int k) {
        List<Integer> adjacents = new ArrayList<>(graph[solution[k - 1]]);
        while (!adjacents.isEmpty()) {
            int candidate = adjacents.remove(0);
            if (isPromising(graph, solution, candidate, k - 1)) {
                solution[k] = candidate;
                if (k == solution.length - 1) {
                    if (graph[candidate].contains(solution[0])) {
                        printSolution(solution);
                    }
                } else {
                    hamiltonian(graph, solution, k + 1);
                }
                solution[k] = -1;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer>[] graph = new List[8];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(1);
        graph[1].add(0);
        graph[0].add(2);
        graph[2].add(0);
        graph[0].add(3);
        graph[3].add(0);
        graph[1].add(2);
        graph[2].add(1);
        graph[1].add(4);
        graph[4].add(1);
        graph[1].add(5);
        graph[5].add(1);
        graph[2].add(3);
        graph[3].add(2);
        graph[2].add(5);
        graph[5].add(2);
        graph[2].add(6);
        graph[6].add(2);
        graph[3].add(6);
        graph[6].add(2);
        graph[3].add(7);
        graph[7].add(3);
        graph[4].add(5);
        graph[5].add(4);
        graph[5].add(6);
        graph[6].add(5);
        graph[6].add(7);
        graph[7].add(6);
        int[] solution = new int[8];
        Arrays.fill(solution, -1);
        solution[0] = 0;
        hamiltonian(graph, solution, 1);
    }
}
