import com.google.gson.Gson;
import estudianteAsignatura.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainAlumno {
    public static void main(String[] args){

       if(args[0].equals("nuevoestudiante")){
            Estudiante e = new Estudiante(args[1], Integer.parseInt(args[2]), args[3]);
            guardarArchivo(args[4], e);
            System.out.println("Estudiante guardado correctamente");
       }else if(args[0].equals("nuevoasignatura")) {
           int i = 3;
           Estudiante[] lista = new Estudiante[50];
           while (args[i] != null) {
               Estudiante e = cargarArchivo(args[i], Estudiante.class);
               lista[i - 3] = e;
               i++;
           }
           Asignatura a = new Asignatura(args[2], lista);
           guardarArchivo(args[1], a);
           System.out.println("Asignatura guardada correctamente");

       }
    }

    public static <T> void guardarArchivo(String rutaArchivo, T algo){
        Gson gson = new Gson();
        try(FileWriter writer = new FileWriter(rutaArchivo)){
            gson.toJson(algo, writer);
        }catch(IOException e){
            System.out.println("An IOException has occurred");
        }
    }

    public static <T> T cargarArchivo(String rutaArchivo, Class<T> clase){
        Gson gson = new Gson();
        try(FileReader reader = new FileReader(rutaArchivo)){
            return gson.fromJson(reader, clase);
        } catch(IOException e){
            System.out.println("An IOException has occurred");
            return null;
        }
    }
}
