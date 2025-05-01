import com.google.gson.Gson;
import estudianteAsignatura.Asignatura;
import estudianteAsignatura.Estudiante;

public class Main {
        public static void main(String[] args) {
            Gson gson = new Gson();
            Persona p = new Persona("Cristiano Ronaldo", 40);
            String json = gson.toJson(p);
            System.out.println(json);

            //Ejemplo para el ejercicio 2
            Direccion dir = new Direccion("Gran Via", "Madrid");
            Persona per = new Persona("Aitorpedo", 33, dir);
            Gson gsoon = new Gson();
            String jsoon = gson.toJson(per);

            System.out.println(jsoon);

            //Ejemplo para el ejercicio 3
            Gson gsonEj3 = new Gson();
            Estudiante estudiante1 = new Estudiante("Folden Linganguliyev", 1, "Bioquímica");
            Estudiante estudiante2 = new Estudiante("Nicolas Marciano Calabaza", 1, "Filología Francesa");
            Estudiante estudiante3 = new Estudiante("Adrian Azukinky", 1,"Matemáticas y Computación");
            Estudiante[] arrayEstudiantes = new Estudiante[]{estudiante1, estudiante2, estudiante3};
            String jsonEj3 = gsonEj3.toJson(arrayEstudiantes);
            System.out.println(jsonEj3);
            Gson gsonEj3b = new Gson();
            Asignatura desempleoIII = new Asignatura("Desempleo III",arrayEstudiantes);
            String jsonEj3b = gsonEj3b.toJson(desempleoIII);
            System.out.println(jsonEj3b);
        }

}
