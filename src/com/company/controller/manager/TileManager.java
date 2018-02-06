package com.company.controller.manager;

import com.company.model.enums.TileType;
import org.apache.logging.log4j.LogManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Manager of the tiles
 */
public class TileManager implements GraphicManager<TileType> {
	/**
	 * Unique instance of TileManager (Singleton Pattern)
	 */
    private static TileManager instance = new TileManager();

	/**
	 * Tileset containing all the tiles
	 */
	private HashMap<TileType, BufferedImage> tileset = new HashMap<>(); // (Tilename, Tile)

	/**
	 * Default constructor
	 */
	private TileManager() {
	}

	@Override
	public void addTile(TileType name, BufferedImage tile) {
		tileset.put(name, tile);
	}

	@Override
	public BufferedImage getTile(TileType name) {
		return tileset.get(name);
	}

	@Override
	public void parsePicture(InputStream tilesetFile, int width, ArrayList<TileType> names) {
		parsePicture(tilesetFile, width, width, names);
	}

	@Override
	public void parsePicture(InputStream tilesetFile, int width, int height, ArrayList<TileType> names) {
		try {
			BufferedImage tilemap = ImageIO.read(tilesetFile);
			int xmax = tilemap.getWidth() / width;
			int ymax = tilemap.getHeight() / height;

			for (int x = 0; x < xmax; ++x)
				for (int y = 0; y < ymax; ++y) {
					TileType name = names.get(y + x * ymax);
					if (name != null)
						tileset.put(name, tilemap.getSubimage(x * width, y * height, width, height));
				}
		} catch (IOException e) {
			LogManager.getLogger(GraphicManager.class).error(e.getMessage());
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
