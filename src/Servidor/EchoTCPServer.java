package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class EchoTCPServer {
	public static final int PORT = 3400;
	private ServerSocket listener;
	private Socket serverSideSocket;
	private PrintWriter toNetwork;
	private BufferedReader fromNetwork;
    private PrincipalServidor serv;
        
	public EchoTCPServer(PrincipalServidor ps) {
                serv = ps;
		System.out.println("Servidor ejecutandose en el puerto : " + PORT);
	}

	public void init() throws Exception {
		listener = new ServerSocket(PORT);
                serverSideSocket = listener.accept();
                createStreams(serverSideSocket);
		protocol(serverSideSocket);
		while (true)
        {
            String res = leerMensaje();
            responder(res);
		}
	}
        
    public String leerMensaje() throws IOException, Exception {
        String idTrans, log, cla, ced, numCue, saldo;
        createStreams(serverSideSocket);
        String cadena = fromNetwork.readLine();
        String resul[] = cadena.split(";");
        String respuesta="";

        double s;

        switch (resul[0]) {
            case "1":
                log = resul[1];
                cla = resul[2];
                if ((serv.buscarUsuario(log, cla) != null))
                    respuesta = serv.buscarUsuario(log, cla);
                break;
            case "2":
                respuesta = serv.obtenerMaterias(resul[1]);
                break;
            case "3":
                respuesta = serv.inscribirMaterias(resul[1], resul[2]);
                break;
            case "4":
                respuesta = serv.obtenerMateriasEstudiante(resul[1]);
                break;
        }
        return respuesta;
    }
	
	public void protocol(Socket socket) throws Exception {
		String message = fromNetwork.readLine();
		System.out.println("El Cliente dice: " + message);

		String answer = "Si sr, lo escucho";

		toNetwork.println(answer);
	}

	private void createStreams(Socket socket) throws Exception {
		toNetwork = new PrintWriter(socket.getOutputStream(), true);
		fromNetwork = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

    private void responder(String res) {
        toNetwork.println(res);
    }

}
