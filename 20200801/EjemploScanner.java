import java.util.Scanner;

public class EjemploScanner {
  public static void main(String[] args) {
    String linea = "Juan Perez,85,62,92,Aprobado";
    Scanner sc = new Scanner(linea);
    sc.useDelimiter(",");

    String nombre = sc.next();
    int notaPrimerParcial = sc.nextInt();
    int notaSegundoParcial = sc.nextInt();
    int notaFinal = sc.nextInt();
    String status = sc.next();
    
    System.out.println("Nombre: " + nombre);
    System.out.println("Nota Primer Parcial: " + notaPrimerParcial);
    System.out.println("Nota Segundo Parcial : " + notaSegundoParcial);
    System.out.println("Nota Final : " + notaFinal);
    System.out.println("Status : " + status);
  }
}