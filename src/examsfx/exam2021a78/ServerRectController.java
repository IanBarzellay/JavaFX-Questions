package examsfx.exam2021a78;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.LinkedList;

public class ServerRectController {

    private LinkedList<Rect> rects;
    private GraphicsContext gc;


    @FXML
    private Canvas canvas;

    @FXML
    private void initialize(){
        rects = new LinkedList<Rect>();
        gc = canvas.getGraphicsContext2D();
        new Server(this);

    }

    @FXML
    void btnOnClear(ActionEvent event) {
        rects.clear();
        gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
    }

    public void drewRect(Rect r){
        rects.push(r);
        gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        for(Rect rect : rects){
            gc.strokeRect(rect.getX1(),rect.getY1(),rect.getX2()- rect.getX1(),rect.getY2()- rect.getY1());
        }
    }
}
