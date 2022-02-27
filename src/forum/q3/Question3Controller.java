package forum.q3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import javax.swing.*;

public class Question3Controller {
    private final int SIZE = 4;
    private Button[][] buttons;
    private int count = 0;
    private int toWin = 0;

    @FXML
    private GridPane grid;

    @FXML
    private void initialize(){
        buttons = new Button[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new Button("0");
                buttons[i][j].setPrefSize(grid.getPrefWidth()/SIZE, grid.getPrefHeight()/SIZE);
                buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        onClick(event);
                    }
                });
                grid.add(buttons[i][j],i,j);
            }
        }
    }

    @FXML
    void btnOnReset(ActionEvent event) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j].setText("0");
            }
        }
        count = 0;
        toWin = 0;
    }

    private void onClick(ActionEvent event){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(event.getSource() == buttons[i][j]){
                    if(!buttons[i][j].getText().equals("10")){
                        if(checkNeg(i,j)>1){
                            buttons[i][j].setText("10");
                            toWin++;
                        }else {
                            int index = Integer.parseInt(buttons[i][j].getText())+1;
                            buttons[i][j].setText(index + "");
                            if(index == 10){
                                toWin++;
                            }
                        }
                        count++;
                    }
                }
            }
        }
        if(toWin == 16){
            JOptionPane.showMessageDialog(null,"You win!!\nYour score: " + count);
        }
    }

    private int checkNeg(int x, int y){
        int index = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(Math.abs(i-x)== 1 && y==j){
                    if(buttons[i][j].getText().equals("10")){
                        index++;
                    }
                }
                if(Math.abs(j-y)==1 && x==i){
                    if(buttons[i][j].getText().equals("10")){
                        index++;
                    }
                }
            }
        }
        return index;
    }
}

