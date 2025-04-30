public class Persona {
    private String nombre;
    private int edad;
    Direccion direccion;

    public Persona(String nombre, int edad){
        this.edad = edad;
        this.nombre = nombre;
    }
    public Persona(String nombre, int edad, Direccion direccion){
        this.edad = edad;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }
}
