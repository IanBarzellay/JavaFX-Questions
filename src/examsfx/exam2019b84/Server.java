package examsfx.exam2019b84;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server(){
        ServerSocket server = null;
        Socket client = null;

        try {
            server = new ServerSocket(4444);
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
