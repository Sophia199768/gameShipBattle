package org.example.ship;

import java.util.List;
import java.util.Random;

public class AllShips {
    private final int AMOUNT_OF_SHIP_TYPES = 4;
    private final int THE_BIGGEST_DESK_SHIP = 4;

    public List<Ship> madeShips(List<Ship> ships) {
        Random random = new Random();
        boolean oriented;
        int j = 1;

        for (int i = 1; i <= AMOUNT_OF_SHIP_TYPES; i++) {
            for (; j <= THE_BIGGEST_DESK_SHIP; j++) {
                oriented = random.nextBoolean();
                Ship ship = new Ship(i, oriented);
                ships.add(ship);
            }

            j = i;
        }

        return ships;
    }
}
