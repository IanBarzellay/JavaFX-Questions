package examsfx.exam2019b84;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClientNumToBinController {

    @FXML
    private TextArea textArea;

    @FXML
    private TextField textField;

    @FXML
    private void initialize(){

    }

    @FXML
    void btnOnGo(ActionEvent event) {
        new ClientThread(this, "127.0.0.1").start();
    }

    public void addData(Data data){
        textArea.setText(textArea.getText() +"\nNumber: " +data.getNum()+ "    Binary: " + data.getBinResult());
    }

    public int getNum() throws Exception{
        return Integer.parseInt(textField.getText());
    }

}

