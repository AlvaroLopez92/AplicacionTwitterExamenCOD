package BaseDatos;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
/**
 *
 * @author alopezcobo
 */
public class BaseDatos {
     /**
     * Connect to a sample database
     */
    
    
    
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
        	String url=Constantes.URL_DB+Constantes.NAME_DB;
           // String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/alopezcobo/NetBeansProjects/BaseDatos/basedatos.txt";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
    }
}