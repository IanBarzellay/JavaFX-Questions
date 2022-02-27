package with_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientThread extends Thread{
    private ClientController controller;
    private String ip;

    public ClientThread(ClientController controller, String ip) {
        this.controller = controller;
        this.ip = ip;
    }

    @Override
    public void run() {
        super.run();
        handle();
    }

    public void handle(){
        try {
            Socket socket = new Socket(ip,9999);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            outputStream.write(4);

            Polygon p = (Polygon) objectInputStream.readObject();
            controller.addPolygon(p);

            outputStream.close();
            inputStream.close();
            objectInputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
