package with_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server(){
        ServerSocket server = null;
        Socket client = null;

        try {
            server = new ServerSocket(9999);
            while (true){
                client = server.accept();
                new ServerThread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
