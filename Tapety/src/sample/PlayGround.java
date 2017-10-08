package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * Created by Jaro on 8.10.2017.
 */
class PlayGround extends Canvas {
    GraphicsContext gc = getGraphicsContext2D();

    public PlayGround(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);

        setFocusTraversable(true);

    }

    public void paint(int col, int row) {
        gc.setFill(Color.WHITE);
        gc.clearRect(0, 0, 400, 400);


        gc.setStroke(Color.BLACK);
        int size = 200/Math.max(col, row);
        for (int i = 0; i <= col; i++) {
            gc.strokeLine(i*size+200, 200, i*size+200, row * size+200);
        }
        for (int j = 0; j <= row; j++) {
            gc.strokeLine(200, j*size+200, col * size+200, j * size+200);
        }
    }
}
