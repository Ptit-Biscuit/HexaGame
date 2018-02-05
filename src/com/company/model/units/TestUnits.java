package com.company.model.units;

import com.company.model.Tile;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Used to test the unit behavior
 */
public class TestUnits {
    /**
     * Calculate the result of a battle
     * @param attackFighterList The list of the attacker fighter
     * @param defendFighterList The list of the defender fighter
     * @param attackerPosition The tile of the attacker
     * @param defenderPosition The tile of the defender
     */
    public void fight(ArrayList<? extends Unit> attackFighterList, ArrayList<? extends Unit> defendFighterList,
                      Tile attackerPosition, Tile defenderPosition){

    }

    /**
     * Main
     * @param args The arguments
     */
    public static void main (String[] args){
        Leader feudalLeader = new Leader(5, true, "feudal", 15,
                new Pair<>(0, 0), "RE", "Count X", 3, 5);
        Fighter feudal1 = new Fighter(1, false, "feudal", 10,
                new Pair<>(0,0),"RE", "A", 3, 3);
        Fighter feudal2 = new Fighter(3, false, "feudal", 10,
                new Pair<>(0,0),"", "C", 3, 3);
        Fighter feudal3 = new Fighter(3, false, "feudal", 10,
                new Pair<>(0,0),"", "C", 3, 3);
        Fighter feudal4 = new Fighter(3, false, "feudal", 10,
                new Pair<>(0,0),"", "C", 3, 3);

        ArrayList<? extends Unit> feudalList = new ArrayList<>(Arrays.asList(feudalLeader, feudal1, feudal2, feudal3, feudal4));

        Leader goblinLeader = new Leader(6, false, "goblin", 13,
                new Pair<>(0, 0), "RE", "King G", 4, 6);
        Fighter goblin1 = new Fighter(2, false, "goblin", 10,
                new Pair<>(0,0),"RE", "B", 3, 3);
        Fighter goblin2 = new Fighter(2, false, "goblin", 10,
                new Pair<>(0,0),"RE", "B", 3, 3);
        Fighter goblin3 = new Fighter(3, false, "goblin", 10,
                new Pair<>(0,0),"RE", "B", 0, 3);

        ArrayList<? extends Unit> goblinList = new ArrayList<>(Arrays.asList(goblinLeader, goblin1, goblin2, goblin3));
    }
}
