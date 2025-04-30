import com.google.gson.Gson;
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
        }

}
