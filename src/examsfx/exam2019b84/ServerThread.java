package examsfx.exam2019b84;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        try {
            OutputStream outputStream = null;
            outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Data data = (Data) objectInputStream.readObject();
            int num = data.getNum();
            String bin = Integer.toBinaryString(num);
            data.setBinResult(bin);
            objectOutputStream.writeObject(data);
            inputStream.close();
            objectOutputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}