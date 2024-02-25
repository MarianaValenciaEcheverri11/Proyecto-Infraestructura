package Servidor.persistence;
import Servidor.model.Universidad;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Persistencia {

    public static String RUTA_ARCHIVO_PROGRAMAXML = getRuta("RUTA_ARCHIVO_PROGRAMAXML");
    public static Universidad cargarRecursoUniversidad() {
        Universidad programa = null;
        try {
            programa = (Universidad) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_PROGRAMAXML);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return programa;

    }
    public static void guardarRecursoUniversidad(Universidad programa) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_PROGRAMAXML, programa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getRuta(String nombreRuta) {
        Properties properties = new Properties();
        try {
            properties.load(new BufferedReader(new FileReader("src/Servidor/resources/Rutas.properties")));
            String ruta = properties.getProperty(nombreRuta);
            return ruta;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
