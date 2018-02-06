package com.company;

import com.company.model.actions.Movement;
import com.company.model.units.Fighter;
import com.company.model.units.Leader;
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
import java.util.*;

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
        initTile();
        initFeudalUnits();
        initGoblinUnits();

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
		                t.setRiver(new Facing[]{Facing.SOUTH, Facing.SOUTH_EAST});

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
     * Initialize the TileManager with the tiles
     */
    private void initTile() {
	    TileType[] list = new TileType[] {
	        EMPTY_TILE, FOREST, FOREST_LIGHT, PLAIN, EMPTY_TILE, EMPTY_TILE,
	        PATH_STRAIGHT, PATH_TURN, PATH_INTERSECTION, PATH_BRIDGE, PATH_END, EMPTY_TILE,
	        LAKE, RIVER, RIVER_2, RIVER_3, EMPTY_TILE, EMPTY_TILE,
	        MOUNTAIN, MOUNTAIN_2, HILL_2, HILL, EMPTY_TILE, EMPTY_TILE,
	        FIELD, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
	        ABBEY, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
	        KEEP, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
	        EMPTY_TILE, HAMLET, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
	        EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
	        CITY, VILLAGE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
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
		      LogManager.getLogger(Main.class).error(e.getMessage());
        }

	    TileManager.getInstance().parsePicture(
			    map,
			    180,
			    155,
			    names);
    }

    public void initFeudalUnits() {
	    UnitType[] feudalUnits = new UnitType[] {
			    PLUNDER1, PLUNDER2, PLUNDER3, PLUNDER4, END_TURN, EMPTY_UNIT,
			    FEUDAL_C_RANK, FEUDAL_B_RANK, FEUDAL_B_RANK_2, FEUDAL_A_RANK, FEUDAL_A_RANK_2, FEUDAL_A_RANK_3,
			    FEUDAL_C_RANK_ZOOM, FEUDAL_B_RANK_ZOOM, FEUDAL_B_RANK_2_ZOOM, FEUDAL_A_RANK_ZOOM, FEUDAL_A_RANK_2_ZOOM, FEUDAL_A_RANK_3_ZOOM,
			    JOHN_GORDON, ROBERT_KEITH, THOPMAS_BRUCE, FRIAR_SIMON, SIR_RANDOLPH, SIR_GODFREY,
			    JOHN_GORDON_ZOOM, ROBERT_KEITH_ZOOM, THOPMAS_BRUCE_ZOOM, FRIAR_SIMON_ZOOM, SIR_RANDOLPH_ZOOM, SIR_GODFREY_ZOOM,
			    SIR_HILBERT, COUNT, BARON, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
			    SIR_HILBERT_ZOOM, COUNT_ZOOM, BARON_ZOOM, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
			    EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
			    EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
			    EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT
	    };
	    ArrayList<UnitType> feudalNames = new ArrayList<>(Arrays.asList(feudalUnits));

	    File unitsFeudalFile = null;
	    try {
		    unitsFeudalFile = new File((
				    getClass()
						    .getClassLoader()
						    .getResource("char.png")
						    .toURI()));
	    } catch (URISyntaxException e) {
		    LogManager.getLogger(Main.class).error(e.getMessage());
	    }

	    UnitManager.getInstance().parsePicture(
			    unitsFeudalFile,
			    180,
			    155,
			    feudalNames);
    }

    public void initGoblinUnits() {
	    UnitType[] goblinUnits = new UnitType[] {
			    EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
			    GOBLIN_C_RANK, GOBLIN_C_RANK_2, GOBLIN_B_RANK, GOBLIN_B_RANK_2, EMPTY_UNIT, EMPTY_UNIT,
			    GOBLIN_C_RANK_ZOOM, GOBLIN_C_RANK_2_ZOOM, GOBLIN_B_RANK_ZOOM, GOBLIN_B_RANK_2_ZOOM, EMPTY_UNIT, EMPTY_UNIT,
			    PHINLOC, UGLOP, GRINPHAR, KASBOSH, ARGBARG, MARGLUSH,
			    PHINLOC_ZOOM, UGLOP_ZOOM, GRINPHAR_ZOOM, KASBOSH_ZOOM, ARGBARG_ZOOM, MARGLUSH_ZOOM,
			    KING, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
			    KING_ZOOM, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
			    EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
			    EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
			    EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
	    };
	    ArrayList<UnitType> goblinNames = new ArrayList<>(Arrays.asList(goblinUnits));

	    File unitsGoblinFile = null;
	    try {
		    unitsGoblinFile = new File((
				    getClass()
						    .getClassLoader()
						    .getResource("char2.png")
						    .toURI()));
	    } catch (URISyntaxException e) {
		    LogManager.getLogger(Main.class).error(e.getMessage());
	    }

	    UnitManager.getInstance().parsePicture(
			    unitsGoblinFile,
			    180,
			    155,
			    goblinNames);
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
