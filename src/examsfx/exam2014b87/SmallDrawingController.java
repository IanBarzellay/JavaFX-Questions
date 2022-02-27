package examsfx.exam2014b87;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class SmallDrawingController {
    private final int SIZE = 10;
    private GraphicsContext gc;
    private Rectangle[][] rect;
    private Color[][] colors;
    private double boxSize;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        rect = new Rectangle[SIZE][SIZE];
        colors = new Color[SIZE][SIZE];
        colorPicker = new ColorPicker();
        gc = canvas.getGraphicsContext2D();
        boxSize = canvas.getHeight()/SIZE;
        resetColors();
    }

    @FXML
    void btnOnClear(ActionEvent event) {
        resetColors();
    }

    @FXML
    void btnColorPicker(ActionEvent event) {
        colorPicker.setValue(((ColorPicker) event.getSource()).getValue());
    }


    @FXML
    void onBoxClick(MouseEvent event) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(rect[i][j].contains(new Point2D(event.getX(),event.getY()))){
                    colors[i][j] = colorPicker.getValue();
                    drawBoard();
                }
            }
        }
    }

    private void drawBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                gc.setFill(colors[i][j]);
                rect[i][j] = new Rectangle(j * boxSize, i * boxSize, boxSize, boxSize);
                gc.fillRect(rect[i][j].getX(), rect[i][j].getY(), rect[i][j].getHeight(), rect[i][j].getWidth());
            }
        }
    }

    private void resetColors(){
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        colorPicker.setValue(Color.LIGHTGRAY);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = colorPicker.getValue();
            }
        }
        drawBoard();
    }

}

