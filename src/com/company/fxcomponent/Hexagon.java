package com.company.fxcomponent;

import com.company.system.Triplet;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Math.*;

/**
 * Class Hexagon: représente un hexagone
 * @author Ptit-Biscuit
 * @version 1.0
 * @since 1.0
 */
public class Hexagon extends Polygon {
	/**
	 * Le centre
	 */
	private Point2D.Double center;

	/**
	 * La longueur des côtés
	 */
	private int hexWidth = 30;

	/**
	 * Les coordonnées
	 */
	private Triplet coords;

	/**
	 * L'orientation horizontale
	 */
	public static final boolean FLAT = true;

	/**
	 * L'orientation verticale
	 */
	public static final boolean POINTY = false;

	/**
	 * L'orientation utilisée
	 */
	private boolean orientation = FLAT;

	/**
	 * Les couleurs
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
	 * Le thème (c-a-d la couleur actuelle)
	 */
	private Color theme;

	/**
	 * Les coordonnées des hexagones voisins
	 */
	private List<Triplet> neighbors;

	/**
	 * Constructeur
	 * @param center Le centre de l'hexagone
	 * @param width La longueur des côtés de l'hexagone
	 * @param coords Les coordonnées de l'hexagone
	 * @param orientation L'orientation de l'hexagone (Hexagon.FLAT ou Hexagon.POINTY)
	 * @see Point2D.Double
	 */
	public Hexagon(Point2D.Double center, int width, Triplet coords, boolean orientation) {
		this.center = center;
		this.hexWidth = width;
		this.coords = coords;
		this.orientation = orientation;
		this.theme = this.colors.get(new Random().nextInt(5));

		this.setFill(this.theme);
		this.addPoints();
		this.addNeighbors();
	}

	/**
	 * Ajout des points correspondants aux sommets
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
	 * Ajout des voisins
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
	 * Getter du point central
	 * @return Le point central
	 * @see Point2D.Double
	 */
	public Point2D.Double getCenter() {
		return this.center;
	}

	/**
	 * Setter du point central
	 * @param center Le nouveau point central
	 * @see Point2D.Double
	 */
	public void setCenter(Point2D.Double center) {
		this.center = center;
	}

	/**
	 * Getter de la longueur des côtés
	 * @return La longeur des côtés
	 */
	public int getHexWidth() {
		return hexWidth;
	}

	/**
	 * Setter de la longueur des côtés
	 * @param hexWidth La nouvelle longueur des côtés
	 */
	public void setHexWidth(int hexWidth) {
		this.hexWidth = hexWidth;
	}

	/**
	 * Getter des coordonnées cubiques
	 * @return Les coordonnées cubiques
	 */
	public Triplet getCoords() {
		return this.coords;
	}

	/**
	 * Setter des coordonnées cubiques
	 * @param coords Les nouvelles coordonnées cubiques
	 */
	public void setCoords(Triplet coords) {
		this.coords = coords;
	}

	/**
	 * Getter de l'orientation
	 * @return L'orientation (c-a-d FLAT ou POINTY)
	 */
	public boolean getOrientation() {
		return orientation;
	}

	/**
	 * Setter de l'orientation
	 * @param orientation La nouvelle orientation (c-a-d <code>Hexagon.FLAT</code> ou <code>Hexagon.POINTY</code>)
	 */
	public void setOrientation(boolean orientation) {
		this.orientation = orientation;
	}

	/**
	 * Getter du thème actuel
	 * @return Le thème actuel
	 */
	public Color getTheme() {
		return this.theme;
	}

	/**
	 * Setter du theme
	 * @param index L'indice du thème
	 */
	public void setTheme(int index) {
		this.theme = this.colors.get(index);
	}

	/**
	 * Getter des coordonnées des hexagones voisins
	 * @return Les coordonnées des hexagones voisins
	 */
	public List<Triplet> getNeighbors() {
		return this.neighbors;
	}

	@Override
	public String toString() {
		return "Hexagon{" + "center=" + this.center + ", hexWidth=" + this.hexWidth + ", orientation=" + this.orientation + ", theme=" + this.theme + '}';
	}
}
