package com.company.utils;

public class Triplet {
	/**
	 * Coordinate x
	 */
	private int x = 0;

	/**
	 * Coordinate y
	 */
	private int y = 0;

	/**
	 * Coordinate z
	 */
	private int z = 0;

	/**
	 * Constructor
	 * @param x Coordinate x
	 * @param y Coordinate y
	 * @param z Coordinate z
	 */
	public Triplet(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Getter x
	 * @return x
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Setter x
	 * @param x New x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Getter y
	 * @return y
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Setter y
	 * @param y New y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Getter z
	 * @return z
	 */
	public int getZ() {
		return this.z;
	}

	/**
	 * Setter z
	 * @param z New z
	 */
	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return x + " " + y + " " + z;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Triplet triplet = (Triplet) o;

		return x == triplet.x && y == triplet.y && z == triplet.z;
	}
}
