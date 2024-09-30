package org.example.board;

import lombok.AllArgsConstructor;
import org.example.playLogic.FillingTheBoard;

@AllArgsConstructor
public class BoardFabric {
    private int boardSize;
    private int amountOfShipTypes;
    private int theBiggestDeskShip;

    public Board boardCreate() {
        Board board = new Board(boardSize);
        FillingTheBoard fillingTheBoard = new FillingTheBoard(boardSize);

        fillingTheBoard.Start(board, amountOfShipTypes, theBiggestDeskShip);

        return board;
    }
}
