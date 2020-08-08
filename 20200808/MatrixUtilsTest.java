public class MatrixUtilsTest {
  public static void main(String[] args) {
    int w = 3;
    int h = 3;

    if(args.length == 2) {
      w = Integer.parseInt(args[0]);
      h = Integer.parseInt(args[1]);
    }

    int[][] m = MatrixUtils.generateRandomMatrix(w, h);
    MatrixUtils.printMatrix(m);

    System.out.println("\nEjemplo paso por valor...");

    // Ejemplo pasando argumento por valor
    int var = 0;
    System.out.println("var = " + var);
    System.out.println("llamando a.. increment(var)");
    MatrixUtils.increment(var);
    System.out.println("var = " + var);
  }
}