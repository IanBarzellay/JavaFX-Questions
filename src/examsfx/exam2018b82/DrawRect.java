package examsfx.exam2018b82;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawRect extends Application {
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../DrawRect.fxml"));
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

