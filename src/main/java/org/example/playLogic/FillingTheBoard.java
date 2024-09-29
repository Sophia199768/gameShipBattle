package org.example.playLogic;

import lombok.AllArgsConstructor;
import org.example.Board.Board;
import org.example.ship.AllShips;
import org.example.ship.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class FillingTheBoard {
    private final int SIZE = 10;
    private final int AMOUNT_OF_SHIPS = 10;

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
            row = rand.nextInt(SIZE);
            col = rand.nextInt(SIZE);
        } while (!canPlaceShip(row, col, ship, board));

        if (ship.isHorizontal()) {
            for (int i = 0; i < ship.getSize(); i++) {
                board.getBoard()[row][col + i] = '!';
            }
        } else {
            for (int i = 0; i < ship.getSize(); i++) {
                board.getBoard()[row + i][col] = '!';
            }
        }

        return true;
    }

    public void Start(Board board) {
        AllShips allShips = new AllShips();
        List<Ship> ships = allShips.madeShips(new ArrayList<>());
        for (int i = 0; i < AMOUNT_OF_SHIPS; i++) {
            placeShip(ships.get(i), board);
        }
    }
}
