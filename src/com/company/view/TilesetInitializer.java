package com.company.view;

import com.company.controller.manager.TileManager;
import com.company.controller.manager.UnitManager;
import com.company.model.enums.TileType;
import com.company.model.enums.UnitType;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import static com.company.model.enums.TileType.*;
import static com.company.model.enums.UnitType.*;

public class TilesetInitializer {

    /**
     * Initialize the TileManager with the tiles
     */
    public void initTileset() {
        TileType[] list = new TileType[] {
                FOREST_LIGHT, FOREST, EMPTY_TILE, PLAIN, EMPTY_TILE, EMPTY_TILE,
                ROAD_STRAIGHT, ROAD_TURN, ROAD_INTERSECTION, ROAD_BRIDGE, ROAD_END, EMPTY_TILE,
                LAKE, RIVER, RIVER_2, RIVER_3, EMPTY_TILE, EMPTY_TILE,
                MOUNTAIN, MOUNTAIN_2, HILL_2, HILL, EMPTY_TILE, EMPTY_TILE,
                FIELD, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
                ABBEY, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
                KEEP, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
                HAMLET, HAMLET_2, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
                CITY, CITY_2, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
                VILLAGE, VILLAGE_2, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
        };
        ArrayList<TileType> names = new ArrayList<>(Arrays.asList(list));

        InputStream map = getClass().getResourceAsStream("/map.png");

        TileManager.getInstance().parsePicture(
                map,
                180,
                155,
                names);
    }

    public void initUnits() {
        UnitType[] units = new UnitType[] {
                FEUDAL_C_RANK, FEUDAL_B_RANK, FEUDAL_B_RANK_2, FEUDAL_A_RANK, FEUDAL_A_RANK_2, FEUDAL_A_RANK_3,
                FEUDAL_C_RANK_ZOOM, FEUDAL_B_RANK_ZOOM, FEUDAL_B_RANK_2_ZOOM, FEUDAL_A_RANK_ZOOM, FEUDAL_A_RANK_2_ZOOM, FEUDAL_A_RANK_3_ZOOM,
                JOHN_GORDON, ROBERT_KEITH, THOPMAS_BRUCE, FRIAR_SIMON, SIR_RANDOLPH, SIR_GODFREY,
                JOHN_GORDON_ZOOM, ROBERT_KEITH_ZOOM, THOPMAS_BRUCE_ZOOM, FRIAR_SIMON_ZOOM, SIR_RANDOLPH_ZOOM, SIR_GODFREY_ZOOM,
                SIR_HILBERT, COUNT, BARON, GOBLIN_C_RANK, GOBLIN_C_RANK_2, GOBLIN_B_RANK,
                SIR_HILBERT_ZOOM, COUNT_ZOOM, BARON_ZOOM, GOBLIN_C_RANK_ZOOM, GOBLIN_C_RANK_2_ZOOM, GOBLIN_B_RANK_ZOOM,
                GOBLIN_B_RANK_2, PHINLOC, UGLOP, GRINPHAR, KASBOSH, ARGBARG,
                GOBLIN_B_RANK_2_ZOOM, PHINLOC_ZOOM, UGLOP_ZOOM, GRINPHAR_ZOOM, KASBOSH_ZOOM, ARGBARG_ZOOM,
                MARGLUSH, KING, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                MARGLUSH_ZOOM, KING_ZOOM, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
        };
        ArrayList<UnitType> unitsNames = new ArrayList<>(Arrays.asList(units));

        InputStream unitsFile = getClass().getResourceAsStream("/char.png");

        UnitManager.getInstance().parsePicture(
                unitsFile,
                180,
                155,
                unitsNames);
    }

    public void initMarkers() {
        UnitType[] markers = new UnitType[] {
                PLUNDER1, PLUNDER2, PLUNDER3, PLUNDER4, END_TURN, EMPTY_UNIT,
                EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT
        };
        ArrayList<UnitType> markersNames = new ArrayList<>(Arrays.asList(markers));

        InputStream markersFile = getClass().getResourceAsStream("/markers.png");

        UnitManager.getInstance().parsePicture(
                markersFile,
                180,
                155,
                markersNames);
    }
}
