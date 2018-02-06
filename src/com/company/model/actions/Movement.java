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
			List<Triplet> neighbors = leader.getGhostPosition().getNeighbors();
			if (neighbors.contains(tile.getCoords())){
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
		leader.setMP(leader.getGhostMP());
		leader.setPosition(leader.getGhostPosition());

		for (Fighter fighter:leader.getFightersList()) {
			fighter.setMP(leader.getMP());
			fighter.setPosition(leader.getPosition());
		}

	}

}