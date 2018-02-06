package com.company.model;

import com.company.controller.manager.TileManager;
import com.company.model.enums.Facing;
import com.company.model.enums.TileType;
import com.company.model.units.Unit;
import com.company.utils.TileUtil;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.util.List;

/**
 * Tile of the map
 */
public class Tile {
    /**
     * Image representing the tile
     */
    private BufferedImage tile;

    /**
     * Type of the tile
     */
    private TileType type;

    /**
     * Units of the tile
     */
    private List<Unit> units;

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
    private Facing forest[];

    /**
     * Entrance on the tile (Mountain only)
     */
    private Facing entrance[];

    /**
     * Bridge on the tile
     */
    private Facing bridge[];

    /**
     * Constructor
     *
     * @param subimage Image representing the tile
     */
    public Tile(BufferedImage subimage) {
        tile = subimage;
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
     * Getter of the tile
     *
     * @return The tile
     */
    public BufferedImage getTile() {
        return this.tile;
    }

    /**
     * Setter of the tile
     *
     * @param tile The new tile
     */
    public void setTile(BufferedImage tile) {
        this.tile = tile;
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
        if (unit != null)
            this.units.add(unit);
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
        
        this.setTile(TileUtil.compose(river, TileType.RIVER, this.getTile()));
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
    public Facing[] getForest() {
        return this.forest;
    }

    /**
     * Setter of the orientation of the forest
     *
     * @param forest The new orientation of the forest
     */
    public void setForest(Facing[] forest) {
        this.forest = forest;
    }

    /**
     * Getter of the orientation of the entrance
     *
     * @return The orientation of the entrance
     */
    public Facing[] getEntrance() {
        return this.entrance;
    }

    /**
     * Setter of the orientation of the entrance
     *
     * @param entrance The new orientation of the entrance
     */
    public void setEntrance(Facing[] entrance) {
        this.entrance = entrance;
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
}
