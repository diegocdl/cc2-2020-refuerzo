package threads;

import java.util.LinkedList;
import java.util.Random;

public class ColaClientes implements Runnable {
    protected LinkedList<Integer> cola;

    public ColaClientes(LinkedList<Integer> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        int contClientes = 0;
        Random r = new Random();
        while (true) {
            synchronized (cola) {
                cola.add(contClientes);
            }
            System.out.printf("Se agrego a la cola al cliente %d\n", contClientes);
            System.out.flush();
            contClientes++;

            try {
                // int sleepTime = 100 + r.nextInt(2900);
                int sleepTime = 10 + r.nextInt(290);
                Thread.sleep(sleepTime);
            } catch (Exception e) {}
        }
    }

}