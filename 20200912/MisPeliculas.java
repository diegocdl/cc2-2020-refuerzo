import java.io.*;
import java.util.LinkedList;

public class MisPeliculas {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Pelicula> peliculas = new LinkedList<Pelicula>();

        int opcion = 0;
        do {
            System.out.println("----------------------------");
            System.out.println("1 Registrar pelicula");
            System.out.println("2 Listar peliculas");
            System.out.println("3 Buscar pelicula");
            System.out.println("4 Remover una pelicula");
            System.out.println("5 Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre de la pelicula: ");
                    String nombre = br.readLine();
                    System.out.print("Ingrese el tipo de la pelicula (Accion, Sci-Fi, Romantica): ");
                    String tipo = br.readLine();
                    System.out.print("Ingrese el año de la pelicula: ");
                    int year = Integer.parseInt(br.readLine());

                    Pelicula pelicula = new Pelicula(nombre, tipo, year);
                    peliculas.add(pelicula);
                    break;
                case 2:
                    System.out.println("Mis Peliculas: ");
                    if (peliculas.isEmpty()) {
                        System.out.println("\tNo se han registrado peliculas aun");
                    } else {
                        for (Pelicula p : peliculas) {
                            System.out.println("\t" + p);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Ingrese termino a buscar en el nombre: ");
                    String parametroBusqueda = br.readLine().toLowerCase();
                    for (Pelicula p : peliculas) {
                        if (p.nombre.toLowerCase().contains(parametroBusqueda)) {
                            System.out.println("\t" + p);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el id de la pelicula que quiere remover: ");
                    int id = Integer.parseInt(br.readLine());
                    if (peliculas.remove(new Pelicula(id))) {
                        System.out.println("Se removio la pelicula exitosamente");
                    } else {
                        System.out.println("No se encontro la pelicula con el ID proporcionado");
                    }
                    break;
                case 5:
                    System.out.println("GoodBye");
                    break;
                default:
                    System.out.println("Opcion ingresada invalida");
                    break;
            }

        } while (opcion != 5);
    }
}

class Pelicula {
    static int contador = 1;
    int id;
    String nombre;
    String tipo;
    int year;

    public Pelicula (String nombre, String tipo, int year) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.year = year;
        this.id = contador++;
    }

    public Pelicula(int id) {
        this.id = id;
    }

    public String toString() {
        return String.format("%d %d %s %s", id, year, nombre, tipo);
    }

    public boolean equals(Object o) {
        Pelicula p = (Pelicula)o;
        return this.id == p.id;
    }
}