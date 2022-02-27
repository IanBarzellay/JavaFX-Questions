package examsfx.exam2016a82;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.util.ArrayList;

public class CaptchaTestController {
    private ArrayList<Captcha> list;
    private int size;
    private int q = 0;
    private int answer = 0;

    @FXML
    private ImageView imageView;

    @FXML
    private TextField textField;

    @FXML
    private void initialize(){
        list = new ArrayList<Captcha>();
        list.add(new Captcha(new Image("./examsfx/exam2016a82/photo/Capture.PNG", true), "smwm"));
        list.add(new Captcha(new Image("./examsfx/exam2016a82/photo/Capture1.PNG", true), "PRNU"));
        list.add(new Captcha(new Image("./examsfx/exam2016a82/photo/Capture2.PNG", true), "W68H"));
        size = list.size();
        imageView.setImage(list.get(q).getImage());

        textField.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER){
                if(list.get(q).getText().equals(textField.getText())){
                    answer++;
                    JOptionPane.showMessageDialog(null,"Good");
                }else {
                    JOptionPane.showMessageDialog(null,"Bad");
                }
                q++;
                textField.setText("");
            }
            if(q<size){
                imageView.setImage(list.get(q).getImage());
            }else {
                JOptionPane.showMessageDialog(null,"Test result: " + Math.round(answer*100/size) + "%");
                Platform.exit();
            }
        });
    }


    @FXML
    void btnStop(ActionEvent event) {
        Platform.exit();
    }
}

