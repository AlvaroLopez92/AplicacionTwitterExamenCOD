/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JFrame;

/**
 *
 * @author otorradomiguez
 */
public class JFrame2 extends JFrame{
    //Creamos un metodo para iniciar la ventana
    public void iniciar(){
        //Establecemos el tamaño
        this.setSize(800, 600);
        //Definimos comportamiento al cerrarse
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Establecemos el titulo, como se ve no es necesario usar el this siempre
        setTitle("Titulo");
        //La hacemos visible
        setVisible(true);
    }
    
}
