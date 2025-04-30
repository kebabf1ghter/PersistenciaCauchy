import com.google.gson.Gson;
public class Main {
        public static void main(String[] args){
            Gson gson = new Gson();
            Persona p = new Persona("Cristiano Ronaldo", 40);
            String json = gson.toJson(p);
            System.out.println(json);
        }
}
