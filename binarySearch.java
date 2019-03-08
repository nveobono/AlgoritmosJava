/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author nveob
 */
public class Prueba {

    //Devuel la posicion del elemento en el array
    //Array tiene que estar previamente ordenado
    public static void main (String [] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Dimension array: ");
        int n = input.nextInt();
        int [] array = new int[n];
        Random rand = new Random();
        for(int i = 0; i < array.length; i++){
            int numero = rand.nextInt(10);
            array[i] = numero;
        }

        System.out.println(Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        System.out.println("Que numero quieres entrocar: ");
        int q = input.nextInt();
        
        int index = recbinarySearch(array,q);
        System.out.println(index);
    }

    public static int recbinarySearch(int [] v, int q){
        return auxBynarySearch(v, 0, v.length - 1, q);
    }

    private static int auxBynarySearch(int [] v, int i, int j, int q){
        if(i > j){
            return - 1; //dato no encontrado
        }
        int k = (i + j)/2;
        if(v[k] == q){
            return k;
        }else if(v[k] < q){
            return auxBynarySearch(v, k+1, j, q);
        }else{
            return auxBynarySearch(v, i, k - 1, q);
        }
    }

    //ordenacion array merge sort
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