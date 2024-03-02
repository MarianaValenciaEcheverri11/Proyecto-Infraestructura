package Servidor;

import Servidor.model.*;
import Servidor.persistence.Persistencia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

public class PrincipalServidor {
    private EchoTCPServer server;
    private Universidad universidad;

    public static void main(String args[]) throws Exception {
        PrincipalServidor ps = new PrincipalServidor();
    }

    public PrincipalServidor() throws Exception {
        cargarResourceXML();
        if(universidad == null){
            inicializarDatos();
            guardarResourceXML();
        }
        server = new EchoTCPServer(this);
        menu();
    }

    private void guardarResourceXML() {
        Persistencia.guardarRecursoUniversidad(universidad);
    }

    private void inicializarDatos() {
        universidad = new Universidad();

        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
        Estudiante estudiante = new Estudiante("1E", "m", "1234", "1P", 7);
        estudiantes.add(estudiante);

        ArrayList<Materia> materias = new ArrayList<Materia>();
        materias.add(new Materia("1M", "Programación", 4, 100000.00F));
        materias.add(new Materia("2M", "Matemáticas", 4, 100000.00F));
        materias.add(new Materia("3M", "Física", 4, 100000.00F));
        materias.add(new Materia("4M", "Química", 4, 100000.00F));
        materias.add(new Materia("5M", "Biología", 4, 100000.00F));
        materias.add(new Materia("6M", "Inglés", 4, 100000.00F));
        materias.add(new Materia("7M", "Español", 4, 100000.00F));
        materias.add(new Materia("8M", "Historia", 4, 100000.00F));
        materias.add(new Materia("9M", "Geografía", 4, 100000.00F));
        materias.add(new Materia("10M", "Educación Física", 4, 100000.00F));
        universidad.setEstudiantes(estudiantes);
        universidad.setMaterias(materias);

        ArrayList<Profesion> profesiones = new ArrayList<Profesion>();
        ArrayList<String> idMaterias = new ArrayList<String>();
        idMaterias.add("1M");
        idMaterias.add("2M");
        idMaterias.add("3M");
        idMaterias.add("6M");
        profesiones.add(new Profesion("1P", "Ingeniería", idMaterias));

        universidad.setProfesiones(profesiones);

        ArrayList<String> idMateriasEstudiante = new ArrayList<String>();
        idMateriasEstudiante.add("1M");
        ArrayList<RegistroMateria> registrosMaterias = new ArrayList<RegistroMateria>();
        registrosMaterias.add(new RegistroMateria("1ER", "1E", idMateriasEstudiante, 7,
                LocalDateTime.now(), 100000.00F));

        universidad.setRegistrosMaterias(registrosMaterias);
    }

    private void cargarResourceXML() {
        universidad = Persistencia.cargarRecursoUniversidad();
    }
    
    public void menu() throws Exception {
        JOptionPane.showMessageDialog(null, "Servidor iniciado");
        server.init();
    }

    public String buscarUsuario(String nombreUsuario, String contrasenia) {
        String usuario = "";
        cargarResourceXML();
        if(universidad == null){
            inicializarDatos();
            guardarResourceXML();
        }
        boolean encontrado=false;

        for(int i=0; i<universidad.getEstudiantes().size() && encontrado==false;i++) {
            if (universidad.getEstudiantes().get(i).getUsuario().equals(nombreUsuario) &&
                    universidad.getEstudiantes().get(i).getContrasenia().equals(contrasenia)) {
                encontrado =true;
                usuario = universidad.getEstudiantes().get(i).getUsuario() + ";" +
                        universidad.getEstudiantes().get(i).getCodigo() + ";" +
                        universidad.getEstudiantes().get(i).getSemestre() + ";" +
                        universidad.getEstudiantes().get(i).getCodigoProfesion();
            }
        }
        return usuario;
    }

    public String obtenerMaterias(String codigoProfesion) {
        cargarResourceXML();
        if(universidad == null){
            inicializarDatos();
            guardarResourceXML();
        }
        String respuesta="";
        for(int i=0; i<universidad.getProfesiones().size(); i++) {
            if (universidad.getProfesiones().get(i).getCodigo().equals(codigoProfesion)) {
                for(int j=0; j<universidad.getProfesiones().get(i).getIdMaterias().size(); j++) {
                    for(int k=0; k<universidad.getMaterias().size(); k++) {
                        if (universidad.getProfesiones().get(i).getIdMaterias().get(j).equals(universidad.getMaterias().get(k).getCodigo())) {
                            respuesta += universidad.getMaterias().get(k).getCodigo() + ";" +
                                    universidad.getMaterias().get(k).getNombre() + ";" +
                                    universidad.getMaterias().get(k).getCreditos() + ";" +
                                    universidad.getMaterias().get(k).getValor() + ":";
                        }
                    }
                }
            }
        }
        return respuesta;
    }

    public String inscribirMaterias(String codigoUsuario, String idMaterias) {
        cargarResourceXML();
        if(universidad == null){
            inicializarDatos();
            guardarResourceXML();
        }
        if (tieneDuplicados(codigoUsuario,idMaterias.split(","))) {
            return "No se puede inscribir porque ya registró esa materia";
        }

        String[] materias = idMaterias.split(",");
        int creditos = 0;
        for(int i=0; i<materias.length; i++) {
            for(int j=0; j<universidad.getMaterias().size(); j++) {
                if (universidad.getMaterias().get(j).getCodigo().equals(materias[i])) {
                    creditos += universidad.getMaterias().get(j).getCreditos();
                }
            }
        }
        if (creditos>=10 && creditos<=15) {
            float costoTotalMatricula = 0;
            ArrayList<String> list = new ArrayList<String>(Arrays.asList(idMaterias.split(",")));
            RegistroMateria registroMateria = new RegistroMateria( codigoUsuario+"R", codigoUsuario, list, 7, LocalDateTime.now(), 100000.00F);

            universidad.getRegistrosMaterias().add(registroMateria);

            Persistencia.guardarRecursoUniversidad(universidad);

            for(int j=0; j<registroMateria.getListaMaterias().size(); j++) {
                float valorMateria = 0;
                for(int i=0; i<universidad.getMaterias().size(); i++) {
                    if (registroMateria.getListaMaterias().get(j).equals(universidad.getMaterias().get(i).getCodigo())) {
                        valorMateria = universidad.getMaterias().get(i).getValor();
                    }
                }
                costoTotalMatricula = costoTotalMatricula + valorMateria;
            }
            return "Inscripción exitosa!, el costo de su matrícula es:  " + costoTotalMatricula;
        } else {
            return "No se puede inscribir por la cantidad de créditos, deben ser mínimo 10 y máximo 15";
        }
    }

    public boolean tieneDuplicados(String codigoUsuario, String[] array) {

        boolean duplicado = false;

        for(int i=0; i < universidad.getRegistrosMaterias().size(); i++) {
            if(universidad.getRegistrosMaterias().get(i).getListaMaterias() != null && universidad.getRegistrosMaterias().get(i).getCodigoEstudiante().equals(codigoUsuario) ) {
                for(int j=0; j<array.length; j++) {
                    if (universidad.getRegistrosMaterias().get(i).getListaMaterias().contains(array[j])) {
                        duplicado = true;
                    }
                }
            }
        }

        Set<String> elementosSet = new HashSet<>();

        for (String elemento : array) {
            if (!elementosSet.add(elemento)) {
                duplicado = true;
            }
        }

        return duplicado;
    }

}