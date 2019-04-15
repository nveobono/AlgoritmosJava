/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinacionnumeros;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nveob
 */
public class CombinacionNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List listanum = new ArrayList<>();
        
        combinacionNum(n, listanum, 0);
    }

    private static void combinacionNum(int n, List listanum, int suma) {
        
        if(suma == n){
            System.out.println(listanum);
        }else{
            for(int i = 1; i <= n; i++ ){
                suma += i;
                if(suma <= n){
                    listanum.add(i);
                    combinacionNum(n, listanum, suma);
                    listanum.remove(listanum.indexOf(i));
                }
                suma -= i;
                
                
            }
        }
    }
    
}
