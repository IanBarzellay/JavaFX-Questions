package examsfx.exam2018a87;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Random;

public class BoxSizeGameController {
    private LinkedList<Rectangle> rects1, rects2;
    private GraphicsContext gc1,gc2;
    private final int NUM = 10;
    private int clicks = 0;
    private double height;
    private double width;

    @FXML
    private Canvas canvBottom;

    @FXML
    private Canvas canvTop;

    @FXML
    private void initialize() {
        gc1 = canvTop.getGraphicsContext2D();
        gc2 = canvBottom.getGraphicsContext2D();
        rects1 = new LinkedList<Rectangle>();
        rects2 = new LinkedList<Rectangle>();

        height = canvTop.getHeight();
        width = canvTop.getWidth();
        Random r = new Random();

        for (int i = 0; i < NUM; i++) {
            int size = r.nextInt(91)+10;
            rects1.add(new Rectangle(r.nextDouble()*width,r.nextDouble()*height,size,size));
        }
        fillReacts();


    }

    @FXML
    void onPressed(MouseEvent event) {
        clicks++;
        Rectangle min = getSmallest();
        if(min.contains(new Point2D(event.getX(), event.getY()))){
            int size = (int)min.getWidth();
            removeSmallest();
            rects2.add(new Rectangle(0,0,size,size));
        }else {
            JOptionPane.showMessageDialog(null,"bad pick");
        }

        if(rects1.isEmpty()){
                JOptionPane.showMessageDialog(null,"game over. \nclicks: " + clicks);
                Platform.exit();

        }else {
            fillReacts();
        }
    }

    private void fillReacts(){
        gc1.clearRect(0,0,width,height);
        gc2.clearRect(0,0,width,height);

        for(Rectangle rec : rects1){
            gc1.strokeRect(rec.getX(),rec.getY(),rec.getWidth(),rec.getHeight());
        }

        for(Rectangle rec : rects2){
            gc2.strokeRect(rec.getX(),rec.getY(),rec.getWidth(),rec.getHeight());
        }
    }

    private void removeSmallest(){
        rects1.remove(getSmallest());
    }

    private Rectangle getSmallest(){
        if(rects1.size()==0){
            return null;
        }
        Rectangle smallest = rects1.get(0);
        for(Rectangle rec : rects1){
           if(rec.getWidth()<smallest.getWidth()){
               smallest = rec;
           }
        }
        return smallest;
    }

}

