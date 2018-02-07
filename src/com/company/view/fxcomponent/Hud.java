package com.company.view.fxcomponent;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;


public class Hud extends Pane {

	private Text name;
	private Text stat_1;
	private Text stat_2;
	private Text stat_3;

	public Hud(double x, double y, double width, double height) {

		super();
		this.setPrefSize(width,height);
		//this.setFill(Color.color(0.1d, 0.8d, 0.1d, 0.9d));
		name = new Text(150, 50, "");
		name.setFill(Color.WHITE);

		stat_1 = new Text(150, 90, "");
		stat_1.setFill(Color.WHITE);

		stat_2 = new Text(150, 110, "");
		stat_2.setFill(Color.WHITE);

		stat_3 = new Text(150, 130,"");
		stat_3.setFill(Color.WHITE);


		Rectangle rectangle = new Rectangle(x, y, width, height);
		rectangle.setFill(Color.web("0x000000",0.9));
		rectangle.setArcWidth(15d);
		rectangle.setArcHeight(15d);
		this.getChildren().addAll(rectangle, name, stat_1, stat_2, stat_3);

	}

	public void updateStats(String text_name, int text_stat1, int text_stat2, int text_stat3){
		name.setText(text_name);
		stat_1.setText(String.valueOf(text_stat1));
		stat_2.setText(String.valueOf(text_stat2));
		stat_3.setText(String.valueOf(text_stat3));
	}
}
