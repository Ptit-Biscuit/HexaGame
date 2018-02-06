package com.company.model.units;

import com.company.model.Tile;

/**
 * Class Unit represent a unit
 */
public abstract class Unit {

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
     * A tile that represents the position of the unit
     */
    private Tile position;


    /**
     * Deployment code of the unit
     */
    private String deploymentCode;


    /**
     * Constructor
     * @param armor The unit armor
     * @param mounted If the unit is mounted
     * @param race The race of the unit
     * @param position The position of the unit
     * @param deploymentCode The deployment code of the unit
     */
    public Unit(int armor, Boolean mounted, String race, Tile position, String deploymentCode) {
        this.armor = armor;
        this.mounted = mounted;
        this.race = race;
        this.position = position;
        this.deploymentCode = deploymentCode;
        this.MP = 10;
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
     * Getter of position
     * @return The position
     */
    public  Tile getPosition() {
        return position;
    }

    /**
     * Setter of position
     * @param position The new position
     */
    public  void setPosition(Tile position) {
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
