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
     * @param attackLeader The leader who attack
     * @param defendLeader The leader who defend
     * @param attackerPosition The tile of the attacker
     * @param defenderPosition The tile of the defender
     */
    public void fight(ArrayList<Fighter> attackFighterList, ArrayList<Fighter> defendFighterList, Leader attackLeader, Leader defendLeader, Tile attackerPosition, Tile defenderPosition){

    }


    public static void main (String[] args){
        Fighter feudal1 = new Fighter(1, Boolean.FALSE, "feudal", 10, new Pair(0,0),"RE", "A", 3, 3);
        Fighter feudal2 = new Fighter(3, Boolean.FALSE, "feudal", 10, new Pair(0,0),"", "C", 3, 3);
        Fighter feudal3 = new Fighter(3, Boolean.FALSE, "feudal", 10, new Pair(0,0),"", "C", 3, 3);
        Fighter feudal4 = new Fighter(3, Boolean.FALSE, "feudal", 10, new Pair(0,0),"", "C", 3, 3);
        ArrayList<Fighter> feudalList = new ArrayList<Fighter>(Arrays.asList(feudal1, feudal2, feudal3, feudal4));

        Fighter goblin1 = new Fighter(2, Boolean.FALSE, "goblin", 10, new Pair(0,0),"RE", "B", 3, 3);
        Fighter goblin2 = new Fighter(2, Boolean.FALSE, "goblin", 10, new Pair(0,0),"RE", "B", 3, 3);
        Fighter goblin3 = new Fighter(3, Boolean.FALSE, "goblin", 10, new Pair(0,0),"RE", "B", 0, 3);
        ArrayList<Fighter> goblinList = new ArrayList<Fighter>(Arrays.asList(goblin1, goblin2, goblin3));

    }
}
