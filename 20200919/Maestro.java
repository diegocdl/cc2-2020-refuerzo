public class Maestro extends Persona {
    protected Curso curso;
    protected String userGes;

    public Maestro(String dpi, String nombre, int edad, char genero, Curso curso, String userGes) {
        super(dpi, nombre, edad, genero);
        this.curso = curso;
        this.userGes = userGes;
    }

    public Maestro(String dpi, String nombre, int edad, char genero, String userGes) {
        this(dpi, nombre, edad, genero, null, userGes);   
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setUserGes(String userGes) {
        this.userGes = userGes;
    }

    public String getUserGes() {
        return this.userGes;
    }

    @Override
    public String toString() {
        String str = super.toString() + ", user GES: " + userGes + "\n";
        str += "Curso Impartido: " + curso;
        return str;
    }

}