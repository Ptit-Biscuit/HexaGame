package com.company;

import com.company.fxcomponent.Hexagon;
import com.company.handler.MyHandler;
import com.company.system.Triplet;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.HashMap;

import static java.lang.StrictMath.sqrt;

public class Goblin extends Application {
	/**
	 * The hexagons
	 */
	private static HashMap<Triplet, Hexagon> hexagons = new HashMap<>();

	/**
	 * Main
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));

			Scene scene = new Scene(root, 640, 400);
			ScrollPane scrollPane = (ScrollPane) scene.lookup("#scrollPane");

			float height = (float) sqrt(3) * 40;
			float distHorizontal = 40 * 1.5f;

			for (int col = 0; col < 27; col++) {
				for (int row = 0; row < 20; row++) {
					hexagons.put(
						new Triplet(row, col, - row - col),
						new Hexagon(
							new Point2D.Double(
								distHorizontal * col,
								height * (row + ((col % 2 == 0) ? 0.5f : 0))),
							new Triplet(row, col, - row - col),
							Hexagon.FLAT)
					);
				}
			}

			new Thread(() -> hexagons.values().forEach(h -> {
				h.addEventHandler(MouseEvent.MOUSE_ENTERED, new MyHandler());
				h.addEventHandler(MouseEvent.MOUSE_EXITED, new MyHandler());
			})).start();

			Pane pane = new Pane(hexagons.values().toArray(new Hexagon[0]));

			scrollPane.setContent(pane);
			scrollPane.addEventFilter(ScrollEvent.SCROLL, Event::consume);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			LogManager.getLogger(Goblin.class).error(e.getMessage());
		}
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
