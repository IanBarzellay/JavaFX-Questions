package examsfx.exam2017a83;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;



public class BoardNumberGameController {
    private final int SIZE = 4;
    private Button[][] buttons;
    private int currentX = SIZE-1;
    private int currentY = SIZE-1;

    @FXML
    private GridPane gridPane;

    @FXML
    private void initialize(){
        buttons = new Button[SIZE][SIZE];
        int index = 15;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(index>0){
                    buttons[i][j] = new Button(index + "");
                    index--;
                }else {
                    buttons[i][j] = new Button("");
                }
                buttons[i][j].setPrefSize(gridPane.getPrefWidth()/SIZE, gridPane.getPrefHeight()/SIZE);
                buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        handleButton(event);
                    }
                });

                gridPane.add(buttons[i][j],j,i);
            }
        }

    }

    private void handleButton(ActionEvent event){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(event.getSource() == buttons[i][j] && (Math.abs(currentX-i) == 1 && Math.abs(currentY-j) == 0 || Math.abs(currentX-i) == 0 && Math.abs(currentY-j) == 1)){
                    buttons[currentX][currentY].setText(buttons[i][j].getText());
                    buttons[i][j].setText("");
                    currentY = j;
                    currentX = i;
                }
            }
        }
    }

}
