package org.example.Board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    private final char[][] board;

    public Board() {
        board = new char[10][10];
    }
}
