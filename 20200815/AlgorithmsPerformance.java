import java.util.*;
public class AlgorithmsPerformance {
  public static int[] generateRandomArray(int size) {
    int[] array = new int[size];
    // le damos un sed = 0 a Random para que siempre que ejecutemos
    // el programa nos genere los mismos numeros aleatorios.
    Random r = new Random(0);
    for (int i = 0; i < array.length; i++) {
      array[i] = r.nextInt();
    }
    return array;
  }

  public static long performanceBubbleSort(int[] arrayOriginal) {
    int[] arrayTest = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
    long startTime = System.currentTimeMillis();
    Algorithms.bubbleSort(arrayTest);
    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }

  public static long performanceSelectionSort(int[] arrayOriginal) {
    int[] arrayTest = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
    long startTime = System.currentTimeMillis();
    Algorithms.selectionSort(arrayTest);
    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }

  public static long performanceInsertionSort(int[] arrayOriginal) {
    int[] arrayTest = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
    long startTime = System.currentTimeMillis();
    Algorithms.insertionSort(arrayTest);
    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }

  public static boolean validateSort(int[] array) {
    for(int i = 0; i < array.length - 1; i++) {
      if (array[i] > array[i + 1]) {
        return false;
      } 
    }
    return true;
  }

  public static void main(String[] args) {
    int[] test = generateRandomArray(100);
    int[] arrayTest = Arrays.copyOf(test, test.length);
    Algorithms.bubbleSort(arrayTest);
    boolean testBubbleSort = validateSort(arrayTest);
    if(!testBubbleSort)
      System.out.println("Problema con el BubbleSort");

    arrayTest = Arrays.copyOf(test, test.length);
    Algorithms.selectionSort(arrayTest);
    boolean testSelectionSort = validateSort(arrayTest);
    if(!testSelectionSort)
      System.out.println("Problema con el SelectionSort");

    arrayTest = Arrays.copyOf(test, test.length);
    Algorithms.insertionSort(arrayTest);
    boolean testInsertionSort = validateSort(arrayTest);
    if(!testInsertionSort)
      System.out.println("Problema con el InsertionSort");
    
    if (testBubbleSort && testSelectionSort && testInsertionSort) {
      int[] arrayOriginal;
      for (int size = 1000; size < 1000000; size += 1000) {
        arrayOriginal = generateRandomArray(size);
        System.out.print(size + ",");
        System.out.print(performanceBubbleSort(arrayOriginal) + ",");
        System.out.print(performanceSelectionSort(arrayOriginal) + ",");
        System.out.print(performanceInsertionSort(arrayOriginal));
        System.out.println();
      }
    }
  }
}