/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author nveob
 */
public class Mergesort {

    public static void main(String[] args) {
        Scanner dimension = new Scanner(System.in);
        int n = dimension.nextInt();
        
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = dimension.nextInt();
        }
        mergeSort(array, 0, array.length - 1);
        
        for(int i = 0 ; i < array.length; i++){
            System.out.print(array[i]+ " ");
        }

    }
    
    public static void mergeSort(int[] array, int inferior, int superior){
        if(inferior < superior){
            int medio = (superior + inferior)/2;
            mergeSort(array, inferior, medio);
            mergeSort(array, medio + 1, superior);
            combinar(array, inferior, medio, superior);
        }
    }
    
    public static void combinar(int[] array, int inf, int medio ,int sup){
        int[] arrayAux = new int[array.length];
        int izqInf = inf;
        int izqSup = medio + 1;
        int supAux = inf;
        
        while ((izqInf <= medio) && (izqSup <= sup)) {
            if(array[izqInf] < array[izqSup]){
                arrayAux[supAux] = array[izqInf];
                izqInf++;
            }else{
                arrayAux[supAux] = array[izqSup];
                izqSup++;
            }
            supAux++;
        }
        
        for(int i = izqInf; i <= medio; i++){
            arrayAux[supAux] = array[i];
            supAux++;
        }
        
        for(int i = izqSup; i <= sup; i++){
            arrayAux[supAux] = array[i];
            supAux++;
        }
                
        for(int i = inf; i <= sup; i++){
            array[i] = arrayAux[i];
        }               
    }
    
}
