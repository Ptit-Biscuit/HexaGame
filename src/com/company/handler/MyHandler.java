package com.company.handler;

import com.company.fxcomponent.Hexagon;
import javafx.event.EventHandler;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MyHandler implements EventHandler<MouseEvent> {
	@Override
	public void handle(MouseEvent event) {
		Hexagon current = (Hexagon) event.getSource();

		ColorAdjust colorDark = new ColorAdjust();
		colorDark.setBrightness(0.2);

		ColorAdjust colorBright = new ColorAdjust();
		colorBright.setBrightness(0);

		if(event.getEventType().equals(MouseEvent.MOUSE_ENTERED)) {
			current.setEffect(colorDark);
		}

		if(event.getEventType().equals(MouseEvent.MOUSE_EXITED))
		{
			current.setEffect(colorBright);
		}
	}
}
