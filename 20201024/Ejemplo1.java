import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

public class Ejemplo1 {
    public static int readNumber(BufferedReader br, String msg) throws IOException {
        int value = 0;
        while (true) {
            try {
                System.out.print(msg);
                value = Integer.parseInt(br.readLine());
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("Error valor ingresado invalido, vuelva a ingresarlo");
            }
        }
        return value;
    }

    public static int validacionNumero(BufferedReader br, int min) throws IOException {
        int value = 0;
        do {
            value = readNumber(br, "Ingrese el maximo: ");
            if (value <= min) {
                System.out.println("El numero maximo debe ser mayor que el minimo: " + min);
            }
        } while (value <= min);
        return value;
    }

    public static void main(String[] args) throws IOException {
        int min = 10;
        int max = 50;
        try {
            if (args.length == 2) {
                min = Integer.parseInt(args[0]);
                max = Integer.parseInt(args[1]);
            }
            if ( max < min) {
                int aux = max;
                max = min;
                min = aux;
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Ocurrio un error al leer los parametros");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            min = readNumber(br, "Ingrese el minimo: ");
            max = validacionNumero(br, min);
        }
        System.out.println(String.format("Se generaran numeros aleatorios entre %d y %d", min, max));
        // generar y desplegar los numeros
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            // Ejemplo del random
            // 5 -> 10
            // max - min = 5 + 1
            // (0 -> 5) + 5 -> (5 -> 10)
            System.out.println(rand.nextInt(max - min + 1) + min);
        }
    }        
}