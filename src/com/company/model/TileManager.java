package com.company.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Manager of the tiles
 * @param
 */
public class TileManager {
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
	private HashMap<TileType, BufferedImage> tileset = new HashMap<>(); // (Tilename, Tile)

	/**
	 * Adding a tile to the tileset
	 * @param name The name of the tile
	 * @param tile The tile
	 */
    public void addTile(TileType name, BufferedImage tile){
        tileset.put(name, tile);
    }

	/**
	 * Getter of a tile
	 * @param name The name of the tile
	 * @return The tile if found by name, null otherwise
	 */
	public BufferedImage getTile(TileType name){ return tileset.get(name); }

	/**
	 * Parse a tileset in a file and initialize all the tiles
	 * @param tilesetFile The file containing the tileset
	 * @param width The width of a tile
	 * @param names The names of the tiles
	 */
	public void parsePicture(File tilesetFile, int width, ArrayList<TileType> names) { parsePicture(tilesetFile, width, width, names); }

	/**
	 * Parse a tileset in a file and initialize all the tiles
	 * @param tilesetFile The file contaning the tileset
	 * @param width The width of a tile
	 * @param height The height of a tile
	 * @param names The names of the tiles
	 */
    public void parsePicture(File tilesetFile, int width, int height, ArrayList<TileType> names){
        try {
            BufferedImage tilemap = ImageIO.read(tilesetFile);
            int xmax = tilemap.getWidth() / width;
            int ymax = tilemap.getHeight() / height;

            for (int x = 0; x < xmax; ++x)
            	for (int y = 0; y < ymax; ++y) {
					System.out.println(y + x * ymax);
					TileType name = names.get(y + x * ymax);
                	if(name != null)
	                    tileset.put(name, tilemap.getSubimage(x * width, y * height, width, height));
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
		if(instance == null)
			instance = new TileManager();
		return instance;
	}
}
