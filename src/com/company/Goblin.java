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

			/*float height = (float) sqrt(3) * 30;
			float distHorizontal = 30 * 1.5f;

			for (int col = 0; col < (640 / distHorizontal); col++) {
				for (int row = 0; row < (640 / height); row++) {
					int x = col - 16;
					int z = row - (col - (col & 1)) / 2;

					hexagons.add(
						new Hexagon(
							new Point2D.Double(
								distHorizontal * col,
								height * (row + ((col%2 == 0) ? 0 : 0.5f))),
							30,
							new Triplet(x, - x - z, z),
							Hexagon.FLAT)
					);
				}
			}*/

			float width = (float) sqrt(3) * 40;
			float distVertical = 40 * 1.5f;

			float colNumber = 4096 / width;
			float rowNumber = 2048 / distVertical;

			for (int col = 0; col < colNumber; col++) {
				for (int row = 0; row < rowNumber; row++) {
					int x = col - (row - (row & 1)) / 2 - 9;
					int z = row - 9;

					hexagons.add(
						new Hexagon(
							new Point2D.Double(
									width * (col + ((row % 2 == 0) ? 0 : 0.5f)),
									distVertical * row),
							38,
							new Triplet(x, - x - z, z),
							Hexagon.POINTY)
					);
				}
			}

			Pane pane = new Pane(hexagons.toArray(new Hexagon[0]));

			scrollPane.setContent(pane);
			scrollPane.addEventFilter(ScrollEvent.SCROLL, Event::consume);



			primaryStage.setScene(scene);
			primaryStage.show();

			/* Main Looper
			class Loop implements Runnable {

				@Override
				public void run() {
					while(true) {
						hexagons.forEach(i -> i.setTheme((int) (random() * 5)));
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}

			new Thread(new Loop()).start();
			*/

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
