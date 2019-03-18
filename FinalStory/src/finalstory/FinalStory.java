/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalstory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nveob
 */
public class FinalStory {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int combates = sc.nextInt();
        for(int i = 0; i < combates; i++){
            int myATK = sc.nextInt();
            int enemies = sc.nextInt();
            List<Double> enemiesATK = new ArrayList<Double>();
            List<Double> enemiesHP = new ArrayList<Double>();
            
            Scanner scanner = new Scanner(System.in);
            String atk = scanner.nextLine();
            String[] atks = atk.split(" ");
            for(int j = 0; j < atks.length; j++){
                enemiesATK.add(Double.parseDouble(atks[j]));
                //enemiesATK[j] = Integer.parseInt(atks[j]);
            }
            
            Scanner scanner1 = new Scanner(System.in);
            String hp = scanner.nextLine();
            String[] hps = hp.split(" ");
            for(int j = 0; j < hps.length; j++){
                enemiesHP.add(Double.parseDouble(hps[j]));
            }
            
            //ordenar
            List<Double> ordenadoATK = new ArrayList<Double>();
            List<Double> ordenadoHP = new ArrayList<Double>();
            double currentTarget = 0;
            int indice = 0;
            for(int l = 0; l < enemies; l++){
                indice = 0;
                currentTarget = 0;
                for(int m = 0; m < enemiesHP.size(); m++){
                    if((currentTarget < enemiesATK.get(m) / enemiesHP.get(m)) && myATK <= enemiesHP.get(m)){
                        currentTarget = enemiesATK.get(m) / enemiesHP.get(m);
                        indice = m;
                    }
                }
                ordenadoATK.add(enemiesATK.get(indice));
                ordenadoHP.add(enemiesHP.get(indice));
                enemiesATK.remove(indice);
                enemiesHP.remove(indice);
            }
            
            int rellenar = 0;
            while(!enemiesHP.isEmpty() && !enemiesATK.isEmpty()){
                ordenadoATK.add(enemiesATK.get(rellenar));
                ordenadoHP.add(enemiesHP.get(rellenar));
                enemiesATK.remove(rellenar);
                enemiesHP.remove(rellenar);
                rellenar++;
            }
            
            int cont = 0;
            int indice1 = 0;
            while(!ordenadoHP.isEmpty()){
                for(int n = 0; n < ordenadoATK.size(); n++){
                    cont += ordenadoATK.get(n);
                }
                ordenadoHP.set(indice, ordenadoHP.get(indice) - myATK);
                if(ordenadoHP.get(indice) <= 0){
                    ordenadoHP.remove(indice);
                    ordenadoATK.remove(indice);
                }
            }
            System.out.println(/*"daño recibido: " + */cont);  
        }
    }
    
}
