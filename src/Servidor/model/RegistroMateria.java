package Servidor.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RegistroMateria implements Serializable {

    public static final long serialVersionUID = 1L;

    private String codigo;
    private String codigoEstudiante;
    private ArrayList<String> listaMaterias;
    private int semestre;
    private LocalDateTime fecha;
    private float valorTotal;

    public RegistroMateria() { }

    public RegistroMateria(String codigo, String codigoEstudiante,
                           ArrayList<String> listaMaterias, int semestre,
                           LocalDateTime fecha, float valorTotal) {
        this.codigo = codigo;
        this.codigoEstudiante = codigoEstudiante;
        this.listaMaterias = listaMaterias;
        this.semestre = semestre;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public ArrayList<String> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(ArrayList<String> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "RegistroMateria{" +
                "codigo='" + codigo + '\'' +
                ", codigoEstudiante='" + codigoEstudiante + '\'' +
                ", listaMaterias=" + listaMaterias +
                ", semestre=" + semestre +
                ", fecha=" + fecha +
                ", valorTotal=" + valorTotal +
                '}';
    }
}