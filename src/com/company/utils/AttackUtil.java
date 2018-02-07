package com.company.utils;

/**
 *
 */
public class AttackUtil {
	/**
	 *
	 */
	private static int[][] missile = new int[][]{
			{3, 2, 2, 1, 1, 1, 1, 1, 1},
			{0, 3, 3, 2, 2, 1, 1, 1, 1},
			{0, 0, 3, 3, 2, 2, 1, 1, 1},
			{0, 0, 0, 3, 3, 2, 2, 1, 1},
			{0, 0, 0, 0, 3, 3, 2, 2, 1},
			{0, 0, 0, 0, 0, 3, 3, 2, 2},
			{0, 0, 0, 0, 0, 0, 3, 3, 2},
			{0, 0, 0, 0, 0, 0, 0, 3, 3}
	};

	/**
	 *
	 */
	private static int[][] melee = new int[][]{
			{2, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8},
			{1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8},
			{1, 1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 7},
			{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5},
			{0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4},
			{0, 0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4},
			{0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3},
			{0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2},
			{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2},
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2}
	};

	/**
	 *
	 */
	private static int[][] moral = new int[][]{
			{3, 3, 4, 2, 1, 0, 0, 0},
			{4, 3, 4, 2, 2, 1, 0, 0},
			{4, 4, 4, 3, 2, 1, 1, 0}
	};

	/**
	 *
	 * @return
	 */
	public static int getMissileTable(int dice, int attacker){
		int val = 0;
		if(attacker>1 && attacker<= 3){
			val = 0;
		}
		if(attacker>4 && attacker <=6){
			val = 1;
		}
		if (attacker>7 && attacker <= 9){
			val = 2;
		}
		if(attacker>10 && attacker <=12){
			val = 3;
		}
		if(attacker>13 && attacker <= 15){
			val = 4;
		}
		if(attacker>16 && attacker <= 18){
			val = 5;
		}
		if(attacker>19 && attacker <= 21){
			val = 6;
		}
		if(attacker>22 && attacker <= 24){
			val = 7;
		}
		if(attacker <= 25){
			val = 8;
		}

		return missile[dice][val];
	}

	/**
	 *
	 * @return
	 */
	public static int getMeleeTable(int target, int attacker){
		int val1 = 0;
		if(target>1 && target <= 3){
			val1 = 0;
		}
		if(target>4 && target <= 5){
			val1 = 1;
		}
		if(target>6 && target <= 8){
			val1 = 2;
		}
		if(target>9 && target <= 12){
			val1 = 3;
		}
		if(target>13 && target <= 15){
			val1 = 4;
		}
		if(target>16 && target <= 18){
			val1 = 5;
		}
		if(target>19 && target <= 21){
			val1 = 6;
		}
		if(target>22 && target <= 25){
			val1 = 7;
		}
		if(target>26 && target <= 28){
			val1 = 8;
		}
		if(target <= 29){
			val1 = 9;
		}

		int val2 = 0;
		if(attacker>1 && attacker <= 3){
			val2 = 0;
		}
		if(attacker==4){
			val2 = 1;
		}
		if(attacker==5){
			val2 = 2;
		}
		if(attacker>6 && attacker <= 7){
			val2 = 3;
		}
		if(attacker>8 && attacker <= 9){
			val2 = 4;
		}
		if(attacker>10 && attacker <= 12){
			val2 = 5;
		}
		if(attacker>13 && attacker <= 15){
			val2 = 6;
		}
		if(attacker>16 && attacker <= 18){
			val2 = 7;
		}
		if(attacker>19 && attacker <= 21){
			val2 = 8;
		}
		if(attacker>22 && attacker <= 25){
			val2 = 9;
		}
		if(attacker>26 && attacker <= 28){
			val2 = 10;
		}
		if(attacker <= 29){
			val2 = 11;
		}

		return melee[val1][val2];
	}

	/**
	 *
	 * @return
	 */
	public static int getMoralTable(int moralClass, int dice){
		return moral[moralClass][dice];
	}
}
