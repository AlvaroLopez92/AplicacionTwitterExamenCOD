/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maagic.interfaz;

import GUI.DimensionPantalla;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;

/**
 *
 * @author otorradomiguez
 */
public class MainInterfaz {
    
    public static JFrame marco=new JFrame();
    public static Menu menu;
    public static Juego juego;
    public boolean resizeControl=false;
    
    public MainInterfaz(){
        initMain();
        
    }
    
    public static ComponentAdapter ajustarImagen=new ComponentAdapter(){
            @Override
            public void componentResized(ComponentEvent e) {
                marco.setTitle("Juego");
                if(e.getSource()==marco){
                menu.fondo.setSize(marco.getSize());
                DimensionPantalla.resizeImagen("/maagic/img/ImagenFondo.jpg", menu.fondo);
                menu.logo.setSize(marco.getWidth()/3,marco.getHeight()/4);
                DimensionPantalla.resizeImagen("/maagic/img/logo.png",menu.logo);
                    System.out.println("menu is showing"+menu.fondo.isShowing()+e.paramString());
                    System.out.println(e.getID());
                }
                else if(e.getSource()==marco){
                    juego.fondo.setSize(marco.getSize());
                    DimensionPantalla.resizeImagen("/maagic/img/pantallazo.png", juego.fondo);
                    System.out.println("Juego is showing"+juego.fondo.isShowing()+e.paramString());
                    System.out.println();
                }
            }
        };
    
    public void initMain(){
        
        //Creamos el frame
        //marco.setUndecorated(true);
        marco.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setLocationRelativeTo(null);
        //añadimos el menu
        menu= new Menu();
        marco.add(menu);
        /*Lo hacemos visible
        Voy a meter el component adapter en un metodo para llamarlo unicamente
        desde las imagenes que lo necesitan, pq sino se lanza con cada componente 
        que cambia de tamaño
        */
        
        
        marco.setVisible(true);
        
                
    }
    
}
