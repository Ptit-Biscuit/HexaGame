package com.company.model.actions;

import java.util.concurrent.ThreadLocalRandom;

public class DiceRoll {
	int result = 0;

	/**
	 * GConstructor of the dic
	 *
	 * @param size Size of the dice to roll
	 */
	public DiceRoll(int size){
		result = ThreadLocalRandom.current().nextInt(1, size + 1);
	}

	/**
	 * Getter of the roll
	 *
	 * @return The result of the dice
	 */
	public int getDiceRoll(){
		return result;
	}
}
