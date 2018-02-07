package com.company.model.actions;

import com.company.model.Tile;
import com.company.model.units.Army;
import com.company.model.units.Fighter;
import com.company.utils.AttackUtil;

public class Attack {

	public void initAttack(Tile location, Army defenser){
		if (!validLocation(location)){
			return;
		}
		//attack(location.getArmy(), defenser);
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

	public void attack(Army attackers, Army defensers, String type){
		int moralValue = 0;

		switch (type) {
			case ("missile"):
				int armorCheck = AttackUtil.getMissileTable(new DiceRoll(8).getDiceRoll(), defensers.getMissileValue());
				defensers.getFighters().forEach(defenser -> {
					if (defenser.getArmor() >= armorCheck) {
						checkMoral(defenser);
					}
				});
				break;
			case ("melee"):
				int meleeCheck = AttackUtil.getMissileTable(attackers.getMeleeValue(), defensers.getMeleeValue());
				defensers.getFighters().forEach(defenser -> {
					if (new DiceRoll(8).getDiceRoll() >= meleeCheck) {
						checkMoral(defenser);
					}
				});
				break;
		}
	}

	public int checkMoral(Fighter fighter){
		int moralClass = 0;
		if(fighter.getMoral() == "A"){
			moralClass = 0;
		}
		if(fighter.getMoral() == "B"){
			moralClass = 1;
		}
		if(fighter.getMoral() == "C"){
			moralClass = 2;
		}
		return AttackUtil.getMissileTable(moralClass, new DiceRoll(8).getDiceRoll());
	}
}
