package com.company;

import java.util.List;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

/**
 * Created by Shane on 31/07/16.
 */
public class App extends Application{

    private static int n = 64;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Drawing tiles");
        Group root = new Group();
        Canvas canvas = new Canvas(n*mul, n*mul);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Tiler t = new Tiler();
        Tiler.Coordinate c = t.createC(26,7);
        t.tile(n,0,n,0,n, c);
        drawMissing(c, gc);
        drawTiles(t.list, gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawTiles(List<Tiler.Pair> list, GraphicsContext gc) {

        for (Tiler.Pair p: list) {
                drawTrom(p.c, p.t, gc);
        }

    }

    int mul = 10;

    private void drawMissing(Tiler.Coordinate c ,GraphicsContext gc) {
        gc.fillRect((c.x*mul), (n*mul-c.y*mul)-mul, mul, mul);
    }

    private void drawTrom(Tiler.Coordinate c, Tiler.Trom t, GraphicsContext gc) {
        int nx = (c.x*mul);
        int ny = (n*mul - c.y*mul);
        int p1x;
        int p1y;
        int p2x;
        int p2y;
        int p3x;
        int p3y;
        int p4x;
        int p4y;
        int p5x;
        int p5y;
        switch (t) {
            case LL:
                p1x = nx;
                p1y = ny - mul;
                p2x = p1x - mul;
                p2y = p1y;
                p3x = p2x;
                p3y = p2y + (mul*2);
                p4x = p3x + (mul*2);
                p4y = p3y;
                p5x = p4x;
                p5y = p4y - mul;
                gc.strokeLine(nx, ny, p1x, p1y);
                gc.strokeLine(p1x, p1y, p2x, p2y);
                gc.strokeLine(p2x, p2y, p3x, p3y);
                gc.strokeLine(p3x, p3y, p4x, p4y);
                gc.strokeLine(p4x, p4y, p5x, p5y);
                gc.strokeLine(p5x, p5y, nx, ny);
                break;
            case LR:
                p1x = nx;
                p1y = ny - mul;
                p2x = p1x + mul;
                p2y = p1y;
                p3x = p2x;
                p3y = p2y + (mul*2);
                p4x = p3x - (mul*2);
                p4y = p3y;
                p5x = p4x;
                p5y = p4y - mul;
                gc.strokeLine(nx, ny, p1x, p1y);
                gc.strokeLine(p1x, p1y, p2x, p2y);
                gc.strokeLine(p2x, p2y, p3x, p3y);
                gc.strokeLine(p3x, p3y, p4x, p4y);
                gc.strokeLine(p4x, p4y, p5x, p5y);
                gc.strokeLine(p5x, p5y, nx, ny);
                break;
            case UL:
                p1x = nx;
                p1y = ny + mul;
                p2x = p1x - mul;
                p2y = p1y;
                p3x = p2x;
                p3y = p2y - (mul*2);
                p4x = p3x + (mul*2);
                p4y = p3y;
                p5x = p4x;
                p5y = p4y + mul;
                gc.strokeLine(nx, ny, p1x, p1y);
                gc.strokeLine(p1x, p1y, p2x, p2y);
                gc.strokeLine(p2x, p2y, p3x, p3y);
                gc.strokeLine(p3x, p3y, p4x, p4y);
                gc.strokeLine(p4x, p4y, p5x, p5y);
                gc.strokeLine(p5x, p5y, nx, ny);
                break;
            case UR:
                p1x = nx;
                p1y = ny + mul;
                p2x = p1x + mul;
                p2y = p1y;
                p3x = p2x;
                p3y = p2y - (mul*2);
                p4x = p3x - (mul*2);
                p4y = p3y;
                p5x = p4x;
                p5y = p4y + mul;
                gc.strokeLine(nx, ny, p1x, p1y);
                gc.strokeLine(p1x, p1y, p2x, p2y);
                gc.strokeLine(p2x, p2y, p3x, p3y);
                gc.strokeLine(p3x, p3y, p4x, p4y);
                gc.strokeLine(p4x, p4y, p5x, p5y);
                gc.strokeLine(p5x, p5y, nx, ny);
                break;
        }
    }
}
