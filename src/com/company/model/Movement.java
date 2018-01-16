package com.company.model;

import com.company.Goblin;
import com.company.model.units.Unit;
import com.company.system.Triplet;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class Movement represent a movement
 */
public class Movement {
	/**
	 *
	 * @param selected
	 * @param movementList
	 * @return
	 */
    public Boolean move(Tile selected, ArrayList<Pair> movementList) {
        if (selected.getUnits().isEmpty() || movementList.isEmpty()) {
	        return false;
        }

	    List<Unit> units = selected.getUnits();

        movementList.stream()
	        .map(p -> new Triplet((int) p.getKey(), (int) p.getValue(), - (int) p.getKey() - (int) p.getValue()))
	        .map(Goblin::getHexagon).forEach(h -> {
	        /*if () {
		        return false;
	        }*/
        });

        return true;
    }
}
