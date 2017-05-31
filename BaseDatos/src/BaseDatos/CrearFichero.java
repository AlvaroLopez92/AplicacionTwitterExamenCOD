/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author alopezcobo
 */
public class CrearFichero {
    


    public static void main(String[] args) throws IOException {
        String ruta = Constantes.URL_DB;
        File archivo = new File(ruta+"basedatos.txt");
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("La base de datos ya estaba creada.");
            System.out.println("La base de datos ya estaba creada.");
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Acabo de crear la base de datos.");
            System.out.println("Acabo de crear la base de datos.");
        }
        bw.close();
    }
    
}
