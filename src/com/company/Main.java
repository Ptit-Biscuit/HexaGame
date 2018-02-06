package com.company;

import com.company.view.TilesetInitializer;
import com.company.model.actions.Movement;
import com.company.model.units.Fighter;
import com.company.model.units.Leader;
import com.company.view.fxcomponent.Hexagon;
import com.company.controller.handler.HexaHandler;
import com.company.model.Map;
import com.company.model.Tile;
import com.company.controller.manager.TileManager;
import com.company.utils.Triplet;
import com.company.view.fxcomponent.Hud;
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
import java.io.IOException;
import java.util.HashMap;
import java.net.URISyntaxException;
import java.util.*;

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
	public static ScrollPane scrollPane;

	/**
	 * The H.U.D
	 */
	private static Hud hud = new Hud(0, 0, 355, 175);

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
		tilesetInit.initTileset();
		tilesetInit.initUnits();
		tilesetInit.initMarkers();

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
	        pane.getChildren().add(hud);
	        hud.setVisible(false);

	        scrollPane = (ScrollPane) scene.lookup("#scrollPane");
            scrollPane.setContent(pane);
            scrollPane.addEventFilter(ScrollEvent.SCROLL, Event::consume);
            primaryStage.setScene(scene);
            primaryStage.show();

			testMove();

        } catch (IOException e) {
            LogManager.getLogger(Main.class).error(e.getMessage());
        }
    }

	/**
	 * Test the move
	 */
    public void testMove(){
		//z=-x-y
		Hexagon hexa1 = Main.getHexagon(new Triplet(1,4,-5));
		Hexagon hexa2 = Main.getHexagon(new Triplet(1,5,-6));
		Hexagon hexa3 = Main.getHexagon(new Triplet(2,5,-7));
		Hexagon hexa4 = Main.getHexagon(new Triplet(2,6,-8));
		Hexagon hexa5 = Main.getHexagon(new Triplet(1,5,-6));
		ArrayList<Hexagon> hexaList = new ArrayList<>();
		hexaList.add(hexa1);
		hexaList.add(hexa2);
		hexaList.add(hexa3);
		hexaList.add(hexa4);
		hexaList.add(hexa5);

		Leader feudalLeader = new Leader(5,true,"feudal", Main.getHexagon(new Triplet(1,3,-4)) , "RE", "Count", 3, 5);
        Fighter feudal1 = new Fighter(3,false,"feudal",Main.getHexagon(new Triplet(1,3,-4)),"","C",3,3, feudalLeader);
        Fighter feudal2 = new Fighter(3,false,"feudal",Main.getHexagon(new Triplet(1,3,-4)),"","C",3,3, feudalLeader);
        Fighter feudal3 = new Fighter(3,false,"feudal",Main.getHexagon(new Triplet(1,3,-4)),"","C",3,3, feudalLeader);
        Fighter feudal4 = new Fighter(3,false,"feudal",Main.getHexagon(new Triplet(1,3,-4)),"","C",3,3, feudalLeader);

		Boolean valid = Movement.isValidMove(feudalLeader,hexaList);
		System.out.println(valid);
		System.out.println(feudalLeader.getPosition().getCoords());
		if (valid){
			Movement.move(feudalLeader);
		}
		System.out.println(feudalLeader.getPosition().getCoords());
	}

	/**
	 * Exit the application
	 */
	@FXML
	public void quit() {
		Platform.exit();
    }


	/**
	 * Getter of the H.U.D
	 * @return the H.U.D
	 */
	public static Hud getHud() {
		return hud;
	}

	/**
	 * Getter of the width of the scrollPane
	 * @return The width of the scrollPane
	 */
	public static double getWidth() {
		return scrollPane.getWidth();
	}

	/**
	 * Getter of the height of the scrollPane
	 * @return The height of the scrollPane
	 */
	public static double getHeight() {
		return scrollPane.getHeight();
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
