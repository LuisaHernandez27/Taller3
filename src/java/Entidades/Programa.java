
package Entidades;


public class Programa {
   
    private int codPrograma ;
    private String descripcion;
    private int codFacultad;

    public Programa(int codPrograma, String descripcion, int codFacultad) {
        this.codPrograma = codPrograma;
        this.descripcion = descripcion;
        this.codFacultad = codFacultad;
    }

    public int getCodPrograma() {
        return codPrograma;
    }

    public void setCodPrograma(int codPrograma) {
        this.codPrograma = codPrograma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodFacultad() {
        return codFacultad;
    }

    public void setCodFacultad(int codFacultad) {
        this.codFacultad = codFacultad;
    }
    
    
}
