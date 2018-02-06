package com.company.model

import com.company.model.enums.TileType
import javafx.util.Pair

import com.company.model.enums.TileType.*

/**
 * Have a Map
 */
class Map {

    private val a = arrayOf(intArrayOf(7, 1), intArrayOf(11, 1), intArrayOf(6, 2), intArrayOf(6, 1), intArrayOf(5, 2), intArrayOf(6, 2), intArrayOf(7, 2), intArrayOf(12, 1), intArrayOf(5, 3), intArrayOf(6, 3), intArrayOf(7, 3), intArrayOf(8, 2), intArrayOf(9, 3), intArrayOf(10, 3), intArrayOf(11, 4), intArrayOf(10, 4), intArrayOf(8, 4), intArrayOf(13, 5), intArrayOf(11, 6), intArrayOf(5, 6), intArrayOf(4, 6), intArrayOf(5, 7), intArrayOf(6, 6), intArrayOf(7, 8), intArrayOf(8, 7), intArrayOf(10, 7), intArrayOf(11, 7), intArrayOf(11, 8), intArrayOf(10, 8), intArrayOf(9, 8), intArrayOf(8, 8), intArrayOf(5, 8), intArrayOf(6, 7), intArrayOf(4, 9), intArrayOf(5, 10), intArrayOf(6, 10), intArrayOf(7, 10), intArrayOf(6, 11), intArrayOf(7, 12), intArrayOf(9, 12), intArrayOf(10, 11), intArrayOf(11, 11), intArrayOf(13, 11), intArrayOf(13, 12), intArrayOf(9, 12), intArrayOf(5, 13), intArrayOf(6, 12), intArrayOf(7, 13), intArrayOf(8, 13), intArrayOf(9, 13), intArrayOf(7, 14), intArrayOf(8, 14), intArrayOf(4, 15), intArrayOf(5, 16), intArrayOf(6, 16), intArrayOf(7, 16), intArrayOf(8, 16), intArrayOf(5, 17), intArrayOf(6, 17), intArrayOf(7, 17), intArrayOf(9, 17), intArrayOf(10, 17), intArrayOf(11, 17), intArrayOf(4, 18), intArrayOf(6, 18), intArrayOf(11, 19), intArrayOf(12, 18), intArrayOf(13, 18), intArrayOf(22, 1), intArrayOf(23, 1), intArrayOf(24, 1), intArrayOf(25, 1), intArrayOf(15, 2), intArrayOf(23, 2), intArrayOf(25, 2), intArrayOf(24, 2), intArrayOf(15, 3), intArrayOf(25, 3), intArrayOf(15, 4), intArrayOf(26, 4), intArrayOf(22, 4), intArrayOf(17, 5), intArrayOf(20, 5), intArrayOf(21, 5), intArrayOf(22, 5), intArrayOf(26, 5), intArrayOf(15, 6), intArrayOf(16, 6), intArrayOf(21, 6), intArrayOf(23, 6), intArrayOf(24, 6), intArrayOf(25, 6), intArrayOf(26, 6), intArrayOf(16, 7), intArrayOf(23, 7), intArrayOf(17, 8), intArrayOf(18, 8), intArrayOf(24, 8), intArrayOf(14, 9), intArrayOf(15, 10), intArrayOf(18, 9), intArrayOf(24, 9), intArrayOf(19, 11), intArrayOf(18, 11), intArrayOf(20, 11), intArrayOf(22, 11), intArrayOf(16, 12), intArrayOf(17, 12), intArrayOf(19, 12), intArrayOf(20, 12), intArrayOf(21, 12), intArrayOf(22, 12), intArrayOf(20, 13), intArrayOf(20, 14), intArrayOf(21, 13), intArrayOf(23, 13), intArrayOf(24, 14), intArrayOf(25, 14), intArrayOf(26, 14), intArrayOf(25, 15), intArrayOf(26, 15), intArrayOf(26, 16), intArrayOf(18, 16), intArrayOf(17, 17), intArrayOf(16, 17), intArrayOf(16, 18), intArrayOf(20, 18), intArrayOf(21, 18), intArrayOf(21, 19), intArrayOf(22, 19), intArrayOf(23, 19))

    companion object {
        /**
         * Map of the game
         */
        private val map = arrayOf(
                /*  1 */ arrayOf(MOUNTAIN, PLAIN, PLAIN, HILL, HILL, HILL, PLAIN, HILL, HILL, FIELD, PLAIN, PLAIN, FOREST, FOREST, FOREST, FIELD, HILL, HILL, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN),
                /*  2 */ arrayOf(MOUNTAIN, MOUNTAIN, HILL, PLAIN, PLAIN, HILL, HILL, PLAIN, HILL, FIELD, HAMLET, PLAIN, FOREST, PLAIN, PLAIN, HAMLET, FIELD, HILL, HILL, HILL, FIELD, ABBEY, PLAIN, PLAIN, PLAIN, PLAIN),
                /*  3 */ arrayOf(MOUNTAIN, PLAIN, PLAIN, HILL, HILL, PLAIN, PLAIN, FOREST, PLAIN, PLAIN, FIELD, FOREST, FOREST, FOREST, PLAIN, PLAIN, FIELD, PLAIN, HILL, HILL, HILL, HILL, FOREST, FOREST, PLAIN, PLAIN),
                /*  4 */ arrayOf(MOUNTAIN, MOUNTAIN, HILL, HILL, HILL, PLAIN, FOREST, PLAIN, PLAIN, PLAIN, PLAIN, FOREST, FOREST, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, HILL, HILL, FOREST, FIELD, PLAIN, PLAIN),
                /*  5 */ arrayOf(MOUNTAIN, PLAIN, PLAIN, PLAIN, HILL, HILL, PLAIN, FIELD, FIELD, PLAIN, FOREST, FOREST, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, HILL, HILL, PLAIN, FOREST, HAMLET, FIELD, PLAIN),
                /*  6 */ arrayOf(MOUNTAIN, MOUNTAIN, HILL, PLAIN, PLAIN, HILL, HILL, HILL, HAMLET, PLAIN, PLAIN, FOREST, FOREST, PLAIN, PLAIN, PLAIN, FIELD, HAMLET, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN),
                /*  7 */ arrayOf(MOUNTAIN, MOUNTAIN, PLAIN, PLAIN, HILL, PLAIN, HILL, HILL, FIELD, PLAIN, PLAIN, FIELD, FIELD, FIELD, FOREST, PLAIN, FIELD, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, FOREST),
                /*  8 */ arrayOf(MOUNTAIN, PLAIN, HILL, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, FOREST, CITY, FOREST, FOREST, PLAIN, PLAIN, PLAIN, PLAIN, LAKE, PLAIN, PLAIN, PLAIN, PLAIN, FOREST, FOREST),
                /*  9 */ arrayOf(MOUNTAIN, MOUNTAIN, PLAIN, HILL, HILL, PLAIN, PLAIN, FIELD, PLAIN, FOREST, FOREST, FOREST, FOREST, PLAIN, FOREST, FIELD, PLAIN, PLAIN, PLAIN, KEEP, VILLAGE, VILLAGE, PLAIN, PLAIN, FOREST, FOREST),
                /* 10 */ arrayOf(MOUNTAIN, PLAIN, HILL, HILL, PLAIN, PLAIN, PLAIN, HAMLET, PLAIN, FOREST, FOREST, FOREST, FOREST, PLAIN, PLAIN, PLAIN, HAMLET, PLAIN, PLAIN, PLAIN, VILLAGE, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN),
                /* 11 */ arrayOf(MOUNTAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, FIELD, FIELD, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, FOREST, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, FIELD),
                /* 12 */ arrayOf(MOUNTAIN, MOUNTAIN, PLAIN, HILL, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, FIELD, PLAIN, PLAIN, FOREST, FOREST, PLAIN, PLAIN, FOREST, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, HAMLET, FIELD),
                /* 13 */ arrayOf(MOUNTAIN, MOUNTAIN, HILL, HILL, HILL, HILL, PLAIN, PLAIN, PLAIN, FIELD, HAMLET, PLAIN, PLAIN, HILL, PLAIN, HAMLET, FOREST, FOREST, FOREST, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN),
                /* 14 */ arrayOf(MOUNTAIN, PLAIN, HILL, PLAIN, HILL, PLAIN, PLAIN, PLAIN, FOREST, FOREST, FIELD, HILL, HILL, HILL, FIELD, FIELD, PLAIN, FOREST, FOREST, PLAIN, PLAIN, CITY, PLAIN, PLAIN, PLAIN, PLAIN),
                /* 15 */ arrayOf(MOUNTAIN, PLAIN, PLAIN, HILL, PLAIN, PLAIN, PLAIN, FOREST, FOREST, FOREST, FOREST, PLAIN, HILL, HILL, PLAIN, PLAIN, FOREST, FOREST, FOREST, PLAIN, FIELD, FIELD, PLAIN, PLAIN, PLAIN, PLAIN),
                /* 16 */ arrayOf(MOUNTAIN, MOUNTAIN, PLAIN, HILL, PLAIN, PLAIN, PLAIN, PLAIN, FOREST, FOREST, FOREST, HAMLET, FIELD, PLAIN, HILL, HILL, HILL, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN),
                /* 17 */ arrayOf(MOUNTAIN, HILL, HILL, HILL, HILL, HILL, PLAIN, FIELD, PLAIN, PLAIN, PLAIN, PLAIN, FIELD, FOREST, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, FIELD, PLAIN, PLAIN, PLAIN, PLAIN),
                /* 18 */ arrayOf(MOUNTAIN, PLAIN, PLAIN, HILL, PLAIN, PLAIN, PLAIN, HAMLET, FIELD, PLAIN, PLAIN, PLAIN, PLAIN, FOREST, FOREST, PLAIN, HAMLET, FIELD, PLAIN, PLAIN, PLAIN, FIELD, HAMLET, PLAIN, PLAIN, PLAIN),
                /* 19 */ arrayOf(MOUNTAIN, MOUNTAIN, PLAIN, HILL, FOREST, FOREST, FIELD, FIELD, PLAIN, PLAIN, PLAIN, FOREST, FOREST, FOREST, FOREST, PLAIN, FIELD, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN, PLAIN))

        /**
         * Map of the game
         */
        private val forest = arrayOf(
                /*  1 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /*  2 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /*  3 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /*  4 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /*  5 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /*  6 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /*  7 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /*  8 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /*  9 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /* 10 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /* 11 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /* 12 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /* 13 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /* 14 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /* 15 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /* 16 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /* 17 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /* 18 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false),
                /* 19 */ booleanArrayOf(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false))

        /**
         * Getter of map's size
         * @return Map's size
         */
        val mapSize: Pair<Int, Int>
            get() = Pair(map.size, map[0].size)

        /**
         * Getter of a tile
         * @param x Row of the tile
         * @param y Column of the tile
         * @return The tile found
         */
        operator fun get(x: Int, y: Int): TileType {
            return map[x][y]
        }
    }
}