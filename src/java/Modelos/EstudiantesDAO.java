package Modelos;

import Configuracion.Conexion;
import Entidades.Estudiantes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class EstudiantesDAO {

    Connection con = null;
    PreparedStatement ps = null;  
    ResultSet rs = null;
    
    public static final String LISTAR = "select * from tblEstudiante";
    public static final String NUEVO = "insert into tblEstudiante values(?,?,?,?,?,?)";
    public static final String ELIMINAR = "delete from tblEstudiante where codEstudiante = ?";
    public static final String BUSCAR = "select * from tblEstudiante where codEstudiante = ?";
    public static final String EDITAR = "update tblEstudiante set nombreEstudiante = ?, apellidoEstudiante = ?, fechaNacimiento = ?, celuar = ?, email = ?, estado = ? where codEstudiante = ?";
    
    
    public List<Estudiantes> ListarEstudiantes() {
        List<Estudiantes> listaEstudiantes = new ArrayList<>();
        try {
            //1. Conectarnos a la BD
            con = Conexion.getConexion();
            //2. Preparamos la consulta.
            ps = con.prepareStatement(LISTAR);
            //3. Ejecutar la consulta y alamacenar los resultados
            rs = ps.executeQuery();
            while (rs.next()) {
                Estudiantes facultad = new Estudiantes();            
                facultad.setCodEstudiante(rs.getInt(1));               
                facultad.setNombreEstudiante(rs.getString(2));
                facultad.setApellidoEstudiante(rs.getString(3)); 
                facultad.setFechaNacimiento(rs.getString(4)); 
                facultad.setCeluar( Integer.parseInt(rs.getString(5))); 
                facultad.setEmail(rs.getString(6)); 
                facultad.setEstado(rs.getString(7));       
                listaEstudiantes.add(facultad);
            };
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            Conexion.Cerrar(con);
        }
        return listaEstudiantes;
    }
    
    public int insertar(Estudiantes estudiante){
                  
        int fila = 0;
        
        try {            
            
            con = Conexion.getConexion();
            ps = con.prepareStatement(NUEVO);
            ps.setString(1, estudiante.getNombreEstudiante());
            ps.setString(2, estudiante.getApellidoEstudiante());
            ps.setString(3, estudiante.getFechaNacimiento().toString());
            ps.setString(4, Integer.toString(estudiante.getCeluar()));
            ps.setString(5, estudiante.getEmail());
            ps.setString(6, estudiante.getEstado());
            fila = ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        Conexion.Cerrar(con);
        }
        return fila;
    }

    public int eliminar(int codigo) {

        int fila = 0;
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(ELIMINAR);
            ps.setInt(1, codigo);
            fila = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.Cerrar(con);
        }
        return fila;
    }
    
    public Estudiantes buscarPorCodigo(int cod) {
        Estudiantes estudiante = null;
        try {

            con = Conexion.getConexion();
            ps = con.prepareStatement(BUSCAR);
            ps.setInt(1, cod);
            rs = ps.executeQuery();

            if (rs.next()) {
                int codigo = rs.getInt("codEstudiante");
                String nombre = rs.getString("nombreEstudiante");
                String apellido = rs.getString("apellidoEstudiante");
                String fecha = rs.getString("fechaNacimiento");
                int cel = rs.getInt("celuar");
                String email = rs.getString("email");
                String estado = rs.getString("estado");
                estudiante = new Estudiantes(codigo, nombre,apellido,fecha,cel,email,estado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.Cerrar(con);
        }
        return estudiante;

    }
    
    public int editar(Estudiantes estudiante) {

        int fila = 0;

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(EDITAR);
            ps.setString(1, estudiante.getNombreEstudiante());
            ps.setString(2, estudiante.getApellidoEstudiante());
            ps.setString(2, estudiante.getFechaNacimiento());
            ps.setString(2, Integer.toString(estudiante.getCeluar()));
            ps.setString(2, estudiante.getEmail());
            ps.setString(2, estudiante.getEstado());
            fila = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.Cerrar(con);
        }
        return fila;

    }
}
