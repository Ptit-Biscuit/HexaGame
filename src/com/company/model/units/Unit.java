package com.company.model.units;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class Unit {
    private int armor;
    private Boolean mounted;
    private String race;
    private int MP;
    private int MPGhost;
    private Pair position;
    private String deploymentCode;

    public Unit(int armor, Boolean mounted, String racse, int MP, Pair position, String deploymentCode) {
        this.armor = armor;
        this.mounted = mounted;
        this.race = race;
        this.MP = MP;
        this.MPGhost = 0;
        this.position = position;
        this.deploymentCode = deploymentCode;
    }

    public  int getArmor() {
        return armor;
    }

    public  void setArmor(int armor) {
        this.armor = armor;
    }

    public  Boolean getMounted() {
        return mounted;
    }

    public  void setMounted(Boolean mounted) {
        this.mounted = mounted;
    }

    public  String getRace() {
        return race;
    }

    public  void setRace(String race) {
        this.race = race;
    }

    public  int getMP() {
        return MP;
    }

    public  void setMP(int MP) {
        this.MP = MP;
    }

    public  int getMPGhost() {
        return MP;
    }

    public  void setMPGhost(int MP) {
        this.MP = MP;
    }

    public  Pair getPosition() {
        return position;
    }

    public  void setPosition(Pair position) {
        this.position = position;
    }

    public  String getDeploymentCode() {
        return deploymentCode;
    }

    public  void setDeploymentCode(String deploymentCode) {
        this.deploymentCode = deploymentCode;
    }


}
