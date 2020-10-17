import java.io.*;
import java.util.*;

public class Banrural {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long correlativoCuentas = 1000;
        HashMap<Long, CuentaBancaria> cuentas = new HashMap<Long, CuentaBancaria>();
        
        salir:
        while (true) {
            System.out.println("-------------------------");
            System.out.println("1. Aperturar cuenta");
            System.out.println("2. Realizar deposito");
            System.out.println("3. Realizar retiro");
            System.out.println("4. Listar Cuentas");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opcion: ");
            String opcion = br.readLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre: ");
                    String nombre = br.readLine();
                    System.out.print("DPI: ");
                    String dpi = br.readLine();
                    CuentaBancaria cb = new CuentaBancaria(correlativoCuentas++, nombre, dpi);
                    cuentas.put(cb.getNumero(), cb);
                    break;
                case "2":
                    System.out.print("No. cuenta: ");
                    long l = Long.parseLong(br.readLine());
                    if (!cuentas.containsKey(l)) System.out.println("No. cuenta no existe");
                    else{
                        System.out.print("Monto: ");
                        double d = Double.parseDouble(br.readLine());
                        CuentaBancaria c = cuentas.get(l);
                        try{
                            c.depositar(d);
                        }
                        catch (OperacionInvalidaException e) {
                            System.out.println(e.getMessage());
                        } 
                    }
                    break;
                case "3":
                    System.out.print("No. cuenta: ");
                    long l2 = Long.parseLong(br.readLine());
                    if (!cuentas.containsKey(l2)) {
                        System.out.println("No. cuenta no existe");
                    } else {
                        System.out.print("Monto: ");
                        double d2 = Double.parseDouble(br.readLine());
                        CuentaBancaria c2 = cuentas.get(l2);
                        try{
                            c2.retirar(d2);
                        }
                        catch (OperacionInvalidaException e) {
                            System.out.println(e.getMessage());
                        } 
                    }
                    break;
                case "4":
                    if(!cuentas.isEmpty()){
                        for(CuentaBancaria c: cuentas.values()){
                        System.out.println("Información de cuenta: "+c.toString());
                        }
                    }else{
                        System.out.println("\n\t-No existen cuentas -");
                    }
                    break;
                case "5":
                    break salir;
                default:
                    System.out.println("Error! Opcion ingresada invalida");
                    break;
            }
        }
    }
}

class CuentaBancaria {
    protected long numero;
    protected String nombre;
    protected String dpi;
    protected double saldo;

    public CuentaBancaria(long numero, String nombre, String dpi) {
        this.numero = numero;
        this.nombre = nombre;
        this.dpi = dpi;
        this.saldo = 0.0;
    }

    public long getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDpi() {
        return dpi;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) throws OperacionInvalidaException {
        if (monto < 0) throw new OperacionInvalidaException("El monto no puede ser negativo en el deposito");
        else saldo += monto;
    }

    public void retirar(double monto) throws OperacionInvalidaException {
        if (monto < 0) 
            throw new OperacionInvalidaException("El monto no puede ser negativo en el retiro");
        else if (monto > saldo) 
            throw new OperacionInvalidaException("El monto a retirar supera al saldo");
        else 
            saldo -= monto;
    }

    @Override
    public String toString() {
        return String.format("%d\t%s\t%s\tQ%f", numero, nombre, dpi, saldo);
    }
}

class OperacionInvalidaException extends Exception {
    public OperacionInvalidaException(String msg) {
        super(msg);
    }
}