package threads;

import java.util.LinkedList;
import java.util.Random;

public class Cajero extends Thread {
    protected LinkedList<Integer> cola;

    public Cajero(String nombre, LinkedList<Integer> cola) {
        super(nombre);
        this.cola = cola;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true) {
            Integer i = null;
            synchronized (cola) {
                if (!cola.isEmpty()) {
                    i = cola.removeFirst();
                }
            }
            if (i != null) {
                System.out.printf("El cajero %s atendio al cliente #%d\n", this.getName(), i);
                System.out.flush();
            }
            try {
                // int sleepTime = 500 + r.nextInt(4500);
                int sleepTime = 50 + r.nextInt(450);
                Thread.sleep(sleepTime);
            } catch (Exception e) { }
        }
    }
}