package com.company;

import com.company.controller.handler.ActionHandler;
import com.company.controller.handler.HexaHandler;
import com.company.model.Board;
import com.company.model.Map;
import com.company.model.Tile;
import com.company.model.units.Army;
import com.company.utils.Triplet;
import com.company.view.TilesetInitializer;
import com.company.view.fxcomponent.Hexagon;
import com.company.view.fxcomponent.Hud;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.apache.logging.log4j.LogManager;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.HashMap;

import static java.lang.StrictMath.sqrt;

public class Main extends Application {
    /**
     * The hexagons
     */
    private static Army army = null;

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
    private static Hud hud  = new Hud(0, 0, 355, 175);

    /**
     * Main
     *
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

            Board tiles = Board.getInstance();
            for (int col = 0; col < size.getValue(); col++)
                for (int row = 0; row < size.getKey(); row++) {
                    Triplet coordinates = new Triplet(row, col, -row - col);
                    Hexagon hexagon = new Hexagon(
                            new Point2D.Double(
                                    Hexagon.getHexWidth() + distHorizontal * col,
                                    height / 2 + height * (row + ((col % 2 == 0) ? 0 : 0.5f))),
                            coordinates, tiles.getTile(coordinates));
                    hexagons.put(coordinates, hexagon);
                }

            HexaHandler handler = new HexaHandler();
            System.out.println("phase de mouvement");
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
	        scrollPane.addEventFilter(KeyEvent.KEY_PRESSED, t -> {
		        if (t.getCode() == KeyCode.SPACE) {
			        t.consume();
		        }
	        });
            scrollPane.addEventHandler(KeyEvent.KEY_PRESSED, new ActionHandler());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            LogManager.getLogger(Main.class).error(e.getMessage());
        }
    }

	/**
	 *
	 */
	public static void update(){ hexagons.values().forEach(Hexagon::update); }

	/**
	 * Exit the application
	 */
	@FXML
	public void quit() {
		Platform.exit();
    }


    /**
     * Getter of the H.U.D
     *
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
     *
     * @return The hexagons
     */
    public static HashMap<Triplet, Hexagon> getHexagons() {
        return hexagons;
    }

    /**
     * Getter of an hexagon from its coordinates
     *
     * @param coordinates The hexagon's coordinates
     * @return The hexagon found, null otherwise
     */
    public static Hexagon getHexagon(Triplet coordinates) {
        return hexagons.get(coordinates);
    }

    public static void handleTile(Tile tile){
        Board board = Board.getInstance();
        if (board.getPhase() % 2==1) {
            if (board.isSelectArmy()) {
                if (tile.getArmy() != null) {
                    board.setArmyToMove(tile.getArmy());
                    System.out.println("Armée selectionnée");
                }
            } else {
                if (!board.getPath().contains(tile)){
                    board.getPath().add(tile);
                    System.out.println("Tile ajoutée au chemin");
                } else {
                    System.out.println("Cette tile est déjà selectionnée");
                }

            }
        } else {
            if (board.isSelectArmy()) {
                if (tile.getArmy() != null) {
                    board.setAttackers(tile);
                    System.out.println("Armée alliée selectionnée");
                }
            } else {
                if (tile.getArmy() != null) {
                    board.setDefenders(tile);
                    System.out.println("Armée ennemie selectionnée");
                }
            }
        }
    }
}
