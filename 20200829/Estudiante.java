public class Estudiante {
  private static int correlativo = 0;
  private int carnet;
  private String nombre;

  public Estudiante(String nombre) {
    this.carnet = ++correlativo;
    this.nombre = nombre;
  }

  public Estudiante(int carnet, String nombre) {
    this.carnet = carnet;
    this.nombre = nombre;
  }

  public int getCarnet() {
    return carnet;
  }

  public String getNombre() {
    return nombre;
  }

  public void setCarnet(int carnet) {
    this.carnet = carnet;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public boolean equals(Object o) {
    if (o instanceof Estudiante) {
      Estudiante e = (Estudiante)o;
      return this.nombre.equals(e.nombre) && this.carnet == e.carnet;  
    } else {
      return false;
    }
  }

  public String toString() {
    return String.format("[%d,%s]", carnet, nombre);
  }
}