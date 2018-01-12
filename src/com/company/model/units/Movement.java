package com.company.model.units;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class Movement {


/*
    public Boolean detectMove(Pair selected, ArrayList<Pair> movementList) {
        Unit unit;

        if (!containUnit(selected)){
            return false;
        }
        if(selected.getCountUnit()>1){
             unit = chooseUnit();
        } else {
             unit = getUnit();
        }

        int mp = unit.getMP();


        if(movementList.isEmpty()){
            return false;
        }

        for (Pair currentCoord:movementList){
            if(!Arrays.asList(selected.getNeighbors()).contains(currentCoord)) {
                return false;
            }
            if (unit.getMP()-currentCoord.getConso()<0){
                return false;
            }
            mp = mp - currentCoord.getConso();
        }
        return true;
    }

    */

}
