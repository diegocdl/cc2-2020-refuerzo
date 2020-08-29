import java.util.*;

public class EjemploLinkedList2 {
  public static void main(String[] args) {
    int size = 10;
    if(args.length > 0) {
      size = Integer.parseInt(args[0]);
    }

    long startTime = System.currentTimeMillis();
    LinkedList<Integer> lista = new LinkedList<Integer>();
    Random rand = new Random(0);
    for(int i = 0; i < size; i++) {
      lista.add(rand.nextInt(100));
    }

    long sumatoria = 0;
    // for(int i = 0; i < lista.size(); i++) {
    //   sumatoria += lista.get(i);
    // }
    while(!lista.isEmpty()) {
      sumatoria += lista.removeFirst();
    }
    System.out.println("Sumatoria: " + sumatoria);
    System.out.println("Tiempo: " + (System.currentTimeMillis() - startTime));
  }
}