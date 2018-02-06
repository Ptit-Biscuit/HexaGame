package com.company.view.fxcomponent;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Hud extends Rectangle {
	public Hud(double x, double y, double width, double height) {
		super(x, y, width, height);
		this.setArcWidth(15d);
		this.setArcHeight(15d);
		this.setFill(Color.color(0.1d, 0.1d, 0.1d, 0.9d));
	}
}
