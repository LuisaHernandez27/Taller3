package Modelos;

import Configuracion.Conexion;
import Entidades.Facultad;
import Entidades.Programa;
import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FacultadDAO {

    Connection con = null;
    PreparedStatement ps = null;  
    ResultSet rs = null;
    
    public static final String LISTAR = "select * from tblFacultad";
    public static final String NUEVAFACULTAD = "insert into tblFacultad values(?)";
    public static final String ELIMINAR = "delete from tblFacultad where codFacultad = ?";
    public static final String BUSCAR = "select * from tblFacultad where codFacultad = ?";
    public static final String EDITAR = "update tblFacultad set descripcion = ? where codFacultad = ?";
    
    
    public List<Facultad> ListarFacultad() {
        List<Facultad> listaFacultades = new ArrayList<>();
        try {
            //1. Conectarnos a la BD
            con = Conexion.getConexion();
            //2. Preparamos la consulta.
            ps = con.prepareStatement(LISTAR);
            //3. Ejecutar la consulta y alamacenar los resultados
            rs = ps.executeQuery();
            while (rs.next()) {
                Facultad facultad = new Facultad();                
                facultad.setCodFacultad(rs.getInt(1));
                facultad.setDescripcion(rs.getString(2));          
                listaFacultades.add(facultad);
            };
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            Conexion.Cerrar(con);
        }
        return listaFacultades;
    }
    
    public int insertar(Facultad facultad){
                  
        int fila = 0;
        
        try {            
            
            con = Conexion.getConexion();
            ps = con.prepareStatement(NUEVAFACULTAD);
            ps.setString(1, facultad.getDescripcion());
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
    
    public Facultad buscarPorCodigo(int cod) {
        Facultad c = null;
        try {

            con = Conexion.getConexion();
            ps = con.prepareStatement(BUSCAR);
            ps.setInt(1, cod);
            rs = ps.executeQuery();

            if (rs.next()) {
                int codigo = rs.getInt("codFacultad");
                String des = rs.getString("descripcion");
                c = new Facultad(codigo, des);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.Cerrar(con);
        }
        return c;

    }
    
    public int editar(Facultad facultad) {

        int fila = 0;

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(EDITAR);
            ps.setString(1, facultad.getDescripcion());
            ps.setInt(2, facultad.getCodFacultad());
            fila = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.Cerrar(con);
        }
        return fila;

    }
}
