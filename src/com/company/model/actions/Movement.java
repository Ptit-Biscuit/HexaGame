package com.company.model.actions;

import com.company.model.Tile;
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
	public static Boolean isValidMove(Leader leader, ArrayList<Tile> tileList) {
		for (Tile tile:tileList) {
			List<Triplet> neighbors = Triplet.getNeighbors(leader.getGhostPosition().getCoordinates());
			if (neighbors.contains(tile.getCoordinates())){
				leader.setGhostPosition(tile);
				leader.setGhostMP(leader.getGhostMP()-1);
				if(leader.getGhostMP()<0){
					return false;
				}
			} else {
				return false;
			}
		}
		System.out.println(leader.getGhostMP());
		return true;
	}

	public static void move(Leader leader){
		leader.getPosition().removeUnit(leader);
		leader.setMP(leader.getGhostMP());
		leader.setPosition(leader.getGhostPosition());
		leader.getPosition().setUnits(leader);

		for (Fighter fighter:leader.getFightersList()) {
			fighter.getPosition().removeUnit(fighter);
			fighter.setMP(leader.getMP());
			fighter.setPosition(leader.getPosition());
			fighter.getPosition().setUnits(fighter);
		}

	}

}