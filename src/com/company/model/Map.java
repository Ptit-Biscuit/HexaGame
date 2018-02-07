package com.company.model;

import com.company.model.enums.Facing;
import com.company.model.enums.TileType;
import javafx.util.Pair;

import static com.company.model.enums.Facing.*;
import static com.company.model.enums.TileType.*;

/**
 * Have a Map
 */
public class Map {
    /**
     * empty facing
     */
    private static Facing[] EMPTY = new Facing[]{};

    /**
     * Map of the game
     */
    private static TileType[][] map = new TileType[][]{
/*  1 */ new TileType[]{MOUNTAIN, PLAIN,    PLAIN, HILL,  HILL_2,   HILL_2,   PLAIN,  HILL,   HILL,   FIELD,  PLAIN,  PLAIN,  FOREST, FOREST, FOREST, FIELD,  HILL,   HILL,   PLAIN,  PLAIN, PLAIN,   PLAIN,   PLAIN,  PLAIN,  PLAIN,  PLAIN },
/*  2 */ new TileType[]{MOUNTAIN_2, MOUNTAIN_2, HILL,  PLAIN, PLAIN,  HILL_2,   HILL,   PLAIN,  HILL,   FIELD,  HAMLET_2, PLAIN,  FOREST, PLAIN,  PLAIN,  HAMLET, FIELD,  HILL,   HILL_2,   HILL_2,  FIELD,   ABBEY,   PLAIN,  PLAIN,  PLAIN,  PLAIN },
/*  3 */ new TileType[]{MOUNTAIN, PLAIN,    PLAIN, HILL,  HILL_2,   PLAIN,  PLAIN,  FOREST, PLAIN,  PLAIN,  FIELD,  FOREST, FOREST, FOREST, PLAIN,  PLAIN,  FIELD,  PLAIN,  HILL,   HILL_2,  HILL_2,    HILL,    FOREST, FOREST, PLAIN,  PLAIN },
/*  4 */ new TileType[]{MOUNTAIN_2, MOUNTAIN_2, HILL,  HILL,  HILL,   PLAIN,  FOREST, PLAIN,  PLAIN,  PLAIN,  PLAIN,  FOREST, FOREST, PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN, HILL_2,    HILL,    FOREST, FIELD,  PLAIN,  PLAIN },
/*  5 */ new TileType[]{MOUNTAIN, PLAIN,    PLAIN, PLAIN, HILL,   HILL,   PLAIN,  FIELD,  FIELD,  PLAIN,  FOREST, FOREST, PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  HILL,  HILL,    PLAIN,   FOREST, HAMLET, FIELD,  PLAIN },
/*  6 */ new TileType[]{MOUNTAIN_2, MOUNTAIN_2, HILL,  PLAIN, PLAIN,  HILL,   HILL,   HILL,   HAMLET, PLAIN,  PLAIN,  FOREST, FOREST, PLAIN,  PLAIN,  PLAIN,  FIELD,  HAMLET_2, PLAIN,  PLAIN, PLAIN,   PLAIN,   PLAIN,  PLAIN,  PLAIN,  PLAIN },
/*  7 */ new TileType[]{MOUNTAIN, MOUNTAIN_2, PLAIN, PLAIN, HILL,   PLAIN,  HILL,   HILL,   FIELD,  PLAIN,  PLAIN,  FIELD,  FIELD,  FIELD,  FOREST, PLAIN,  FIELD,  PLAIN,  PLAIN,  PLAIN, PLAIN,   PLAIN,   PLAIN,  PLAIN,  PLAIN,  FOREST},
/*  8 */ new TileType[]{MOUNTAIN_2, PLAIN,    HILL,  PLAIN, PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  FOREST, CITY_2,   FOREST, FOREST, PLAIN,  PLAIN,  PLAIN,  PLAIN,  LAKE,  PLAIN,   PLAIN,   PLAIN,  PLAIN,  FOREST, FOREST},
/*  9 */ new TileType[]{MOUNTAIN, MOUNTAIN_2, PLAIN, HILL,  HILL,   PLAIN,  PLAIN,  FIELD,  PLAIN,  FOREST, FOREST, FOREST, FOREST, PLAIN,  FOREST, FIELD,  PLAIN,  PLAIN,  PLAIN,  KEEP,  VILLAGE, VILLAGE, PLAIN,  PLAIN,  FOREST, FOREST},
/* 10 */ new TileType[]{MOUNTAIN_2, PLAIN,    HILL,  HILL,  PLAIN,  PLAIN,  PLAIN,  HAMLET, PLAIN,  FOREST, FOREST, FOREST, FOREST, PLAIN,  PLAIN,  PLAIN,  HAMLET, PLAIN,  PLAIN,  PLAIN, VILLAGE, PLAIN,   PLAIN,  PLAIN,  PLAIN,  PLAIN },
/* 11 */ new TileType[]{MOUNTAIN_2, PLAIN,    PLAIN, PLAIN, PLAIN,  PLAIN,  FIELD,  FIELD,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  FOREST, PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN, PLAIN,   PLAIN,   PLAIN,  PLAIN,  PLAIN,  FIELD },
/* 12 */ new TileType[]{MOUNTAIN, MOUNTAIN_2, PLAIN, HILL,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  FIELD,  PLAIN,  PLAIN,  FOREST, FOREST, PLAIN,  PLAIN,  FOREST, PLAIN,  PLAIN, PLAIN,   PLAIN,   PLAIN,  PLAIN,  HAMLET, FIELD },
/* 13 */ new TileType[]{MOUNTAIN, MOUNTAIN, HILL,  HILL,  HILL_2,   HILL_2,   PLAIN,  PLAIN,  PLAIN,  FIELD,  HAMLET, PLAIN,  PLAIN,  HILL,   PLAIN,  HAMLET_2, FOREST, FOREST, FOREST, PLAIN, PLAIN,   PLAIN,   PLAIN,  PLAIN,  PLAIN,  PLAIN },
/* 14 */ new TileType[]{MOUNTAIN, PLAIN,    HILL,  PLAIN, HILL_2,   PLAIN,  PLAIN,  PLAIN,  FOREST, FOREST, FIELD,  HILL,   HILL_2,   HILL,   FIELD,  FIELD,  PLAIN,  FOREST, FOREST, PLAIN, PLAIN,   CITY,    PLAIN,  PLAIN,  PLAIN,  PLAIN },
/* 15 */ new TileType[]{MOUNTAIN_2, PLAIN,    PLAIN, HILL,  PLAIN,  PLAIN,  PLAIN,  FOREST, FOREST, FOREST, FOREST, PLAIN,  HILL_2,   HILL_2,   PLAIN,  PLAIN,  FOREST, FOREST, FOREST, PLAIN, FIELD,   FIELD,   PLAIN,  PLAIN,  PLAIN,  PLAIN },
/* 16 */ new TileType[]{MOUNTAIN, MOUNTAIN_2, PLAIN, HILL,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  FOREST, FOREST, FOREST, HAMLET, FIELD,  PLAIN,  HILL,   HILL,   HILL,   PLAIN,  PLAIN,  PLAIN, PLAIN,   PLAIN,   PLAIN,  PLAIN,  PLAIN,  PLAIN },
/* 17 */ new TileType[]{MOUNTAIN, HILL,     HILL,  HILL,  HILL,   HILL_2,   PLAIN,  FIELD,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  FIELD,  FOREST, PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  PLAIN, PLAIN,   FIELD,   PLAIN,  PLAIN,  PLAIN,  PLAIN },
/* 18 */ new TileType[]{MOUNTAIN_2, PLAIN,    PLAIN, HILL,  PLAIN,  PLAIN,  PLAIN,  HAMLET_2, FIELD,  PLAIN,  PLAIN,  PLAIN,  PLAIN,  FOREST, FOREST, PLAIN,  HAMLET, FIELD,  PLAIN,  PLAIN, PLAIN,   FIELD,   HAMLET_2, PLAIN,  PLAIN,  PLAIN },
/* 19 */ new TileType[]{MOUNTAIN_2, MOUNTAIN, PLAIN, HILL,  FOREST, FOREST, FIELD,  FIELD,  PLAIN,  PLAIN,  PLAIN,  FOREST, FOREST, FOREST, FOREST, PLAIN,  FIELD,  PLAIN,  PLAIN,  PLAIN, PLAIN,   PLAIN,   PLAIN,  PLAIN,  PLAIN,  PLAIN }
    };

    /**
     * Map of all light forests of the game
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
        new boolean[]{false, false, false, false, false, false, false, false, false, false, true,  false, false, false, false, false, false, false, false, false, true,  true,  true,  false, false, false}
    };

    /**
     * Map of all rivers of the game
     */
    private static Facing[][][] river = new Facing[][][]{
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{SOUTH}},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{SOUTH, SOUTH_EAST}, new Facing[]{SOUTH, SOUTH_EAST}, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{NORTH_WEST, SOUTH_WEST}, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{SOUTH, SOUTH_EAST}, new Facing[]{SOUTH}, new Facing[]{SOUTH_WEST, SOUTH}, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{SOUTH, SOUTH_EAST}, new Facing[]{SOUTH, SOUTH_EAST}, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{SOUTH, SOUTH_EAST}, new Facing[]{SOUTH, SOUTH_EAST}, EMPTY, EMPTY, EMPTY, new Facing[]{SOUTH, SOUTH_WEST}, new Facing[]{SOUTH, SOUTH_WEST}, EMPTY, new Facing[]{SOUTH}, EMPTY, new Facing[]{SOUTH, SOUTH_EAST}, new Facing[]{SOUTH}, EMPTY, new Facing[]{SOUTH, SOUTH_EAST}, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{new Facing[]{SOUTH}, new Facing[]{SOUTH_WEST, SOUTH}, EMPTY, new Facing[]{SOUTH, SOUTH_EAST}, new Facing[]{SOUTH}, new Facing[]{SOUTH, SOUTH_WEST}, new Facing[]{SOUTH_EAST}, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{SOUTH, SOUTH_WEST, SOUTH_EAST}, EMPTY, new Facing[]{SOUTH, SOUTH_WEST, SOUTH_EAST}, EMPTY, EMPTY, new Facing[]{NORTH_EAST, SOUTH_EAST}, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, new Facing[]{SOUTH_WEST, SOUTH, SOUTH_EAST}, EMPTY, EMPTY, new Facing[]{NORTH_WEST, SOUTH_WEST}, new Facing[]{NORTH_EAST, SOUTH_WEST, SOUTH, SOUTH_EAST}, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{NORTH_EAST}, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{SOUTH, SOUTH_EAST}, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{NORTH, NORTH_EAST, SOUTH_EAST}, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, new Facing[]{SOUTH}, EMPTY, new Facing[]{SOUTH, SOUTH_EAST}, new Facing[]{NORTH_WEST, SOUTH_WEST}, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{NORTH_EAST, SOUTH_EAST}, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{new Facing[]{SOUTH, SOUTH_EAST}, EMPTY, new Facing[]{SOUTH, SOUTH_WEST, SOUTH_EAST}, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{NORTH_EAST}, new Facing[]{NORTH, NORTH_EAST}, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{NORTH_WEST, SOUTH, SOUTH_WEST}, new Facing[]{SOUTH_WEST, SOUTH}, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{SOUTH_WEST, SOUTH}, new Facing[]{SOUTH_WEST}},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{NORTH_WEST, SOUTH, SOUTH_WEST}},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}
    };

    /**
     * Map of all roads of the game
     */
    private static Facing[][][] road = new Facing[][][]{
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{NORTH_WEST, SOUTH}, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{NORTH_WEST, SOUTH}, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{NORTH, NORTH_WEST, NORTH_EAST}, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{NORTH_WEST, NORTH_EAST}, EMPTY, EMPTY, new Facing[]{SOUTH}, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{NORTH, NORTH_WEST}, EMPTY, new Facing[]{SOUTH}, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, new Facing[]{NORTH, NORTH_WEST}, new Facing[]{NORTH_WEST}, new Facing[]{SOUTH}, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        new Facing[][]{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}
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

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public static boolean getForest(int x, int y) {
        return forest[x][y];
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public static Facing[] getRiver(int x, int y) {
        return river[x][y];
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public static Facing[] getRoad(int x, int y) {
        return road[x][y];
    }
}