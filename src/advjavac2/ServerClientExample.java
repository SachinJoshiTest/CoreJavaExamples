package advjavac2;

import java.io.*;
import java.net.Socket;

public class ServerClientExample {
    static BufferedReader in;
    static PrintWriter out;

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", 4444)) {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);  // Enable auto-flush

            out.println("Hello from Client");
            String serverMessage = in.readLine();
            System.out.println("Received from server: " + serverMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
