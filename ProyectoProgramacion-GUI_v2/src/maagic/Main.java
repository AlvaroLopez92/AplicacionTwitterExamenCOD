/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maagic;

import maagic.interfaz.MainInterfaz;

/**
 *
 * @author otorradomiguez
 */
public class Main {

    public static Jugador j1;
    public static Jugador j2;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        //Instancio el interfaz grafico
        MainInterfaz mI=new MainInterfaz();
        
    }
    
    public static void initGame(){
        //Instancio los jugadores. Hay que modificarlo para que cojan la baraja de la BD
        j1=new Jugador("barajas/Cartas.txt");
        j2=new Jugador("barajas/Cartas.txt");
        //Se barajan ambos mazos
        j1.barajar();
        j2.barajar();
        j1.cogerMano();
        j2.cogerMano();
        MainInterfaz.juego.updateCartas(j1,j2);
    }
    
    public static void repintar(){
        MainInterfaz.juego.updateCartas(j1,j2);
    }
}
