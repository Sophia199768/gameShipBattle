package org.example.playLogic;

import lombok.AllArgsConstructor;
import org.example.board.Board;
import org.example.ship.AllShips;
import org.example.ship.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class FillingTheBoard {
    private final int SIZE;

    private boolean canPlaceShip(int row, int col, Ship ship, Board board) {
        if (ship.isHorizontal()) {
            if (col + ship.getSize() > SIZE) {
                return false;
            }
            for (int i = 0; i < ship.getSize(); i++) {
                if (board.getBoard()[row][col + i] != '.') {
                    return false;
                }
            }
        } else {
            if (row + ship.getSize() > SIZE) {
                return false;
            }
            for (int i = 0; i < ship.getSize(); i++) {
                if (board.getBoard()[row + i][col] != '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean placeShip(Ship ship, Board board) {
        Random rand = new Random();
        int row, col;

        do {
            row = rand.nextInt(SIZE) + 1;
            col = rand.nextInt(SIZE) + 1;
        } while (!canPlaceShip(row, col, ship, board));

        if (ship.isHorizontal()) {
            for (int i = 0; i < ship.getSize(); i++) {
                board.set(row, col + i, '!');
            }

            for (int i = 0; i <= ship.getSize(); i++) {
                board.set(row - 1, col + i - 1, '|');
                board.set(row + 1, col + i - 1, '|');
            }

            board.set(row, col +  ship.getSize(), '|');
            board.set(row, col - 1, '|');

        } else {
            for (int i = 0; i < ship.getSize(); i++) {
                board.set(row + i, col, '!');
            }

            for (int i = 0; i <= ship.getSize() + 1; i++) {
                board.set(row + i - 1, col - 1, '|');
                board.set(row + i - 1, col + 1, '|');
            }

            board.set(row + ship.getSize(), col, '|');
            board.set(row - 1, col, '|');
        }

        return true;
    }

    public void Start(Board board, int amountOfShipTypes, int amountOfBiggestDesk) {
        AllShips allShips = new AllShips(amountOfShipTypes, amountOfBiggestDesk);
        List<Ship> ships = allShips.madeShips(new ArrayList<>());
        for (int i = 0; i < ships.size(); i++) {
            placeShip(ships.get(i), board);
        }
    }
}
