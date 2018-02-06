package com.company.model;

import com.company.model.enums.Facing;
import com.company.model.enums.TileType;
import javafx.util.Pair;

import static com.company.model.enums.TileType.*;

/**
 * Have a Map
 */
public class Map {
    /**
     * Map of the game
     */
    private static boolean[][] forest = new boolean[][]{
            new boolean[]{false, false, false, false, false, true,  true,  false, false, false, true,  true,  false, false, false, false, false, false, false, false, false, true,  true,  true,  true,  false},
            new boolean[]{false, false, false, false, true,  true,  true,  true,  false, false, false, false, false, false, true,  false, false, false, false, false, false, false, true,  true,  true,  false},
            new boolean[]{false, false, false, false, true,  true,  true,  false, true,  true,  false, false, false, false, true,  false, false, false, false, false, false, false, false, false, true,  false},
            new boolean[]{false, false, false, false, false, false, false, true,  false, true,  true,  false, false, false, true,  false, false, false, false, false, false, true,  false, false, false, true },
            new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, true,  false, false, false, true,  false, false, true,  true,  true,  false, false, false, true },
            new boolean[]{false, false, false, true,  true,  true,  false, false, false, false, true,  false, false, false, true,  true,  false, false, false, false, true,  false, true,  true,  true,  true },
            new boolean[]{false, false, false, false, true,  true,  false, true,  false, true,  true,  false, false, false, false, true,  false, false, false, false, false, false, true,  false, false, false},
            new boolean[]{false, false, false, false, true,  false, true,  true,  true,  true,  true,  false, false, false, false, false, true,  true,  false, false, false, false, false, true,  false, false},
            new boolean[]{false, false, false, true,  false, false, false, false, false, false, false, false, false, true,  false, false, false, true,  false, false, false, false, false, true,  false, false},
            new boolean[]{false, false, false, false, true,  true,  true,  false, false, false, false, false, false, false, true,  false, false, false, false, false, false, false, false, false, false, false},
            new boolean[]{false, false, false, false, false, true,  false, false, false, true,  true,  false, true,  false, false, false, false, true,  true,  true,  false, true,  false, false, false, false},
            new boolean[]{false, false, false, false, false, true,  true,  false, true,  false, false, false, true,  false, false, true,  true,  false, true,  true,  true,  true,  false, false, false, false},
            new boolean[]{false, false, false, false, true,  false, true,  true,  true,  false, false, false, false, false, false, false, false, false, false, true,  true,  false, true,  false, false, false},
            new boolean[]{false, false, false, false, false, false, true,  true,  false, false, false, false, false, false, false, false, false, false, false, true,  false, false, false, true,  true,  true },
            new boolean[]{false, false, false, true,  false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true,  true },
            new boolean[]{false, false, false, false, true,  true,  true,  true,  false, false, false, false, false, false, false, false, false, true,  false, false, false, false, false, false, false, true },
            new boolean[]{false, false, false, false, true,  true,  true,  false, true,  true,  true,  false, false, false, false, true,  true,  false, false, false, false, false, false, false, false, false},
            new boolean[]{false, false, false, true,  false, true,  false, false, false, false, false, true,  true,  false, false, true,  false, false, false, true,  true,  false, false, false, false, false},
            new boolean[]{false, false, false, false, false, false, false, false, false, false, true,  false, false, false, false, false, false, false, false, false, true,  true,  true,  false, false, false}};
    /**
     * Map of the game
     */
    private static TileType[][] map = new TileType[][]{
/*  1 */ new TileType[]{MOUNTAIN, PLAIN,    PLAIN, HILL,  HILL,   HILL,   PLAIN,  HILL,   HILL,   FIELD,  PLAIN,  PLAIN,  FOREST, FOREST, FOREST, FIELD,  HILL,   HILL,   PLAIN,  PLAIN, PLAIN,   PLAIN,   PLAIN,  PLAIN,  PLAIN,  PLAIN },
/*  2 */ new TileType[]{MOUNTAIN, MOUNTAIN, HILL,  PLAIN, PLAIN,  HILL,   HILL,   PLAIN,  HILL,   FIELD,  HAMLET, PLAIN,  FOREST, PLAIN,  PLAIN,  HAMLET, FIELD,  HILL,   HILL,   HILL,  FIELD,   ABBEY,   PLAIN,  PLAIN,  PLAIN,  PLAIN },
/*  3 */ new TileType[]{MOUNTAIN, PLAIN,    PLAIN, HILL,  HILL,   PLAIN,  PLAIN,  FOREST, PLAIN,  PLAIN,  FIELD,  FOREST, FOREST, FOREST, PLAIN,  PLAIN,  FIELD,  PLAIN,  HILL,   HILL,  HILL,    HILL,    FOREST, FOREST, PLAIN,  PLAIN },
/*  4 */ new TileType[]{MOUNTAIN, MOUNTAIN, HILL,  HILL,  HILL,   PLAIN,  FOREST, PLAIN,  PLAIN,  PLAIN,  PLAIN,  FOREST, FOREST, PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN, HILL,    HILL,    FOREST, FIELD,  PLAIN,  PLAIN },
/*  5 */ new TileType[]{MOUNTAIN, PLAIN,    PLAIN, PLAIN, HILL,   HILL,   PLAIN,  FIELD,  FIELD,  PLAIN,  FOREST, FOREST, PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  HILL,  HILL,    PLAIN,   FOREST, HAMLET, FIELD,  PLAIN },
/*  6 */ new TileType[]{MOUNTAIN, MOUNTAIN, HILL,  PLAIN, PLAIN,  HILL,   HILL,   HILL,   HAMLET, PLAIN,  PLAIN,  FOREST, FOREST, PLAIN,  PLAIN,  PLAIN,  FIELD,  HAMLET, PLAIN,  PLAIN, PLAIN,   PLAIN,   PLAIN,  PLAIN,  PLAIN,  PLAIN },
/*  7 */ new TileType[]{MOUNTAIN, MOUNTAIN, PLAIN, PLAIN, HILL,   PLAIN,  HILL,   HILL,   FIELD,  PLAIN,  PLAIN,  FIELD,  FIELD,  FIELD,  FOREST, PLAIN,  FIELD,  PLAIN,  PLAIN,  PLAIN, PLAIN,   PLAIN,   PLAIN,  PLAIN,  PLAIN,  FOREST},
/*  8 */ new TileType[]{MOUNTAIN, PLAIN,    HILL,  PLAIN, PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  FOREST, CITY,   FOREST, FOREST, PLAIN,  PLAIN,  PLAIN,  PLAIN,  LAKE,  PLAIN,   PLAIN,   PLAIN,  PLAIN,  FOREST, FOREST},
/*  9 */ new TileType[]{MOUNTAIN, MOUNTAIN, PLAIN, HILL,  HILL,   PLAIN,  PLAIN,  FIELD,  PLAIN,  FOREST, FOREST, FOREST, FOREST, PLAIN,  FOREST, FIELD,  PLAIN,  PLAIN,  PLAIN,  KEEP,  VILLAGE, VILLAGE, PLAIN,  PLAIN,  FOREST, FOREST},
/* 10 */ new TileType[]{MOUNTAIN, PLAIN,    HILL,  HILL,  PLAIN,  PLAIN,  PLAIN,  HAMLET, PLAIN,  FOREST, FOREST, FOREST, FOREST, PLAIN,  PLAIN,  PLAIN,  HAMLET, PLAIN,  PLAIN,  PLAIN, VILLAGE, PLAIN,   PLAIN,  PLAIN,  PLAIN,  PLAIN },
/* 11 */ new TileType[]{MOUNTAIN, PLAIN,    PLAIN, PLAIN, PLAIN,  PLAIN,  FIELD,  FIELD,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  FOREST, PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN, PLAIN,   PLAIN,   PLAIN,  PLAIN,  PLAIN,  FIELD },
/* 12 */ new TileType[]{MOUNTAIN, MOUNTAIN, PLAIN, HILL,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  FIELD,  PLAIN,  PLAIN,  FOREST, FOREST, PLAIN,  PLAIN,  FOREST, PLAIN,  PLAIN, PLAIN,   PLAIN,   PLAIN,  PLAIN,  HAMLET, FIELD },
/* 13 */ new TileType[]{MOUNTAIN, MOUNTAIN, HILL,  HILL,  HILL,   HILL,   PLAIN,  PLAIN,  PLAIN,  FIELD,  HAMLET, PLAIN,  PLAIN,  HILL,   PLAIN,  HAMLET, FOREST, FOREST, FOREST, PLAIN, PLAIN,   PLAIN,   PLAIN,  PLAIN,  PLAIN,  PLAIN },
/* 14 */ new TileType[]{MOUNTAIN, PLAIN,    HILL,  PLAIN, HILL,   PLAIN,  PLAIN,  PLAIN,  FOREST, FOREST, FIELD,  HILL,   HILL,   HILL,   FIELD,  FIELD,  PLAIN,  FOREST, FOREST, PLAIN, PLAIN,   CITY,    PLAIN,  PLAIN,  PLAIN,  PLAIN },
/* 15 */ new TileType[]{MOUNTAIN, PLAIN,    PLAIN, HILL,  PLAIN,  PLAIN,  PLAIN,  FOREST, FOREST, FOREST, FOREST, PLAIN,  HILL,   HILL,   PLAIN,  PLAIN,  FOREST, FOREST, FOREST, PLAIN, FIELD,   FIELD,   PLAIN,  PLAIN,  PLAIN,  PLAIN },
/* 16 */ new TileType[]{MOUNTAIN, MOUNTAIN, PLAIN, HILL,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  FOREST, FOREST, FOREST, HAMLET, FIELD,  PLAIN,  HILL,   HILL,   HILL,   PLAIN,  PLAIN,  PLAIN, PLAIN,   PLAIN,   PLAIN,  PLAIN,  PLAIN,  PLAIN },
/* 17 */ new TileType[]{MOUNTAIN, HILL,     HILL,  HILL,  HILL,   HILL,   PLAIN,  FIELD,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  FIELD,  FOREST, PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN, PLAIN,   FIELD,   PLAIN,  PLAIN,  PLAIN,  PLAIN },
/* 18 */ new TileType[]{MOUNTAIN, PLAIN,    PLAIN, HILL,  PLAIN,  PLAIN,  PLAIN,  HAMLET, FIELD,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  FOREST, FOREST, PLAIN,  HAMLET, FIELD,  PLAIN,  PLAIN, PLAIN,   FIELD,   HAMLET, PLAIN,  PLAIN,  PLAIN },
/* 19 */ new TileType[]{MOUNTAIN, MOUNTAIN, PLAIN, HILL,  FOREST, FOREST, FIELD,  FIELD,  PLAIN,  PLAIN,  PLAIN,  FOREST, FOREST, FOREST, FOREST, PLAIN,  FIELD,  PLAIN,  PLAIN,  PLAIN, PLAIN,   PLAIN,   PLAIN,  PLAIN,  PLAIN,  PLAIN }
    };


    /**
     * Getter of map's size
     * @return Map's size
     */
    public static Pair<Integer, Integer> getMapSize(){
        return new Pair<>(map.length, map[0].length);
    }

    /**
     * Getter of a tile
     * @param x Row of the tile
     * @param y Column of the tile
     * @return The tile found
     */
    public static TileType get(int x, int y){
        return map[x][y];
    }

    public static Facing[] getRiver(int x, int y) {
        // TODO : Store the river facing and get it
        return new Facing[]{};
    }

    public static boolean getForest(int x, int y) { return forest[x][y]; }
}