import com.google.gson.Gson;
import punto2D.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainPunto2D {
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("Uso del programa: \n");
            System.out.println("OPERACIONES CON PUNTOS:");
            System.out.println("    'point' <x> <y> <nombre del archivo>");
            System.out.println("    'showpoint' <nombre del archivo>");
            System.out.println("OPERACIONES CON SEGMENTOS:");
            System.out.println("    'segment' <nombre del punto origen> <nombre del punto destino> <nombre del archivo>");
            System.out.println("    'showsegment' <nombre del archivo>");
            System.out.println("    'norm' <nombre del segmento>");
            System.out.println("    'gradient' <nombre del segmento>");
            System.out.println("    'product' <nombre del segmento 1> <nombre del segmento 2>");
            System.out.println("OPERACIONES GENÉRICAS:");
            System.out.println("    'delete' <nombre del archivo>");
            System.out.println("    'rename' <nombre del archivo> <nombre nuevo>");
            return;
        }
        if(args[0].equals("point")){
            Punto2D punto = new Punto2D(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            if(cargarArchivo(args[3], Punto2D.class) != null){
                System.out.println("El archivo " + args[3] + " ya existe");
            }else{
                guardarArchivo(args[3], punto);
                System.out.println("Punto guardado correctamente bajo el nombre " + args[3]);
            }
        }
        if(args[0].equals("showpoint")){
            Punto2D punto = cargarArchivo(args[1], Punto2D.class);
            System.out.println(punto);
        }
        if(args[0].equals("segment")){
            Punto2D punto1 = cargarArchivo(args[1], Punto2D.class);
            Punto2D punto2 = cargarArchivo(args[2], Punto2D.class);
            Segmento s = new Segmento(punto1, punto2);
            guardarArchivo(args[3], s);
            System.out.println("Segmento guardado correctamente bajo el nombre " + args[3]);
        }
        if(args[0].equals("showsegment")){
            Segmento s = cargarArchivo(args[1], Segmento.class);
            if(s != null) {
                Punto2D inicio = s.getInicio();
                Punto2D fin = s.getFin();
                System.out.println("Inicio: " + inicio);
                System.out.println("Fin: " + fin);
                System.out.println("Segmento resultante: " +
                        String.format("[%d,%d]", s.getxDiff(inicio, fin), s.getyDiff(inicio, fin)));
            } else {
                System.out.println("No existe el segmento");
            }
        }
        if(args[0].equals("norm")){
            Segmento s = cargarArchivo(args[1], Segmento.class);
            if (s != null) {
                System.out.println("La norma de " + args[1] + " es de " + s.longitud());
            }else System.out.println("No existe el segmento");
        }
        if(args[0].equals("gradient")){
            Segmento s = cargarArchivo(args[1], Segmento.class);
            if(s != null){
                double pendiente = s.getPendiente();
                System.out.println("La pendiente del segmento es " + pendiente);
            }else System.out.println("No existe el segmento");
        }
        if(args[0].equals("product")){
            Segmento s1 = cargarArchivo(args[1], Segmento.class);
            Segmento s2 = cargarArchivo(args[2], Segmento.class);
            if(s1 != null && s2 != null){
                System.out.println("El producto escalar de " + args[1] + " es de " + s1.productoEscalar(s2));
            }else System.out.println("No existe alguno de los segmentos");
        }
        if(args[0].equals("delete")){
            if(borrarArchivo(args[1])){
                System.out.println("El archivo " + args[1] + " se eliminó correctamente");
            }
            else System.out.println("No se pudo eliminar el archivo " + args[1]);
        }
        if(args[0].equals("rename")){
            if(renombrarArchivo(args[1], args[2], Class.class)){
                System.out.println("El archivo " + args[1] + " se renombró correctamente a " + args[2]);
            }else System.out.println("El archivo " + args[1] + " no existe");
        }
    }

    public static <T> void guardarArchivo(String rutaArchivo, T algo){
        Gson gson = new Gson();
        try(FileWriter writer = new FileWriter(rutaArchivo)){
            gson.toJson(algo, writer);
        }catch (IOException e){
            e.getMessage();
        }
    }

    public static <T> T cargarArchivo(String rutaArchivo, Class<T> clase){
        Gson gson = new Gson();
        try(FileReader reader = new FileReader(rutaArchivo)){
            return gson.fromJson(reader, clase);
        }catch(IOException e){
            e.getMessage();
            return null;
        }
    }

    public static boolean borrarArchivo(String rutaArchivo){
        File file = new File(rutaArchivo);
        return file.delete();
    }

    public static <T> boolean renombrarArchivo(String rutaArchivo, String nuevoNombre, Class<T> clase){
        T archivo = cargarArchivo(rutaArchivo, clase);
        if(archivo != null){
            guardarArchivo(nuevoNombre, archivo);
            borrarArchivo(rutaArchivo);
            return true;
        }else return false;
    }
}
