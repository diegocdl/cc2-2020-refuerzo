public class Ejemplo {
    public static void main(String[] args) {
        Object[] array = {
           Integer.valueOf(5),
           Integer.valueOf(20),
           "Emily",
           Integer.valueOf(30),
           "José",
           Integer.valueOf(50),
           "Kevin",
           "Jared" 
        };

        int count = 0;
        int sumatoria = 0;
        for(Object o : array) {
            if (o instanceof Integer) {
                count++;
                sumatoria += (Integer)o;
            }
        }

        System.out.println("Cantidad de Enteros: " + count);
        System.out.println("Sumatoria de los Valores Enteros: " + sumatoria);
    }
}