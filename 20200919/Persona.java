public class Persona {
    public static final char MASCULINO = 'M';
    public static final char FEMENINO = 'F';
    
    protected String dpi;
    protected String nombre;
    protected int edad;
    protected char genero;

    public Persona(String dpi, String nombre, int edad, char genero) {
        this.dpi = dpi;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDpi() {
        return dpi;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return String.format("%s - %s, edad: %d, genero: %c", dpi, nombre, edad, genero);
    }

}