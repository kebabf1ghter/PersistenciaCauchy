import account.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;

public class MainAccount {
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("Uso del programa: \n");
            System.out.println("    'new' <String id> <String nombre> <int balance> <nombre del archivo>");
            System.out.println("    'show' <nombre del archivo>");
            System.out.println("    'credit' <nombre del archivo> <int cantidad>");
            System.out.println("    'transfer' <nombre del archivo origen> <nombre del archivo destino> <int cantidad>");
            return;
        }
        if(args[0].equals("new")){
            try {
                Account account = new Account(args[1], args[2], Integer.parseInt(args[3]));
                guardarArchivo(args[4], account);
                System.out.println("Cuenta guardada correctamente. ");
            } catch (NumberFormatException e) {
                System.out.println("Pon un número imbécil");
            }
        }
        if(args[0].equals("show")){
            Account cuentaCargada = cargarArchivo(args[1], Account.class);
            System.out.println(cuentaCargada);
        }
        if(args[0].equals("credit")){
            Account cuenta = cargarArchivo(args[1], Account.class);
            try {
                cuenta.credit(Integer.parseInt(args[2]));
                System.out.println(cuenta.getBalance());
                guardarArchivo(args[1], cuenta);
                System.out.println("Dinero añadido correctamente");
            } catch (Exception e) {
                System.out.println("Eres tonto ponlo todo bien");
            }
        }
        if(args[0].equals("transfer")){
            Account cuenta1 = cargarArchivo(args[1], Account.class);
            Account cuenta2 = cargarArchivo(args[2], Account.class);
            try {
                cuenta1.transferTo(cuenta2, Integer.parseInt(args[3]));
                guardarArchivo(args[1], cuenta1);
                guardarArchivo(args[2], cuenta2);
                System.out.println("Dinero transferido correctamente");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Eres tonto ponlo todo bien");
            }
        }
    }

    public static void guardarArchivo(String rutaArchivo, Account cuenta){
        Gson gson = new Gson();
        try(FileWriter writer = new FileWriter(rutaArchivo)){
            gson.toJson(cuenta, writer);
        }catch(IOException e){
            e.getMessage();
        }
    }
    public static Account cargarArchivo(String rutaArchivo, Class<Account> clase){
        Gson gson = new Gson();
        try(FileReader reader = new FileReader(rutaArchivo)){
            return gson.fromJson(reader, clase);
        } catch(IOException e){
            e.getMessage();
            return null;
        }
    }

}
