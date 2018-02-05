package com.company.fxcomponent;

import com.company.model.Tile;
import com.company.system.Triplet;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
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
	private static int hexWidth = 75;

	/**
	 * Cubic coordinates of the hexagon
	 */
	private Triplet coords;

	/**
	 * Theme (i.e Actual image) of the hexagon
	 */
	private BufferedImage theme;

	/**
	 * Coordinates of neighbors hexagons
	 */
	private List<Triplet> neighbors;

	/**
	 * Constructor
	 * @param center Center of the hexagon
	 * @param coords Coordinates of the hexagon
	 * @see Point2D.Double
	 */
	public Hexagon(Point2D.Double center, Triplet coords) {
		this.center = center;
		this.coords = coords;

		this.setFill(Color.LIGHTGREY);
		this.setStroke(Color.WHITE);
		this.setStrokeWidth(2.5);
		this.addPoints();
		this.addNeighbors();
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
	 * Getter of the actual theme
	 * @return The actual theme
	 */
	public BufferedImage getTheme() {
		return this.theme;
	}

	/**
	 * Setter of the color of the hexagon
	 * @param color The color for the theme
	 */
	public void setTheme(Color color) {
		this.setFill(color);
	}

	/**
	 * Set the theme
	 * @param image The image for the hexagon
	 */
	public void setTheme(BufferedImage image) {
		this.theme = image;
		this.setFill(new ImagePattern(SwingFXUtils.toFXImage(this.theme, null)));
	}

	public void setTheme(Tile tile) {
		this.setFill(new ImagePattern(SwingFXUtils.toFXImage(tile.getTile(), null)));
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
		return "Hexagon{" + "center=" + this.center + ", hexWidth=" + hexWidth + ", theme=" + this.theme + '}';
	}
}
