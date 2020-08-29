public class EjemploSimpleList {
  public static void main(String[] args) {
    SimpleList<Estudiante> estudiantes = new SimpleList<Estudiante>();
    estudiantes.addFirst(new Estudiante("Gabriela"));
    System.out.println(estudiantes);
    Estudiante luis = new Estudiante("Luis");
    estudiantes.addFirst(luis);
    System.out.println(estudiantes);
    System.out.println(estudiantes.search(new Estudiante(1, "Luis")));
    estudiantes.addFirst(new Estudiante("Oscar"));
    System.out.println(estudiantes);
    estudiantes.addFirst(new Estudiante("Diego"));
    System.out.println(estudiantes);
  }
}