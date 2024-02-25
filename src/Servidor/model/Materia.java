package Servidor.model;

import java.io.Serializable;

public class Materia implements Serializable {

    public static final long serialVersionUID = 1L;

    private String codigo;
    private String nombre;
    private int creditos;
    private Float valor;

    public Materia() { }

    public Materia(String codigo,
                   String nombre,
                   int creditos,
                   Float valor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.valor = valor;
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

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", creditos='" + creditos + '\'' +
                ", valor=" + valor +
                '}';
    }
}