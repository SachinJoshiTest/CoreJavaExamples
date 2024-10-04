package advjavac2;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ChatClient2 {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    private JFrame frame;
    private JTextField textField;
    private JTextArea messageArea;
    private PrintWriter out;

    public ChatClient2(String clientName) {
        frame = new JFrame("Chat Client - " + clientName);
        textField = new JTextField(50);
        messageArea = new JTextArea(16, 50);
        messageArea.setEditable(false);

        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Message: "), BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);

        frame.getContentPane().add(new JScrollPane(messageArea), BorderLayout.CENTER);
        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                out.println(textField.getText());
                textField.setText("");
            }
        });

        new SwingWorker<Void, String>() {
            protected Void doInBackground() throws Exception {
                try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                    out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(clientName);

                    String message;
                    while ((message = in.readLine()) != null) {
                        publish(message);
                    }
                }
                return null;
            }

            protected void process(java.util.List<String> chunks) {
                for (String message : chunks) {
                    messageArea.append(message + "\n");
                }
            }
        }.execute();
    }

    public static void main(String[] args) {
        String clientName = JOptionPane.showInputDialog("Enter your name:");
        if (clientName != null && !clientName.trim().isEmpty()) {
            ChatClient2 client = new ChatClient2(clientName);
            client.frame.setVisible(true);
        }
    }
}

