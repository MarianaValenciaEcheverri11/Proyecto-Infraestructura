package Servidor.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Universidad implements Serializable {

    public static final long serialVersionUID = 1L;

    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Materia> materias;
    private ArrayList<Profesion> profesiones;
    private ArrayList<RegistroMateria> registrosMaterias;

    public Universidad() {
    }

    public Universidad(ArrayList<Estudiante> estudiantes,
                       ArrayList<Materia> materias,
                       ArrayList<Profesion> profesiones,
                       ArrayList<RegistroMateria> registrosMaterias) {
        this.estudiantes = estudiantes;
        this.materias = materias;
        this.profesiones = profesiones;
        this.registrosMaterias = registrosMaterias;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }

    public ArrayList<Profesion> getProfesiones() {
        return profesiones;
    }

    public void setProfesiones(ArrayList<Profesion> profesiones) {
        this.profesiones = profesiones;
    }

    public ArrayList<RegistroMateria> getRegistrosMaterias() {
        return registrosMaterias;
    }

    public void setRegistrosMaterias(ArrayList<RegistroMateria> registrosMaterias) {
        this.registrosMaterias = registrosMaterias;
    }

    @Override
    public String toString() {
        return "Universidad{" +
                "estudiantes=" + estudiantes +
                ", materias=" + materias +
                ", profesiones=" + profesiones +
                ", registrosMaterias=" + registrosMaterias +
                '}';
    }
}