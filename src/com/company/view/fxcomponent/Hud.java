package com.company.view.fxcomponent;

import com.company.controller.manager.UnitManager;
import com.company.model.enums.UnitType;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;


public class Hud extends Pane {

	private Text name;
	private ImageView portrait = new ImageView();
	private Text stat_1;
	private Text stat_2;
	private Text stat_3;
	private Text stat_4;
	private Text stat_5;
	private Text stat_6;

	public Hud(double x, double y, double width, double height) {

		super();
		this.setPrefSize(width,height);

		name = new Text(150, 50, "");
		name.setFill(Color.WHITE);

		stat_1 = new Text(150, 90, "");
		stat_1.setFill(Color.WHITE);

		stat_2 = new Text(150, 110, "");
		stat_2.setFill(Color.WHITE);

		stat_3 = new Text(150, 130,"");
		stat_3.setFill(Color.WHITE);

		stat_4 = new Text(280, 90, "");
		stat_4.setFill(Color.WHITE);

		stat_5 = new Text(280, 110, "");
		stat_5.setFill(Color.WHITE);

		stat_6 = new Text(280, 130,"");
		stat_6.setFill(Color.WHITE);


		Rectangle rectangle = new Rectangle(x, y, width, height);
		rectangle.setFill(Color.web("0x000000",0.9));
		rectangle.setArcWidth(15d);
		rectangle.setArcHeight(15d);
		this.getChildren().addAll(rectangle, portrait, name, stat_1, stat_2, stat_3, stat_4, stat_5, stat_6);

	}

	public void updateStats(String text_name, Image image_portrait, int text_MP_Lead, int text_Armor_Lead, int text_Command_Lead, int text_Missile_Fighter, int text_Melee_Fighter, int text_Armor_Fighter){
		name.setText(text_name);
		portrait.setImage(image_portrait);
		stat_1.setText("MP modifier: "+String.valueOf(text_MP_Lead));
		stat_2.setText("Command limit: "+String.valueOf(text_Command_Lead));
		stat_3.setText("Armor: "+String.valueOf(text_Armor_Lead));
		stat_4.setText("Missile: "+String.valueOf(text_Missile_Fighter));
		stat_5.setText("Melee: "+String.valueOf(text_Melee_Fighter));
		stat_6.setText("Armor: "+String.valueOf(text_Armor_Fighter));
	}
}
