package forum.q2;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

public class PosterController extends Thread{
    final int SIZE = 380;

    @FXML
    private ImageView imageView;

    @FXML
    private TextField tfImage;

    @FXML
    private TextField tfTitle;

    @FXML
    private Text txtTitle;

    @FXML
    private void initialize(){
        start();
        tfImage.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER){
                imageView.setImage(new Image("./forum/q2/photo/"+tfImage.getText()+".PNG"));
                tfImage.setText("");
            }
        });

        tfTitle.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER){
                txtTitle.setText(tfTitle.getText());
                tfTitle.setText("");
            }
        });

    }

    @Override
    public void run() {
        super.run();
        while (true){
            if(txtTitle.getTranslateX() < SIZE){
                txtTitle.setTranslateX(txtTitle.getTranslateX()+10);
            }else {
                txtTitle.setTranslateX(-txtTitle.getLayoutBounds().getWidth());
            }

            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

