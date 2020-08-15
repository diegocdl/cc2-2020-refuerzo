import java.util.Arrays;

public class MyArrays {
  public static int[] concat(int[] a, int[] b) {
    int[] aux = new int[a.length + b.length];
    int i;
    for(i = 0; i < a.length; i++) {
      aux[i] = a[i];
    }
    for(int j = 0; i < aux.length; i++, j++) {
      aux[i] = b[j];
    }
    return aux;
  }

  public static int[] copy(int[] a) {
    int[] aux = new int[a.length];
    for(int i = 0; i < aux.length; i++) {
      aux[i] = a[i];
    }
    return aux;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 5, 6};
    int[] b = new int[5];
    b[0] = 10;
    b[1] = 15;
    b[2] = 20;
    b[3] = 35;
    b[4] = 40;

    int[] c = concat(a, b);
    System.out.println(Arrays.toString(c));

    int[] a2 = {1, 2, 3, 4};
    int[] b2 = copy(a2);
    b2[1] = 100;
    System.out.println(Arrays.toString(a2));
    System.out.println(Arrays.toString(b2));
  }
}