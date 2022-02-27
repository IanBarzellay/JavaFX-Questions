package examsfx.exam2017a86;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class InputDrawController {
    private boolean firstDraw = true;
    private int currentX;
    private int currentY;
    private GraphicsContext gc;

    @FXML
    private Canvas canvas;

    @FXML
    private TextField textFieldX;

    @FXML
    private TextField textFieldY;

    @FXML
    private void initialize(){
        gc = canvas.getGraphicsContext2D();
    }

    @FXML
    void btnOnAdd(ActionEvent event) {
        if(!textFieldX.getText().equals("") && !textFieldY.getText().equals("")){
            try {
                if(firstDraw){
                    currentX = Integer.parseInt(textFieldX.getText());
                    currentY = Integer.parseInt(textFieldY.getText());
                    firstDraw = false;
                }else {
                    gc.strokeLine(currentX,currentY,Integer.parseInt(textFieldX.getText()),Integer.parseInt(textFieldY.getText()));
                    currentX = Integer.parseInt(textFieldX.getText());
                    currentY = Integer.parseInt(textFieldY.getText());
                }
            }catch (Exception e){
                System.out.println("Input exception");
            }finally {
                textFieldX.setText("");
                textFieldY.setText("");
            }
        }

    }

    @FXML
    void btnOnClear(ActionEvent event) {
        gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        firstDraw = true;
        textFieldX.setText("");
        textFieldY.setText("");
    }

}

