package com.company.model.units;

import javafx.util.Pair;

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
     * List of the fighter under the command of the leader
     */
    private ArrayList<Fighter> fightersList;

    /**
     * Constructor
     * @param armor Param of the super class Unit
     * @param mounted Param of the super class Unit
     * @param race Param of the super class Unit
     * @param MP Param of the super class Unit
     * @param position Param of the super class Unit
     * @param deploymentCode Param of the super class Unit
     * @param name The name of the leader
     * @param moralModifier The moral modifier of the leader
     * @param commandLimit The command limit of the leader
     */
    public Leader(int armor, Boolean mounted, String race, int MP, Pair position, String deploymentCode, String name, int moralModifier, int commandLimit) {
        super(armor, mounted, race, MP, position, deploymentCode);
        this.name = name;
        this.moralModifier = moralModifier;
        this.commandLimit = commandLimit;
    }

    /**
     * Getter of the name
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter of the moral modifier
     * @return The moral modifier value
     */
    public int getMoralModifier() {
        return moralModifier;
    }

    /**
     * Getter of the commandLimit
     * @return The command limit value
     */
    public int getCommandLimit() {
        return commandLimit;
    }

    /**
     * Getter of the fighters list
     * @return The list of the fighter under the leader's command
     */
    public ArrayList<Fighter> getFightersList() {
        return fightersList;
    }

    /**
     * Setter of the fighters list
     * @param fightersList The new list of the fighter under the leader's command
     */
    public void setFightersList(ArrayList<Fighter> fightersList) {
        this.fightersList = fightersList;
    }

    /**
     * Delete a fighter of the control of the leader
     * @param fighter The fighter to delete
     */
    public void deleteAssociateFighter(Fighter fighter) {
        if(this.fightersList.contains(fighter)){
            this.fightersList.remove(fighter);
        }
    }

    /**
     * Add a new fighter under the control of the leader
     * @param fighter The fighter to add
     */
    public void addAssociateFighter(Fighter fighter) {
        this.fightersList.add(fighter);
    }
}