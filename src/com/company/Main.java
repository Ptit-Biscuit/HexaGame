package com.company;

import com.company.view.TilesetInitializer;
import com.company.view.fxcomponent.Hexagon;
import com.company.controller.handler.HexaHandler;
import com.company.model.Map;
import com.company.model.Tile;
import com.company.model.enums.Facing;
import com.company.model.enums.TileType;
import com.company.model.enums.UnitType;
import com.company.controller.manager.TileManager;
import com.company.controller.manager.UnitManager;
import com.company.utils.Triplet;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.apache.logging.log4j.LogManager;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.company.model.enums.TileType.*;
import static com.company.model.enums.UnitType.*;
import static java.lang.StrictMath.sqrt;

public class Main extends Application {
	/**
	 * The hexagons
	 */
	private static HashMap<Triplet, Hexagon> hexagons = new HashMap<>();

	/**
	 * The scroll pane
	 */
	@FXML
	public ScrollPane scrollPane;

	/**
	 * Main
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

    @Override
    public void start(Stage primaryStage) {
		TilesetInitializer tilesetInit = new TilesetInitializer();
		tilesetInit.initTile();
		tilesetInit.initFeudalUnits();
		tilesetInit.initGoblinUnits();

        //initBoard();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("board.fxml"));
            Scene scene = new Scene(root, 1280, 720);

            float height = (float) sqrt(3) * Hexagon.getHexWidth();
            float distHorizontal = 1.5f * Hexagon.getHexWidth();

            Pair<Integer, Integer> size = Map.getMapSize();

            for (int col = 0; col < size.getValue(); col++) {
                for (int row = 0; row < size.getKey(); row++) {
                    Triplet coordinates = new Triplet(row, col, - row - col);

                    Hexagon hexagon = new Hexagon(
                        new Point2D.Double(
		                        Hexagon.getHexWidth() + distHorizontal * col,
		                        height/2 + height * (row + ((col % 2 == 0) ? 0 : 0.5f))),
                        coordinates);

                    BufferedImage tile = TileManager.getInstance().getTile(Map.get(row, col));

	                if (tile != null) {
		                Tile t = new Tile(tile);
		                t.setType(Map.get(row, col));
		                t.setRiver(new Facing[]{Facing.NORTH_EAST});//, Facing.NORTH, Facing.NORTH_WEST, Facing.SOUTH_EAST, Facing.SOUTH, });

		                hexagon.setTheme(t);
	                }
                    else hexagon.setTheme(Color.rgb(35, 243, 35));

                    hexagons.put(coordinates, hexagon);
                }
            }

            HexaHandler handler = new HexaHandler();

            new Thread(() -> hexagons.values().forEach(h -> {
	            h.addEventHandler(MouseEvent.MOUSE_ENTERED, handler);
	            h.addEventHandler(MouseEvent.MOUSE_EXITED, handler);
	            h.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
            })).start();

	        Pane pane = new Pane(hexagons.values().toArray(new Hexagon[0]));

	        scrollPane = (ScrollPane) scene.lookup("#scrollPane");
            scrollPane.setContent(pane);
            scrollPane.addEventFilter(ScrollEvent.SCROLL, Event::consume);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            LogManager.getLogger(Main.class).error(e.getMessage());
        }
    }

	/**
	 * Exit the application
	 */
	@FXML
	public void quit() {
		Platform.exit();
    }


	/**
	 * Getter of the hexagons
	 * @return The hexagons
	 */
	public static HashMap<Triplet, Hexagon> getHexagons() {
		return hexagons;
	}

	/**
	 * Getter of an hexagon from its coordinates
	 * @param coordinates The hexagon's coordinates
	 * @return The hexagon found, null otherwise
	 */
	public static Hexagon getHexagon(Triplet coordinates) {
		return hexagons.get(coordinates);
	}
}
