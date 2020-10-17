import java.util.Random;

public class Ejemplo3 {
    public static int[] generateRandomArray(int size) {
        Random r = new Random();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = r.nextInt(10);
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        int size = 100000000;
        int[] array = generateRandomArray(size);
        long start, time;

        int cantidad = 1;
        if (args.length > 0) {
            try {
                cantidad = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Error en el argumento se usara valor por default");
            } finally {
                System.out.printf("Se utilizara %d threads\n", cantidad);
            }
            System.out.flush();
        }
        int sizeBlock = size / cantidad;
        Sumador[] threads = new Sumador[cantidad];
        
        start = System.currentTimeMillis();
        // crear threads
        for (int i = 0; i < cantidad; i++) {
            threads[i] = new Sumador(array, i * sizeBlock, (i + 1) * sizeBlock);
        }
        // iniciar Threads
        for (int i = 0; i < cantidad; i++) {
            threads[i].start();
        }
        // esperar a que todos terminen
        for (int i = 0; i < cantidad; i++) {
            threads[i].join();
        }
        long sumatoria = 0;
        for (int i = 0; i < cantidad; i++) {
            sumatoria += threads[i].resultado;
        }
        System.out.println("Sumatoria: " + sumatoria);
        time = System.currentTimeMillis() - start;
        System.out.println("Time: " + time);

    }
}

class Sumador extends Thread {
    int[] array;
    int start;
    int end;
    long resultado;

    public Sumador(int[] array, int start, int end) {
        super();
        this.array = array;
        this.start = (start < 0) ? 0 : start;
        this.end =  (end < array.length) ? end : array.length;
    }

    @Override
    public void run() {
        long sumatoria = 0;
        for(int i = start; i < end; i++) {
            sumatoria += array[i];
        }
        resultado = sumatoria;
    }
}