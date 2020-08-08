import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EjemploRandom {
  private static int[] arreglo = new int[10];

  public static void insertRandom1() {
    Random r = new Random();
    int indice = r.nextInt(10);
    arreglo[indice] = 1;
    System.out.println(Arrays.toString(arreglo));
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while(true) {
      insertRandom1();
      br.readLine();
    }
  }
}