package com.company.utils;

public class AttackUtil {


	int[][] missile = new int[][]{
			{3, 2, 2, 1, 1, 1, 1, 1, 1},
			{0, 3, 3, 2, 2, 1, 1, 1, 1},
			{0, 0, 3, 3, 2, 2, 1, 1, 1},
			{0, 0, 0, 3, 3, 2, 2, 1, 1},
			{0, 0, 0, 0, 3, 3, 2, 2, 1},
			{0, 0, 0, 0, 0, 3, 3, 2, 2},
			{0, 0, 0, 0, 0, 0, 3, 3, 2},
			{0, 0, 0, 0, 0, 0, 0, 3, 3}
	};

	int[][] melee = new int[][]{
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

	int[][] moral = new int[][]{
			{3, 3, 4, 2, 1, 0, 0, 0},
			{4, 3, 4, 2, 2, 1, 0, 0},
			{4, 4, 4, 3, 2, 1, 1, 0}
	};

	public int[][] getMissileTable(){
		return this.missile;
	}
	public int[][] getMeleeTable(){
		return this.melee;
	}
	public int[][] getMoralTable(){
		return this.moral;
	}

}
