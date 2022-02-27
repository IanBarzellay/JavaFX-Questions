package examsfx.exam2021b78;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import javax.swing.*;
import java.util.Random;

public class CardGameController {
    private int trys = 0;
    private Random r = new Random();
    private int card1, card2, card3;

    @FXML
    private Text txtCard1;

    @FXML
    private Text txtCard2;

    @FXML
    private Text txtCard3;

    @FXML
    private void initialize(){
        shuffleCards();
    }

    @FXML
    void btnOnChange(ActionEvent event) {
        shuffleCards();
        trys++;
        if(trys == 2){
            endRound();
        }
    }

    @FXML
    void btnOnStop(ActionEvent event) {
        endRound();
    }

    private void shuffleCards(){
        card1 = r.nextInt(100)+1;
        card2 = r.nextInt(100)+1;
        card3 = r.nextInt(100)+1;
        txtCard1.setText(card1+"");
        txtCard2.setText(card2+"");
        txtCard3.setText(card3+"");
    }

    private void endRound(){
        int score = card1+card2+card3;
        JOptionPane.showMessageDialog(null,"Game over!\nyour score: " + score);
        trys = 0;
        shuffleCards();
    }

}
