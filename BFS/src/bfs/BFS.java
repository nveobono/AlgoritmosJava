/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs;

import java.io.IOException;
import java.util.Arrays;
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
        try{
            System.out.println("Introduce el numero de nodos, aristas y nodo de inicio recorrido: ");
            int[] datos = new int[3];
            for(int i = 0; i < datos.length; i++){
                datos[i] = scanner.nextInt();
            }    
            System.out.println(Arrays.toString(datos));
            
        }catch(Exception e){
           System.out.println(e);
        }finally{
            System.out.checkError();
        }
    }
    
}
