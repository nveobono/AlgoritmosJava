/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author nveob
 */
public class Actividades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Numero de casos: ");
        int casos = scanner.nextInt();
        
        ArrayList<Integer> arrayCasos = new ArrayList<>(casos);
        ArrayList<Integer> arrayActividados = new ArrayList<>();
        
        for(int i = 0; i < casos; i++){
            
            int suma = scanner.nextInt();
            arrayCasos.add(suma);
            
            for(int j = 0; j < 2 * suma; j++){
                
                int activo = scanner.nextInt();
                arrayActividados.add(activo);
            }
        }
        
        for(int i = 0; i < arrayCasos.size(); i++) {   
            System.out.print(arrayCasos.get(i) + "");
        } 
        for(int i = 0; i < arrayActividados.size(); i++) {   
            System.out.print(arrayActividados.get(i) + "");
        } 
        
    }
    
}
