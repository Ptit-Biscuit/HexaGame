package com.company.system;

import com.company.Goblin;
import com.company.fxcomponent.Hexagon;
import com.company.model.Tile;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

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

	    AtomicInteger mp = new AtomicInteger(selected.getUnits().get(0).getMP());
        final Hexagon[] previous = new Hexagon[1];

        movementList.stream()
	        .map(p -> new Triplet((int) p.getKey(), (int) p.getValue(), - (int) p.getKey() - (int) p.getValue()))
	        .forEach(t -> {
		        if (previous[0] != null) {
			        previous[0].getNeighbors().contains(t);
		        }

		        previous[0] = Goblin.getHexagon(t);
		        mp.getAndDecrement();
        });

        return true;
    }
}
