package com.company.listener;

import com.company.model.Board;
import com.company.system.Hexagon;
import com.company.system.Triplet;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BoardListener implements MouseListener, MouseMotionListener {
	/**
	 * CL'unique instance du plateau
	 */
	private Board board = Board.getInstance();

	/**
	 * Le dernier hexagone survolé
	 */
	private Hexagon lastHovered;

	/**
	 * Les derniers hexagones cliqués
	 */
	private List<Hexagon> lastClicked = new ArrayList<>();

	/**
	 * Setter du theme de l'hexagone survolé ou cliqué
	 * ainsi que du thème de ses voisins
	 *
	 * @param hex CL'hexagone actuellement survolé ou cliqué
	 * @param themeForHex Le thème pour l'hexagone actuel
	 * @param themeForNeighbors Le thème pour les voisins de l'hexagone actuel
	 */
	private void setHexTheme(Hexagon hex, int themeForHex, int themeForNeighbors) {
		hex.setTheme(themeForHex);
		hex.getNeighbors().stream()
			.map(n -> this.board.getHexagon(n))
			.filter(Objects::nonNull)
			.forEach(h -> h.setTheme(themeForNeighbors));
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Hexagon current = this.board.getHexagons().stream()
			.filter(h -> h.contains(e.getPoint()))
			.findFirst()
			.orElse(null);

		if (current != null && SwingUtilities.isRightMouseButton(e)) {
			this.lastClicked.add(current);
			current.setTheme(4);
		}

		this.board.getParent().repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		boolean changed = false;
		Hexagon current = this.board.getHexagons().stream()
				.filter(h -> h.contains(e.getPoint()))
				.findFirst()
				.orElse(null);

		if (this.lastHovered != current) {
			changed = true;

			if (this.lastHovered != null)
				this.setHexTheme(this.lastHovered, 0, 0);

			if (current != null)
				this.setHexTheme(current, 1, 2);
		}

		this.lastHovered = current;

		this.lastClicked.forEach(
			lc -> lc.setTheme(4)
		);

		this.board.getHexagon(new Triplet(0, 0, 0)).setTheme(5);

		if (changed)
			this.board.getParent().repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Hexagon current = this.board.getHexagons().stream()
				.filter(h -> h.contains(e.getPoint()))
				.findFirst()
				.orElse(null);

		if (current != null && SwingUtilities.isRightMouseButton(e)) {
				this.setHexTheme(current, 4, 0);
			this.lastClicked.add(current);
		}
		/*else if (SwingUtilities.isMiddleMouseButton(e)) {
			current.reset();
		}*/

		this.board.getParent().revalidate();
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
