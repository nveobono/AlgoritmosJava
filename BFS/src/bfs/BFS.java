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
            
            
            List<Integer> g = new ArrayList<>();
            g.add(1,2);
            g.add(1,5);
            g.add(2,3);
            g.add(3,4);
            g.add(3,5);
            
            BFS.breadthFirstSearch(g, 2);
            
            /*System.out.println("Introduce el numero de nodos, aristas y nodo de inicio recorrido: ");
            int[] datos = new int[3];
            for(int i = 0; i < datos.length; i++){
                datos[i] = scanner.nextInt();
            }    
            System.out.println(Arrays.toString(datos));
            
            List<Integer> g = new ArrayList<Integer>();
            for(int i = 0; i < 2*datos[0]; i++){
                int nodoAris = sc.nextInt();
                g.add(nodoAris);
            }
            
            g.forEach((out) -> {
                System.out.println("ArrayList: " + g.get(out));
            });*/
                       
            
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
            g[aux].stream().filter((adj) -> (!visited[adj])).map((adj) -> {
                visited[adj] = true;
                return adj;
            }).map((adj) -> {
                traversal.add(adj);
                return adj;
            }).forEachOrdered((adj) -> {
                q.add(adj);
            });
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
