package examsfx.exam2018b82;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

import java.util.LinkedList;

public class DrawRectController {
    private int SIZE = 10;
    private GraphicsContext gc;
    private LinkedList<Rectangle> rects;

    @FXML
    private Canvas canv;

    @FXML
    private void initialize() {
        gc = canv.getGraphicsContext2D();
        rects = new LinkedList<Rectangle>();
    }

    @FXML
    void btnClear(ActionEvent event) {
        gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
        rects.clear();
    }

    @FXML
    void onPressed(MouseEvent event) {
        LinkedList<Rectangle> temp = new LinkedList<Rectangle>();
//        double x = event.getX();
//        double y = event.getY();

        for (Rectangle rect : rects) {
            if (!rect.contains(new Point2D(event.getX(), event.getY()))){
//            if (!rect.contains(new Point2D(x, y))
//                    && !rect.contains(new Point2D(x + SIZE, y + SIZE))
//                    && !rect.contains(new Point2D(x + SIZE, y))
//                    && !rect.contains(new Point2D(x, y + SIZE))) {
                temp.add(rect);
            }
        }
        if (temp.size() == rects.size()) {
            rects.add(new Rectangle(event.getX(), event.getY(), SIZE, SIZE));
        } else {
            rects = temp;
        }

        draw();
    }

    private void draw() {
        gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
        for (Rectangle rect : rects) {
            gc.fillRect(rect.getX(), rect.getY(), SIZE, SIZE);
        }
    }
}

