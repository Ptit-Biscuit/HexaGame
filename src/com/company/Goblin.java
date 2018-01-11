package com.company;

import com.company.fxcomponent.Hexagon;
import com.company.system.Triplet;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.sqrt;

public class Goblin extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));

			Scene scene = new Scene(root, 640, 400);
			ScrollPane scrollPane = (ScrollPane) scene.lookup("#scrollPane");

			List<Hexagon> hexagons = new ArrayList<>();

			float height = (float) sqrt(3) * 40;
			float distHorizontal = 40 * 1.5f;

			for (int col = 0; col < (4096 / distHorizontal); col++) {
				for (int row = 0; row < (2048 / height); row++) {
					int x = col - 16;
					int z = row - (col - (col & 1)) / 2;

					hexagons.add(
						new Hexagon(
							new Point2D.Double(
								distHorizontal * col,
								height * (row + ((col % 2 == 0) ? 0 : 0.5f))),
							new Triplet(x, - x - z, z),
							Hexagon.FLAT)
					);
				}
			}

			Pane pane = new Pane(hexagons.toArray(new Hexagon[0]));

			scrollPane.setContent(pane);
			scrollPane.addEventFilter(ScrollEvent.SCROLL, Event::consume);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
