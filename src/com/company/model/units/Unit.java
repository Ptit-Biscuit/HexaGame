package com.company.model.units;

import javafx.util.Pair;

/**
 * Class Unit represent a unit
 */
public class Unit {

    /**
     * Unit armor
     */
    private int armor;

    /**
     * If the unit is mounted or not
     */
    private Boolean mounted;

    /**
     * Race of the unit
     */
    private String race;

    /**
     * Number of movement point of the unit
     */
    private int MP;

    /**
     * Number of MP after a movement test
     */
    private int MPGhost;

    /**
     * A pair that represents the position of the unit
     */
    private Pair position;

    /**
     * Deployment code of the unit
     */
    private String deploymentCode;

    /**
     * Constructor
     * @param armor
     * @param mounted
     * @param MP
     * @param position
     * @param deploymentCode
     */
    public Unit(int armor, Boolean mounted, String race, int MP, Pair position, String deploymentCode) {
        this.armor = armor;
        this.mounted = mounted;
        this.race = race;
        this.MP = MP;
        this.position = position;
        this.deploymentCode = deploymentCode;
        this.MPGhost = 0;
    }

    /**
     * Getter of the armor
     * @return The armor
     */
    public  int getArmor() {
        return armor;
    }

    /**
     * Getter of the mounted value
     * @return The mounted value
     */
    public  Boolean getMounted() {
        return mounted;
    }

    /**
     * Setter of the mounted value
     * @param mounted The new value of mounted
     */
    public  void setMounted(Boolean mounted) {
        this.mounted = mounted;
    }

    /**
     * Getter of the race
     * @return the race
     */
    public  String getRace() {
        return race;
    }

    /**
     * Getter of MP
     * @return The movement point
     */
    public  int getMP() {
        return MP;
    }

    /**
     * Setter of the MP
     * @param MP The new value of MP
     */
    public  void setMP(int MP) {
        this.MP = MP;
    }

    /**
     * Getter of MPGhost
     * @return The MPGhost
     */
    public  int getMPGhost() {
        return MPGhost;
    }

    /**
     * Setter of MPGhost
     * @param MPGhost The new value of MPGhost
     */
    public  void setMPGhost(int MPGhost) {
        this.MPGhost = MPGhost;
    }

    /**
     * Getter of position
     * @return The position
     */
    public  Pair getPosition() {
        return position;
    }

    /**
     * Setter of position
     * @param position The new position
     */
    public  void setPosition(Pair position) {
        this.position = position;
    }

    /**
     * Getter of deployment code
     * @return The deployment code
     */
    public  String getDeploymentCode() {
        return deploymentCode;
    }


}
