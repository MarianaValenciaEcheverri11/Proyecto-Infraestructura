package Cliente;

import Cliente.model.Usuario;
import Servidor.model.Estudiante;
import Servidor.model.Materia;
import Servidor.model.Universidad;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PrincipalCliente {
    private EchoTCPClient cliente;
    boolean logueado=false;
    Usuario usuario;

    Universidad universidad;

    ArrayList<String> materias = new ArrayList<String>();


    public static void main(String args[]) throws Exception {
        PrincipalCliente pc = new PrincipalCliente();
    }
    
    public PrincipalCliente() throws Exception {
        cliente = new EchoTCPClient();
        cliente.init();

        menu();
    }
    
    public void menu() throws IOException {
        int opc;
        String respuesta;
        String log, cla;
        String dinero;
        do {
           opc = Integer.parseInt(JOptionPane.showInputDialog( "Cosito \n" +
                           "1. Ingresar al banco \n", "1"));

           switch (opc) {
               case 1:
                   log = JOptionPane.showInputDialog("Ingrese su usuario: ", "m");
                   cla = JOptionPane.showInputDialog("Ingrese su contraseña: ", "1234");
                   cliente.enviarMensaje(opc+";"+log+";"+cla);
                   respuesta = cliente.leerMensaje();
                   if (respuesta != null && !respuesta.isEmpty() && !respuesta.equals("null")) {
                       String[] listaUsuario = respuesta.split(";");
                       logueado=true;
                       JOptionPane.showMessageDialog(null, "Bienvenido " + log);
                       usuario = new Usuario(listaUsuario[0], listaUsuario[1], listaUsuario[2], listaUsuario[3]);
                       menuMaterias();
                   }
                   else {
                       JOptionPane.showMessageDialog(null, "Usuario o clave incorrecta. Vuelva a intentarlo");
                   }
                   break;
               case 2:
                   break;
           }
           
        } while(opc!=6);
    }

    public void menuMaterias() throws IOException {
        int opc;
        String respuesta;
        String listaMaterias = "";

        do {
           opc = Integer.parseInt(JOptionPane.showInputDialog( "Cosito \n" +
                           "1. Registrar materias \n" +
                            "2. Consultar materias \n" ));

           switch (opc) {
               case 1:

                   if (logueado) {
                       cliente.enviarMensaje((opc+1) + ";" + usuario.getCodigoprofesion());
                       respuesta = cliente.leerMensaje();

                       String[] materiasSeparadas = respuesta.split(":");

                       for (int i = 0; i < materiasSeparadas.length; i++) {
                           String[] materia = materiasSeparadas[i].split(";");
                           materias.add(materia[0]);
                           listaMaterias += "Codigo: " + materia[0] + " Materia: " + materia[1] + " Creditos: " + materia[2] + " Valor: " + materia[3] + "\n";
                       }

                       String idMaterias = JOptionPane.showInputDialog(null, listaMaterias + "\n" + "Seleccione la materia que desea inscribirse separada por ','");

                       cliente.enviarMensaje((opc+2)+ ";" + usuario.getCodigo() + ";" + idMaterias);
                       JOptionPane.showMessageDialog(null, cliente.leerMensaje());

                   } else {
                       JOptionPane.showMessageDialog(null, "Debe ingresar primero");
                   }
                   break;
               case 2:
                   if (logueado) {
                       cliente.enviarMensaje((opc+2) + ";" + usuario.getCodigo());
                       respuesta = cliente.leerMensaje();

                       String[] materiasSeparadas = respuesta.split(":");

                       for (int i = 0; i < materiasSeparadas.length; i++) {
                           String[] materia = materiasSeparadas[i].split(";");
                           materias.add(materia[0]);
                           listaMaterias += "Codigo: " + materia[0] + " CodigoEstudiante: " + materia[1] + " ListaMaterias: " + materia[2] + " Semestre: " + materia[3] + " Fecha: " + materia[4] + "ValorTotal"+ materia[5] +"\n";
                       }

                       JOptionPane.showMessageDialog(null, listaMaterias);

                   } else {
                       JOptionPane.showMessageDialog(null, "Debe ingresar primero");
                   }
                   break;
           }

        } while(opc!=6);

        System.out.println("Saliendo del sistema...");

    }
}