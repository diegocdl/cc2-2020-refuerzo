import java.util.*;
import java.io.*;

public class Ejemplo4 {
    public static void main(String[] args) throws Exception {
        LinkedList<Estampa> album = new LinkedList<Estampa>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ciclo:
        while (true) {
            System.out.println("\n1. Registrar Estampa");
            System.out.println("2. Listar Estampas");
            System.out.println("3. Buscar");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opcion: ");
            int opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el numero de estampa: ");
                    int numero = Integer.parseInt(br.readLine());
                    System.out.print("Ingrese el nombre del jugador: ");
                    String nombre = br.readLine();
                    System.out.print("Ingrese el pais del jugador: ");
                    String pais = br.readLine();
                    Estampa nuevaEstampa = new Estampa(numero, nombre, pais);
                    album.add(nuevaEstampa);
                    break;
                case 2:
                    System.out.println("Lista de estampas: ");
                    for (Estampa estampa : album) {
                        System.out.println("\t" + estampa);
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del Jugador a Buscar: ");
                    String nombreBusqueda = br.readLine();
                    Estampa estampa = null;
                    for (Estampa e : album) {
                        if (e.getNombre().equals(nombreBusqueda)) {
                            estampa = e;
                            break;
                        }
                    }
                    if (estampa == null) {
                        System.out.printf("No se encuentra la estampa con nombre: %s :(\n", nombreBusqueda);
                    } else {
                        System.out.println("Estampa encontrada: " + estampa);
                    }
                    break;
                case 4:
                    break ciclo;
                default:
                    System.out.println("Ingreso una opcion invalida");
                    break;
            }

        }
    }
}

class Estampa {
    private int numero;
    private String nombre;
    private String pais;

    public Estampa(int numero, String nombre, String pais) {
        this.numero = numero;
        this.nombre = new String(nombre);
        this.pais = new String(pais);
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public String toString() {
        return numero + " | " + nombre + " | " + pais;
    }
}