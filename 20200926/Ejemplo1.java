import java.util.*;
public class Ejemplo1 {
    public static void fillRandom(List<Integer> lista)  {
        Random r = new Random();
        for(int i = 0; i < 10; i++) {
            lista.add(r.nextInt(15) + 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> lista1 = new LinkedList<Integer>();
        fillRandom(lista1);
        System.out.println("Lista1: " + lista1);

        ArrayList<Integer> lista2 = new ArrayList<Integer>();
        fillRandom(lista2);
        System.out.println("Lista2: " + lista2);

        // o tiene tipo estatico Object y tipo dinamico String
        // Como tipo estatico podemos utilizar cualquier superclase del objeto que queremos guardar
        //      o podemos utilizar cualquier intarfaz que implemente el objecto que queremos guardar.
        Object o = "Hola";

        // Cuando accedemos a un metodo de o se utiliza el Dynamic Method Lookup
        // que significa que revisara si el tipo dinamico tiene una implementación(sobreescribe)
        // ese metodo y si si lo hace utilizara esas instrucciones.
        System.out.println("String: " + o.toString());

        // Al ser o su tipo estatico Object solo podemos usar los metodos
        // definidos en Object
        // String s2 = o.substring(0, 2);

        // Con instanceof podemos revisar si una variable guarda un tipo de objeto
        // en especifico y asi castearlo para acceder a todas sus caracteristicas.
        if (o instanceof String) {
            String s = (String)o;
            String s2 = s.substring(0, 2);
            System.out.println("Substring de s de (0, 2): " + s2);
        }

        o = Integer.valueOf(5);

    }
}