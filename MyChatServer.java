import java.io.*;
import java.net.*;
import java.util.*;

public class MyChatServer {
    static List<UserHandler> users = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9090);
            System.out.println(">> Chat Server Running on Port 9090");

            while (true) {
                Socket client = server.accept();
                System.out.println(">> New User Connected");

                UserHandler userThread = new UserHandler(client);
                users.add(userThread);
                userThread.start();
            }
        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }

    static void broadcast(String message, UserHandler sender) {
        for (UserHandler user : users) {
            if (user != sender) {
                user.send(message);
            }
        }
    }

    static void removeUser(UserHandler user) {
        users.remove(user);
    }
}

class UserHandler extends Thread {
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    private String name;

    public UserHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println("Enter your name: ");
            name = reader.readLine();
            MyChatServer.broadcast(">> " + name + " joined the chat", this);

            String msg;
            while ((msg = reader.readLine()) != null) {
                MyChatServer.broadcast(name + ": " + msg, this);
            }
        } catch (IOException e) {
            System.out.println(name + " left the chat.");
        } finally {
            MyChatServer.removeUser(this);
            try {
                socket.close();
            } catch (IOException e) {}
        }
    }

    public void send(String message) {
        writer.println(message);
    }
}
