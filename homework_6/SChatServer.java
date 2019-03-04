package homework_6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SChatServer {

    public static void run() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            // listen port 8189
            serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения...");

            // main thread waiting for connections
            // new client will be assigned to sock variable
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            Scanner console = new Scanner(System.in);

            SChatClient.stream(pw, in, console);

        } catch (IOException e) {
            System.out.println("[error] server init failed");
        } finally {
            try {
                serverSocket.close();
                System.out.println("server stopped");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SChatServer.run();
    }
}