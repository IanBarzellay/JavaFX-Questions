package examsfx.exam2019b84;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread{
    private ClientNumToBinController controller;
    private String ip;

    public ClientThread(ClientNumToBinController controller, String ip) {
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
            Socket socket = new Socket(ip,4444);

            Data data = new Data();
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);



            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            data.setNum(controller.getNum());
            objectOutputStream.writeObject(data);

            data = (Data) objectInputStream.readObject();
            controller.addData(data);

            objectInputStream.close();
            inputStream.close();
            objectOutputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Input error","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
