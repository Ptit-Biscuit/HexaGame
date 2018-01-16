package com.company.model.managers;

/**
 * Manager of the tiles
 */
public class TileManager extends GraphicManager {
	/**
	 * Unique instance of TileManager (Singleton Pattern)
	 */
    private static TileManager instance = new TileManager();

	/**
	 * Default constructor
	 */
	private TileManager() {  }

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
