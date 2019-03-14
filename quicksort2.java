import java.util.Arrays;
import java.util.Random;

public class Quicksort{

    public static void main(String [] args) {
        
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cual es la dimension del Array: ");
        int dimension = scanner.nextInt();
        int[] arrayQuick = new int[dimension];
        for(int i = 0; i < arrayQuick.length; i++){
            int num = rand.nextInt(100) + 1;
            arrayQuick[i] = num;
        }
           System.out.println("No ordenado: "+Arrays.toString(arrayQuick));
           Prueba.quicksort(arrayQuick);
           System.out.println("Ordenado: " + Arrays.toString(arrayQuick));
    }
    public static void quicksort(int[] vector){
        quicksort(vector, 0, vector.length - 1);
    }
    public static void quicksort(int[] vector, int ini, int fin){
        if(ini < fin + 1){
            int p = partition(vector, ini, fin);
            quicksort(vector, ini, p - 1);
            quicksort(vector, p + 1, fin);
        }
    }
    public static void intercambiar(int[] vector, int x, int y){
        int temp = vector[x];
        vector[x] = vector[y];
        vector[y] = temp;
    }
    public static int getPivot(int ini, int fin){
        Random rand = new Random();
        return rand.nextInt((fin - ini) + 1) + ini;
    }

    private static int partition(int[] vector, int ini, int fin){
        intercambiar(vector, ini, getPivot(ini, fin));
        int border = ini + 1;
        for(int i = border; i <= fin; i++){
            if(vector[i] < vector[ini]){
                intercambiar(vector, i, border++);
            }
        }
        intercambiar(vector, ini, border - 1);
        return border - 1;
    }
}