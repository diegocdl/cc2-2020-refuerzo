import java.util.Arrays;

public class EjemploArray {
  public static int count(int[] arreglo, int value) {
    int contador = 0;
    for(int i = 0; i < arreglo.length; i++) {
      if(arreglo[i] == value) {
        contador++;
      }
    }
    return contador;
  }

  public static void main(String[] args) {
    int[] arregloTest = {1, 2, 20, 10, 15, 20};
    int numeroBuscar = 20;
    int cantidad = count(arregloTest, numeroBuscar);
    System.out.println("Arreglo: " + Arrays.toString(arregloTest));
    System.out.println("El " + numeroBuscar + " aparece " + cantidad + " veces");
  }
}