package com.company.model;

import com.company.Main;
import com.company.model.enums.Facing;
import com.company.model.enums.TileType;
import com.company.model.units.Army;
import com.company.model.units.Unit;
import com.company.utils.Triplet;

import java.util.ArrayList;
import java.util.List;

/**
 * Tile of the map
 */
public class Tile {
    /**
     *
     */
    private final Triplet coordinates;

    /**
     * Type of the tile
     */
    private TileType type;

    /**
     * Units of the tile
     */
    private List<Unit> units;

    /**
     * Army of the tile
     */
    private Army army;

    /**
     * River on the tile
     */
    private Facing river[];

    /**
     * Road on the tile
     */
    private Facing road[];

    /**
     * Forest on the tile
     */
    private boolean forest;

    /**
     * Bridge on the tile
     */
    private Facing bridge[];

    /**
     * Constructor
     */
    public Tile(Triplet coordinates) {
        this.coordinates = coordinates;
        this.units = new ArrayList<>();
    }

    /**
     * Getter of the type
     *
     * @return The type
     */
    public TileType getType() {
        return this.type;
    }

    /**
     * Setter of the type
     *
     * @param type The new type
     */
    public void setType(TileType type) {
        this.type = type;
    }

    /**
     *
     */
    public void setArmy(Army army) {
        this.army = army;

        this.army.getLeader().forEach(l -> Board.getInstance().getTile(new Triplet(11,13,-24)).setUnits(l));
        this.army.getFighters().forEach(f -> Board.getInstance().getTile(new Triplet(11,13,-24)).setUnits(f));
    }

    /**
     * Getter of the army of the tile
     *
     * @return The army of the tile
     */
    public Army getArmy() {
        return this.army;
    }

    /**
     * Getter of the units of the tile
     *
     * @return The units of the tile
     */
    public List<Unit> getUnits() {
        return this.units;
    }

    /**
     * Setter of the units of the tile
     *
     * @param unit The unit to add on the tile
     */
    public void setUnits(Unit unit) {
        if (unit != null) {
	        this.units.add(unit);
        }
    }

    /**
     * Remove a unit from the tile
     *
     * @param unit The unit to be remove
     */
    public boolean removeUnit(Unit unit) {
        return units.contains(unit) && units.remove(unit);
    }

    /**
     * Getter of the orientation of the river
     *
     * @return The orientation of the river
     */
    public Facing[] getRiver() {
        return this.river;
    }

    /**
     * Setter of the orientation of the river
     *
     * @param river The new orientation of the river
     */
    public void setRiver(Facing[] river) {
        this.river = river;
    }

    /**
     * Getter of the orientation of the road
     *
     * @return The orientation of the road
     */
    public Facing[] getRoad() {
        return this.road;
    }

    /**
     * Setter of the orientation of the road
     *
     * @param road The new orientation of the road
     */
    public void setRoad(Facing[] road) {
        this.road = road;
    }

    /**
     * Getter of the orientation of the forest
     *
     * @return The orientation of the forest
     */
    public boolean getForest() {
        return this.forest;
    }

    /**
     * Setter of the orientation of the forest
     *
     * @param forest The new orientation of the forest
     */
    public void setForest(boolean forest) {
        this.forest = forest;
    }

    /**
     * Getter of the orientation of the bridge
     *
     * @return The orientation of the bridge
     */
    public Facing[] getBridge() {
        return this.bridge;
    }

    /**
     * Setter of the orientation of the bridge
     *
     * @param bridge The new orientation of the bridge
     */
    public void setBridge(Facing[] bridge) {
        this.bridge = bridge;
    }

    /**
     *
     * @return
     */
    public Triplet getCoordinates() {
        return coordinates;
    }
}
