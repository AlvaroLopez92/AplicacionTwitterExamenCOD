/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maagic.interfaz;

import GUI.DimensionPantalla;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

/**
 *
 * @author Delio
 */
public final class InterfadSeleccion extends JPanel {
    public InterfadSeleccion() {
        initComponents();
    }
    public void initComponents(){
         this.setLayout(new OverlayLayout(this));
        
        JLabel fondo = new JLabel();
        fondo.setSize(MainInterfaz.marco.getSize());
        fondo.setAlignmentX(0.5f);
        DimensionPantalla.resizeImagen("/maagic/img/ImagenFondo.jpg", fondo);
    //
    JPanel  jugador1    =   new JPanel();
    JButton botonSelectj1 =   new JButton();
    JButton botonBorrarJugador =   new JButton();
    JButton botonCancelarj1   =   new JButton();
    JButton botonCrearj =   new JButton();
    JComboBox   cajaJugadoresj1   =   new JComboBox();
    JComboBox   cajaJugadoresj2   =   new JComboBox();
    JButton botonSelectj2   =   new JButton();
    JButton botonCancelar2  =   new JButton();
    JButton botonJugar  =   new JButton();
    JButton volverMenu  =   new JButton();
    //
    jugador1.add(botonSelectj1);
    jugador1.add(botonCancelarj1);
    jugador1.add(cajaJugadoresj1);
    jugador1.add(botonBorrarJugador);
    jugador1.add(botonCrearj);
    jugador1.add(cajaJugadoresj2);
    jugador1.add(botonSelectj2);
    jugador1.add(botonCancelar2);
    jugador1.add(botonJugar);
    jugador1.add(volverMenu);
    //
    botonSelectj1.setPreferredSize(new Dimension(100, 40));
    botonCancelarj1.setPreferredSize(new Dimension(100, 40));
    botonBorrarJugador.setPreferredSize(new Dimension(100, 40));
    botonCrearj.setPreferredSize(new Dimension(100, 40));
    botonSelectj2.setPreferredSize(new Dimension(100, 40));
    botonCancelar2.setPreferredSize(new Dimension(100, 40));
    botonJugar.setPreferredSize(new Dimension(100, 40));
    volverMenu.setPreferredSize(new Dimension(100, 40));
    //
    botonSelectj1.setText("Seleccionar Jugador 1");
    botonCancelarj1.setText("Cancelar Selección");
    botonBorrarJugador.setText("Borrar un Jugador");
    botonCrearj.setText("CrearJugador");
    botonSelectj2.setText("Seleccionar Jugador 2 ");
    botonCancelar2.setText("Cancelar Selección");
    botonJugar.setText("Jugar");
    volverMenu.setText("Volver al Menu");
    
    botonSelectj1.setAlignmentX(0.5f);
        botonSelectj1.addActionListener((java.awt.event.ActionEvent evt) -> {
            botonSelectj1ActionPerformed(evt);
        });
        botonCancelarj1.setAlignmentX(0.5f);
        botonCancelarj1.addActionListener((java.awt.event.ActionEvent evt) -> {
            botonCancelarj1ActionPerformed(evt);
        });
        botonBorrarJugador.setAlignmentX(0.5f);
        botonBorrarJugador.addActionListener((java.awt.event.ActionEvent evt) -> {
            botonBorrarJugadorActionPerformed(evt);
        });
        botonCrearj.setAlignmentX(0.5f);
        botonCrearj.addActionListener((java.awt.event.ActionEvent evt) -> {
            botonCrearjActionPerformed(evt);
        });
        botonSelectj2.setAlignmentX(0.5f);
        botonSelectj2.addActionListener((java.awt.event.ActionEvent evt) -> {
            botonSelectj2ActionPerformed(evt);
        });
        botonCancelar2.setAlignmentX(0.5f);
        botonCancelar2.addActionListener((java.awt.event.ActionEvent evt) -> {
            botonCancelar2ActionPerformed(evt);
        });
        botonJugar.setAlignmentX(0.5f);
        botonJugar.addActionListener((java.awt.event.ActionEvent evt) -> {
            botonJugarActionPerformed(evt);
        });
        volverMenu.setAlignmentX(0.5f);
        volverMenu.addActionListener((java.awt.event.ActionEvent evt) -> {
            volverMenuActionPerformed(evt);
        });
    
    
    
    }

    private void botonSelectj1ActionPerformed(ActionEvent evt) {
        
    }

    private void botonCrearjActionPerformed(ActionEvent evt) {
       
    }

    private void botonBorrarJugadorActionPerformed(ActionEvent evt) {
        
    }

    private void botonSelectj2ActionPerformed(ActionEvent evt) {
        
    }

    private void botonCancelar2ActionPerformed(ActionEvent evt) {
        
    }

    private void botonJugarActionPerformed(ActionEvent evt) {
        
    }

    private void volverMenuActionPerformed(ActionEvent evt) {
       
    }

    private void botonCancelarj1ActionPerformed(ActionEvent evt) {
       
        
    }
}
