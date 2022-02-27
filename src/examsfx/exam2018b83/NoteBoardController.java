package examsfx.exam2018b83;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import javax.swing.*;
import java.util.LinkedList;

public class NoteBoardController {

    private GraphicsContext gc;
    private final int AREA = 10;
    private LinkedList<Text> list;
    private double canvH;
    private double canvW;

    @FXML
    private Canvas canvas;

    @FXML
    private void initialize(){
        gc = canvas.getGraphicsContext2D();
        list = new LinkedList<Text>();
        canvH = canvas.getHeight();
        canvW = canvas.getWidth();
    }

    @FXML
    void onPressed(MouseEvent event) {
        LinkedList<Text> temp = new LinkedList<Text>();
        for(Text text : list){
            if(!(Math.abs(text.getX()-event.getX()) <=AREA && Math.abs(text.getY()-event.getY()) <=AREA)){
                temp.add(text);
            }
        }
        if(temp.size() == list.size()){
            String input = JOptionPane.showInputDialog("set new note");
            list.add(new Text(event.getX(),event.getY(),input));
        }else {
            list = temp;
        }
        gc.clearRect(0,0,canvW,canvH);
        for(Text text : list){
            gc.fillText(text.getText(),text.getX(),text.getY());
        }

    }
}

