/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maagic.interfaz;

import GUI.DimensionPantalla;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.LEFT;
import maagic.Main;

/**
 *
 * @author otorradomiguez
 */
public class CartaVacia extends JPanel {

    public JLabel fondoVacio;

    public CartaVacia() {
        fondoVacio = new JLabel();
        this.setSize(160, 200);
        fondoVacio.setSize(160, 200);
        DimensionPantalla.resizeImagen("/maagic/img/fondoCarta.png",fondoVacio);
        //fondoVacio.setHorizontalAlignment(LEFT);
        this.add(fondoVacio);
        //this.setAlignmentX(1f);
        fondoVacio.setAlignmentY(0.5f);
        //fondoVacio.setVerticalAlignment(CENTER);
        fondoVacio.setPreferredSize(new Dimension(160, 200));
        //this.setBorder(BorderFactory.createLineBorder(Color.blue));
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Juego tempJuego=(Juego)fondoVacio.getParent().getParent().getParent().getParent();
                
                if(tempJuego.cartaSeleccionada!=-1 && tempJuego.turnoJ1){
                    /*
                    Aki en lugar de cambiar el interfaz tengo k cambiar el estado de la partida y luego llamar a Main.repintar()
                    */
                    System.out.println(tempJuego.cartaSeleccionada+", "+fondoVacio.getParent().getParent().getComponentZOrder(fondoVacio.getParent()));
                    Main.j1.moverManoMesa(tempJuego.cartaSeleccionada, fondoVacio.getParent().getParent().getComponentZOrder(fondoVacio.getParent()));
                    Main.repintar();
                    tempJuego.cartaSeleccionada=-1;
                    tempJuego.requestFocusInWindow();
                }else{
                fondoVacio.requestFocusInWindow();
                }
            }
        
        });
            
        
        fondoVacio.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                fondoVacio.setBorder(BorderFactory.createLineBorder(Color.white,3));
            }

            @Override
            public void focusLost(FocusEvent e) {
               fondoVacio.setBorder(null);
            }
        });
        
        this.setOpaque(false);
    }
}
