public class EjemploArray3 {
  public static void print(int[] arreglo) {
    System.out.print("| ");
    for (int i = 0; i < arreglo.length; i++) {
      System.out.print(arreglo[i]);
      if (i < arreglo.length - 1) {
        System.out.print(" - ");
      } else {
        System.out.print(" |");
      }
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    int[] arreglo = {1, 2, 3, 4};
    print(arreglo);
  }
}