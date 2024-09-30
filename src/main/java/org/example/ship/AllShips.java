package org.example.ship;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class AllShips {
    private final int amountOfShipTypes;
    private final int theBiggestDeskShip;

    public List<Ship> madeShips(List<Ship> ships) {
        Random random = new Random();
        boolean oriented;
        int j;

        for (int i = 1; i <= amountOfShipTypes; i++) {
            j = i;
            for (; j <= theBiggestDeskShip; j++) {
                oriented = random.nextBoolean();
                Ship ship = new Ship(i, oriented);
                ships.add(ship);
            }
        }

        return ships;
    }
}
