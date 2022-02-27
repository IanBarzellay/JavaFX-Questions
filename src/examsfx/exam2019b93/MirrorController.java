package examsfx.exam2019b93;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class MirrorController {
    private GraphicsContext gc1;
    private GraphicsContext gc2;
    private double xPos;
    private double yPos;

    @FXML
    private Canvas canv1;

    @FXML
    private Canvas canv2;

    @FXML
    private void initialize(){
        gc1 = canv1.getGraphicsContext2D();
        gc2 = canv2.getGraphicsContext2D();
    }

    @FXML
    void onMouseClick1(MouseEvent event) {
        onClick(event);
    }

    @FXML
    void onMouseClick2(MouseEvent event) {
        onClick(event);
    }

    @FXML
    void onMouseRelease1(MouseEvent event) {
        onRelease(event);
    }

    @FXML
    void onMouseRelease2(MouseEvent event) {
        onRelease(event);
    }

    private void onClick(MouseEvent event){
        xPos = event.getX();
        yPos = event.getY();
    }

    private void onRelease(MouseEvent event){
        gc1.strokeLine(xPos,yPos,event.getX(),event.getY());
        gc2.strokeLine(xPos,yPos,event.getX(),event.getY());
    }

}
