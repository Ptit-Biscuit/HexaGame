package com.company.model.actions;

import com.company.Main;
import com.company.model.Board;
import com.company.model.Tile;
import com.company.model.units.Army;
import com.company.model.units.Fighter;
import com.company.model.units.Leader;
import com.company.utils.Triplet;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Movement represent a movement
 */
public class Movement {

	/**
	 *
	 * @param tileList
	 * @return If the movement is valid
	 */
	public static Boolean isValidMove(Army army, ArrayList<Tile> tileList) {
		int mpCost = 1;
		if (army == null){
			return false;
		}
		if (tileList.isEmpty()){
			return false;
		}
		army.setGhostPosition(army.getPosition());
		army.setGhostMP(army.getMP());
		for (Tile tile:tileList) {
			List<Triplet> neighbors = Triplet.getNeighbors(army.getGhostPosition().getCoordinates());
			if (neighbors.contains(tile.getCoordinates())){
				army.setGhostPosition(tile);
				//define the cost of the Tile
				switch (tile.getType()){
					case FOREST:  mpCost = 3;
						break;
					case HILL:  mpCost = 2;
						break;
					case HILL_2:  mpCost = 2;
						break;
					case LAKE:
						return false;
					default: mpCost = 1;
						break;
				}
				army.setGhostMP(army.getGhostMP()-mpCost);
				if(army.getGhostMP()<0){
					army.setGhostMP(army.getMP());
					army.setGhostPosition(army.getPosition());
					return false;
				}
			} else {
				army.setGhostMP(army.getMP());
				army.setGhostPosition(army.getPosition());
				return false;
			}
		}
		return true;
	}

	public static boolean move(Army army, ArrayList<Tile> tileList) {
		if (isValidMove(army, tileList)) {
			//move the army
			army.setMP(army.getGhostMP());
			Tile oldPosition = army.getPosition();
			army.setPosition(army.getGhostPosition());

			//move the leader
			Leader leader = army.getLeader().get(0);
			leader.setMP(army.getMP());
			leader.setPosition(army.getPosition());

			//move the fighters
			for (Fighter fighter : army.getFighters()) {
				fighter.setMP(army.getMP());
				fighter.setPosition(army.getPosition());
			}

			//move image
			Tile newLocation = Board.getInstance().getTile(army.getPosition().getCoordinates());
			army.setPosition(newLocation);
			newLocation.setArmy(army);
			oldPosition.removeArmy();
			Main.update();


			return true;
		} else {
			return false;
		}

	}

}