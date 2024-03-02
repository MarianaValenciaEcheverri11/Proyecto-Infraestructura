package Cliente.helpers;

public class ConvertirMensajes {

    public static String[] convertirMaterias(String materias) {
        return materias.split(";");
    }

    public static String[] convertirUsuarios(String usuarios) {
        return usuarios.split(";");
    }

}
