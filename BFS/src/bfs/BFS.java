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
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        try{
            
            System.out.println("Introduce el numero de nodos, aristas y nodo de inicio recorrido: ");
            int[] datos = new int[3];
            for(int i = 0; i < datos.length; i++){
                datos[i] = scanner.nextInt();
            }    
            System.out.println(Arrays.toString(datos));
            
            List<Integer> nodoAristas = new ArrayList<>();
            for(int i = 0; i < 2*datos[0]; i++){
                int nodoAris = sc.nextInt();
                nodoAristas.add(nodoAris);
            }
            
            nodoAristas.forEach((out) -> {
                System.out.println("ArrayList: " + nodoAristas.get(out));
            });
                       
                       
        }catch(Exception e){
           System.out.println(e);
        }finally{
            System.out.println("Final");
        }
    }
    
    
    public static List<Integer> breadthFirstSearch(List<Integer>[] g, int v) {
        int n = g.length;
        List<Integer> traversal = new ArrayList<>(n);
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        traversal.add(v);
        q.add(v);
        while (!q.isEmpty()) {
            int aux = q.remove();
            for (int adj : g[aux]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    traversal.add(adj);
                    q.add(adj);
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
