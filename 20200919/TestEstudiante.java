public class TestEstudiante {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("1234 56789 0101", "Fernando Ortiz", 18, Persona.MASCULINO, 12345678);
        estudiante.asignarCurso("Matematica 2");
        if (!estudiante.asignarCurso("Matematica 2")) {
            System.out.println("No se pudo asignar el curso");
        }
        estudiante.asignarCurso("Fisica 2");
        System.out.println(estudiante);
        System.out.println();

        Persona persona = estudiante;
        // persona.setPromedio(100.0); Esto genera un error porque el tipo Estatico de persona es Persona
        if (persona instanceof Estudiante)
            ((Estudiante)persona).setPromedio(99);

        System.out.println(persona);
    }
}