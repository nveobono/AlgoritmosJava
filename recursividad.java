import java.util.Scanner;

public class recursividad{

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        imprimir(n);
        System.out.println("");
        int valor = factorial(n);
        System.out.println(valor);
    }
    public static void imprimir(int n){
        if(n < 0){
            System.out.println(n);
        }else if(n > 0){
            imprimir( n - 1);
            System.out.print(n + " ");           
        }
    }
    
    public static int factorial(int n){
        if(n > 0){
            int valor = n * factorial(n - 1);
            return valor;
        }else{
            return 1;
        }
    }
}