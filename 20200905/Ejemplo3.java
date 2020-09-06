public class Ejemplo3 {

    public static void print(int[] arreglo) {
        int cont = 0;

        for (int elemento : arreglo) {
            if (elemento == 0) {
                System.out.print(" X ");
            } else if (elemento < 10) {
                System.out.print(" " + elemento + " ");
            } else {
                System.out.print(elemento + " ");
            }
            cont++;
            if (cont == 6) {
                System.out.println();
                cont = 0;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};

        print(arreglo);
        System.out.println();

        System.out.println("Ocupando posicion 5...");
        arreglo[4] = 0;

        print(arreglo);
        System.out.println();      
    }
}