import java.util.*;
import java.io.*;

public class ArreglosReferencias {

  public static void readNumbers(int[] arr) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for(int i = 0; i < arr.length; i++) {
      System.out.print("Ingrese un numero: ");
      arr[i] = Integer.parseInt(br.readLine());
    }
  }

  public static int[] readNumbers(int size) throws Exception {
    int[] arr = new int[size];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for(int i = 0; i < arr.length; i++) {
      System.out.print("Ingrese un numero: ");
      arr[i] = Integer.parseInt(br.readLine());
    }
    return arr;
  }

  public static void main(String[] args) throws Exception {
    int[] arr1 = new int[10];
    readNumbers(arr1);
    // se esperaria que arr2 = [3, 4, 5]
    System.out.println("Arr1: " + Arrays.toString(arr1));
  }
}