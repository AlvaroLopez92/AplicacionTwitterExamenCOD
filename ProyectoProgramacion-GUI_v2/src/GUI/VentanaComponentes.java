/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author otorradomiguez
 */
public class VentanaComponentes {
    
public void ventanaComponentes(){
    //Cremaos un frame nuevo
    JFrame frame= new JFrame("Esto es lo basico");
    frame.setBounds(0, 0, 800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    //Creamos tres botones
    //Este con constructor vacio
    JButton b1=new JButton();
    //A este le pasamo una string con el texto a mostrar
    JButton b2=new JButton("BOTON");
    //A este le pasamos un icono
    ImageIcon iconoB3=new ImageIcon(getClass().getResource("/maagic/img/mana.png"));
    JButton b3=new JButton(iconoB3);
    //Creamos una etiqueta (Para mostrar texto o imagenes)
    JLabel l1=new JLabel("ETIQUETA");
    //Antes de añadir los componentes les damos dimensiones
    b1.setSize(100, 50);
    b2.setSize(200, 100);    
    //Y los posicionamos
    b1.setLocation(400, 200);
    b2.setLocation(100, 0);
    //En el caso de b3 hacemos ambas cosas con setBounds
    b3.setBounds(500, 300, 300, 300);
    //Ahora les damos colorines de fondo
    b1.setBackground(Color.red);
    b2.setBackground(Color.green);
    b3.setBackground(Color.yellow);
    //activamos/desactivamos el boton 2
    b2.setEnabled(true);
    //lo hacemos transparente
    b2.setOpaque(false);
    //Le quitamos el texto    
    b2.setText(null);
    /*
    Podriamos poner debajo de el contenido y que el boton manejase las acciones
    */
    //Le ponemos un borde a la etiqueta
    l1.setBorder(BorderFactory.createLineBorder(Color.green));
    //Añadimos los componentes al frame
    frame.add(b1);
    frame.add(b2);
    frame.add(b3);
    frame.add(l1);    
    //El set visible va al final para que se añada todo antes de mostrarlo
    frame.setVisible(true);
}    
}
