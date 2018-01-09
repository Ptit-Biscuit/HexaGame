package com.company.system;

public class Triplet {
	/**
	 * Coord x
	 */
	private int x = 0;

	/**
	 * Coord y
	 */
	private int y = 0;

	/**
	 * Coord z
	 */
	private int z = 0;

	/**
	 * Constructeur
	 * @param x Coord x
	 * @param y Coord y
	 * @param z Coord z
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
	 * @param x Nouveau x
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
	 * @param y Nouveau y
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
	 * @param z Nouveau z
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

		if (x != triplet.x) return false;
		if (y != triplet.y) return false;
		return z == triplet.z;
	}
}
