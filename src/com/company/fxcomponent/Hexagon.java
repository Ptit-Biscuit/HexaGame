package com.company.fxcomponent;

import com.company.system.Triplet;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Math.*;

/**
 * Represent an hexagon
 */
public class Hexagon extends Polygon {
	/**
	 * Center of the hexagon
	 */
	private Point2D.Double center;

	/**
	 * Width of the hexagon's sides
	 */
	private int hexWidth = 40;

	/**
	 * Cubic coordinates of the hexagon
	 */
	private Triplet coords;

	/**
	 * Horizontal orientation
	 */
	public static final boolean FLAT = true;

	/**
	 * Vertical orientation
	 */
	public static final boolean POINTY = false;

	/**
	 * Used orientation
	 */
	private boolean orientation = FLAT;

	/**
	 * Usable colors for the hexagon
	 */
	private List<Color> colors = new ArrayList<>(
			Arrays.asList(
					/*Color.TRANSPARENT,
					Color.LIGHTGRAY,*/
					Color.WHITE,
					Color.BLACK,
					Color.RED,
					Color.GREEN,
					Color.BLUE));

	/**
	 * Theme (i.e Actual color) of the hexagon
	 */
	private Color theme;

	/**
	 * Coordinates of neighbors hexagons
	 */
	private List<Triplet> neighbors;

	/**
	 * Constructor
	 * @param center Center of the hexagon
	 * @param coords Coordinates of the hexagon
	 * @param orientation Orientation of the hexagon (Hexagon.FLAT or Hexagon.POINTY)
	 * @see Point2D.Double
	 */
	public Hexagon(Point2D.Double center, Triplet coords, boolean orientation) {
		this.center = center;
		this.coords = coords;
		this.orientation = orientation;
		this.theme = this.colors.get(new Random().nextInt(5));

		this.setFill(this.theme);
		this.setStroke(Color.GRAY);
		this.addPoints();
		this.addNeighbors();
	}

	/**
	 * Constructor
	 * @param center Center of the hexagon
	 * @param width Width of the hexagon
	 * @param coords Coordinates of the hexagon
	 * @param orientation Orientation of the hexagon (Hexagon.FLAT or Hexagon.POINTY)
	 * @see Point2D.Double
	 */
	public Hexagon(Point2D.Double center, int width, Triplet coords, boolean orientation) {
		this.center = center;
		this.hexWidth = width;
		this.coords = coords;
		this.orientation = orientation;
		this.theme = this.colors.get(new Random().nextInt(5));

		this.setFill(this.theme);
		this.setStroke(Color.GRAY);
		this.addPoints();
		this.addNeighbors();
	}

	/**
	 * Adding points corresponding to vertices
	 */
	private void addPoints() {
		int orientationAngle = (this.orientation ? 0 : 30);
		List<Double> points = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			int radAngle = 60 * i + orientationAngle;
			points.add(this.center.getX() + this.hexWidth * cos(PI / 180 * radAngle));
			points.add(this.center.getY() + this.hexWidth * sin(PI / 180 * radAngle));
		}

		this.getPoints().addAll(points);
	}

	/**
	 * Adding neighbors
	 */
	private void addNeighbors() {
		this.neighbors = new ArrayList<>();

		int coordX = this.getCoords().getX();
		int coordY = this.getCoords().getY();
		int coordZ = this.getCoords().getZ();

		this.neighbors.add(new Triplet(coordX + 1, coordY - 1, coordZ));
		this.neighbors.add(new Triplet(coordX, coordY + 1, coordZ - 1));
		this.neighbors.add(new Triplet(coordX - 1, coordY, coordZ + 1));
		this.neighbors.add(new Triplet(coordX + 1, coordY, coordZ - 1));
		this.neighbors.add(new Triplet(coordX, coordY - 1, coordZ + 1));
		this.neighbors.add(new Triplet(coordX - 1, coordY + 1, coordZ));
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
	public int getHexWidth() {
		return hexWidth;
	}

	/**
	 * Setter of the hexagon's sides width
	 * @param hexWidth the new hexagon's sides width
	 */
	public void setHexWidth(int hexWidth) {
		this.hexWidth = hexWidth;
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
	 * Getter of the orientation
	 * @return The orientation (i.e <code>Hexagon.FLAT</code> or <code>Hexagon.POINTY</code>)
	 */
	public boolean getOrientation() {
		return orientation;
	}

	/**
	 * Setter of the orientation
	 * @param orientation The new orientation (i.e <code>Hexagon.FLAT</code> or <code>Hexagon.POINTY</code>)
	 */
	public void setOrientation(boolean orientation) {
		this.orientation = orientation;
	}

	/**
	 * Getter of the actual theme
	 * @return The actual theme
	 */
	public Color getTheme() {
		return this.theme;
	}

	/**
	 * Setter of the theme
	 * @param index The index of the theme
	 */
	public void setTheme(int index) {
		this.theme = this.colors.get(index);
		this.setFill(this.theme);
	}

	/**
	 * Getter of the neighbors hexagons' coordinates
	 * @return The neighbors hexagons' coordinates
	 */
	public List<Triplet> getNeighbors() {
		return this.neighbors;
	}

	@Override
	public String toString() {
		return "Hexagon{" + "center=" + this.center + ", hexWidth=" + this.hexWidth + ", orientation=" + this.orientation + ", theme=" + this.theme + '}';
	}
}
