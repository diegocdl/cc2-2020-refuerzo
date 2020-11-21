import java.io.*;
import db.*;

public class AddressBook {
    public static void main(String[] args) throws Exception {
        DB contactosDb = new DB("contactos.db");
        if(!contactosDb.connect()) {//create actual connection to db
			System.out.println("Error en db " + contactosDb.getError());
			System.exit(0);
		}

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while(flag) {
            System.out.println("--------------------------------");
            System.out.println("1. Agregar Contacto");
            System.out.println("2. Consultar Contactos");
            System.out.println("3. Buscar Contactos");
            System.out.println("4. Eliminar Contactos");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            String opcion = br.readLine();
            String query;
            switch(opcion) {
                case "1":
                    query = "INSERT INTO contacto (nombre, telefonos, favorito) VALUES ('%s', '%s', '%d');";
                    System.out.print("Ingrese nombre: ");
                    String nombre = br.readLine();
                    System.out.print("Ingrese telefonos: ");
                    String telefonos = br.readLine();
                    System.out.print("Es contacto favorito? (si/no): ");
                    int favorito = br.readLine().equals("si") ? 1 : 0;
                    query = String.format(query, nombre, telefonos, favorito);
                    if (contactosDb.executeNonQuery(query)) {
                        System.out.println("Contacto guardado existosamente.");
                    } else {
                        System.out.println("Ocurrio un error al guardar el contacto");
                    }
                    break;
                case "2":
                    query = "SELECT nombre, telefonos, favorito FROM contacto;";
                    if (contactosDb.executeQuery(query, "rs1")) {
                        while(contactosDb.next("rs1")) {
                            System.out.print(contactosDb.getString("nombre", "rs1"));
                            System.out.print(contactosDb.getString("favorito", "rs1").equals("1")? "*\t" : "\t");
                            System.out.print(contactosDb.getString("telefonos", "rs1") + "\t");
                            System.out.println();
                        }
                    } else {
                        System.out.println("Ocurrio un error al obtener los datos");
                    }
                    break;
                case "3":
                    query = "SELECT nombre, telefonos, favorito FROM contacto WHERE nombre LIKE '%%%s%%';";
                    System.out.print("Ingrese nombre a buscar:");
                    String nombreBusqueda = br.readLine();
                    query = String.format(query, nombreBusqueda);
                    if (contactosDb.executeQuery(query, "rs1")) {
                        while(contactosDb.next("rs1")) {
                            System.out.print(contactosDb.getString("nombre", "rs1"));
                            System.out.print(contactosDb.getString("favorito", "rs1").equals("1")? "*\t" : "\t");
                            System.out.print(contactosDb.getString("telefonos", "rs1") + "\t");
                            System.out.println();
                        }
                    } else {
                        System.out.println("Ocurrio un error al obtener los datos");
                    }
                    break;
                case "4":
                    System.out.print("Ingrese un nombre para eliminar: ");
                    String nombreRemover = br.readLine();
                    query = "SELECT COUNT(*) as cant FROM contacto WHERE nombre = '%s'; COMMIT;";
                    query = String.format(query, nombreRemover);
                    if (contactosDb.executeQuery(query, "rs1")) {
                        contactosDb.next("rs1");
                        String cantidad = contactosDb.getString("cant", "rs1");
                        if(cantidad.equals("1")) {
                            query = "DELETE FROM contacto WHERE nombre = '%s'";
                            query = String.format(query, nombreRemover);
                            if (contactosDb.executeNonQuery(query)) {
                                System.out.println("Se borro el contacto exitosamente");
                            } else {
                                System.out.println("Ocurrio un error al eliminar al contacto");
                            }
                        } else {
                            System.out.println("El usuario con el nombre ingresado no existe y no puede ser borrado");
                        }
                    }
                    break;
                case "5":
                    flag = false;
                    contactosDb.close();
                    break;
                default:
                    System.out.println("Opcion ingresada invalida :(");
            }
        }
    }
}