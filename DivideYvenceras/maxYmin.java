import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class maxYmin{
    public static void main(String [] args){
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        int dimension = scanner.nextInt();
        int[] arrays = new int[dimension];
        for(int i = 0; i < arrays.length; i++){
            int numero = rand.nextInt(100);
            arrays[i] = numero;
        }
        System.out.println(Arrays.toString(arrays));
        int num = maximo(arrays);
        System.out.println(num);
    }

    public static int maximo(int[] aux){
        return maximo(aux, 0, aux.length - 1);
    }

    public static int maximo(int[] aux, int ini, int fin){
        if(ini == fin){
            return aux[ini];
        }else{
            int medio = (ini + fin)/2;
            int maxIzq = maximo(aux, ini, medio);
            int maxDer = maximo(aux, medio + 1, fin);
            return Math.max(maxIzq, maxDer);
        }
    }
}