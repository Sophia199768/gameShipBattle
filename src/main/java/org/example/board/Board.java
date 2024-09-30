package org.example.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    private final char[][] board;
    private int BOUNDS = 2;

    public void set(int x, int y, char val) {
        board[x][y] = val;
    }

    public Board(int boardSize) {
        board = new char[boardSize + BOUNDS][boardSize + BOUNDS];
        for (int i = 0; i < boardSize + BOUNDS; i++) {
            for (int j = 0; j < boardSize + BOUNDS; j++) {
                board[i][j] = '.';
            }
        }
    }
}
