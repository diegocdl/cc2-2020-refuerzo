public class Ejemplo1 {
    public static void print(int[][] matriz) {
        for (int[] row : matriz) {
            for (int element : row) {
                if (element == 0) {
                    System.out.print(" X ");
                } else if (element < 10) {
                    System.out.print(" " + element + " ");
                } else {
                    System.out.print(element + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3, 4, 5, 6},
            {7, 8, 0, 10, 11, 12},
            {13, 14, 15, 16, 17, 18}
        };
        print(matriz);
        
    }
}