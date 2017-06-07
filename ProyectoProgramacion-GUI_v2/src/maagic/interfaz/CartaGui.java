/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maagic.interfaz;

import GUI.DimensionPantalla;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author otorradomiguez
 */
public class CartaGui extends JPanel {

    public JLabel vida, ataque, coste, fondo;
    public JPanel panelGrid;

    public CartaGui() {
        vida = new JLabel();
        ataque = new JLabel();
        coste = new JLabel();
        fondo = new JLabel();
        panelGrid = new JPanel();

        //this.setBorder(BorderFactory.createLineBorder(Color.yellow));
        this.setLayout(new OverlayLayout(this));
        fondo.setFocusable(true);
        this.setSize(160, 200);
        fondo.setSize(160, 200);

        panelGrid.setSize(new Dimension(160, 200));
        panelGrid.setLayout(new GridLayout(2, 2));

        vida.setSize(40, 40);
        ataque.setSize(40, 40);
        coste.setSize(40, 40);

        Font fuente = new Font("Courier New", Font.BOLD, 20);

        vida.setFont(fuente);
        ataque.setFont(fuente);
        coste.setFont(fuente);

        vida.setHorizontalTextPosition(CENTER);
        ataque.setHorizontalTextPosition(CENTER);
        ataque.setForeground(Color.RED);
        coste.setHorizontalTextPosition(CENTER);
        coste.setForeground(Color.RED);

        panelGrid.add(coste);

        panelGrid.add(Box.createGlue());

        panelGrid.add(ataque);

        panelGrid.add(vida);

        panelGrid.setAlignmentX(0f);
        coste.setHorizontalAlignment(0);
        ataque.setHorizontalAlignment(0);
        vida.setHorizontalAlignment(0);

        DimensionPantalla.resizeImagen("/maagic/img/corazon.png", vida);
        DimensionPantalla.resizeImagen("/maagic/img/espada.png", ataque);
        DimensionPantalla.resizeImagen("/maagic/img/mana.png", coste);

        DimensionPantalla.resizeImagen("/maagic/img/fondoCarta.png", fondo);

        this.add(panelGrid);
        this.add(fondo);

        panelGrid.setOpaque(false);
        this.setOpaque(false);

        fondo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fondo.requestFocusInWindow();
            }
        });

        fondo.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                fondo.setBorder(BorderFactory.createLineBorder(Color.blue, 3));
            }

            @Override
            public void focusLost(FocusEvent e) {
                fondo.setBorder(null);
            }
        });
        
        fondo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D){
                    System.out.println("pulsas d o flecha derecha");
                    System.out.println(fondo.getParent().getParent().getComponentZOrder(fondo.getParent()));
                    System.out.println(fondo.getParent());
                    System.out.println(fondo.getParent().getParent());
                    System.out.println(fondo.getParent().getParent().getParent());
                    System.out.println(fondo.getParent().getParent().getParent().getParent());
                    Juego tempJuego=(Juego)fondo.getParent().getParent().getParent().getParent();
                    tempJuego.cartaSeleccionada=fondo.getParent().getParent().getComponentZOrder(fondo.getParent());
                }else if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A){
                    System.out.println("Pulsas a o flecha izq");
                }
            }
        
        });
    }

}
