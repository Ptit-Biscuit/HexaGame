package com.company.model.units;

import com.company.model.Tile;

import java.awt.image.BufferedImage;

/**
 * Class Unit represent a unitImage
 */
public abstract class Unit {
    /**
     * Image of the unitImage
     */
    private BufferedImage unitImage;

    /**
     * Zoom of the unitImage
     */
    private BufferedImage zoom;

    /**
     * Unit armor
     */
    private int armor;

    /**
     * If the unitImage is mounted or not
     */
    private boolean mounted;

    /**
     * Race of the unitImage
     */
    private String race;

    /**
     * Number of movement point of the unitImage
     */
    private int MP;

    /**
     * A tile that represents the position of the unitImage
     */
    private Tile position;

    /**
     * Deployment code of the unitImage
     */
    private String deploymentCode;

    /**
     * Constructor
     * @param unit   The fighter image
     * @param zoom   The fighter image zoom
     * @param armor The itImage armor
     * @param mounted If the unitImage is mounted
     * @param race The race of the unitImage
     * @param position The position of the unitImage
     * @param deploymentCode The deployment code of the unitImage
     */
    public Unit(BufferedImage unit, BufferedImage zoom, int armor, boolean mounted, String race, Tile position, String deploymentCode) {
        this.unitImage = unit;
        this.zoom = zoom;
        this.armor = armor;
        this.mounted = mounted;
        this.race = race;
        this.position = position;
        this.deploymentCode = deploymentCode;
        this.MP = 10;
    }

    /**
     *
     */
    public BufferedImage getUnitImage() {
        return this.unitImage;
    }

    /**
     *
     */
    public BufferedImage getUnitZoom() {
        return this.zoom;
    }


    /**
     * Getter of the armor
     * @return The armor
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Getter of the mounted value
     * @return The mounted value
     */
    public boolean getMounted() {
        return mounted;
    }

    /**
     * Setter of the mounted value
     * @param mounted The new value of mounted
     */
    public void setMounted(boolean mounted) {
        this.mounted = mounted;
    }

    /**
     * Getter of the race
     * @return the race
     */
    public String getRace() {
        return race;
    }

    /**
     * Getter of MP
     * @return The movement point
     */
    public int getMP() {
        return MP;
    }

    /**
     * Setter of the MP
     * @param MP The new value of MP
     */
    public void setMP(int MP) {
        this.MP = MP;
    }

    /**
     * Getter of position
     * @return The position
     */
    public Tile getPosition() {
        return position;
    }

    /**
     * Setter of position
     * @param position The new position
     */
    public void setPosition(Tile position) {
        this.position = position;
    }

    /**
     * Getter of deployment code
     * @return The deployment code
     */
    public String getDeploymentCode() {
        return deploymentCode;
    }
}
