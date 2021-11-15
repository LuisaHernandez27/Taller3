
package Entidades;

public class Facultad{
    
   private int codFacultad;
   private String descripcion;

    public Facultad(int codFacultad, String descripcion) {
        this.codFacultad = codFacultad;
        this.descripcion = descripcion;
    }

    public Facultad() {
    }

    public Facultad(String des) {
        descripcion = des;
    }

    public int getCodFacultad() {
        return codFacultad;
    }

    public void setCodFacultad(int codFacultad) {
        this.codFacultad = codFacultad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
   
    
}
