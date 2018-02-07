package com.company.model.actions;

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
					default: mpCost = 1;
						break;
				}
				army.setGhostMP(army.getGhostMP()-mpCost);
				if(army.getGhostMP()<0){
					return false;
				}
			} else {
				return false;
			}
		}
		System.out.println(army.getGhostMP());
		return true;
	}

	public static void move(Army army){
        //move the army
        army.setMP(army.getGhostMP());
        army.setPosition(army.getGhostPosition());

	    //move the leader
		Leader leader = army.getLeader().get(0);
		//leader.getPosition().removeUnit(leader);
        leader.setMP(army.getMP());
        leader.setPosition(army.getPosition());
		//leader.getPosition().setUnits(leader);

		//move the fighters
		for (Fighter fighter:army.getFighters()) {
			//fighter.getPosition().removeUnit(fighter);
			fighter.setMP(army.getMP());
			fighter.setPosition(army.getPosition());
			//fighter.getPosition().setUnits(fighter);
		}

	}

}