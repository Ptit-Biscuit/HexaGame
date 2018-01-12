package com.company.handler;

import com.company.fxcomponent.Hexagon;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class MyHandler implements EventHandler<MouseEvent> {
	@Override
	public void handle(MouseEvent event) {
		Hexagon current = (Hexagon) event.getSource();

		if(event.getEventType().equals(MouseEvent.MOUSE_ENTERED)) {
			System.out.println("entered");
			current.setTheme(Color.BLUE);
		}

		if(event.getEventType().equals(MouseEvent.MOUSE_EXITED))
		{
			System.out.println("exited");
			current.setTheme(Color.RED);
		}
	}
}
