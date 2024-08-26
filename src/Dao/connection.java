package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

        
public class connection {


    Connection con;
    String bd="construction";
    String url="jdbc:mysql://localhost:3306/"+bd+"?useSSL=false&serverTimezone=UTC";
    String user="root";
    String pass="root";
    
    public Connection conectar (){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            con = DriverManager.getConnection(url, user, pass);
            return con;
            }catch (ClassNotFoundException e) {
                //JOptionPane.showConfirmDialog(null, e);
                JOptionPane.showMessageDialog(null, "Error: No se encontró el controlador JDBC. " + e.getMessage());
                System.out.println("Error: No se encontró el controlador JDBC");
            } catch (SQLException e) {
                 JOptionPane.showMessageDialog(null, "Error en la conexión: " + e.getMessage());
                 System.out.println("Error en la conexión");
            }
        return null;
    }
}
