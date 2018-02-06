package com.company.model.units;


import com.company.model.Tile;

/**
 * Class Fighter extends Unit represent a fighter
 */
public class Fighter extends Unit {
    /**
     * The moral of a fighter
     */
    private String moral;

    /**
     * The missile value of a fighter
     */
    private int missileValue;

    /**
     * The melee value of a fighter
     */
    private int meleeValue;

    /**
     * Constructor
     * @param armor Param of the super class Unit
     * @param mounted Param of the super class Unit
     * @param race Param of he super class Unit
     * @param position Param of the super class Unit
     * @param deploymentCode Param of the super class Unit
     * @param moral The moral of the fighter
     * @param missileValue The missile value of the fighter
     * @param meleeValue The melee value of the fighter
     */
    public Fighter(int armor, Boolean mounted, String race, Tile position, String deploymentCode, String moral, int missileValue, int meleeValue) {
        super(armor, mounted, race, position, deploymentCode);
        this.moral = moral;
        this.missileValue = missileValue;
        this.meleeValue = meleeValue;
    }

    /**
     * Getter of the moral
     * @return The moral
     */
    public String getMoral() {
        return moral;
    }

    /**
     * Getter of the missile value
     * @return The missile value
     */
    public int getMissileValue() {
        return missileValue;
    }

    /**
     * Getter of melee value
     * @return The melee value
     */
    public int getMeleeValue() {
        return meleeValue;
    }

}
