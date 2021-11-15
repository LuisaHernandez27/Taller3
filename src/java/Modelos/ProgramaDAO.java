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

public class ProgramaDAO {

    Connection con = null;
    PreparedStatement ps = null;  
    ResultSet rs = null;
    
    public static final String LISTAR = "select * from tblProgramaAcademico";
    public static final String NUEVO = "insert into tblProgramaAcademico values(?,?)";
    public static final String ELIMINAR = "delete from tblProgramaAcademico where codPrograma = ?";
    public static final String BUSCAR = "select * from tblProgramaAcademico where codPrograma = ?";
    public static final String EDITAR = "update tblProgramaAcademico set descripcion = ?, codFacultad = ? where codPrograma = ?";
    
    
    public List<Programa> ListarPrograma() {
        List<Programa> listaProgramas = new ArrayList<>();
        try {
            //1. Conectarnos a la BD
            con = Conexion.getConexion();
            //2. Preparamos la consulta.
            ps = con.prepareStatement(LISTAR);
            //3. Ejecutar la consulta y alamacenar los resultados
            rs = ps.executeQuery();
            while (rs.next()) {
                Programa programa = new Programa();                
                programa.setCodPrograma(rs.getInt(1));
                programa.setDescripcion(rs.getString(2));  
                programa.setCodFacultad(rs.getInt(3));          
                listaProgramas.add(programa);
            };
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            Conexion.Cerrar(con);
        }
        return listaProgramas;
    }
    
    public int insertar(Programa programa){
                  
        int fila = 0;
        
        try {            
            
            con = Conexion.getConexion();
            ps = con.prepareStatement(NUEVO);
            ps.setString(1, programa.getDescripcion());
            ps.setInt(2, programa.getCodFacultad());
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
    
    public Programa buscarPorCodigo(int cod) {
        Programa programa = null;
        try {

            con = Conexion.getConexion();
            ps = con.prepareStatement(BUSCAR);
            ps.setInt(1, cod);
            rs = ps.executeQuery();

            if (rs.next()) {
                int codigo = rs.getInt("codPrograma");
                String des = rs.getString("descripcion");
                int codFacultad = rs.getInt("codFacultad");
                
                programa = new Programa(codigo, des, codFacultad);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.Cerrar(con);
        }
        return programa;

    }
    
    public int editar(Programa programa) {

        int fila = 0;

        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(EDITAR);
            ps.setString(1, programa.getDescripcion());
            ps.setInt(2, programa.getCodFacultad());
            ps.setInt(3, programa.getCodPrograma());
            fila = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.Cerrar(con);
        }
        return fila;

    }
   
}
