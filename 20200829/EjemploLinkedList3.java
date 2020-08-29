import java.util.LinkedList;
import java.io.*;

public class EjemploLinkedList3 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LinkedList<String> lista = new LinkedList<String>();

    while(true) {
      System.out.println("\n1. Agregar palabra");
      System.out.println("2. Mostrar palabras");
      System.out.println("3. Salir");
      System.out.print("Elija una opción del menu: ");
      int opcion = Integer.parseInt(br.readLine());
      if (opcion == 1) {
        System.out.print("Ingrese una palabra a agregar: ");
        String palabra = br.readLine();
        lista.add(palabra);
      } else if (opcion == 2) {
        for(String e : lista) {
          System.out.println("\t- " + e);
        }
      } else if (opcion == 3) {
        break;
      } else {
        System.out.println("Opcion invalida :(");
      }
    }
  }
}