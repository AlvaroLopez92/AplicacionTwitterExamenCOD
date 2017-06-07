/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maagic.interfaz;

import GUI.DimensionPantalla;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import maagic.Main;

/**
 *
 * @author otorradomiguez
 */
public class Menu extends JPanel {

    public JLabel fondo;
    public JLabel logo;
    public JPanel panelMenu;
    public JButton nuevaPartida;
    public JButton modificarBaraja;
    public JButton salir;

    public Menu() {
        initComponents();
    }

    public void initComponents() {

        //Tengo k buscar un layout que coloque bien las cosas encima unas de otras
        //kiza usar layered pane?
        this.setLayout(new OverlayLayout(this));
        
        fondo = new JLabel();
        fondo.setSize(MainInterfaz.marco.getSize());
        fondo.setAlignmentX(0.5f);
        DimensionPantalla.resizeImagen("/maagic/img/ImagenFondo.jpg", fondo);
        panelMenu = new JPanel();
        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));
        panelMenu.setOpaque(false);
        panelMenu.setSize(MainInterfaz.marco.getSize());

        logo = new JLabel();
        logo.setSize(MainInterfaz.marco.getWidth() / 3, MainInterfaz.marco.getHeight() / 4);
        DimensionPantalla.resizeImagen("/maagic/img/logo.png", logo);
        nuevaPartida = new JButton("Nueva partida");
        modificarBaraja = new JButton("Editar barajas");
        salir = new JButton("Salir al escritorio");

        logo.setAlignmentX(0.5f);
        nuevaPartida.setAlignmentX(0.5f);
        nuevaPartida.addActionListener((java.awt.event.ActionEvent evt) -> {
            nuevaPartidaActionPerformed(evt);
        });
        modificarBaraja.setAlignmentX(0.5f);
        modificarBaraja.addActionListener((java.awt.event.ActionEvent evt) -> {
            modificarBarajaActionPerformed(evt);
        });
        salir.setAlignmentX(0.5f);
        salir.addActionListener((java.awt.event.ActionEvent evt) -> {
            SalirActionPerformed(evt);
        });
        //Con los verticalGlue en lugar de los struts si modifica el tamaño del boton verticalmente
        nuevaPartida.setPreferredSize(new Dimension(100, 40));
        modificarBaraja.setPreferredSize(new Dimension(100, 40));
        salir.setPreferredSize(new Dimension(100, 40));

        panelMenu.add(Box.createVerticalGlue());
        panelMenu.add(logo);
        panelMenu.add(Box.createVerticalGlue());
        panelMenu.add(nuevaPartida);
        panelMenu.add(Box.createVerticalGlue());
        panelMenu.add(modificarBaraja);
        panelMenu.add(Box.createVerticalGlue());
        panelMenu.add(salir);
        panelMenu.add(Box.createVerticalGlue());

        panelMenu.setAlignmentX(0.5f);
        this.add(panelMenu);
        this.add(fondo);

    }

    private void nuevaPartidaActionPerformed(ActionEvent evt) {
        
        MainInterfaz.juego = new Juego();
        Main.initGame();
        MainInterfaz.marco.getContentPane().removeAll();
        MainInterfaz.marco.add(MainInterfaz.juego);
        //Hay que poner el repaint() revalidate() para que redibuje todo tras quitar/poner panels
        MainInterfaz.marco.repaint();
        MainInterfaz.marco.revalidate();

    }

    private void modificarBarajaActionPerformed(ActionEvent evt) {
        EditarBarajas Barajas = new EditarBarajas();
        this.repaint();
        this.add(Barajas);
    }

    private void SalirActionPerformed(ActionEvent evt) {
        System.exit(0);
    }
}
