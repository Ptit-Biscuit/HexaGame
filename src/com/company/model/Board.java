package com.company.model;

import com.company.system.Hexagon;
import com.company.system.Triplet;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/**
 * Class Board: représente le plateau du jeu
 * @author Ptit-Biscuit
 * @version 1.0
 * @since 1.0
 */
public class Board extends JPanel {
	/**
	 * La longueur
	 */
	public static final int WIDTH = 60 * 25 + 13;

	/**
	 * La hauteur
	 */
	public static final int HEIGHT = 60 * 14 + 10;

	/**
	 * La longueur minimale d'un hexagone
	 */
	private static final int MIN_HEX_WIDTH = 10;

	/**
	 * La longueur maximale d'un hexagone
	 */
	private static final int MAX_HEX_WIDTH = 50;

	/**
	 * CL'unique instance
	 */
	private static Board instance = new Board();

	/**
	 * Liste des hexagons
	 */
	private List<Hexagon> hexagons;

	/**
	 * Constructeur
	 */
	private Board() {
		this.createPointyHex(30);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		this.hexagons.forEach(
				h -> {
					g2.setColor(h.getTheme());
					g2.fillPolygon(h);

					g2.setColor(new Color(200, 0, 0));
//					g2.drawString(String.valueOf(h.getCoords().getX()), (int) h.getCenter().getX() + 7, (int)h.getCenter().getY() - 5);
//					g2.drawString(String.valueOf(h.getCoords().getY()), (int) h.getCenter().getX() - 15, (int)h.getCenter().getY() - 5);
//					g2.drawString(String.valueOf(h.getCoords().getZ()), (int) h.getCenter().getX() - 3, (int)h.getCenter().getY() + 17);
//					g2.drawOval((int) h.getCenter().getX(), (int) h.getCenter().getY(), 1, 1);
					g2.drawPolygon(h);
				}
		);

		g2.dispose();
	}

	/**
	 * Créer les hexagons du plateau
	 * (mode horizontal, plat)
	 * @param hexWidth La longeur d'un hexagone
	 */
	private void createFlatHex(int hexWidth) {
		this.hexagons = new ArrayList<>();

		float height = (float) sqrt(3) * hexWidth;
		float distHorizontal = hexWidth * 1.5f;

		for (int col = 0; col < (WIDTH / distHorizontal); col++) {
			for (int row = 0; row < (HEIGHT / height); row++) {
				int x = col - 16;
				int z = row - (col - (col & 1)) / 2;

				this.hexagons.add(
					new Hexagon(
						new Point2D.Double(
								distHorizontal * col,
								height * (row + ((col%2 == 0) ? 0 : 0.5f))),
						hexWidth,
						new Triplet(x, - x - z, z),
						Hexagon.FLAT)
				);
			}
		}
	}

	/**
	 * Créer les hexagons (mode vertical, pointus)
	 * @param hexWidth La longueur d'un hexagone
	 */
	private void createPointyHex(int hexWidth) {
		this.hexagons = new ArrayList<>();

		if (hexWidth < MIN_HEX_WIDTH || hexWidth > MAX_HEX_WIDTH)
			return;

		float width = (float) sqrt(3) * hexWidth;
		float distVertical = hexWidth * 1.5f;

		float colNumber = WIDTH / width;
		float rowNumber = HEIGHT / distVertical;

		for (int col = 0; col < colNumber; col++) {
			for (int row = 0; row < rowNumber; row++) {
				int x = col - (row - (row & 1)) / 2 - 9;
				int z = row - 9;

				this.hexagons.add(
					new Hexagon(
						new Point2D.Double(
							width * (col + ((row % 2 == 0) ? 0 : 0.5f)),
							distVertical * row),
						hexWidth,
						new Triplet(x, - x - z, z),
						Hexagon.POINTY)
				);
			}
		}
	}

	/**
	 * Ajoute <i>widthToAdd</i> à la longueur des hexagones
	 */
	public void addHexWidth(int widthToAdd) {
		int newWidth = this.hexagons.get(0).getHexWidth() + widthToAdd;

		if (newWidth >= MIN_HEX_WIDTH && newWidth <= MAX_HEX_WIDTH)
			if (this.hexagons.get(0).getOrientation())
				this.createFlatHex(newWidth);
			else
				this.createPointyHex(newWidth);
	}

	/**
	 * Tourne le plateau de 30°
	 */
	public void rotate() {
		int oldWidth = this.hexagons.get(0).getHexWidth();

		if (this.hexagons.get(0).getOrientation())
			this.createPointyHex(oldWidth);
		else
			this.createFlatHex(oldWidth);
	}

	/**
	 * Getter de l'unique instance du plateau
	 * @return CL'unique instance du plateau
	 */
	public static Board getInstance() {
		return instance;
	}

	/**
	 * Getter des hexagones du plateau
	 * @return Les haxagones du plateau
	 */
	public List<Hexagon> getHexagons() {
		return this.hexagons;
	}

	/**
	 * Getter d'un hexagone contenant le point passé en paramètre
	 * @param point Un point de la fenêtre dont on veut l'hexagone
	 * @return CL'hexagone contenant le point, null si aucun hexagone ne le contient
	 */
	public Hexagon getHexagon(Point point) {
		return this.hexagons.stream()
				.filter(h -> h.contains(point))
				.findFirst()
				.orElse(null);
	}

	/**
	 * Getter d'un hexagone en fonction des coordonnées passées en paramètre
	 * @param coords Des coordonnées dont on veut l'hexagone
	 * @return CL'hexagone ayant les mêmes coordonnées, null si aucun hexagone n'a ces coordonnées
	 */
	public Hexagon getHexagon(Triplet coords) {
		return this.hexagons.stream()
				.filter(h -> coords.equals(h.getCoords()))
				.findFirst()
				.orElse(null);
	}

	/**
	 * Getter de la distance entre deux hexagones
	 * @param from CL'hexagone de départ
	 * @param to CL'hexagone d'arriver
	 * @return La distance entre les hexagones
	 */
	public int getDist(Hexagon from, Hexagon to) {
		Triplet fromCoords = from.getCoords();
		Triplet toCoords = to.getCoords();

		return (abs(fromCoords.getX() - toCoords.getX())
				+ abs(fromCoords.getY() - toCoords.getY())
				+ abs(fromCoords.getZ() - toCoords.getZ())) / 2;
	}

	/**
	 * Dessine une ligne entre deux hexagones
	 * @param from CL'hexagone de départ
	 * @param to CL'hexagone d'arriver
	 */
	public void drawLine(Hexagon from, Hexagon to) {
		Graphics2D g2 = (Graphics2D) this.getGraphics();

		g2.setColor(Color.BLACK);
		g2.drawLine(
				(int) from.getCenter().getX(),
				(int) from.getCenter().getY(),
				(int) to.getCenter().getX(),
				(int) to.getCenter().getY());
	}
}
