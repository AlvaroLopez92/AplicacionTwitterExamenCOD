/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author otorradomiguez
 */
public class VentanaPrincipal {
    /*
    En esta clase normal instanciamos un nuevo jFrame. En JFrame2 creamos una clase 
    que extiende JFrame
    */
    public void NuevoFrame(){
        //Creamos un frame
        JFrame frame=new JFrame("Titulo que sale en el marco de la ventana");
        /*Le cambiamos el background, no al frame en si, pq al abrirse el contentPane
        encima lo taparia. Asi k para evitar eso le cambiamos el color al contentPane*/
        frame.getContentPane().setBackground(Color.blue);
        //Establecemos posicion (0,0) y tamaño (800,600)
        frame.setBounds(0, 0, 800, 600);
        //Definimos el comportamiento al cerrarse
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Lo hacemos visible
        frame.setVisible(true);
        //Cambiamos el titulo del frame
        frame.setTitle("Pruebas JFrame");
        /*Sobreescribimos la posicion para que salga centrada. Cambiando el null
        por un elemento podemos posicionarlo en relacion a dicho elemento*/
        frame.setLocationRelativeTo(null);
    }
}
