package Servidor.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Profesion implements Serializable {

    public static final long serialVersionUID = 1L;

    private String codigo;
    private String nombre;
    private ArrayList<String> idMaterias;

    public Profesion() { }

    public Profesion(String codigo,
                     String nombre,
                     ArrayList<String> idMaterias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.idMaterias = idMaterias;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getIdMaterias() {
        return idMaterias;
    }

    public void setIdMaterias(ArrayList<String> idMaterias) {
        this.idMaterias = idMaterias;
    }

    @Override
    public String toString() {
        return "Profesion{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", idMaterias=" + idMaterias +
                '}';
    }
}