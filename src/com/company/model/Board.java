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
import javafx.scene.input.KeyEvent;
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
    private Army armyToMove;

    /**
     *
     */
    private ArrayList<Tile> path;

    /**
     *
     */
    private boolean selectArmy;

    /**
     *
     */
    private int phase;

    /**
     *
     */
    private int nbTurns;

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
        this.armyToMove = null;
        this.path = new ArrayList<Tile>();
        this.selectArmy = true;
        this.phase = 1;
        this.nbTurns = 0;

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

    }

    /**
     *
     */
    private void initUnits() {
        Tile combatExample = Board.getInstance().getTile(new Triplet(12,10,-22)); // feudal
        Tile combatExample2 = Board.getInstance().getTile(new Triplet(11,9,-20)); // goblin (marglush)
        Tile combatExample3 = Board.getInstance().getTile(new Triplet(12,9,-21)); // goblin (grinphar)

        // init feudal example combat army
        Leader feudalLeader = new Leader(UnitManager.getInstance().getTile(UnitType.COUNT),1,true,"feudal", combatExample , "RE", "Count", 2, 8);
        Fighter feudal1 = new Fighter(UnitManager.getInstance().getTile(UnitType.FEUDAL_A_RANK),1,false,"feudal",combatExample,"","A",0,4);
        Fighter feudal2 = new Fighter(UnitManager.getInstance().getTile(UnitType.FEUDAL_A_RANK),1,false,"feudal",combatExample,"","A",0,4);
        Fighter feudal3 = new Fighter(UnitManager.getInstance().getTile(UnitType.FEUDAL_A_RANK_2),1,false,"feudal",combatExample,"","A",4,3);
        Fighter feudal4 = new Fighter(UnitManager.getInstance().getTile(UnitType.FEUDAL_B_RANK),2,true,"feudal", combatExample,"","B",0,4);
        Fighter feudal5 = new Fighter(UnitManager.getInstance().getTile(UnitType.FEUDAL_B_RANK_2),2,false,"feudal",combatExample,"","C",4,2);
        Fighter feudal6 = new Fighter(UnitManager.getInstance().getTile(UnitType.FEUDAL_B_RANK_2),2,false,"feudal",combatExample,"","C",4,2);
        Fighter feudal7 = new Fighter(UnitManager.getInstance().getTile(UnitType.FEUDAL_C_RANK),3,false,"feudal",combatExample,"","C",2,2);
        Fighter feudal8 = new Fighter(UnitManager.getInstance().getTile(UnitType.FEUDAL_C_RANK),3,false,"feudal",combatExample,"","C",2,2);

        List<Leader> leaders = new ArrayList<>();
        leaders.add(feudalLeader);

        List<Fighter> fighters = new ArrayList<>();
        fighters.add(feudal1);
        fighters.add(feudal2);
        fighters.add(feudal3);
        fighters.add(feudal4);
        fighters.add(feudal5);
        fighters.add(feudal6);
        fighters.add(feudal7);
        fighters.add(feudal8);

        Army army = new Army(leaders, fighters, combatExample);
        combatExample.setArmy(army);

        // init goblin (marglush) example combat army
        Leader goblinLeader = new Leader(UnitManager.getInstance().getTile(UnitType.MARGLUSH), 1, false, "goblin", combatExample2, "", "Marglush", 1, 8);
        Fighter goblin1 = new Fighter(UnitManager.getInstance().getTile(UnitType.GOBLIN_B_RANK), 1, false, "goblin", combatExample2, "", "B", 0, 4);
        Fighter goblin2 = new Fighter(UnitManager.getInstance().getTile(UnitType.GOBLIN_B_RANK), 1, false, "goblin", combatExample2, "", "B", 0, 3);
        Fighter goblin3 = new Fighter(UnitManager.getInstance().getTile(UnitType.GOBLIN_B_RANK), 2, false, "goblin", combatExample2, "", "B", 0, 4);
        Fighter goblin4 = new Fighter(UnitManager.getInstance().getTile(UnitType.GOBLIN_B_RANK_2), 2, false, "goblin", combatExample2, "", "B", 0, 3);
        Fighter goblin5 = new Fighter(UnitManager.getInstance().getTile(UnitType.GOBLIN_B_RANK_2), 2, false, "goblin", combatExample2, "", "B", 0, 3);
        Fighter goblin6 = new Fighter(UnitManager.getInstance().getTile(UnitType.GOBLIN_C_RANK), 3, false, "goblin", combatExample2, "", "C", 2, 2);
        Fighter goblin7 = new Fighter(UnitManager.getInstance().getTile(UnitType.GOBLIN_C_RANK), 3, false, "goblin", combatExample2, "", "C", 2, 2);
        Fighter goblin8 = new Fighter(UnitManager.getInstance().getTile(UnitType.GOBLIN_C_RANK), 3, false, "goblin", combatExample2, "", "C", 2, 2);

        List<Leader> leadersGoblin = new ArrayList<>();
        leadersGoblin.add(goblinLeader);

        List<Fighter> fightersGoblin = new ArrayList<>();
        fightersGoblin.add(goblin1);
        fightersGoblin.add(goblin2);
        fightersGoblin.add(goblin3);
        fightersGoblin.add(goblin4);
        fightersGoblin.add(goblin5);
        fightersGoblin.add(goblin6);
        fightersGoblin.add(goblin7);
        fightersGoblin.add(goblin8);

        Army army2 = new Army(leadersGoblin, fightersGoblin, combatExample2);
        combatExample2.setArmy(army2);

        // init goblin (grinphar) example combat army
        Leader goblinLeader2 = new Leader(UnitManager.getInstance().getTile(UnitType.GRINPHAR), 3, false, "goblin", combatExample3, "", "Grinphar", 0, 3);
        Fighter goblin9 = new Fighter(UnitManager.getInstance().getTile(UnitType.GOBLIN_C_RANK_2), 3, false, "goblin", combatExample3, "", "C", 0, 3);
        Fighter goblin10 = new Fighter(UnitManager.getInstance().getTile(UnitType.GOBLIN_C_RANK_2), 3, false, "goblin", combatExample3, "", "C", 0, 3);
        Fighter goblin11 = new Fighter(UnitManager.getInstance().getTile(UnitType.GOBLIN_C_RANK_2), 3, false, "goblin", combatExample3, "", "C", 0, 3);

        List<Leader> leadersGoblin2 = new ArrayList<>();
        leadersGoblin2.add(goblinLeader2);

        List<Fighter> fightersGoblin2 = new ArrayList<>();
        fightersGoblin.add(goblin9);
        fightersGoblin.add(goblin10);
        fightersGoblin.add(goblin11);

        Army army3 = new Army(leadersGoblin2, fightersGoblin2, combatExample3);
        combatExample3.setArmy(army3);


        Main.update();
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


    public void setArmyToMove(Army armyToMove) {
        this.armyToMove = armyToMove;
    }

    public Army getArmyToMove() {
        return armyToMove;
    }

    public ArrayList<Tile> getPath() {
        return path;
    }

    public void addPath(Tile tile) {
        this.path.add(tile);
    }

    public boolean isSelectArmy() { return selectArmy; }

    public void setSelectArmy(boolean selectArmy) { this.selectArmy = selectArmy; }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public int getNbTurns() {
        return nbTurns;
    }

    public void setNbTurns(int nbTurns) {
        this.nbTurns = nbTurns;
    }

}
