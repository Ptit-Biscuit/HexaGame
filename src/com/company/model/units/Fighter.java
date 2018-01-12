package com.company.model.units;

import javafx.util.Pair;

import java.util.ArrayList;

public class Fighter extends Unit {
    private String moral;
    private int missileValue;
    private int meleeValue;

    public Fighter(int armor, Boolean mounted, String race, int MP, Pair position, String deploymentCode, String moral, int missileValue, int meleeValue) {
        super(armor, mounted, race, MP, position, deploymentCode);
        this.moral = moral;
        this.missileValue = missileValue;
        this.meleeValue = meleeValue;
    }

    public String getMoral() {
        return moral;
    }

    public void setMoral(String moral) {
        this.moral = moral;
    }

    public int getMissileValue() {
        return missileValue;
    }

    public void setMissileValue(int missileValue) {
        this.missileValue = missileValue;
    }

    public int getMeleeValue() {
        return meleeValue;
    }

    public void setMeleeValue(int meleeValue) {
        this.meleeValue = meleeValue;
    }

}
