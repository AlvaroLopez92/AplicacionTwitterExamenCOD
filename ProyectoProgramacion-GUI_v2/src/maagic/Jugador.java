/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maagic;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Orom
 */
public class Jugador {

    //Aki irian variables del jugador (mano,baraja,descarte,vida,mana,...)
    //Tambien se instanciarian aqui mano, descarte, y baraja
    /*
    private ArrayList<Carta> mano;
    //cambio mano a un array, para no preocuparnos de que cambie de tamaño
    //al tratarse de un array de objetos Carta, cuando no hay nada en una
    //posicion devuelve null, lo que nos evita tener la "carta vacia" para rellenar
    //cuando no hay nada
     */
    public Carta[] mano = new Carta[3];
    private ArrayList<Carta> baraja = new ArrayList();
    private ArrayList<Carta> descarte = new ArrayList();
    public Carta[] mesa = new Carta[3];
    public int vida = 20;
    public int mana = 3;
    

//    Constructor 
//    esta comentado para subirlo lo corrijo esta tarde
    public Jugador(String fileBaraja) {
        Scanner scBaraja;
        
        File miBaraja = new File(fileBaraja);
        try {
            scBaraja = new Scanner(miBaraja);
            while (scBaraja.hasNextLine()) {
                int cId=scBaraja.nextInt();
                String cnombre=scBaraja.next();
                int cvida = scBaraja.nextInt();
                int cataque = scBaraja.nextInt();
                int ccoste = scBaraja.nextInt();
                //System.out.println(cId + "," +cnombre+"," +cvida + "," + cataque + "," + ccoste);
                Carta c = new Carta(cId,cnombre,cvida, cataque, ccoste);
                this.baraja.add(c);
            }
            scBaraja.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error. Baraja no encontrada");
        }

    }

    //Getters
    public int getVida() {
        return vida;
    }

    public int getMana() {
        return mana;
    }

    
    public Carta getMano(int i) {
        return mano[i];

    }
    
    public Carta getMesa(int i){
        return mesa[i];
    }

    public boolean hayCarta(int i) {
        if(mano[i] == null) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean hayCartaEnMesa(int i) {
        if(mesa[i] == null) {
            return false;
        } else {
            return true;
        }
    }

    //Metodos del jugador
    public void cogerUltimas() {
        //Coge las 3 ultimas cartas de la baraja y las guarda en mano
        for (int i = 0; i < 3; i++) {
            mano[i] = baraja.get(baraja.size() - 1);
            baraja.remove(baraja.size() - 1);
        }
    }

    public void cogerMano() {
        //Lo primero el jugador gana 1 punto de maná
        mana += 1;
        //A continuacion coge 3 cartas, si no hay baraja el descarte y luego coje
        if (baraja.size() >= 3) {
            cogerUltimas();
        } else {
            Collections.shuffle(descarte);
            baraja.addAll(baraja.size(), descarte);
            cogerUltimas();
        }
        //Test
        System.out.println("Esta es tu mano:");
        for (Carta cartaActual : mano) {
            System.out.println("Has cogido -> Vida: " + cartaActual.getVida() + " Ataque: " + cartaActual.getAtaque() + " Coste: " + cartaActual.getCoste());
        }
        //End test
    }

    public void barajar() {
        Collections.shuffle(baraja);
        //Test
        System.out.println("Baraja:");
        for (Carta c : baraja) {
            System.out.println("Vida: " + c.getVida() + " Ataque: " + c.getAtaque() + " Coste: " + c.getCoste());
        }
        //End test
    }

    public void jugarCarta(int i) {

    }

    public void moverManoMesa(int carta, int mesa) {
        if (this.mesa[mesa] == null) {
            this.mesa[mesa] = this.mano[carta];
            this.mano[carta] = null;
        }
    }

    public void moverManoDescarte(int carta) {
        descarte.add(mano[carta]);
        mano[carta] = null;
    }

    public void moverMesaDescarte(int carta) {
        descarte.add(mesa[carta]);
        mesa[carta] = null;
    }

    public void ganarMana(int pos) {
        int cartaMana = Math.round((float) mano[pos].getCoste() / 2f);
        if (cartaMana < 1) {
            mana += 1;
        } else {
            mana += cartaMana;
        }
        mano[pos] = null;
        //Test
        System.out.println("Mana que da la carta: " + cartaMana + " Mana actual: " + mana);
        //End Test
    }

    public void recibirAtaque(Carta c) {
        vida -= c.getAtaque();
    }

    public void cartaMuere(int i) {
        mesa[i] = null;
    }

    //El jugador j es el oponente
    public void realizarAtaque(Jugador j) {
        //Para los tres slots de la mesa, en caso de que haya una carta(mesa[i]!=null)
        for (int i = 0; i < 3; i++) {
            //Este if-else if diferencia entre que haya carta en ambos o solo en el 
            //atacante. en caso de que el atacante no tenga carta no hace nada
            if (mesa[i] != null && j.mesa[i] != null) {
                mesa[i].ataque(j.mesa[i]);
                System.out.println("Se realiza un ataque. Vida:"+mesa[i].getVida()+" Vida Carta Oponente:"+j.mesa[i].getVida());
                //Estos dos if comprueban si la vida de la carta bajo de 1 y
                //la destruyen en ese caso
                if (mesa[i].getVida() < 1) {
                    cartaMuere(i);
                    System.out.println("Carta muere");
                }
                if (j.mesa[i].getVida() < 1) {
                    cartaMuere(i);
                    System.out.println("Carta oponente muere");
                }
            } else if (mesa[i] != null && j.mesa[i] == null) {
                //Este es el metodo para que el jugador pierda vida a causa del ataque
                j.recibirAtaque(mesa[i]);
                System.out.println("El oponente recibe "+mesa[i].getAtaque());
            }
        }
    }

    //TEST METHODS
    public int elegirCartaOrigen() {
        return Integer.parseInt(JOptionPane.showInputDialog("¿Que carta quieres jugar?"));

    }

    public int elegirCartaDestino() {
        return Integer.parseInt(JOptionPane.showInputDialog("¿En que posicion quieres jugarla?"));
    }

    public int entrada(String mensaje) {
        return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
    }

    public void printMesa(Jugador j) {
        System.out.println("Mesa:");
        for (int i = 0; i < 3; i++) {
            if (mesa[i] != null) {
                System.out.println("J: slot" + i + "=" + mesa[i].getAtaque() + " " + mesa[i].getVida() + " " + mesa[i].getCoste());
            } else {
                System.out.println("Slot" + i + "Sin carta");
            }
        }
        for (int i = 0; i < 3; i++) {
            if (j.mesa[i] != null) {
                System.out.println("O: slot" + i + "=" + j.mesa[i].getAtaque() + " " + j.mesa[i].getVida() + " " + j.mesa[i].getCoste());
            } else {
                System.out.println("Slot" + i + "Sin carta");
            }
        }
        System.out.println("Fin de jugada");
    }

    public void elegirCarta() {
        int cartaElegida = -1;
        //Test
        System.out.println("Mana: " + mana);
        System.out.println("Esta es tu mano:");
        int count = 0;
        for (Carta cartaActual : this.mano) {
            if (cartaActual != null) {
                System.out.println("Carta" + count + ": Vida: " + cartaActual.getVida() + " Ataque: " + cartaActual.getAtaque() + " Coste: " + cartaActual.getCoste());
            } else {
                System.out.println("Carta" + count + ": ya jugada");
            }
            count++;
        }
        //End test
        do {
            cartaElegida = elegirCartaOrigen();
            if (mano[cartaElegida].getCoste() > mana) {
                System.out.println("Puedes jugarla para obtener mana pulsando 1\nO cancelar con 0");
                int select = entrada("Que elijes?");
                if (select == 1) {
                    ganarMana(cartaElegida);
                }
            } else {
                System.out.println("Puedes jugarla para obtener mana pulsando 1\nPara atacar pulsando 2\nO cancelar con 0");
                int select = entrada("Que elijes?");
                if (select == 1) {
                    ganarMana(cartaElegida);
                } else if (select == 2) {
                    costeMana(cartaElegida);
                    moverManoMesa(cartaElegida, elegirCartaDestino());
                }
            }
        } while (mano[cartaElegida] != null);

    }

    public void costeMana(int cartaElegida) {
        mana -= this.mano[cartaElegida].getCoste();
    }
}
