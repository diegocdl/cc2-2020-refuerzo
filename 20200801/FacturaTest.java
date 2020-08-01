import java.io.*;

public class FacturaTest {
  public static void main(String[] args) throws Exception {
    // Factura f = new Factura("1234-K", "Juan Perez", "01/08/2020");
    // f.agregarProducto(1, "Coca Cola 500ml", 5.00);
    // f.agregarProducto(5, "Tortrix   ", 2.50);
    // f.agregarProducto(10, "Chocolate", 3.00);
    // f.setDescuento(0.10);
    // System.out.println(f);

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Sistema de Facturacion Supermercado La Bendicion");
    
    System.out.print("Nit: ");
    String nit = br.readLine();
    
    System.out.print("Nombre: ");
    String nombre = br.readLine();

    System.out.print("Fecha: ");
    String fecha = br.readLine();

    Factura f = new Factura(nit, nombre, fecha);

    int cant;
    double precio;
    String descripcion;

    System.out.println("\nIngrese detalle de factura: ");
    while (true) {
      System.out.print("Cantidad: ");
      cant = Integer.parseInt(br.readLine());

      if (cant == 0) {
        break;
      }
      
      System.out.print("Descripción: ");
      descripcion = br.readLine();

      System.out.print("Precio Unitario: ");
      precio = Double.parseDouble(br.readLine());

      f.agregarProducto(cant, descripcion, precio);

      System.out.println();
    }

    System.out.print("Descuento %: ");
    int descuento = Integer.parseInt(br.readLine());
    f.setDescuento((double)descuento/100.0);

    System.out.println("\n-------------------------------");
    System.out.println(f);
    System.out.println("-------------------------------");
  }
}