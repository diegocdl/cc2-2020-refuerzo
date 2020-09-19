public class Curso {
    protected String nombre;
    protected String horario;
    protected int cantidadCreditos;

    public Curso(String nombre, String horario, int creditos) {
        this.nombre = nombre;
        this.horario = horario;
        this.cantidadCreditos = creditos;
    }


    public String toString() {
        return nombre + " - " + horario + " : " + cantidadCreditos + " creditos";
    }
}