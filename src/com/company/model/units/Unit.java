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
     * Number of MP after a movement
     */
    private int MPGhost;

    /**
     * A pair of coordinates that represents the position of the unit
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
        this.MPGhost = 0;
        this.position = position;
        this.deploymentCode = deploymentCode;
    }

    /**
     * Getter of the armor
     * @return The armor
     */
    public  int getArmor() {
        return armor;
    }

    /**
     * Setter of the armor
     * @param armor The new value of armor
     */
    public  void setArmor(int armor) {
        this.armor = armor;
    }

    /**
     *
     */
    public  Boolean getMounted() {
        return mounted;
    }

    /**
     *
     */
    public  void setMounted(Boolean mounted) {
        this.mounted = mounted;
    }

    /**
     *
     */
    public  String getRace() {
        return race;
    }

    /**
     *
     */
    public  void setRace(String race) {
        this.race = race;
    }

    /**
     *
     */
    public  int getMP() {
        return MP;
    }

    /**
     *
     */
    public  void setMP(int MP) {
        this.MP = MP;
    }

    /**
     *
     */
    public  int getMPGhost() {
        return MP;
    }

    /**
     *
     */
    public  void setMPGhost(int MP) {
        this.MP = MP;
    }

    /**
     *
     */
    public  Pair getPosition() {
        return position;
    }

    /**
     *
     */
    public  void setPosition(Pair position) {
        this.position = position;
    }

    /**
     *
     */
    public  String getDeploymentCode() {
        return deploymentCode;
    }

    /**
     *
     */
    public  void setDeploymentCode(String deploymentCode) {
        this.deploymentCode = deploymentCode;
    }


}
