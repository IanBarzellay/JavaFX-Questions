package examsfx.exam2016a83;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class QuestionController {
    private int answer = 0;
    private int correct = 0;
    private int max = 0;
    private ArrayList<Question> questions;


    @FXML
    private ToggleGroup group1;

    @FXML
    private RadioButton radioFalse;

    @FXML
    private RadioButton radioTrue;

    @FXML
    private Text text;

    @FXML
    private void initialize(){
        LogicRepository logicRepository = new LogicRepository();
        try{
            max = Integer.parseInt(JOptionPane.showInputDialog("Enter number:"));
            questions = logicRepository.getQuestions(max);
            text.setText(questions.get(answer).getText());

            group1.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                @Override
                public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                    handle(questions.get(answer));
                }
            });
        }catch (Exception e){
            System.out.println("input error");
            Platform.exit();
        }
    }

    private void handle(Question q){
        RadioButton selectedRadioButton = (RadioButton) group1.getSelectedToggle();
        if(selectedRadioButton != null){
            String userData = selectedRadioButton.getText();

            if(userData.equals("true") && q.getAnswer() || userData.equals("false") && !q.getAnswer()){
                correct++;
                JOptionPane.showMessageDialog(null,"good");

            }else {
                JOptionPane.showMessageDialog(null,"bad");
            }
            answer++;
            if(answer==max){
                JOptionPane.showMessageDialog(null,"your score: " + Math.round(correct*100/max));
                Platform.exit();
            }else {
                text.setText(questions.get(answer).getText());
                selectedRadioButton.setSelected(false);
            }
            HashMap<String, String> h = new HashMap<>();
        }
    }
}
