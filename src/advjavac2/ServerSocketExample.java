package advjavac2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample {
    static PrintWriter out;
    static BufferedReader in;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(4444)) {
            System.out.println("Server is waiting for client connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);  // Enable auto-flush

            String clientMessage = in.readLine();
            System.out.println("Received from client: " + clientMessage);

            out.println("Hello, how are you?");
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
