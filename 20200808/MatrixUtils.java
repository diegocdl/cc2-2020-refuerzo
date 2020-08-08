
public class MatrixUtils {

  public static int[][] generateRandomMatrix(int w, int h) {
    int[][] matrix = new int[h][w];
    fillMatrixRandom(matrix);
    return matrix;
  }

  public static void fillMatrixRandom(int[][] m) {
    for(int h = 0; h < m.length; h++) {
      for(int w = 0; w < m[h].length; w++) {
        m[h][w] = (int)(Math.random()*100);
      }
    }
  }

  public static void printMatrix(int[][] matrix) {
    for(int h = 0; h < matrix.length; h++) {
      for(int w = 0; w < matrix[h].length; w++) {
        System.out.print(matrix[h][w] + " ");
      }
      System.out.println();
    }
  }

  public static void increment(int x) {
    x++;
    System.out.println("x = " + x);
  }
}