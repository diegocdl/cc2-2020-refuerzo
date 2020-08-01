import java.util.Scanner;

public class FacturaTest {
  public static void main(String[] args) {
    // Factura f = new Factura("1234-K", "Juan Perez", "01/08/2020");
    // f.agregarProducto(1, "Coca Cola 500ml", 5.00);
    // f.agregarProducto(5, "Tortrix   ", 2.50);
    // f.agregarProducto(10, "Chocolate", 3.00);
    // f.setDescuento(0.10);
    // System.out.println(f);

    Scanner sc = new Scanner(System.in);
    System.out.println("Sistema de Facturacion Supermercado La Bendicion");
    
    System.out.print("Nit: ");
    String nit = sc.nextLine();
    
    System.out.print("Nombre: ");
    String nombre = sc.nextLine();

    System.out.print("Fecha: ");
    String fecha = sc.nextLine();

    Factura f = new Factura(nit, nombre, fecha);

    int cant;
    double precio;
    String descripcion;

    System.out.println("\nIngrese detalle de factura: ");
    while (true) {
      System.out.print("Cantidad: ");
      cant = sc.nextInt();
      sc.nextLine();

      if (cant == 0) {
        break;
      }
      
      System.out.print("Descripción: ");
      descripcion = sc.nextLine();

      System.out.print("Precio Unitario: ");
      precio = sc.nextDouble();
      sc.nextLine();

      f.agregarProducto(cant, descripcion, precio);

      System.out.println();
    }

    System.out.print("Descuento %: ");
    int descuento = sc.nextInt();
    f.setDescuento((double)descuento/100.0);

    System.out.println("\n-------------------------------");
    System.out.println(f);
    System.out.println("-------------------------------");
  }
}