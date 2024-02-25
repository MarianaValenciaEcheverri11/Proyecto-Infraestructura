package Cliente;

import java.io.IOException;
import javax.swing.JOptionPane;

public class PrincipalCliente {
    private EchoTCPClient cliente;
    
    public static void main(String args[]) throws Exception
    {
        PrincipalCliente pc = new PrincipalCliente();
    }
    
    public PrincipalCliente() throws Exception
    {
        cliente = new EchoTCPClient();
        cliente.init();

        menu();
    }
    
    public void menu() throws IOException
    {
        int opc;
        String respuesta;
        String log, cla;
        boolean logueado=false;
        String dinero;
        do
        {
           opc = Integer.parseInt(JOptionPane.showInputDialog("BANCO LOS DESALMADOS \n\n"
                        + "1. Ingresar al banco \n" 
                        + "2. Consultar saldo \n"
                        + "3. Consignar dinero \n"
                        + "4. Retirar efectivo \n"
                        + "5. Transferir efectivo \n"
                        + "6. Salir"));
           
           switch (opc)
           {
               case 1: log = JOptionPane.showInputDialog("Ingrese su usuario: ");
                       cla = JOptionPane.showInputDialog("Ingrese su contraseña: ");
                       cliente.enviarMensaje(opc+";"+log+";"+cla);
                       respuesta = cliente.leerMensaje();
                       if (respuesta.equals("ok"))
                       {
                           logueado=true;
                           JOptionPane.showMessageDialog(null, "Bienvenido " + log); 
                       }
                       else
                       {
                           JOptionPane.showMessageDialog(null, "Usuario o clave incorrecta. Vuelva a intentarlo");
                       }
                       break;
           }
           
        }
        while(opc!=6);
    }
}