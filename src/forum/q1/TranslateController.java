package forum.q1;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;

public class TranslateController {
    private Dictionary dictionary;

    @FXML
    private ToggleGroup tGroup;

    @FXML
    private TextField tfResult;

    @FXML
    private TextField tfWord;

    @FXML
    private void initialize(){
        dictionary = new Dictionary();


        tfWord.setOnKeyPressed(keyEvent ->{
            if(keyEvent.getCode() == KeyCode.ENTER){
                RadioButton selectedRadioButton = (RadioButton) tGroup.getSelectedToggle();
                if(selectedRadioButton.getText().equals("EnglishToHebrew")){
                    try {
                        tfResult.setText(dictionary.englishToHebrew(tfWord.getText()));
                    } catch (Exception e) {
                        tfResult.setText("word not found.");
                    }
                }else {
                    try {
                        tfResult.setText(dictionary.hebrewToEnglish(tfWord.getText()));
                    } catch (Exception e) {
                        tfResult.setText("word not found.");
                    }
                }
            }
        });
    }
}
