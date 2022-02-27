package examsfx.exam2016a91;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import javax.swing.*;
import java.util.Random;

public class MathTeachController {
    private final int SIZE = 10;
    private Button[][] buttons = new Button[SIZE][SIZE];
    private Random r = new Random();
    private int divNum = 0;

    @FXML
    private GridPane gridPane;

    @FXML
    private Text text;

    @FXML
    private void initialize(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new Button((r.nextInt(100)+1) +"");
                buttons[i][j].setPrefSize(gridPane.getPrefWidth() / SIZE, gridPane.getPrefHeight() / SIZE);
                gridPane.add(buttons[i][j],i,j);
                buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        handleButtons(event);
                    }
                });
            }
        }
    }

    @FXML
    void btnOnNext(ActionEvent event) {
        divNum = r.nextInt(10) + 1;
        text.setText("click on all numbers witch can be divided by " + divNum);
    }

    private void handleButtons(ActionEvent event){
        Button btn = (Button)event.getSource();
        String txt = btn.getText();
        if(!txt.equals("")){
            if(Integer.parseInt(txt) % divNum == 0){
                btn.setText("");
            }else {
                JOptionPane.showMessageDialog(null,"Bad!");
            }
        }
    }
}