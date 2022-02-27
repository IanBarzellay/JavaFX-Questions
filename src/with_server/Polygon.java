package with_server;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;
import java.io.Serializable;
import java.util.Random;

public class Polygon implements Serializable {
    private Point[] points;

    public Polygon(int n) {
        points = new Point[n];
        createPolygon();
    }

    public void draw (GraphicsContext context){
        double[] x = new double[points.length];
        double[] y = new double[points.length];
        for (int i = 0; i < points.length; i++) {
            x[i] = points[i].x;
            y[i] = points[i].y;
        }
        context.fillPolygon(x,y,points.length);
    }

    private void createPolygon(){
        Random r = new Random();
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(r.nextInt(400), r.nextInt(400));
        }
    }
}
