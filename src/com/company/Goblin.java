package com.company;

import com.company.fxcomponent.Hexagon;
import com.company.handler.HexaHandler;
import com.company.model.Map;
import com.company.model.enums.TileType;
import com.company.model.enums.UnitType;
import com.company.model.managers.TileManager;
import com.company.model.managers.UnitManager;
import com.company.system.Triplet;
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

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.company.model.enums.TileType.*;
import static com.company.model.enums.UnitType.COUNT;
import static com.company.model.enums.UnitType.SIR;
import static java.lang.StrictMath.sqrt;

public class Goblin extends Application {
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
                        coordinates,
                        Hexagon.FLAT);

                    BufferedImage tile = TileManager.getInstance().getTile(Map.get(row, col));

                    if (tile != null)
                        hexagon.setTheme(tile);
                    else hexagon.setTheme(Color.rgb(35, 243, 35));

                    hexagons.put(coordinates, hexagon);
                }
            }

            new Thread(() -> hexagons.values().forEach(h -> {
	            h.addEventHandler(MouseEvent.MOUSE_ENTERED, new HexaHandler());
	            h.addEventHandler(MouseEvent.MOUSE_EXITED, new HexaHandler());
            })).start();

	        Pane pane = new Pane(hexagons.values().toArray(new Hexagon[0]));

	        scrollPane = (ScrollPane) scene.lookup("#scrollPane");
            scrollPane.setContent(pane);
            scrollPane.addEventFilter(ScrollEvent.SCROLL, Event::consume);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            LogManager.getLogger(Goblin.class).error(e.getMessage());
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
     * Initialize the TileManager with the tiles
     */
    private void initTile() {
        TileType[] list = new TileType[]{
            CA, FOREST, CC, CD, CE, CF, CG, CH, CI, CJ, CK, CL, LAKE, CN, CO, CP, CQ, CR, CS, MOUNTAIN, CU, HILL, CW, CX, FIELD, CZ,
            AA, AB, AC, AD, ABBEY, AF, AG, AH, AI, AJ, KEEP, AL, AM, AN, AO, AP, AQ, HAMLET, AS, AT, AU, AV, AW, AX, AY, AZ,
            BA, BB, CITY, VILLAGE, BE, BF, BG, BH, BI, BJ, BK, BL, BM, BN, BO, BP, BQ, BR, BS, BT, BU, BV, BW, BX, BY, BZ
        };

	    UnitType[] units = new UnitType[]{
			    UnitType.AA, UnitType.AB, UnitType.AB, UnitType.AA, UnitType.AB, UnitType.AB,
			    UnitType.AB, UnitType.AA, UnitType.AB, UnitType.AB, UnitType.AB, UnitType.AB,
			    UnitType.AA, UnitType.AB, UnitType.AB, UnitType.AA, UnitType.AB, UnitType.AB,
			    UnitType.AB, UnitType.AA, UnitType.AB, SIR, UnitType.AB, UnitType.AA,
			    UnitType.AA, UnitType.AB, UnitType.AB, UnitType.AA, UnitType.AB, UnitType.AB,
			    UnitType.AB, UnitType.AA, COUNT, UnitType.AB, UnitType.AB, UnitType.AB,
			    UnitType.AA, UnitType.AB, UnitType.AA, UnitType.AA, UnitType.AB, UnitType.AB,
			    UnitType.AB, UnitType.AA, UnitType.AB, UnitType.AB, UnitType.AB, UnitType.AA,
			    UnitType.AA, UnitType.AB, UnitType.AB, UnitType.AA, UnitType.AB, UnitType.AB,
			    UnitType.AB, UnitType.AA, UnitType.AB, UnitType.AB, UnitType.AA, UnitType.AB
	    };

        ArrayList<TileType> names = new ArrayList<>(Arrays.asList(list));
	    ArrayList<UnitType> unitsNames = new ArrayList<>(Arrays.asList(units));

        File map = null;
	    File unitsFile = null;
        try {
	        map = new File((
			        getClass()
					        .getClassLoader()
					        .getResource("map.png")
					        .toURI()));

	        unitsFile = new File((
			        getClass()
					        .getClassLoader()
					        .getResource("char.png")
					        .toURI()));
        } catch (Exception e) {
		      LogManager.getLogger(Goblin.class).error(e.getMessage());
        }

	    TileManager.getInstance().parsePicture(
			    map,
			    180,
			    155,
			    names);

	    UnitManager.getInstance().parsePicture(
			    unitsFile,
			    180,
			    155,
			    unitsNames);

	    TileManager.getInstance().addTile(PLAIN,
			    createComposite(TileManager.getInstance().getTile(AA),
					    UnitManager.getInstance().getTile(COUNT), 0.8f));
    }

	public BufferedImage createComposite(BufferedImage tileBase, BufferedImage tileDecoration, float alpha) {
		BufferedImage buffer = new BufferedImage(Math.max(tileBase.getWidth(), tileDecoration.getWidth()),
				Math.max(tileBase.getHeight(), tileDecoration.getHeight()),
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = buffer.createGraphics();
		Composite newComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);

		g2.drawImage(tileBase, null, null);
		g2.setComposite(newComposite);
		g2.drawImage(tileDecoration, null, null);
		g2.dispose();

		return buffer;
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
