package estudianteAsignatura;
public class Estudiante {
    private String nombre;
    private int curso;
    private String titulacion;

    public Estudiante(String nombre, int curso, String titulacion){
        this.nombre = nombre;
        this.curso = curso;
        this.titulacion = titulacion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCurso() {
        return curso;
    }
    public void setCurso(int curso) {
        this.curso = curso;
    }
    public String getTitulacion() {
        return titulacion;
    }
    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    @Override
    public String toString(){
        return String.format("Alumno: \nNombre: %s \nCurso: %d \nTitulación: %s", nombre, curso, titulacion);
    }
}
