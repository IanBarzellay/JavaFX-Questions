package examsfx.exam2017b85;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class InstinctGameController extends Thread{
    private final int SIZE = 10;
    private final int RECT_NUM = 10;
    private final int TIME = 1000;
    private GraphicsContext gc;
    private ArrayList<Rectangle> list;
    private double boardSize;
    private Rectangle onBoard;
    private int hit = 0;
    private int miss = 0;
    private boolean canHit = true;

    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        Random r = new Random();
        list = new ArrayList<Rectangle>();
        gc = canvas.getGraphicsContext2D();
        boardSize = canvas.getHeight();
        for (int i = 0; i < RECT_NUM; i++) {
            list.add(new Rectangle(r.nextDouble()*boardSize,r.nextDouble()*boardSize,SIZE,SIZE));
        }
        start();
    }

    @FXML
    void onMousePressed(MouseEvent event) {
        if(canHit){
            if(onBoard != null && onBoard.contains(event.getX(),event.getY())){
                hit++;
            }else {
                miss++;
            }
            gc.clearRect(0,0,boardSize,boardSize);
            canHit=false;
        }
    }

    @Override
    public void run() {
        for(Rectangle rec : list){
            canHit = true;
            onBoard = rec;
            gc.fillRect(rec.getX(),rec.getY(),rec.getHeight(),rec.getWidth());
            try {
                sleep(TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if(canHit){
                    gc.clearRect(0,0,boardSize,boardSize);
                    miss++;
                }
            }
        }
        JOptionPane.showMessageDialog(null,"Hit: " + hit + "\nMiss: " + miss);
        Platform.exit();
    }
}

