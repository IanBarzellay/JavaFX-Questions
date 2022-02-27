package examsfx.exam2017a93;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CoinsValue extends Application {
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../CoinsValue.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Application");
        stage.setScene(scene);
        stage.setResizable(false); //save the size of the windows (can't change)
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println();
    }
}
