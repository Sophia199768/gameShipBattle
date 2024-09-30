package org.example.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    private final char[][] board;
    private int BOUNDS = 2;
    private int boardSizeWithBounds;

    public void set(int x, int y, char val) {
        board[x][y] = val;
    }

    public Board(int boardSize) {
        boardSizeWithBounds = boardSize + BOUNDS;
        board = new char[boardSizeWithBounds][boardSizeWithBounds];
        for (int i = 0; i < boardSizeWithBounds; i++) {
            for (int j = 0; j < boardSizeWithBounds; j++) {
                board[i][j] = '.';
            }
        }
    }

    public void clear() {
        for (int i = 0; i < boardSizeWithBounds; i++) {
            for (int j = 0; j < boardSizeWithBounds; j++) {
                board[i][j] = '.';
            }
        }
    }
}
