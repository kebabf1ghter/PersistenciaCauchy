import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonUtilEjemplo {
    public static <T> void guardarObjetoEnArchivo(String rutaArchivo, T objeto){
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(rutaArchivo)){
            gson.toJson(objeto, writer);
        } catch(IOException e){
            System.out.println("An IO exception has occurred nigga");
        }
    }

    public static <T> T cargarObjetoDesdeArchivo(String rutaArchivo, Class<T> clase){
        Gson gson = new Gson();
        try(FileReader reader = new FileReader(rutaArchivo)){
            return gson.fromJson(reader, clase);
        }catch(IOException e){
            System.out.println("An IO exception has occurred nigga");
            return null;
        }
    }

    public static void main(String[] args){
        String rutaArchivo = "usuario.json";
        Usuario usuario = new Usuario("Adrián Mascapitos", 1, "adrian.ruesga@edu.uah.es");
        guardarObjetoEnArchivo(rutaArchivo, usuario);
        Usuario usuarioCargado = cargarObjetoDesdeArchivo(rutaArchivo, Usuario.class);

        if(usuarioCargado != null){
            System.out.println(usuarioCargado.nombre);
        }

    }

    static class Usuario{
        String nombre;
        int edad;
        String correo;
        public Usuario(String nombre, int edad, String correo){
            this.edad = edad;
            this.nombre = nombre;
            this.correo = correo;
        }

    }
}