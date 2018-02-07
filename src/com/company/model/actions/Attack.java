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
	public static void initAttack(Tile location, Army defenders){
		if (!validLocation(location)) {
			return;
		}
		attackCycle(location.getArmy(), defenders);
	}

	/**
	 * Verify if the location to fight is correct
	 *
	 * @return True if the location is correct, else false
	 */
	public static Boolean validLocation(Tile location){
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
	public static void attackCycle(Army attackers, Army defenders){
		attack(defenders, attackers, "missile");
		attack(attackers,defenders,"missile");
		attack(attackers,defenders,"melee");
		attack(defenders,attackers,"melee");
	}

	/**
	 * Method used to check the battle actions
	 *
	 */
	public static void attack(Army attackers, Army defenders, String type){

		switch (type) {
			case ("missile"):
				int armorCheck = AttackUtil.getMissileTable(new DiceRoll(8).getDiceRoll(), defenders.getMissileValue());
				defenders.getFighters().forEach(defender -> {
					if (defender.getArmor() >= armorCheck) {
						checkMoral(defender);
					}
				});
				break;
			case ("melee"):
				int meleeCheck = AttackUtil.getMissileTable(attackers.getMeleeValue(), defenders.getMeleeValue());
				defenders.getFighters().forEach(defender -> {
					if (new DiceRoll(8).getDiceRoll() >= meleeCheck) {
						checkMoral(defender);
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
	public static int checkMoral(Fighter fighter){
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
