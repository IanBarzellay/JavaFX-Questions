package with_server;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//The best main class and the most interesting ever in the javaFX up to this point!!!
public class Client extends Application {
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../ClientController.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("ClientController");
        stage.setScene(scene);
        stage.setResizable(false); //save the size of the windows (can't change)
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println();
    }
}

