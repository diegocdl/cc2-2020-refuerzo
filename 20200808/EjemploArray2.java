import java.util.Arrays;
import java.util.regex.Pattern;

public class EjemploArray2 {

  public static int[] convert(String[] arreglo) {
    int[] arregloInts = new int[arreglo.length];
    for(int i = 0; i < arreglo.length; i++) {
      arregloInts[i] = Integer.parseInt(arreglo[i]);
    }
    return arregloInts;
  }

  public static boolean validate(String[] arreglo) {
    for(String e: arreglo) {
      if(!Pattern.matches("[0-9]+", e)) {
        return false;
      }
    }
    return true;
  }

  // java EjemploArray2 1 2 10 20 5 5
  // Output: Sumatoria = 38
  public static void main(String[] args) {
    int sumatoria = 0;
    if(validate(args)) {
      int[] argsInt = convert(args);
      for(int e:argsInt) {  // equivalente al for e in argsInt:
        sumatoria += e;
      }
      System.out.println(Arrays.toString(argsInt));
      System.out.println("Sumatoria = " + sumatoria);
    } else {
      System.out.println("Error! todos los argumentos deben ser numeros enteros");
    }
  }
}