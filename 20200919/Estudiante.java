import java.util.ArrayList;
public class Estudiante extends Persona {
    public static int MAX_CURSOS = 6;
    protected long carnet;
    protected double promedio;
    protected ArrayList<String> cursos;

    public Estudiante(String dpi, String nombre, int edad, char genero, long carnet) {
        super(dpi, nombre, edad, genero);
        this.carnet = carnet;
        this.promedio = 0;
        this.cursos = new ArrayList<String>();
    }

    public boolean asignarCurso(String nombreCurso) {
        if (cursos.size() > MAX_CURSOS) {
            return false;
        } else if (cursos.contains(nombreCurso)) {
            return false;
        }
        cursos.add(nombreCurso);
        return true;
    }

    public long getCarnet() {
        return carnet;
    }

    public double getPromedio() {
        return promedio;
    }
    
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        String str = super.toString() + "\n";
        str += "Carnet: " + carnet + ", Promedio: " + promedio + "\n";
        str += "Cursos Asignados: " + cursos.toString();
        return str;
    }
}