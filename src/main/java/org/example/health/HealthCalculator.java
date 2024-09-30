package org.example.health;

public class HealthCalculator {

    public int calculate(int amountOfShipTypes, int theBiggestDeskShip) {
        int health = 0;
        int j;

        for (int i = 1; i <= amountOfShipTypes; i++) {
            j = i;
            for (; j <= theBiggestDeskShip; j++) {
                health += i;
            }
        }

        return health;
    }
}
