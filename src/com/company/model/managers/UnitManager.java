package com.company.model.managers;

import com.company.model.enums.UnitType;
import org.apache.logging.log4j.LogManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Manager of the tiles
 */
public class UnitManager implements GraphicManager<UnitType> {
	/**
	 * Unique instance of UnitManager (Singleton Pattern)
	 */
    private static UnitManager instance = new UnitManager();

	/**
	 * Tileset containing all the tiles
	 */
	private HashMap<UnitType, BufferedImage> tileset = new HashMap<>(); // (Tilename, Tile)

	/**
	 * Default constructor
	 */
	private UnitManager() {
	}

	@Override
	public void addTile(UnitType name, BufferedImage tile) {
		tileset.put(name, tile);
	}

	@Override
	public BufferedImage getTile(UnitType name) {
		return tileset.get(name);
	}

	@Override
	public void parsePicture(File tilesetFile, int width, ArrayList<UnitType> names) {
		parsePicture(tilesetFile, width, width, names);
	}

	@Override
	public void parsePicture(File tilesetFile, int width, int height, ArrayList<UnitType> names) {
		try {
			BufferedImage tilemap = ImageIO.read(tilesetFile);
			int xmax = tilemap.getWidth() / width;
			int ymax = tilemap.getHeight() / height;

			for (int x = 0; x < xmax; ++x)
				for (int y = 0; y < ymax; ++y) {
					UnitType name = names.get(y + x * ymax);
					if (name != null)
						tileset.put(name, tilemap.getSubimage(x * width, y * height, width, height));
				}
		} catch (IOException e) {
			LogManager.getLogger(com.company.model.managers.GraphicManager.class).error(e.getMessage());
		}
	}

	/**
	 * Complementary method of singleton pattern
	 * @return The unique instance of UnitManager
	 */
	public static UnitManager getInstance() {
		if(instance == null)
			instance = new UnitManager();
		return instance;
	}
}
