package examsfx.exam2021a78;

import examsfx.exam2019b84.Data;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        handle(new Rect(10,10,100,100));
        handle(new Rect(110,110,130,200));
        handle(new Rect(0,0,300,120));
    }

    public static void handle(Rect rect){
        try {
            Socket socket = new Socket("127.0.0.1",8888);

            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(rect);

            objectOutputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Input error","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
