package with_server;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class ClientController {
    private GraphicsContext context;

    @FXML
    private Canvas canv;

    @FXML
    public void initialize(){
        context = canv.getGraphicsContext2D();
    }

    @FXML
    void btnOnClick(ActionEvent event) {
        new ClientThread(this, "127.0.0.1").start();
    }

    public void addPolygon(Polygon p){
        p.draw(context);
    }

}
