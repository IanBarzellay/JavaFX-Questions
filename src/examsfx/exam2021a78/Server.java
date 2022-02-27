package examsfx.exam2021a78;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    private ServerRectController controller;
    public Server(ServerRectController controller) {
        this.controller = controller;
        start();
    }

    @Override
    public void run() {
        super.run();
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(8888);
            while (true){
                client = server.accept();
                new ServerThread(client,controller).start();
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
}
