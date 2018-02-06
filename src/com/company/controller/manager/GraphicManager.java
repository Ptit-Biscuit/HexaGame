package com.company.controller.manager;

import com.company.model.enums.TileType;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Manager of the tiles
 */
interface GraphicManager<T> {
	/**
	 * Adding a tile to the tileset
	 * @param name The name of the tile
	 * @param tile The tile
	 */
	void addTile(T name, BufferedImage tile);

	/**
	 * Getter of a tile
	 * @param name The name of the tile
	 * @return The tile if found by name, null otherwise
	 */
	BufferedImage getTile(T name);

	/**
	 * Parse a tileset in a file and initialize all the tiles
	 * @param tilesetFile The file containing the tileset
	 * @param width The width of a tile
	 * @param names The names of the tiles
	 */
	void parsePicture(InputStream tilesetFile, int width, ArrayList<T> names);

	/**
	 * Parse a tileset in a file and initialize all the tiles
     * @param tilesetFile The file containing the tileset
     * @param width The width of a tile
     * @param height The height of a tile
     * @param names The names of the tiles
     */
	void parsePicture(InputStream tilesetFile, int width, int height, ArrayList<T> names);
}
