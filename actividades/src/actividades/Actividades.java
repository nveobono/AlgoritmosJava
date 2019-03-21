/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        
        int[] arrayCasos = new int[casos];
        List<int[]> arrayActividados = new ArrayList<>(casos);
        
        for(int i = 0; i < casos; i++){         
            int suma = scanner.nextInt();
            arrayCasos[i] = suma;
            int[] arrays = new int[2 * arrayCasos[i]];
            for(int j = 0; j < 2 * suma; j++){                
                int activo = scanner.nextInt();
                arrays[j] = activo;
            }
            arrayActividados.add(arrays);
        }
        
        for(int i = 0; i < arrayCasos.length; i++) {   
            System.out.print(arrayCasos[i] + " ");
        } 
        System.out.println("");
        for(int i = 0; i < arrayActividados.size(); i++) {   
            System.out.print(" " + Arrays.toString(arrayActividados.get(i)));
        } 
        
        List<Integer> resultado = actividadesAtender(arrayActividados);
        for(int i = 0; i < resultado.size(); i++){
            System.out.println(resultado.get(i));
        }
        
    }
    
    public static List<Integer> actividadesAtender(List<int[]> misActividades){
        List<Integer> listaActividades = new ArrayList<>();
        
        return listaActividades;        
    }
    
}
