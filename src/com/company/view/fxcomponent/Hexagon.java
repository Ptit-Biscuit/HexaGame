package com.company.view.fxcomponent;

import com.company.controller.manager.TileManager;
import com.company.model.Tile;
import com.company.model.enums.TileType;
import com.company.model.units.Unit;
import com.company.utils.TileUtil;
import com.company.utils.Triplet;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

/**
 * Represent an hexagon
 */
public class Hexagon extends Polygon {
	/**
	 *
	 */
	private final Tile tileHolder;

	/**
	 * Center of the hexagon
	 */
	private Point2D.Double center;

	/**
	 * Width of the hexagon's sides
	 */
	private static int hexWidth = 55;

	/**
	 * Cubic coordinates of the hexagon
	 */
	private Triplet coords;

	/**
	 * Constructor
	 * @param center Center of the hexagon
	 * @param coords Coordinates of the hexagon
	 * @param tile
     * @see Point2D.Double
	 */
	public Hexagon(Point2D.Double center, Triplet coords, Tile tile) {
		this.center = center;
		this.coords = coords;

		this.tileHolder = tile;

		this.setStroke(Color.WHITE);
		this.setStrokeWidth(2.5);
		this.addPoints();

		update();
	}

	/**
	 *
	 */
	public void update() {
		BufferedImage image = TileManager.getInstance().getTile(tileHolder.getType()); // Get main image
		image = TileUtil.compose( // Add river
				tileHolder.getRiver(),
				TileType.RIVER,
				image);
		image = TileUtil.compose( // Add forest
				tileHolder.getForest(), // BOOLEAN
				TileType.FOREST_LIGHT,
				image);
		image = TileUtil.compose( // Add road
				tileHolder.getRoad(),
				TileType.ROAD_STRAIGHT,
				image);

		if (tileHolder.getArmy() != null)
			image = TileUtil.compose(true, tileHolder.getType(), tileHolder.getArmy().getLeader().get(0).getUnitImage());
		// TODO : ADD UNITS
		// TileUtil.compose()

		this.setFill(new ImagePattern(SwingFXUtils.toFXImage(image, null)));
	}

	/**
	 * Adding points corresponding to vertices
	 */
	private void addPoints() {
		List<Double> points = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			int radAngle = 60 * i;
			points.add(this.center.getX() + hexWidth * cos(PI / 180 * radAngle));
			points.add(this.center.getY() + hexWidth * sin(PI / 180 * radAngle));
		}

		this.getPoints().addAll(points);
	}

	/**
	 * Getter of the central point
	 * @return Central point
	 * @see Point2D.Double
	 */
	public Point2D.Double getCenter() {
		return this.center;
	}

	/**
	 * Setter of the central point
	 * @param center The new central point
	 * @see Point2D.Double
	 */
	public void setCenter(Point2D.Double center) {
		this.center = center;
	}

	/**
	 * Getter of the hexagon's sides width
	 * @return The hexagon's sides width
	 */
	public static int getHexWidth() {
		return hexWidth;
	}

	/**
	 * Setter of the hexagon's sides width
	 * @param newHexWidth the new hexagon's sides width
	 */
	public static void setHexWidth(int newHexWidth) {
		hexWidth = newHexWidth;
	}

	/**
	 * Getter of the cubic coordinates
	 * @return The cubic coordinates
	 */
	public Triplet getCoords() {
		return this.coords;
	}

	/**
	 * Setter of the cubic coordinates
	 * @param coords the new cubic coordinates
	 */
	public void setCoords(Triplet coords) {
		this.coords = coords;
	}


	/**
	 * Setter of the color of the hexagon
	 * @param color The color for the theme
	 */
	public void setTheme(Color color) {
		this.setFill(color);
	}

	/**
	 * Getter of the neighbors hexagons' coordinates
	 * @return The neighbors hexagons' coordinates
	 */
	public List<Triplet> getNeighbors() {
		return Triplet.getNeighbors(this.coords);
	}

	@Override
	public String toString() {
		return "Hexagon : center=" + this.center + ", hexWidth=" + hexWidth;
	}
}
