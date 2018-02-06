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
			{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2},
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
	public static int[][] getMissileTable(){
		return missile;
	}

	/**
	 *
	 * @return
	 */
	public static int[][] getMeleeTable(){
		return melee;
	}

	/**
	 *
	 * @return
	 */
	public static int[][] getMoralTable(){
		return moral;
	}
}
