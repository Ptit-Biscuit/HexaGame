package com.company.view.fxcomponent;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;


public class Hud extends Pane {
	public Hud(double x, double y, double width, double height, String text_name, int text_stat1, int text_stat2, int text_stat3) {

		super();
		this.setPrefSize(width,height);
		//this.setFill(Color.color(0.1d, 0.8d, 0.1d, 0.9d));
		Text name = new Text(150, 50, text_name);
		name.setFill(Color.WHITE);

		Text stat_1 = new Text(150, 90, ""+text_stat1);
		stat_1.setFill(Color.WHITE);

		Text stat_2 = new Text(150, 110, ""+text_stat2);
		stat_2.setFill(Color.WHITE);

		Text stat_3 = new Text(150, 130,""+text_stat3);
		stat_3.setFill(Color.WHITE);


		Rectangle rectangle = new Rectangle(x, y, width, height);
		rectangle.setFill(Color.web("0x000000",0.9));
		rectangle.setArcWidth(15d);
		rectangle.setArcHeight(15d);
		this.getChildren().addAll(rectangle, name, stat_1, stat_2, stat_3);

	}
}
