package com.company.model.units;

import javafx.util.Pair;
import java.util.ArrayList;

public class Leader extends Unit {
    private String name;
    private int moralModifier;
    private int commandLimit;
    private ArrayList<Fighter> fightersList;

    public Leader(int armor, Boolean mounted, String race, int MP, Pair position, String deployementCode, String name, int moralModifier, int commandLimit) {
        super(armor, mounted, race, MP, position, deployementCode);
        this.name = name;
        this.moralModifier = moralModifier;
        this.commandLimit = commandLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoralModifier() {
        return moralModifier;
    }

    public void setMoralModifier(int moralModifier) {
        this.moralModifier = moralModifier;
    }

    public int getCommandLimit() {
        return commandLimit;
    }

    public void setCommandLimit(int commandLimit) {
        this.commandLimit = commandLimit;
    }
}
