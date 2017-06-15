/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciontwitter;

import javax.swing.JOptionPane;
import twitter4j.TwitterException;
import aplicaciontwitter.Conectar;
/**
 *
 * @author alopezcobo
 */
public class AplicacionTwitter {

    public static void main(String[] args) throws TwitterException {
        // Menú principal
        
        String busqueda,tweet;
        Conectar obj1 = new Conectar();
                
        int opciones;
        do{
            opciones=Integer.parseInt(JOptionPane.showInputDialog("1- Ver TimeLine y buscar Trending \n2- Tweetear \n3- Enviar Mensaje Directo \n0- Salir"));
                switch(opciones){
                    case 1:
                        //Opción para ver Timelines
                        obj1.verTimeLine(); 
                        busqueda  =JOptionPane.showInputDialog("Introduce lo que deseas buscar:");
                        obj1.buscarTrending(busqueda);
                        break;
                    case 2:
                        //Opción para twittear
                        tweet = JOptionPane.showInputDialog("Introduce un tweet:");
                        obj1.tuiteando(tweet);
                        break;
                    case 3:
                        //Opción paa mandar mensajes directos.
                        obj1.directMenssage();
                        break;
                    case 0:
                        //Salir.
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Error");
                }
            }while(opciones!=0);
    }
    
}
