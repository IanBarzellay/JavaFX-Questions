package examsfx.exam2021a78;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket = null;
    private ServerRectController controller;

    public ServerThread(Socket socket,ServerRectController controller) {
        this.socket = socket;
        this.controller = controller;
    }

    @Override
    public void run() {
        super.run();
        try {
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Rect rect = (Rect)objectInputStream.readObject();
            controller.drewRect(rect);

            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
