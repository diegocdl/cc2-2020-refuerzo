import java.util.LinkedList;

public class EjemploLinkedList {
  public static void main(String[] args) {
    LinkedList<Estudiante> lista = new LinkedList<Estudiante>();
    lista.add(new Estudiante("Pedro"));
    System.out.println(lista);
    lista.add(new Estudiante("Gabriela"));
    System.out.println(lista);
    lista.add(new Estudiante("Oscar"));
    System.out.println(lista);
    
    int index = lista.indexOf(new Estudiante(2, "Gabriela"));
    System.out.println("Buscamos a Gabriela en la lista y tiene indice: " + index);
  
    lista.remove(new Estudiante(2, "Gabriela"));
    System.out.println(lista);
  }
}