/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
/**
 *
 * @author nveob
 */
public class BFS {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String strFirstLine = sc.nextLine();

        //11 20 897
        String[] items = strFirstLine.split(" ");
        int n = Integer.parseInt(items[0]);
        int m = Integer.parseInt(items[1]);
        int s = Integer.parseInt(items[2]);

        List<Integer>[] grafo = new List[n+1];

        for (int i = 1; i<=n; i++)
        {
            grafo[i] = new ArrayList<>(n);
        }

        for (int i = 1; i<=m; i++)
        {
            String readLine = sc.nextLine();
            String[] elementos = readLine.split(" ");

            int u = Integer.parseInt(elementos[0]);
            int v = Integer.parseInt(elementos[1]);

            grafo[u].add(v);
            grafo[v].add(u);

        }

        List<Integer> recorrido = breadthFirstSearch(grafo, s);


        for (int i = 0; i<recorrido.size(); i++)
        {
            System.out.print(recorrido.get(i) + " ");
        }


    }

    public static List<Integer> breadthFirstSearch(List<Integer>[] g, int v) {

        int n = g.length;
        List<Integer> traversal = new ArrayList<>(n);
        boolean[] visited = new boolean[n];
        Queue<Integer> cola = new LinkedList<>();
        visited[v] = true;
        traversal.add(v);
        cola.add(v);

        while (!cola.isEmpty()) {
            int aux = cola.remove();
            for (int adj : g[aux]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    traversal.add(adj);
                    cola.add(adj);
                }
            }
        }
        return traversal;
    }

    public static List<Integer>[] breadthFirstSearch(List<Integer>[] g) {
        int n = g.length;
        List<Integer> traversals[] = new List[n];
        for (int v = 0; v < n; v++) {
            traversals[v] = breadthFirstSearch(g, v);
        }
        return traversals;
    }
}
