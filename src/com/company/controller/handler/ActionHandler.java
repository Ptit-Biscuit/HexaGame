package com.company.controller.handler;

import com.company.model.Board;
import com.company.model.actions.Attack;
import com.company.model.actions.Movement;
import com.company.model.units.Army;
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
						Movement.move(board.getArmyToMove());
						board.addArmyMoved(board.getArmyToMove());
						board.emptyPath();
						board.setArmyToMove(null);
						System.out.println("mouvement effectué");
					} else {
						board.emptyPath();
						board.setArmyToMove(null);
						System.out.println("Mouvement non valide");
					}
					board.setSelectArmy(true);
					System.out.println("Selection armée");
				}
			} else {
				//combat
				if (board.isSelectArmy()) {
					// chose the army
					board.setSelectArmy(false);
					System.out.println("Selection armée ennemie");
				} else {
					//chose the enemy
					board.setSelectArmy(true);

					//launch the battle
					if (board.getAttackers() != null && board.getDefenders() != null) {
						System.out.println("Bataille entre :");

						Attack.initAttack(Board.getInstance().getAttackers(), Board.getInstance().getDefenders().getArmy());

						//call Attack function
						System.out.println(board.getAttackers().toString());
						System.out.println(board.getAttackers().toString());


						//reset to null
						board.setAttackers(null);
						board.setDefenders(null);
					} else {
						System.out.println("Pas de bataille ...");
					}
					System.out.println("Selection armée alliée");
				}
			}

			if (board.getPhase() == 5) {
				System.out.println("Appuyez sur espace pour finir le tour");
			}
		}

		if (event.getCode() == KeyCode.P) {
			Board board = Board.getInstance();
			board.setPhase(board.getPhase() + 1);
			if (board.getPhase() == 1 || board.getPhase() == 3) {
				System.out.println("phase de mouvement");
			} else if (board.getPhase() == 2 || board.getPhase() == 4) {
				System.out.println("phase de combat");
				System.out.println("selection armée alliée");
			} else {
				System.out.println("fin du tour");
				board.setNbTurns(board.getNbTurns() + 1);
				board.setPhase(1);
				//reset army mp
				for (Army armyMoved : board.getArmyMoved()) {
					armyMoved.setGhostMP(10);
					armyMoved.setMP(10);
				}
				board.emptyArmyMoved();
				System.out.println("phase de mouvement");
			}
			board.setSelectArmy(true);
		}
	}
}
