import java.io.*;
import java.util.Random;
public class RandomPractice {
  public static void main(String[] args) throws Exception {
    System.out.println("Programa para generar numeros aleatorios entre dos numeros.");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Ingrese limite inferior: ");
    int a = Integer.parseInt(br.readLine());
    System.out.print("Ingrese limite superior: ");
    int b = Integer.parseInt(br.readLine());
    Random rand = new Random();

    if (a < b) {
      while (true) {
        int num = rand.nextInt(b - a + 1) + a;
        System.out.printf("Numero generado: %d", num);
        br.readLine();
      }
    } else {
      System.out.println("Error! numeros ingresados invalidos");
    }
  }
}