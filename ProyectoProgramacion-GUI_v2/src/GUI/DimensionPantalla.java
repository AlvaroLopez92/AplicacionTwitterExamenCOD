/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Delio
 */
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Delio
 */
import javax.swing.JPanel;
import javax.swing.text.View;
public class DimensionPantalla extends JPanel{
    
    /*
    COMO USAR ESTOS METODOS:
        - Para el Frame principal:
        Tras el: initComponents(); hay k poner:
        this.setSize(1920,1080);
        this.getRootPane().setSize(1920, 1080);
        DimensionPantalla.adaptarFrame(this);
        DimensionPantalla.adaptarResolucion(panelprincipal);
        panelprincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        DimensionPantalla.adaptarResolucion(menu);
        DimensionPantalla.adaptarResolucion(Boton1Jugar);
        DimensionPantalla.adaptarResolucion(Boton2Baraja);
        DimensionPantalla.adaptarResolucion(Boton3Salir);
        DimensionPantalla.adaptarResolucion(imagentitulo);
        DimensionPantalla.adaptarResolucion(imagenfondo);
        DimensionPantalla.adaptarResolucion(panelJugarTest);
        panelJugarTest.setVisible(false);
    
        -Para los paneles de los menus:
        initComponents();
        this.setSize(800,600);
        DimensionPantalla.adaptarResolucion(jButtonCargar);
        DimensionPantalla.adaptarResolucion(jButtonVolver);
        DimensionPantalla.adaptarResolucion(jButtonGuardar);
        DimensionPantalla.adaptarResolucion(jLabelFondo);
        DimensionPantalla.adaptarResolucion(jScrollPaneCartas);
        DimensionPantalla.adaptarResolucion(jScrollPaneBaraja);
        DimensionPantalla.adaptarResolucion(jLabel1);
        DimensionPantalla.adaptarResolucion(jLabel2);
        DimensionPantalla.adaptarPanel(this);
    */
    
    
    public static void adaptarFrame(JFrame f){
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension tamaño=tk.getScreenSize();
        System.out.println("Nuevo tamaño: "+tamaño.toString());
        System.out.println("Antiguo tamaño: "+f.getSize());
        f.setSize(tamaño);
        System.out.println("Tamaño modificado: "+f.getSize());
        
        f.setLocationRelativeTo(null);
    }
    public static void adaptarPanel(JPanel j){
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension tamaño=tk.getScreenSize();
        j.setSize(tamaño);
        j.setLocation(0,0);
    }
    
    //Metodo para ajustar el tamaño del componente a la pantalla, manteniendo
    //La proporcion de tamaño original
    public static void resizeComponente(JComponent j){
    Toolkit tk=Toolkit.getDefaultToolkit();
    Dimension tamaño=tk.getScreenSize();
    System.out.println("Componente"+j.toString());
        
    float proporcionH=1;
    float proporcionV=1;
        try{
            proporcionH=(float)tamaño.width/(float)j.getRootPane().getWidth();
            proporcionV=(float)tamaño.height/(float)j.getRootPane().getHeight();
            System.out.println("Tamaño del panel Root: "+j.getRootPane().getWidth()+" "+j.getRootPane().getHeight());
        }
        catch(NullPointerException e){
            proporcionH=(float)tamaño.width/(float)j.getParent().getWidth();
            proporcionV=(float)tamaño.height/(float)j.getParent().getHeight();
            System.out.println("Tamaño del panel padre: "+j.getParent().getWidth()+" "+j.getParent().getHeight());
        }
    Dimension tamañoNuevo=new Dimension((int)((float)j.getWidth()*proporcionH),(int)((float)j.getHeight()*proporcionV));
    
    System.out.println("Tamaño original: "+j.getWidth()+" "+j.getHeight());
        //Esto falla cuando pilla j.getParent() en lugar del RootPane
        //System.out.println("Tamaño del panel Root: "+j.getRootPane().getWidth());
    j.setSize(tamañoNuevo);
    System.out.println("Nuevo tamaño: "+j.getWidth()+" "+j.getHeight());
    
    /*
    //Ancho del componente
    int jW=j.getWidth();
    //Alto del componente
    int jH=j.getHeight();
    //Ancho del panel padre
    int pW=j.getRootPane().getWidth();
    //Alto del panel padre
    int pH=j.getRootPane().getHeight();
    //Formula generica
    int anchoNuevo=(int)((jW/pW)*tamaño.getWidth());
    int altoNuevo=(int)((jH/pH)*tamaño.getHeight());
    //Todo esto lo meto directamente en el constructor de tamañoNuevo
    */    
    }
    
    //Metodo para recolocar el componente adapatandose al cambio de resolucion
    public static void recolocarComponente(JComponent j){
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension tamaño=tk.getScreenSize();
        float proporcionH=1;
        float proporcionV=1;
        try{
            proporcionH=(float)tamaño.width/(float)j.getRootPane().getWidth();
            proporcionV=(float)tamaño.height/(float)j.getRootPane().getHeight();
        }
        catch(NullPointerException e){
            proporcionH=(float)tamaño.width/(float)j.getParent().getWidth();
            proporcionV=(float)tamaño.height/(float)j.getParent().getHeight();
        }
        Point posicionNueva=new Point((int)(j.getLocation().x*proporcionH),(int)(j.getLocation().y*proporcionV));
        //Test
        System.out.println("location original:"+j.getLocation().x+" "+j.getLocation().y);
        System.out.println("proporcion: "+proporcionH+" "+proporcionV);
        //End Test
        j.setLocation(posicionNueva);
        //Test
        System.out.println("Posicion nueva :"+j.getLocation());
        //End Test        
    }
    
    //Meto ambos metodos en uno por comodidad. Los dejo escritos por separado por claridad
    public static void adaptarResolucion(JComponent j){
        resizeComponente(j);
        recolocarComponente(j);
                
    }
    
    public static void resizeImagen(String ruta,JLabel container){
        //Hay k pasarle la ruta de la imagen en plan "/maagic/img/nombreDeLaImagen.jpg"
    try{
        BufferedImage titulo=ImageIO.read(container.getClass().getResource(ruta));
        ImageIcon iconoResize=new ImageIcon(titulo.getScaledInstance(container.getWidth(), container.getHeight(), Image.SCALE_DEFAULT));
        container.setIcon(iconoResize);
        }
        catch(IOException e){
            System.out.println("Error");
        }
    }

}