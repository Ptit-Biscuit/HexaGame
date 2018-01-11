package com.company.model;

public class MapManager {
    private static MapManager ourInstance = new MapManager();

    public static MapManager getInstance() {
        return ourInstance;
    }

    // 0 = Mountain
    // 1 = Plain
    // 2 = Hill
    // 3 = Forest
    // 5 = Lake
    // 6 = City
    // 7 = Ruin
    // 8 = Keep

    private MapManager() {

    }
}
