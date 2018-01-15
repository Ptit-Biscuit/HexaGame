package com.company.model.units;

import javafx.util.Pair;

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
     * @param MP Param of the super class Unit
     * @param position Param of the super class Unit
     * @param deploymentCode Param of the super class Unit
     */
    public Fighter(int armor, Boolean mounted, String race, int MP, Pair position, String deploymentCode, String moral, int missileValue, int meleeValue) {
        super(armor, mounted, race, MP, position, deploymentCode);
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
