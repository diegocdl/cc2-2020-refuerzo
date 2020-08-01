/**
 * Definamos la clase Empleado
 * Que vamos a guardar?
 *  - sueldoBase: double
 *  - porcentajeComision: double
 *  - ventas: double
 *  - nombre: String
 *  - codigo: String
 *  - descuentos: double
 * Constructores?
 *  - (codigo, nombre, sueldoBase, descuentos, porcentajeComision) -> ventas = 0 
 *  - (codigo, nombre, sueldoBase, descuentos) -> ventas = 0 , porcentajeComision = 0.10
 * Metodos?
 *  - getSueldoBase()
 *  - setSueldoBase(double)
 *  - getPorcentajeComision()
 *  - setPorcentajeComision(double)
 *  - getVentas()
 *  - registroVenta(double)
 *  - getNombre()
 *  - getCodigo()
 *  - getDescuentos()
 *  - toString()
 * Empleado empleado = new Empleado("JP-00001", "Juan Perez", 2500.00, 250.00, 0.15);
*/

public class Empleado {
  private double sueldoBase;
  private double porcentajeComision;
  private double ventas;
  private String nombre, codigo;
  private double descuentos;

  public Empleado(String codigo, String nombre, double sueldoBase, double descuentos, double pComision) {
    this(codigo, nombre, sueldoBase, descuentos);
    this.porcentajeComision = pComision;
  }

  public Empleado(String cod, String nom, double sueldo, double desc) {
    this.codigo = new String(cod);
    this.nombre = new String(nom);
    this.sueldoBase = sueldo;
    this.descuentos = desc;
    this.porcentajeComision = 0.10;
    this.ventas = 0.00;
  }

  public double getSueldoBase() {
    return this.sueldoBase;
  }

  public void setSueldoBase(double sueldo) {
    this.sueldoBase = sueldo;
  }

  public double getPorcentajeComision() {
    return this.porcentajeComision;
  }

  public void setPorcentajeComision(double porcentaje) {
    this.porcentajeComision = porcentaje;
  }

  public double getVentas() {
    return this.ventas;
  }

  public void setVentas(double monto) {
    this.ventas = monto;
  }

  public void registrarVenta(double monto) {
    this.ventas += monto;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getCodigo() {
    return this.codigo;
  }

  public double getDescuentos() {
    return this.descuentos;
  }

  public double getSalario() {
    return this.getSueldoBase() + this.getVentas() * this.getPorcentajeComision() -  this.getDescuentos();
  }

  public String toString() {
    String resultado = "Codigo: " + this.getCodigo() + ", Nombre: " + this.getNombre() + ", Ventas: Q" + this.getVentas();
    resultado += ", Salario: Q" + this.getSalario();
    return resultado;
  }
}