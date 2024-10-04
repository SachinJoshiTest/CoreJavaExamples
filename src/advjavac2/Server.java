package advjavac2;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static final int PORT = 12345;
    private static Set<PrintWriter> clientWriters = new HashSet<>();
    private static Set<String> clientNames = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Chat server started...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Request and register client name
                out.println("SUBMITNAME");
                clientName = in.readLine();
                synchronized (clientNames) {
                    while (clientNames.contains(clientName)) {
                        out.println("NAMEALREADYEXISTS");
                        clientName = in.readLine();
                    }
                    clientNames.add(clientName);
                }

                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                // Broadcast welcome message
                broadcast("SERVER: " + clientName + " has joined the chat.");

                String message;
                while ((message = in.readLine()) != null) {
                    broadcast(clientName + ": " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }
                synchronized (clientNames) {
                    clientNames.remove(clientName);
                }
                broadcast("SERVER: " + clientName + " has left the chat.");
            }
        }

        private void broadcast(String message) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters) {
                    writer.println(message);
                }
            }
        }
    }
}
