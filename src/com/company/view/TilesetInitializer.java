package com.company.view;

import com.company.Main;
import com.company.controller.manager.TileManager;
import com.company.controller.manager.UnitManager;
import com.company.model.enums.TileType;
import com.company.model.enums.UnitType;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.company.model.enums.TileType.*;
import static com.company.model.enums.UnitType.*;

public class TilesetInitializer {

    /**
     * Initialize the TileManager with the tiles
     */
    public void initTile() {
        TileType[] list = new TileType[] {
                EMPTY_TILE, FOREST, FOREST_LIGHT, PLAIN, EMPTY_TILE, EMPTY_TILE,
                PATH_STRAIGHT, PATH_TURN, PATH_INTERSECTION, PATH_BRIDGE, PATH_END, EMPTY_TILE,
                LAKE, RIVER, RIVER_2, RIVER_3, EMPTY_TILE, EMPTY_TILE,
                MOUNTAIN, MOUNTAIN_2, HILL_2, HILL, EMPTY_TILE, EMPTY_TILE,
                FIELD, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
                ABBEY, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
                KEEP, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
                EMPTY_TILE, HAMLET, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
                EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
                CITY, VILLAGE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE, EMPTY_TILE,
        };
        ArrayList<TileType> names = new ArrayList<>(Arrays.asList(list));

        InputStream map = getClass().getResourceAsStream("/map.png");

        TileManager.getInstance().parsePicture(
                map,
                180,
                155,
                names);
    }

    public void initFeudalUnits() {
        UnitType[] feudalUnits = new UnitType[] {
                PLUNDER1, PLUNDER2, PLUNDER3, PLUNDER4, END_TURN, EMPTY_UNIT,
                FEUDAL_C_RANK, FEUDAL_B_RANK, FEUDAL_B_RANK_2, FEUDAL_A_RANK, FEUDAL_A_RANK_2, FEUDAL_A_RANK_3,
                FEUDAL_C_RANK_ZOOM, FEUDAL_B_RANK_ZOOM, FEUDAL_B_RANK_2_ZOOM, FEUDAL_A_RANK_ZOOM, FEUDAL_A_RANK_2_ZOOM, FEUDAL_A_RANK_3_ZOOM,
                JOHN_GORDON, ROBERT_KEITH, THOPMAS_BRUCE, FRIAR_SIMON, SIR_RANDOLPH, SIR_GODFREY,
                JOHN_GORDON_ZOOM, ROBERT_KEITH_ZOOM, THOPMAS_BRUCE_ZOOM, FRIAR_SIMON_ZOOM, SIR_RANDOLPH_ZOOM, SIR_GODFREY_ZOOM,
                SIR_HILBERT, COUNT, BARON, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                SIR_HILBERT_ZOOM, COUNT_ZOOM, BARON_ZOOM, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT
        };
        ArrayList<UnitType> feudalNames = new ArrayList<>(Arrays.asList(feudalUnits));

        InputStream unitsFeudalFile = getClass().getResourceAsStream("/char.png");

        UnitManager.getInstance().parsePicture(
                unitsFeudalFile,
                180,
                155,
                feudalNames);
    }

    public void initGoblinUnits() {
        UnitType[] goblinUnits = new UnitType[] {
                EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                GOBLIN_C_RANK, GOBLIN_C_RANK_2, GOBLIN_B_RANK, GOBLIN_B_RANK_2, EMPTY_UNIT, EMPTY_UNIT,
                GOBLIN_C_RANK_ZOOM, GOBLIN_C_RANK_2_ZOOM, GOBLIN_B_RANK_ZOOM, GOBLIN_B_RANK_2_ZOOM, EMPTY_UNIT, EMPTY_UNIT,
                PHINLOC, UGLOP, GRINPHAR, KASBOSH, ARGBARG, MARGLUSH,
                PHINLOC_ZOOM, UGLOP_ZOOM, GRINPHAR_ZOOM, KASBOSH_ZOOM, ARGBARG_ZOOM, MARGLUSH_ZOOM,
                KING, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                KING_ZOOM, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
                EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT, EMPTY_UNIT,
        };
        ArrayList<UnitType> goblinNames = new ArrayList<>(Arrays.asList(goblinUnits));

        InputStream unitsGoblinFile = getClass().getResourceAsStream("/char2.png");


        UnitManager.getInstance().parsePicture(
                unitsGoblinFile,
                180,
                155,
                goblinNames);
    }

}
