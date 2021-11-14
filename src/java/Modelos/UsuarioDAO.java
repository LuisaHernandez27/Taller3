package Modelos;

import Configuracion.Conexion;
import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection con = null;
    PreparedStatement ps = null;  
    ResultSet rs = null;
    
    public static final String LOGIN = "select * from tblUsuarios where NombreUsuario = ?"
            + " and Contrasena = ?";
    public Usuario login(Usuario usu) {
        Usuario u = new Usuario();
        try {
            //1. Conectarnos a la BD
            con = Conexion.getConexion();
            //2. Preparamos la consulta.
            ps = con.prepareStatement(LOGIN);
            ps.setString(1, usu.getNombreUsuario());
            ps.setString(2, usu.getContrasena());
            //3. Ejecutar la consulta y alamacenar los resultados
            rs = ps.executeQuery();
            if (rs.next()) {
                u.setNombreUsuario(rs.getString("NombreUsuario"));
                u.setContrasena(rs.getString("Contrasena"));
                u.setTipoUsuario(rs.getString("TipoUsuario"));
                u.setCodEstudiante(rs.getInt("codEstudiante"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            Conexion.Cerrar(con);
        }
        return u;

    }

}
