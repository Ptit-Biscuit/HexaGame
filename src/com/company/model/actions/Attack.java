package com.company.model.actions;

import com.company.model.Tile;
import com.company.model.units.Army;

public class Attack {

	public void initAttack(Tile location, Army defenser){
		if (!validLocation(location)){
			return;
		}
		attack(location.getArmy(), defenser);
	}

	public Boolean validLocation(Tile location){
		Boolean result = true;
		if(location.getUnits().isEmpty()){
			result = false;
		}
		/*for (Tile neighbour : location.getNeighbours()) {
			if(neighbour.getUnits().isEmpty()){
				result = false;
			}
		}*/
		return result;
	}

	public void attack(Army attacker, Army defenser){
		if(defenser.getMissileValue() > attacker.getArmorValue()){
			attacker.decreaseMoral(defenser.getMissileValue());
		}
		if(attacker.getMissileValue() > defenser.getArmorValue()){
			defenser.decreaseMoral(attacker.getMissileValue());
		}
		if(attacker.getMeleeValue() > defenser.getMeleeValue()){
			defenser.decreaseMoral(attacker.getMeleeValue());
		}
		if(defenser.getMeleeValue() > attacker.getMeleeValue()){
			attacker.decreaseMoral(defenser.getMeleeValue());
		}
	}
}
