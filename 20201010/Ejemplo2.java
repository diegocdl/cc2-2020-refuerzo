import java.util.LinkedList;
import threads.Cajero;
import threads.ColaClientes;

public class Ejemplo2 {
    public static void main(String[] args) {
        LinkedList<Integer> cola = new LinkedList<Integer>();
        Thread colaClientes = new Thread(new ColaClientes(cola));
        Cajero cajero1 = new Cajero("Cajero #1", cola);
        Cajero cajero2 = new Cajero("Cajero #2", cola);
        Cajero cajero3 = new Cajero("Cajero #3", cola);
        Cajero cajero4 = new Cajero("Cajero #4", cola);
        colaClientes.start();
        cajero1.start();
        cajero2.start();
        cajero3.start();
        cajero4.start();
    }
}