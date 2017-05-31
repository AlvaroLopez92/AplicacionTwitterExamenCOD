package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PoblarTabla {

	public static void main(String[] args) {

        String url = "jdbc:sqlite:"+Constantes.URL_DB+Constantes.NAME_DB;
        
        String sql ="INSERT INTO warehouses VALUES (1, 'Name1',666);"; 
        		
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {

           boolean allOk= stmt.execute(sql);
           if(allOk)System.out.println("Insertado correctamente");
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}

}
