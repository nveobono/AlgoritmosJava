/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipodarksoul;

import java.util.Scanner;

/**
 *
 * @author nveob
 */
public class EquipoDarkSoul {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        
        /*System.out.println("Número de piezas de armadura disponibles para elegir");
        int piezas = scanner.nextInt();
        System.out.println("peso máximo que puede soportar el jugador");
        int peso = scanner.nextInt();*/
        
        String modoJugador;
        do{
            System.out.println("el modo en el que quiere ir el jugador, que puede ser ligero, medio o pesado");
            modoJugador = scanner1.next();
        }while("ligero".equals(modoJugador) || "medio".equals(modoJugador) || "pesado".equals(modoJugador));
        
        System.out.println(modoJugador);
    }    
}
