
package Entidades;

        
public class Estudiantes {
    
    private int codEstudiante;
    private String nombreEstudiante;
    private String apellidoEstudiante;
    private String fechaNacimiento;
    private int celuar;
    private String email;
    private String usuario;
    private String password;
    private String estado;

    public Estudiantes(int codEstudiante, String nombreEstudiante, String apellidoEstudiante, String fechaNacimiento, int celuar, String email, String usuario, String password, String estado) {
        this.codEstudiante = codEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.apellidoEstudiante = apellidoEstudiante;
        this.fechaNacimiento = fechaNacimiento;
        this.celuar = celuar;
        this.email = email;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
    }

    public Estudiantes() {
    }
    

    public int getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(int codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCeluar() {
        return celuar;
    }

    public void setCeluar(int celuar) {
        this.celuar = celuar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}

