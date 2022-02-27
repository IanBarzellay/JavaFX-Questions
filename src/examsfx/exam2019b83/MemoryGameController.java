package examsfx.exam2019b83;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.util.Random;

public class MemoryGameController {
    private final int SIZE = 10;
    private Button[][] buttons;
    private int count = 0;
    private Random r = new Random();
    private int[][] values;
    private boolean[] show = new boolean[20];

    @FXML
    private GridPane gridPane;

    @FXML
    private void initialize(){
        buttons = new Button[SIZE][SIZE];
        values = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                values[i][j] = r.nextInt(20)+1;
                buttons[i][j] = new Button("");
                buttons[i][j].setPrefSize(gridPane.getPrefHeight()/SIZE,gridPane.getPrefWidth()/SIZE);
                buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        handleButton(event);
                    }
                });
                gridPane.add(buttons[i][j],i,j);
            }
        }
    }

    private void handleButton(ActionEvent event){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(event.getSource() == buttons[i][j]){
                    Button button = (Button) event.getSource();
                    if(button.getText().equals("")){
                        count++;
                        int val = values[i][j];
                        button.setText(val+"");
                        button.setDisable(true);
                        if(show[val-1]){
                            JOptionPane.showMessageDialog(null,"Game over. count: " + count);
                            restart();
                        }else {
                            show[val-1] = true;
                        }
                    }
                }
            }
        }
    }

    private void restart(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(!buttons[i][j].equals("")){
                    buttons[i][j].setText("");
                    buttons[i][j].setDisable(false);
                    values[i][j] = r.nextInt(20)+1;
                }
            }
        }
        show = new boolean[20];
        count=0;
    }

}

