import java.io.*;
import java.net.*;

public class MyChatClient {

```
public static void main(String[] args) {
    try {
        Socket socket = new Socket("localhost", 9090);
        System.out.println("Connected to chat server!");

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        // Thread to receive messages from the server
        Thread readThread = new Thread(() -> {
            String msgFromServer;
            try {
                while ((msgFromServer = input.readLine()) != null) {
                    System.out.println(msgFromServer);
                }
            } catch (IOException e) {
                System.out.println("Disconnected from server.");
            }
        });

        readThread.start();

        // Main loop to send messages
        String message;
        while ((message = keyboard.readLine()) != null) {
            output.println(message);
        }

    } catch (IOException e) {
        System.out.println("Client Error: " + e.getMessage());
    }
}

}

