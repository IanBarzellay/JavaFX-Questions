package forum.q2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Poster extends Application {
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../Poster.fxml"));
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

