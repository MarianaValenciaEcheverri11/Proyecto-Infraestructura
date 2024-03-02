package Cliente.model;

public class Usuario {
    private String nombre;
    private String codigo;
    private String semestre;
    private String codigoprofesion;

    public Usuario(String nombre, String codigo, String semestre, String codigoprofesion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.semestre = semestre;
        this.codigoprofesion = codigoprofesion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getCodigoprofesion() {
        return codigoprofesion;
    }

    public void setCodigoprofesion(String codigoprofesion) {
        this.codigoprofesion = codigoprofesion;
    }

    public String toString(){
        return "Nombre: "+nombre+" Codigo: "+codigo+" Semestre: "+semestre+" Codigo Profesion: "+codigoprofesion;
    }

}
