package com.company;

import com.company.fxcomponent.Hexagon;
import com.company.model.MapManager;
import com.company.model.TileManager;
import com.company.model.TileType;
import com.company.system.Triplet;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.geometry.BoundingBox;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.company.model.TileType.*;
import static java.lang.StrictMath.random;
import static java.lang.StrictMath.sqrt;

public class Goblin extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initTile();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));

            Scene scene = new Scene(root, 640, 400);
            ScrollPane scrollPane = (ScrollPane) scene.lookup("#scrollPane");

            List<Hexagon> hexagons = new ArrayList<>();

            float height = (float) sqrt(3) * 40;
            float distHorizontal = 40 * 1.5f;

            Pair<Integer, Integer> size = MapManager.getMapSize();

            for (int col = 0; col < size.getValue(); col++) {
                for (int row = 0; row < size.getKey(); row++) {
                    int x = col - 16;
                    int z = row - (col - (col & 1)) / 2;

                    Hexagon hexagon = new Hexagon(
                            new Point2D.Double(
                                    40 + distHorizontal * col,
                                    height/2 + height * (row + ((col % 2 == 0) ? 0 : 0.5f))),
                            new Triplet(x, -x - z, z),
                            Hexagon.FLAT);
                    BufferedImage tile = TileManager.getInstance().getTile(MapManager.get(row, col));
                    if (tile != null)
                        hexagon.setTheme(tile);
                    else hexagon.setTheme(4);
                    hexagons.add(hexagon);
                }
            }

            Pane pane = new Pane(hexagons.toArray(new Hexagon[0]));

            scrollPane.setContent(pane);
            scrollPane.addEventFilter(ScrollEvent.SCROLL, Event::consume);

            new Thread(() -> {
                while (true) {
                    hexagons.forEach(h -> h.setTheme((int) (random() * 5)));
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            TileManager.getInstance();

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize the TileManager with the tiles
     */
    private void initTile() {
        TileType[] list = new TileType[]{
                CA, FOREST, CC, CD, CE, CF, CG, CH, CI, CJ, CK, CL, LAKE, CN, CO, CP, CQ, CR, CS, MOUNTAIN, CU, HILL, CW, CX, FIELD, CZ,
                AA, AB, AC, AD, ABBEY, AF, AG, AH, AI, AJ, KEEP, AL, AM, AN, AO, AP, AQ, HAMLET, AS, AT, AU, AV, AW, AX, AY, AZ,
                BA, BB, CITY, VILLAGE, BE, BF, BG, BH, BI, BJ, BK, BL, BM, BN, BO, BP, BQ, BR, BS, BT, BU, BV, BW, BX, BY, BZ
        };

        ArrayList<TileType> names = new ArrayList<>(Arrays.asList(list));
        File map = null;
        try {
            map = new File((
                    getClass()
                            .getClassLoader()
                            .getResource("map.png")
                            .toURI()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        TileManager.getInstance().parsePicture(
                map,
                180,
                155,
                names);
    }
}
