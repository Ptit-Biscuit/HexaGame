package com.company.model;

import com.company.Main;
import com.company.controller.manager.UnitManager;
import com.company.model.enums.UnitType;
import com.company.model.units.Army;
import com.company.model.units.Fighter;
import com.company.model.units.Leader;
import com.company.model.actions.Movement;
import com.company.model.units.Army;
import com.company.utils.Triplet;
import com.company.view.TilesetInitializer;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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


                Tile tile = new Tile(coordinates);
                tile.setType(Map.get(row, col));
                tile.setForest(Map.getForest(row, col));
                tile.setRiver(Map.getRiver(row, col));
                tile.setRoad(Map.getRoad(row, col));

                tiles.put(coordinates, tile);
            }
        }

        this.initUnits();
        this.game(2);

    }

    /**
     *
     */
    private void initUnits() {
        Leader feudalLeader = new Leader(UnitManager.getInstance().getTile(UnitType.COUNT),5,true,"feudal", Board.getInstance().getTile(new Triplet(11,13,-24)) , "RE", "Count", 3, 5);
        Fighter feudal1 = new Fighter(UnitManager.getInstance().getTile(UnitType.FEUDAL_C_RANK),3,false,"feudal", Board.getInstance().getTile(new Triplet(11,13,-24)),"","C",3,3);
        Fighter feudal2 = new Fighter(UnitManager.getInstance().getTile(UnitType.FEUDAL_C_RANK),3,false,"feudal",Board.getInstance().getTile(new Triplet(11,13,-24)),"","C",3,3);
        Fighter feudal3 = new Fighter(UnitManager.getInstance().getTile(UnitType.FEUDAL_C_RANK),3,false,"feudal",Board.getInstance().getTile(new Triplet(11,13,-24)),"","C",3,3);
        Fighter feudal4 = new Fighter(UnitManager.getInstance().getTile(UnitType.FEUDAL_C_RANK),3,false,"feudal",Board.getInstance().getTile(new Triplet(11,13,-24)),"","C",3,3);

        List<Leader> leaders = new ArrayList<>();
        leaders.add(feudalLeader);

        List<Fighter> fighters = new ArrayList<>();
        fighters.add(feudal1);
        fighters.add(feudal2);
        fighters.add(feudal3);
        fighters.add(feudal4);

        Board.getInstance().getTile(new Triplet(11,13,-24)).setUnits(feudalLeader);


//        Army army = new Army(leaders, fighters, Board.getInstance().getTile(new Triplet(11,13,-24)));
//        Board.getInstance().getTile(new Triplet(11,13,-24)).setArmy(army);
//        Main.update();
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


    public void game(int totalTurns){
        int nbTurns = 0;
        int phase = 1;
        while (totalTurns>nbTurns){
            //phase 1
            phase = 1;
            //get which army to move and the path
            //Movement.isValidMove(army, tileList);
            //validation of the movement
            //Movement.move(army,tileList);


            //phase 2
            phase = 2;

            //phase 3
            phase = 3;

            //phase 4
            phase = 4;


            //phase 5
            phase = 5;
            nbTurns ++;

        }
    }
}
