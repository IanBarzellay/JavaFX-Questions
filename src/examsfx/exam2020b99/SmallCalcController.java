package examsfx.exam2020b99;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.*;

public class SmallCalcController {
    private double num1, num2;

    @FXML
    private ComboBox<String> cbAction;

    @FXML
    private TextField tfEqu;

    @FXML
    private TextField tfNum1;

    @FXML
    private TextField tfNum2;

    @FXML
    private void initialize(){
        cbAction.getItems().addAll("+","-","*");
        cbAction.getSelectionModel().selectFirst();
    }

    @FXML
    void btnOnEqu(ActionEvent event) {
        try{
            num1 = Double.parseDouble(tfNum1.getText());
            num2 = Double.parseDouble(tfNum2.getText());
            calc();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Input error!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calc(){
        switch (cbAction.getValue()){
            case "+":
                tfEqu.setText("" + (num1 + num2));
                break;
            case "-":
                tfEqu.setText("" + (num1 - num2));
                break;
            case "*":
                tfEqu.setText("" + (num1 * num2));
                break;
        }
    }
}

