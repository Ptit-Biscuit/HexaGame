package com.company.model;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @param <T>
 */
public class TileManager <T> {
	/**
	 * Unique intance of TileManager (Singleton Pattern)
	 */
    private static TileManager instance = new TileManager();

	/**
	 * Default constructor
	 */
	private TileManager() {  }

	/**
	 * Tileset containing all the tiles
	 */
	private HashMap<T, Tile> tileset = new HashMap<>(); // (Tilename, Tile)

	/**
	 *
	 * @param name
	 * @param tile
	 */
    public void addTile(T name, Tile tile){
        tileset.put(name, tile);
    }

	/**
	 *
	 * @param name
	 * @return
	 */
	public Tile getTile(T name){ return tileset.get(name); }

	/**
	 *
	 * @param tilesetFile
	 * @param width
	 * @param names
	 */
	public void parsePicture(File tilesetFile, int width, ArrayList<T> names) { parsePicture(tilesetFile, width, width, names); }

	/**
	 * Parse a tileset file and initilize all the tiles
	 * @param tilesetFile
	 * @param width
	 * @param height
	 * @param names
	 */
    public void parsePicture(File tilesetFile, int width, int height, ArrayList<T> names){
        try {
            BufferedImage tilemap = ImageIO.read(tilesetFile);
            int xmax = tilemap.getWidth() / width;
            int ymax = tilemap.getHeight() / height;

            for (int x = 0; x < xmax; ++x) for (int y = 0; y < ymax; ++y) {
                T name = names.get(x + y * xmax);
                if(name != null)
                    tileset.put(name, new Tile(tilemap.getSubimage(x * width, y * height, width, height)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/**
	 * Complementary method of singleton pattern
	 * @return The unique instance of TileManager
	 */
	public static TileManager getInstance() {
		return instance;
	}
}
