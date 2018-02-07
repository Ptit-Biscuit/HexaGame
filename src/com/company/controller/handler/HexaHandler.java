package com.company.controller.handler;

import com.company.Main;
import com.company.model.Tile;
import com.company.view.fxcomponent.Hexagon;
import javafx.event.EventHandler;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseEvent;

public class HexaHandler implements EventHandler<MouseEvent> {
	@Override
	public void handle(MouseEvent event) {
		Hexagon current = (Hexagon) event.getSource();

		ColorAdjust colorAdjust = new ColorAdjust();

		if (event.getEventType().equals(MouseEvent.MOUSE_ENTERED)) {
			colorAdjust.setBrightness(-0.2);
			current.setEffect(colorAdjust);
			current.toFront();
			System.out.println(current.getCoords().getX() + ", " + current.getCoords().getY());
		}

		if (event.getEventType().equals(MouseEvent.MOUSE_EXITED)) {
			colorAdjust.setBrightness(0);
			current.setEffect(colorAdjust);
			Main.getHud().setVisible(false);
		}

		if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
			Main.getHud().setTranslateX(current.getCenter().getX() + 65);
			Main.getHud().setTranslateY(current.getCenter().getY() - 210);

			if (Main.getWidth() >= (Main.getWidth() - current.getCenter().getX() + Main.getHud().getWidth())) {
				Main.getHud().setTranslateX(current.getCenter().getX() - 420);
			}

			if (Main.getHeight() <= (Main.getHeight() - current.getCenter().getY() + Main.getHud().getHeight() + 20)) {
				Main.getHud().setTranslateY(current.getCenter().getY() + 35);
			}

			Main.getHud().setVisible(true);
			Main.getHud().toFront();

			Tile tile = new Tile(current.getCoords());
            Main.handleTile(tile);
        }
	}
}
