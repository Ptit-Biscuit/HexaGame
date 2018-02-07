package com.company.model.units;


import com.company.model.Tile;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Class Leader extends Unit represent a leader
 */
public class Leader extends Unit {
    /**
     * The name of the leader
     */
    private String name;

    /**
     * The moral modifier of the leader
     */
    private int moralModifier;

    /**
     * The command limit of the leader
     */
    private int commandLimit;

    /**
     * Constructor
     * @param leaderImage
     * @param armor          Param of the super class Unit
     * @param mounted        Param of the super class Unit
     * @param race           Param of the super class Unit
     * @param position       Param of the super class Unit
     * @param deploymentCode Param of the super class Unit
     * @param name           The name of the leader
     * @param moralModifier  The moral modifier of the leader
     * @param commandLimit   The command limit of the leader
     */
    public Leader(BufferedImage leaderImage, int armor, Boolean mounted, String race, Tile position, String deploymentCode, String name, int moralModifier, int commandLimit) {
        super(leaderImage, armor, mounted, race, position, deploymentCode);
        this.name = name;
        this.moralModifier = moralModifier;
        this.commandLimit = commandLimit;
    }

    /**
     * Getter of the name
     *
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter of the moral modifier
     *
     * @return The moral modifier value
     */
    public int getMoralModifier() {
        return moralModifier;
    }

    /**
     * Getter of the commandLimit
     *
     * @return The command limit value
     */
    public int getCommandLimit() {
        return commandLimit;
    }

}
