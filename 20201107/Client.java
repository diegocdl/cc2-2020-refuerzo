import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket server = new Socket("localhost", 1200);

        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter out = new PrintWriter(server.getOutputStream(), true);

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Ingrese comando: ");
            String cmd = teclado.readLine();

            out.println(cmd);
            System.out.println(in.readLine());
            if(cmd.equals("EXIT")) {
                in.close();
                out.close();
                server.close();
                break;
            }
        }
    }
}