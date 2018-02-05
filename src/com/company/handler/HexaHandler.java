package com.company.handler;

import com.company.Goblin;
import com.company.fxcomponent.Hexagon;
import com.company.model.enums.TileType;
import com.company.model.enums.UnitType;
import com.company.model.managers.TileManager;
import com.company.model.managers.UnitManager;
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
		}

		/*if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
			current.setTheme(
					Goblin.createComposite(current.getTheme(),
					UnitManager.getInstance().getTile(UnitType.BARON),
					0.8f));
		}*/
	}
}
