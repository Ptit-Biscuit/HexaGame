package com.company.model.actions;

import com.company.model.Tile;
import com.company.model.units.Army;
import com.company.model.units.Fighter;
import com.company.utils.AttackUtil;
import com.company.utils.Triplet;

public class Attack {

	/**
	 * Supposed to init the attack, Todo
	 *
	 */
	public void initAttack(Tile location, Army defensers){
		if (!validLocation(location)) {
			return;
		}
		attackCycle(location.getArmy(), defensers);
	}

	/**
	 * Verify if the location to fight is correct
	 *
	 * @return True if the location is correct, else false
	 */
	public Boolean validLocation(Tile location){
		if(location.getUnits().isEmpty()){
			return false;
		}
		if (Triplet.getNeighbors(location.getCoordinates()).isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * Method used to cycle the attacks
	 *
	 */
	public void attackCycle(Army attackers, Army defensers){
		attack(defensers, attackers, "missile");
		attack(attackers,defensers,"missile");
		attack(attackers,defensers,"melee");
		attack(defensers,attackers,"melee");
	}

	/**
	 * Method used to check the battle actions
	 *
	 */
	public void attack(Army attackers, Army defensers, String type){

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

	/**
	 * Method used to check the result of a moral decay
	 *
	 * @return The moral result
	 */
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
