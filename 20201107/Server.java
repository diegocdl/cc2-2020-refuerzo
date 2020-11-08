import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        int puerto = 1200;
        ServerSocket server = new ServerSocket(puerto);
        System.out.println("El servidor se a iniciado y esta ejecutandose en el puerto " + puerto);

        Socket client = server.accept();
        System.out.println("Cliente conectado");

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        boolean flag = true;
        while (flag) {
            // LOWER texto
            //      LOWER Hola => hola
            // UPPER texto
            //      UPPER Hola => HOLA
            // EXIT
            String comando = in.readLine();
            System.out.println("Cliente: " + comando);

            String cmd = "", txt = "";
            if (comando.indexOf(' ') != -1) {
                cmd = comando.substring(0, comando.indexOf(' '));
                txt = comando.substring(comando.indexOf(' ') + 1, comando.length());
            } else {
                cmd = comando;
            }
            String respuesta;
            switch (cmd) {
                case "LOWER":
                    respuesta = txt.toLowerCase();
                    System.out.println("Server: " + respuesta);
                    out.println(respuesta);
                    break;
                case "UPPER":
                    respuesta = txt.toUpperCase();
                    System.out.println("Server: " + respuesta);
                    out.println(respuesta);
                    break;
                case "EXIT":
                    out.close();
                    in.close();
                    server.close();
                    client.close();
                    flag = false;
                    break;
                default:
                    respuesta = "COMANDO INVALIDO";
                    System.out.println("Server: " + respuesta);
                    out.println(respuesta);
                    break;
            }
        }
    }
}