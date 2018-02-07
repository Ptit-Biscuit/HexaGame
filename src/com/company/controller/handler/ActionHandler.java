package com.company.controller.handler;

import com.company.model.Board;
import com.company.model.actions.Movement;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ActionHandler implements EventHandler<KeyEvent> {
	@Override
	public void handle(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {


			Board board = Board.getInstance();
			if (board.getPhase() % 2 == 1) {
				if (board.isSelectArmy()) {
					board.setSelectArmy(false);
					System.out.println("Selection chemin");
				} else {
					if (Movement.isValidMove(board.getArmyToMove(), board.getPath())) {
						Movement.move(board.getArmyToMove(), board.getPath());
					} else {
						System.out.println("Mouvement non valide");
					}
					board.setSelectArmy(true);
					System.out.println("Selection armée");
				}
			} else {
				//combat
				if (board.isSelectArmy()) {
					// chose the army
				} else {
					//chose the enemy
				}
			}

			if (board.getPhase() == 5) {
				System.out.println("Appuyez sur espace pour finir le tour");
			}
		}

		if (event.getCode() == KeyCode.SPACE) {
			Board board = Board.getInstance();
			board.setPhase(board.getPhase() + 1);
			if (board.getPhase() == 1 || board.getPhase() == 3) {
				System.out.println("phase de mouvement");
			} else if (board.getPhase() == 2 || board.getPhase() == 4) {
				System.out.println("phase de combat");
			} else {
				System.out.println("fin du tour");
				board.setNbTurns(board.getNbTurns() + 1);
				board.setPhase(1);
			}
			board.setSelectArmy(true);
		}
	}
}
