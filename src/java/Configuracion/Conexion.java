package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {

    public static Connection getConexion() {

        Connection con = null;

        try {
            //Se escribe el código que deseamos se ejecute 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-JGS14GN:1433;"
                    + "database=db_Universidad;user=luisa;password=123");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return con;

    }

    public static void Cerrar(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(Conexion.getConexion());
    }

}
