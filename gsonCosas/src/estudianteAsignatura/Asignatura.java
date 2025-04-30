package estudianteAsignatura;

public class Asignatura {
    private String nombre;
    private Estudiante[] listaEstudiantes;

    public Asignatura(String nombre, Estudiante[] listaEstudiantes){
        this.nombre = nombre;
        this.listaEstudiantes = listaEstudiantes;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Estudiante[] getListaEstudiantes() {
        return listaEstudiantes;
    }
    public void setListaEstudiantes(Estudiante[] listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
}
