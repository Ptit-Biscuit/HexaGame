package com.company.model;

import com.company.utils.Triplet;
import javafx.util.Pair;

import java.util.HashMap;

/**
 *
 */
public class Board {
    /**
     *
     */
    private static Board ourInstance = null;

    /**
     *
     * @return
     */
    public static Board getInstance() {
        if(ourInstance == null)
            return new Board();
        return ourInstance;
    }

    /**
     *
     */
    private HashMap<Triplet, Tile> tiles = new HashMap<>();

    /**
     *
     */
    private Board() {
        ourInstance = this;

        Pair<Integer, Integer> size = Map.getMapSize();

        for (int col = 0; col < size.getValue(); col++) {
            for (int row = 0; row < size.getKey(); row++) {
                Triplet coordinates = new Triplet(row, col, -row - col);


                Tile tile = new Tile();
                tile.setType(Map.get(row, col));
                // tile.setCostMP(costMP.getOrDefault(tile.getType(), 1));
                tile.setForest(Map.getForest(row, col));
                tile.setRiver(Map.getRiver(row, col));
                // tile.setBridge();
                // tile.setRoad();
                // tile.setEntrance();

                tiles.put(coordinates, tile);
            }
        }
    }

    /**
     *
     * @return
     */
    public HashMap<Triplet, Tile> getTiles() {
        return tiles;
    }

    /**
     *
     * @param coordinate
     * @return
     */
    public Tile getTile(Triplet coordinate) {
        return tiles.get(coordinate);
    }

}
