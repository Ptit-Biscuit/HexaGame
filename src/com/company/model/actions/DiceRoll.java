package com.company.model.actions;

import java.util.concurrent.ThreadLocalRandom;

public class DiceRoll {
	int result = 0;

	public DiceRoll(int size){
		result = ThreadLocalRandom.current().nextInt(1, size + 1);
	}

	public int getDiceRoll(){
		return result;
	}
}
