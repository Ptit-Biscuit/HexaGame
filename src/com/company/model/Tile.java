package com.company.model;

import java.awt.image.BufferedImage;

/**
 * Tile of the map
 */
public class Tile {
	/**
	 * Image representing the tile
	 */
    public BufferedImage tile;

	/**
	 * Type of the tile
	 */
	private TileType type;

	/**
	 * River on the tile
	 */
	private Facing river[];

	/**
	 * Road on the tile
	 */
	private Facing road[];

	/**
	 * Forest on the tile
	 */
	private Facing forest[];

	/**
	 * Entrance on the tile (Moutain only)
	 */
	private Facing entrance[];

	/**
	 * Bridge on the tile
	 */
	private Facing bridge[];

	/**
	 * Constructor
	 * @param subimage Image representing the tile
	 */
	public Tile(BufferedImage subimage) {
        tile = subimage;
    }

	/**
	 * Getter of the type
	 * @return The type
	 */
	public TileType getType() {
		return this.type;
	}

	/**
	 * Setter of the type
	 * @param type The new type
	 */
	public void setType(TileType type) {
		this.type = type;
	}

	/**
	 * Getter of the tile
	 * @return The tile
	 */
	public BufferedImage getTile() {
		return this.tile;
	}

	/**
	 * Setter of the tile
	 * @param tile The new tile
	 */
	public void setTile(BufferedImage tile) {
		this.tile = tile;
	}

	/**
	 * Getter of the orientation of the river
	 * @return The orientation of the river
	 */
	public Facing[] getRiver() {
		return this.river;
	}

	/**
	 * Setter of the orientation of the river
	 * @param river The new orientation of the river
	 */
	public void setRiver(Facing[] river) {
		this.river = river;
	}

	/**
	 * Getter of the orientation of the road
	 * @return The orientation of the road
	 */
	public Facing[] getRoad() {
		return this.road;
	}

	/**
	 * Setter of the orientation of the road
	 * @param road The new orientation of the road
	 */
	public void setRoad(Facing[] road) {
		this.road = road;
	}

	/**
	 * Getter of the orientation of the forest
	 * @return The orientation of the forest
	 */
	public Facing[] getForest() {
		return this.forest;
	}

	/**
	 * Setter of the orientation of the forest
	 * @param forest The new orientation of the forest
	 */
	public void setForest(Facing[] forest) {
		this.forest = forest;
	}

	/**
	 * Getter of the orientation of the entrance
	 * @return The orientation of the entrance
	 */
	public Facing[] getEntrance() {
		return this.entrance;
	}

	/**
	 * Setter of the orientation of the entrance
	 * @param entrance The new orientation of the entrance
	 */
	public void setEntrance(Facing[] entrance) {
		this.entrance = entrance;
	}

	/**
	 * Getter of the orientation of the bridge
	 * @return The orientation of the bridge
	 */
	public Facing[] getBridge() {
		return this.bridge;
	}

	/**
	 * Setter of the orientation of the bridge
	 * @param bridge The new orientation of the bridge
	 */
	public void setBridge(Facing[] bridge) {
		this.bridge = bridge;
	}
}
