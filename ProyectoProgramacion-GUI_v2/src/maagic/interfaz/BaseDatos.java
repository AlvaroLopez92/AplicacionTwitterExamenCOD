/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maagic.interfaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import maagic.Carta;


/**
 *
 * @author dfernandezrivas
 */
public class BaseDatos {
    public void BaseDatos(Carta cartas) throws ClassNotFoundException, SQLException {
        //Esta es la url para indicarnos donde estara la base de datos
        String url = "D:\\Cartas.db";
        Carta carta = null;
    //Cargamos el driver JDBC para sqlite (Esta en la libreria)
        Class.forName("org.sqlite.JDBC");
          //Establecemos una conexion (Como no existe la DB creara una)
         Connection conexion = DriverManager.getConnection("jdbc:sqlite:bdpruebas.db");
          //Instanciamos un Statement (Para realizar consultas, etc)
          //Esta parte de aquí asta el último st.executeUpdate forman parte de pruevas para la base en el proyecto ya no es valido 
          java.sql.Statement st=conexion.createStatement();
          st.executeUpdate("DROP table Cartas");//Hacemos el drop pq si la tabla ya existe da error
          st.executeUpdate("CREATE table Cartas(id integer, nombre varchar, valorataque integer, valormana integer, valorvida integer)");//Creamos una tabla
           //A partir de aqui interactuamos con la BD usando el statement
           //Creamos un st1 como PreparedStatement para insertar los valores de la clase Cartas en una vase de datos que tendremos creada que se llamara Cartas.db
           PreparedStatement st1 = conexion.prepareStatement("insert into cartas (id, nombre,valorataque,valormana,valorvida) values (?,?,?,?,?)");
           //Le insertamos los datos a la tabla
           st1.setInt(1, carta.getid());
           st1.setString(2, carta.getnombre());
           st1.setInt(3, carta.getAtaque());
           st1.setInt(4,carta.getCoste());
           st1.setInt(5, carta.getVida());
           st1.execute();
           //Esta parte tampoco estara en el proyecto final 
//            st.executeUpdate("INSERT into Cartas(1,Carta1,5,2,7)");
//            st.executeUpdate("INSERT into Cartas(2,Carta2,7,3,4)");
            //Realizamos una consulta para que nos coja todos los datos
            ResultSet Cartastotales=st.executeQuery("SELECT * from Cartas");
            //realizamos un while para que nos muestre por pantalla todas las cartas
            while(Cartastotales.next()){
                //Mostramos la informacion de forma ordenada con un System.out.println para comprobar que funciona
        System.out.println("ID"+Cartastotales.getInt("id")+"Nombre de la carta"+Cartastotales.getString("nombre")+"Ataque"+Cartastotales.getInt("valorataque")+"Mana"+Cartastotales.getInt("valormana")+"Vida"+Cartastotales.getInt("valorvida"));
            }
             /*Por ultimo si la conexion no es nula la cierra (y con ello tb los 
            Statements y Resultsets que creasemos con ella
            */
    
    
    
    
    
    }
    }

