package homework_7.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ilnaz-92@yandex.ru
 * Created on 2019-03-04
 */
public class Server
{
  private List<ClientHandler> clientHandlers = new ArrayList<>();

  public Server()
  {
    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    try
    {
      serverSocket = new ServerSocket(8888);
      System.out.println("Server launched");

      while (true)
      {
        clientSocket = serverSocket.accept();
        ClientHandler client = new ClientHandler(clientSocket, this);
        clientHandlers.add(client);
        new Thread(client).start();
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        serverSocket.close();
        clientSocket.close();
        System.out.println("Server finished");
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }

  public void notificationAllClientWithNewMessage(String msg)
  {
    for (ClientHandler clientHandler : clientHandlers)
    {
      clientHandler.sendMessage(msg);
    }
  }

  // Метод для отправки личных сообщений
  public void privateNotificationClientMsg(ClientHandler from, String to, String msg) {
    for (ClientHandler client : clientHandlers) {
      if (client.getClientName().equalsIgnoreCase(to)) {
        client.sendMessage("[W from: " + from.getClientName() + "] " + msg);
        break;
      }
    }
    from.sendMessage("[W to: " + to + "] " + msg);
  }

  public void removeClient(ClientHandler clientHandler)
  {
    clientHandlers.remove(clientHandler);
  }
}
