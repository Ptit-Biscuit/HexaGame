package com.company.model.managers;

/**
 * Manager of the tiles
 */
public class UnitManager extends GraphicManager {
	/**
	 * Unique instance of UnitManager (Singleton Pattern)
	 */
    private static UnitManager instance = new UnitManager();

	/**
	 * Default constructor
	 */
	private UnitManager() {  }

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
