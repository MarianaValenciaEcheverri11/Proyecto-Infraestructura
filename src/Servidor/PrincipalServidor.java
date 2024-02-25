package Servidor;

import Servidor.model.*;
import Servidor.persistence.Persistencia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PrincipalServidor {
    private EchoTCPServer server;
    private Universidad universidad;

    public static void main(String args[]) throws Exception
    {
        PrincipalServidor ps = new PrincipalServidor();
    }

    public PrincipalServidor() throws Exception
    {
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
        Estudiante estudiante = new Estudiante("1E", "mariana", "1234", "1", 7);
        estudiantes.add(estudiante);
        ArrayList<Materia> materias = new ArrayList<Materia>();
        materias.add(new Materia("1M", "Programación", 4, 100000.00F));
        universidad.setEstudiantes(estudiantes);
        universidad.setMaterias(materias);
        ArrayList<Profesion> profesiones = new ArrayList<Profesion>();
        ArrayList<String> idMaterias = new ArrayList<String>();
        idMaterias.add("M1");
        profesiones.add(new Profesion("1P", "Ingeniería",idMaterias));
        universidad.setProfesiones(profesiones);
        ArrayList<RegistroMateria> registrosMaterias = new ArrayList<RegistroMateria>();
        registrosMaterias.add(new RegistroMateria("1R", "1E", idMaterias, 7,
                LocalDateTime.now(), 100000.00F));
        universidad.setRegistrosMaterias(registrosMaterias);
    }

    private void cargarResourceXML() {
        universidad = Persistencia.cargarRecursoUniversidad();
    }
    
    public void menu() throws Exception
    {
        JOptionPane.showMessageDialog(null, "En construcción. No acose!!!");
        
        server.init();
    }
    
    public boolean buscarUsuario(String nombreUsuario, String contrasenia)
    {
        cargarResourceXML();
        if(universidad == null){
            inicializarDatos();
            guardarResourceXML();
        }
        boolean encontrado=false;
        
        for(int i=0; i<universidad.getEstudiantes().size() && encontrado==false;i++)
        {
            if (universidad.getEstudiantes().get(i).getUsuario().equals(nombreUsuario) &&
                    universidad.getEstudiantes().get(i).getContrasenia().equals(contrasenia))
            {
                encontrado =true;
            }
        }       
        return encontrado;
    }
}