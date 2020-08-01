
/**
 * Clase Factura
 * Que va a guardar?
 *    - nombre: String
 *    - fecha: String
 *    - nit: String
 *    - monto: double
 *    - descripcion: String
 *    - decuento: double
 * Como construimos un objeto?
 *    - (nit, nombre, fecha) -> monto = 0.00, decripcion = "", decuento = 0.00
 * Metodos?
 *    - agregarProducto(int cant, String descripcion, double precio)
 *    - setDescuento(double porcentaje)
 *    - getNombre()
 *    - getFecha()
 *    - getNit()
 *    - getMonto()
 *    - getDescripcion()
 *    - getDescuento()
 *    - toString()
 */
 public class Factura {
   private String nombre, fecha, nit, descripcion;
   private double monto, descuento;

   public Factura(String nit, String nombre, String fecha) {
    this.nit = new String(nit);
    this.nombre = new String(nombre);
    this.fecha = new String(fecha);
    this.monto = 0.00;
    this.descuento = 0.00;
    this.descripcion = "";
   }

   public void agregarProducto(int cant, String descripcion, double precio) {
    //Formato: cant descripcion precio_unitario precio_total\n
    this.descripcion += String.format("%d\t%s\t%.2f\t\t%.2f\n", cant, descripcion, precio, precio * cant);
    this.monto += precio * cant;
   }

   public String getNombre() {
     return this.nombre;
   }

   public String getFecha() {
     return this.fecha;
   }

   public String getNit() {
     return this.nit;
   }

   public double getMonto() {
     return this.monto;
   }

   private double getMontoConDescuento() {
     return this.getMonto() - this.getMonto() * this.getDescuento();
   }

   public String getDescripcion() {
     return this.descripcion;
   }

   public double getDescuento() {
     return this.descuento;
   }

   public void setDescuento(double porcentaje) {
     this.descuento = porcentaje;
   }

   /**
     * El formato que se generara es el siguiente
     * Nombre empresa
     * Nit: ______  
     * Nombre: ________
     * Fecha: ________
     * 
     * Cant Descripcion   Precio U. Precio Total.
     * ___  ___________    ________ ___________
     * ___  ___________    ________ ___________
     * ___  ___________    ________ ___________
     * ___  ___________    ________ ___________
     * 
     * Total Q_______
     * Descuento Q_______
     * Total a Pagar Q________
     */
   public String toString() {
    String resultado = "Supermercado La Bendicion\n";
    resultado += "Nit: " + this.getNit() + "\n";
    resultado += "Nombre: " + this.getNombre() + "\n";
    resultado += "Fecha: " + this.getFecha() + "\n";
    resultado += "\n";
    resultado += "Cant\tDescripcion\tPrecio U.\tPrecio T.\n";
    resultado += this.getDescripcion();
    resultado += "\n";
    resultado += "Total Q" + this.getMonto() + "\n";
    resultado += "Descuento Q" + this.getMonto() * this.getDescuento() + "\n";
    resultado += "Total a Pagar Q" + this.getMontoConDescuento();
    return resultado;
   }

 }