public class TestEstudiante {
    public static void main(String[] args) {
        Estudiante var1 = new Estudiante("1234 56789 0101", "Fernando Ortiz", 18, Persona.MASCULINO, 12345678);
        var1.asignarCurso("Matematica 2");
        if (!var1.asignarCurso("Matematica 2")) {
            System.out.println("No se pudo asignar el curso");
        }
        var1.asignarCurso("Fisica 2");
        System.out.println(var1);
        System.out.println();

        // Object > Persona > Estudiante
        Object var2 = var1;
        // persona.setPromedio(100.0); // Esto genera un error porque el tipo Estatico de persona es Persona
        if (var2 instanceof Estudiante)
            ((Estudiante)var2).setPromedio(99);

        System.out.println(var2.toString());

        System.out.println();
        Maestro var3 = new Maestro("1234 56908 0101", "Diego Calderon", 28, Persona.MASCULINO, "diegocdl");
        System.out.println(var3);

        System.out.println();
        Persona var4 = new Maestro("1234 56780 0101", "Juan Perez", 26, Persona.MASCULINO, "jperez");
        if (var4 instanceof Maestro) {
            Maestro var5 = (Maestro)var4;
            Curso curso = new Curso("CC2", "10:00 am", 5);
            var5.setCurso(curso);
        }
        System.out.println(var4);
    }
}