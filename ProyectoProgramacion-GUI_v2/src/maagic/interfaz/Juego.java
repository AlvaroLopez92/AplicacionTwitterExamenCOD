/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maagic.interfaz;

import GUI.DimensionPantalla;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import maagic.Jugador;

/**
 *
 * @author otorradomiguez
 */
public class Juego extends JPanel {

    public JPanel panelGridBag = new JPanel();
    public JPanel panelManoJ1 = new JPanel();
    public JPanel panelManoJ2 = new JPanel();
    public JPanel panelMesaJ1 = new JPanel();
    public JPanel panelMesaJ2 = new JPanel();

    public JLabel fondo = new JLabel();
    
    public int cartaSeleccionada=-1;
    public boolean turnoJ1=true;

    public Juego() {
        initJuego();
    }

    public void initJuego() {
        //Establecemos los layouts del panel principal y los subpaneles
        this.setSize(MainInterfaz.marco.getSize());
        this.setLayout(new OverlayLayout(this));
        panelGridBag.setLayout(new GridBagLayout());
        panelManoJ1.setLayout(new BoxLayout(panelManoJ1, BoxLayout.Y_AXIS));
        panelMesaJ1.setLayout(new BoxLayout(panelMesaJ1, BoxLayout.Y_AXIS));
        panelManoJ2.setLayout(new BoxLayout(panelManoJ2, BoxLayout.Y_AXIS));
        panelMesaJ2.setLayout(new BoxLayout(panelMesaJ2, BoxLayout.Y_AXIS));

        //Definimos las propiedades del panel Juego
        fondo.setSize(MainInterfaz.marco.getSize());
        fondo.setAlignmentX(0.5f);
        DimensionPantalla.resizeImagen("/maagic/img/pantallazo.png", fondo);
        fondo.addComponentListener(MainInterfaz.ajustarImagen);
        //Definimos propiedades de panelGridBagthis.getSize().height/4
        panelGridBag.setPreferredSize(this.getSize());

        panelGridBag.setOpaque(false);
        //Definimos las propiedades de los paneles de cada jugador
        //panelManoJ1.setSize(this.getSize().width/4,this.getSize().height);
        //panelManoJ1.setBackground(Color.red);        
        panelMesaJ1.setBackground(Color.blue);
        panelManoJ2.setBackground(Color.yellow);
        panelMesaJ2.setBackground(Color.GREEN);

        //Defino las constraints iniciales
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        //c.fill=GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;

        //pruebas
        CartaVacia c1j1 = new CartaVacia();
        CartaVacia c2j1 = new CartaVacia();
        CartaVacia c3j1 = new CartaVacia();
        CartaVacia c4j1 = new CartaVacia();
        CartaVacia c5j1 = new CartaVacia();
        CartaVacia c6j1 = new CartaVacia();

        CartaVacia c1j2 = new CartaVacia();
        CartaVacia c2j2 = new CartaVacia();
        CartaVacia c3j2 = new CartaVacia();
        CartaVacia c4j2 = new CartaVacia();
        CartaVacia c5j2 = new CartaVacia();
        CartaVacia c6j2 = new CartaVacia();

        c1j1.setAlignmentY(CENTER_ALIGNMENT);
        c2j1.setAlignmentY(CENTER_ALIGNMENT);
        c3j1.setAlignmentY(CENTER_ALIGNMENT);
        c4j1.setAlignmentY(CENTER_ALIGNMENT);
        c5j1.setAlignmentY(CENTER_ALIGNMENT);
        c6j1.setAlignmentY(CENTER_ALIGNMENT);

        c1j2.setAlignmentY(CENTER_ALIGNMENT);
        c2j2.setAlignmentY(CENTER_ALIGNMENT);
        c3j2.setAlignmentY(CENTER_ALIGNMENT);
        c4j2.setAlignmentY(CENTER_ALIGNMENT);
        c5j2.setAlignmentY(CENTER_ALIGNMENT);
        c6j2.setAlignmentY(CENTER_ALIGNMENT);

        panelManoJ1.add(c1j1);
        panelManoJ1.add(c2j1);
        panelManoJ1.add(c3j1);

        panelMesaJ1.add(c4j1);
        panelMesaJ1.add(c5j1);
        panelMesaJ1.add(c6j1);

        panelMesaJ2.add(c4j2);
        panelMesaJ2.add(c5j2);
        panelMesaJ2.add(c6j2);

        panelManoJ2.add(c1j2);
        panelManoJ2.add(c2j2);
        panelManoJ2.add(c3j2);

        panelManoJ1.setOpaque(false);
        panelManoJ2.setOpaque(false);
        panelMesaJ1.setOpaque(false);
        panelMesaJ2.setOpaque(false);

        JButton b2 = new JButton("es esta jodida mierda");
        panelGridBag.add(b2, c);
        JButton b6 = new JButton("es esta jodida mierda");
        c.gridx = 3;
        panelGridBag.add(b6, c);

        //Añadimos los componentes,
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.VERTICAL;
        c.gridheight = 3;
        c.weightx = 1;
        c.weighty = 1;
        panelGridBag.add(panelManoJ1, c);
        c.gridx = 1;
        c.gridy = 1;
        panelGridBag.add(panelMesaJ1, c);
        c.gridx = 2;
        c.gridy = 1;
        panelGridBag.add(panelMesaJ2, c);
        c.gridx = 3;
        c.gridy = 1;
        panelGridBag.add(panelManoJ2, c);

        this.add(panelGridBag);

        this.add(fondo);

    }

    public void updateCartas(Jugador j, Jugador k) {
        for (int i = 0; i < 3; i++) {
            if (j.hayCarta(i)) {
                CartaGui cartaTemp = new CartaGui();
                cartaTemp.ataque.setText("" + j.getMano(i).getAtaque());
                cartaTemp.coste.setText("" + j.getMano(i).getCoste());
                cartaTemp.vida.setText("" + j.getMano(i).getVida());
                panelManoJ1.remove(i);
                panelManoJ1.add(cartaTemp, i);
            }else{
                CartaVacia cV=new CartaVacia();
                panelManoJ1.remove(i);
                panelManoJ1.add(cV, i);
            }
            if(k.hayCarta(i)){
                CartaGui cartaTemp = new CartaGui();
                cartaTemp.ataque.setText("" + k.getMano(i).getAtaque());
                cartaTemp.coste.setText("" + k.getMano(i).getCoste());
                cartaTemp.vida.setText("" + k.getMano(i).getVida());
                panelManoJ2.remove(i);
                panelManoJ2.add(cartaTemp, i);
            }else{
                CartaVacia cV=new CartaVacia();
                panelManoJ2.remove(i);
                panelManoJ2.add(cV, i);
            }
            if(j.hayCartaEnMesa(i)){
                CartaGui cartaTemp = new CartaGui();
                cartaTemp.ataque.setText("" + j.getMesa(i).getAtaque());
                cartaTemp.coste.setText("" + j.getMesa(i).getCoste());
                cartaTemp.vida.setText("" + j.getMesa(i).getVida());
                panelMesaJ1.remove(i);
                panelMesaJ1.add(cartaTemp, i);
            }else{
                CartaVacia cV=new CartaVacia();
                panelMesaJ1.remove(i);
                panelMesaJ1.add(cV, i);
            }
            if(k.hayCartaEnMesa(i)){
                CartaGui cartaTemp = new CartaGui();
                cartaTemp.ataque.setText("" + k.getMesa(i).getAtaque());
                cartaTemp.coste.setText("" + k.getMesa(i).getCoste());
                cartaTemp.vida.setText("" + k.getMesa(i).getVida());
                panelMesaJ2.remove(i);
                panelMesaJ2.add(cartaTemp, i);
            }else{
                CartaVacia cV=new CartaVacia();
                panelMesaJ2.remove(i);
                panelMesaJ2.add(cV, i);
            }
        }
        /*
        panelManoJ1.repaint();
        panelManoJ1.revalidate();
        panelManoJ2.repaint();
        panelManoJ2.revalidate();
        */
    }

}
