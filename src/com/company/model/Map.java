package com.company.model;

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


    private int[][] a = new int[][]{new int[]{7, 1}, new int[]{11, 1}, new int[]{6, 2}, new int[]{6, 1}, new int[]{5, 2}, new int[]{6, 2}, new int[]{7, 2}, new int[]{12, 1}, new int[]{5, 3}, new int[]{6, 3}, new int[]{7, 3}, new int[]{8, 2}, new int[]{9, 3}, new int[]{10, 3}, new int[]{11, 4}, new int[]{10, 4}, new int[]{8, 4}, new int[]{13, 5}, new int[]{11, 6}, new int[]{5, 6}, new int[]{4, 6}, new int[]{5, 7}, new int[]{6, 6}, new int[]{7, 8}, new int[]{8, 7}, new int[]{10, 7}, new int[]{11, 7}, new int[]{11, 8}, new int[]{10, 8}, new int[]{9, 8}, new int[]{8, 8}, new int[]{5, 8}, new int[]{6, 7}, new int[]{4, 9}, new int[]{5, 10}, new int[]{6, 10}, new int[]{7, 10}, new int[]{6, 11}, new int[]{7, 12}, new int[]{9, 12}, new int[]{10, 11}, new int[]{11, 11}, new int[]{13, 11}, new int[]{13, 12}, new int[]{9, 12}, new int[]{5, 13}, new int[]{6, 12}, new int[]{7, 13}, new int[]{8, 13}, new int[]{9, 13}, new int[]{7, 14}, new int[]{8, 14}, new int[]{4, 15}, new int[]{5, 16}, new int[]{6, 16}, new int[]{7, 16}, new int[]{8, 16}, new int[]{5, 17}, new int[]{6, 17}, new int[]{7, 17}, new int[]{9, 17}, new int[]{10, 17}, new int[]{11, 17}, new int[]{4, 18}, new int[]{6, 18}, new int[]{11, 19}, new int[]{12, 18}, new int[]{13, 18}, new int[]{22, 1}, new int[]{23, 1}, new int[]{24, 1}, new int[]{25, 1}, new int[]{15, 2}, new int[]{23, 2}, new int[]{25, 2}, new int[]{24, 2}, new int[]{15, 3}, new int[]{25, 3}, new int[]{15, 4}, new int[]{26, 4}, new int[]{22, 4}, new int[]{17, 5}, new int[]{20, 5}, new int[]{21, 5}, new int[]{22, 5}, new int[]{26, 5}, new int[]{15, 6}, new int[]{16, 6}, new int[]{21, 6}, new int[]{23, 6}, new int[]{24, 6}, new int[]{25, 6}, new int[]{26, 6}, new int[]{16, 7}, new int[]{23, 7}, new int[]{17, 8}, new int[]{18, 8}, new int[]{24, 8}, new int[]{14, 9}, new int[]{15, 10}, new int[]{18, 9}, new int[]{24, 9}, new int[]{19, 11}, new int[]{18, 11}, new int[]{20, 11}, new int[]{22, 11}, new int[]{16, 12}, new int[]{17, 12}, new int[]{19, 12}, new int[]{20, 12}, new int[]{21, 12}, new int[]{22, 12}, new int[]{20, 13}, new int[]{20, 14}, new int[]{21, 13}, new int[]{23, 13}, new int[]{24, 14}, new int[]{25, 14}, new int[]{26, 14}, new int[]{25, 15}, new int[]{26, 15}, new int[]{26, 16}, new int[]{18, 16}, new int[]{17, 17}, new int[]{16, 17}, new int[]{16, 18}, new int[]{20, 18}, new int[]{21, 18}, new int[]{21, 19}, new int[]{22, 19}, new int[]{23, 19}};

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
}