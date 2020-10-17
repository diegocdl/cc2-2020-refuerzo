public class Ejemplo1 {
    public static void main(String[] args) {
        
        int estadoA = 0;
        int estadoB = 1;

        int maxSleep = 1000;

        int contA = 0;
        int contB = 0;

        while (true) {
            if(estadoA == 0) {
                estadoA = 1;
                estadoB = 0;
            } else {
                estadoA = 0;
                estadoB = 1;
            }
            System.out.printf("estadoA: %d, estadoB: %d\n", estadoA, estadoB);
            if (estadoA == 1) {
                for (int i = 0; i < 10; i++) {
                    contA++;
                    System.out.println("ContA: " + contA);
                    try {
                        Thread.sleep(maxSleep/10);
                    } catch (Exception e) { }
                }
            } else if (estadoB == 1) {
                int sleepedTime = 0;
                while (sleepedTime < maxSleep) {
                    contB++;
                    System.out.println("ContB: " + contB);
                    try {
                        Thread.sleep(500);
                        sleepedTime += 500;
                    } catch (Exception e) { }
                }
            }            
        }
    }
}