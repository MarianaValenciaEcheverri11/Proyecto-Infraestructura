package Servidor.model;

import java.io.Serializable;

public class Estudiante implements Serializable {

    public static final long serialVersionUID = 1L;

    private String codigo;
    private String usuario;
    private String contrasenia;
    private String codigoProfesion;
    private int semestre;

    public Estudiante() { }

    public Estudiante(String codigo,
                      String usuario,
                      String contrasenia,
                      String codigoProfesion, int semestre) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.codigoProfesion = codigoProfesion;
        this.semestre = semestre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoProfesion() {
        return codigoProfesion;
    }

    public void setCodigoProfesion(String codigoProfesion) {
        this.codigoProfesion = codigoProfesion;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "codigo='" + codigo + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", codigoProfesion='" + codigoProfesion + '\'' +
                ", semestre=" + semestre +
                '}';
    }
}