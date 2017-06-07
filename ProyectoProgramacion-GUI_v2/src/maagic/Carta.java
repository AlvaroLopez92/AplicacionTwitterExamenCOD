/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maagic;

import javax.swing.JPanel;


/**
 *
 * @author Orom
 */
public class  Carta extends JPanel  {
 
    //Aki iran las variables ataque,defensa,coste, y en caso de haberlos habilidades
//especiales o asi
    private int vida;
    private int ataque;
    private int coste;
    private int id;
    private String nombre;

    public void setVida(int cartaAtaque) {
        this.vida -= cartaAtaque;
    }

    public Carta(int id,String nombre,int vida, int ataque, int coste) {
        this.vida = vida;
        this.ataque = ataque;
        this.coste = coste;
        this.id=id;
        this.nombre=nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getnombre(){
    return nombre;
    }
    public int getid(){
    return id;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getCoste() {
        return coste;
    }

    public void ataque(Carta c) {
        c.setVida(this.ataque);
        this.vida -= c.getAtaque();
    }

}
