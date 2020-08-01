public class EmpleadoTest {
  public static void main(String[] args) {
    Empleado santiago = new Empleado("SB-0001", "Santiago Barrios", 5000.00, 350.00);
    santiago.registrarVenta(250);
    santiago.registrarVenta(300);
    System.out.println(santiago.toString());
  }
}