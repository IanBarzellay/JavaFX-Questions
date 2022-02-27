package examsfx.exam2017a93;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

public class CoinsValueController {
    private String[] currency;
    private Converter converter;

    @FXML
    private ComboBox<String> cbCoin1;

    @FXML
    private ComboBox<String> cbCoin2;

    @FXML
    private TextField tfValue;

    @FXML
    private Text txtResult;

    @FXML
    private void initialize(){
        converter = new Converter();
        currency = converter.getCurrency();
        for (int i = 0; i < currency.length; i++) {
            cbCoin1.getItems().add(currency[i]);
            cbCoin2.getItems().add(currency[i]);
        }

        tfValue.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER){
                try {
                    txtResult.setText(""+converter.convert(cbCoin1.getValue(),cbCoin2.getValue(),Double.parseDouble(tfValue.getText())));
                }catch (Exception e){
                    txtResult.setText("input error");
                }
            }
        });
    }

    @FXML
    void btnOnClick(ActionEvent event) {
        handleButton();
    }


    private void handleButton() {
        try {
            txtResult.setText(""+converter.convert(cbCoin1.getValue(),cbCoin2.getValue(),Double.parseDouble(tfValue.getText())));
        }catch (Exception e){
            txtResult.setText("input error");
        }

    }

}

