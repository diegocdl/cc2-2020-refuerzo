import java.util.Arrays;

public class EjemploArray4 {
  public static void pow(int[] A, int pot) {
    for(int i = 0; i < A.length; i++) {
      int aux = A[i];
      A[i] = (int)Math.pow(aux, pot);
    }
  }

  public static void main(String[] args) {
    int[] base = {5, 2, 1, 0};
    pow(base, 2);
    System.out.println(Arrays.toString(base));
  }
}