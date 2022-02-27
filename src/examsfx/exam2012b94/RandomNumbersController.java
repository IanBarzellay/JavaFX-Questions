package examsfx.exam2012b94;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.Random;

public class RandomNumbersController {

    @FXML
    private Button btnA;

    @FXML
    private Button btnB;

    @FXML
    private Button btnC;

    @FXML
    private Button btnD;

    @FXML
    void btnOnClickA(ActionEvent event) {
        onClick(btnA);
    }

    @FXML
    void btnOnClickB(ActionEvent event) {
        onClick(btnB);
    }

    @FXML
    void btnOnClickC(ActionEvent event) {
        onClick(btnC);
    }

    @FXML
    void btnOnClickD(ActionEvent event) {
        onClick(btnD);
    }

    private void onClick(Button button){
        Task task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Random r = new Random();
                int jump = r.nextInt(101);
                for (int i = 0; i < jump; i++) {
                    int index = (Integer.parseInt(button.getText()) + 1) % 10;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            button.setText(index + "");
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };
        Thread t = new Thread(task);
        t.start();
    }
}

