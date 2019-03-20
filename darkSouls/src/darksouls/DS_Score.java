/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darksouls;

import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author nveob
 */
public class DS_Score {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner oleada = new Scanner(System.in);
        try{

            int n = oleada.nextInt();
            int[] totalEnemigos = new int[n];

            for(int i = 0; i < totalEnemigos.length; i++){
                totalEnemigos[i] = oleada.nextInt();
            }
            
            int prueba = oleada.nextInt();
            
            int[] nivelPrueba = new int[prueba];
            for(int i = 0; i < nivelPrueba.length; i++){
                nivelPrueba[i] = oleada.nextInt();
            }
            //System.out.println(Arrays.toString(nivelCasoPrueba));
            
            int[] puntosTotales = puntosTotales(nivelPrueba, totalEnemigos);
            int[] derrotasTotales = derrotasTotales(nivelPrueba, totalEnemigos);
            for(int i = 0; i < puntosTotales.length; i++){                
                System.out.println(derrotasTotales[i] +" "+ puntosTotales[i]);
            }

            
        }catch(Exception e){
            System.out.println(e);
        }finally{
            System.out.checkError();
        }        
    }
    
    public static int [] puntosTotales(int[] niveles, int[] enemigos){
        int[] resultatos = new int[niveles.length];
        int puntos = 0;
        for(int i = 0; i < niveles.length; i++){
            for(int j = 0; j < enemigos.length; j++){
                if(enemigos[j] <= niveles[i]){
                    puntos += enemigos[j];
                    resultatos[i] = puntos;
                }
                
            }
            puntos = 0;
        }
        return resultatos;
    }
    
    public static int[] derrotasTotales(int[] niveles, int[] enemigos){
        int[] totalPuntos = new int[niveles.length];
        int derotados = 0;
        for(int i = 0; i < niveles.length; i++){
            for(int j = 0; j < enemigos.length; j++){
                if(enemigos[j] <= niveles[i]){
                    derotados ++;
                }
            }
            totalPuntos[i] = derotados;
            derotados = 0;
        }
        return totalPuntos;
    }
}
