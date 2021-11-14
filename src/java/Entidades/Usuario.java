
package Entidades;


public class Usuario {
    
    private int CodUsuario;
    private int codEstudiante;
    private String TipoUsuario;
    private String nombreUsuario;
    private String contrasena;

    public Usuario(int CodUsuario, int codEstudiante, String TipoUsuario) {
        this.CodUsuario = CodUsuario;
        this.codEstudiante = codEstudiante;
        this.TipoUsuario = TipoUsuario;
    }

    public Usuario() {
    }

    public int getCodUsuario() {
        return CodUsuario;
    }

    public void setCodUsuario(int CodUsuario) {
        this.CodUsuario = CodUsuario;
    }

    public int getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(int codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
}
