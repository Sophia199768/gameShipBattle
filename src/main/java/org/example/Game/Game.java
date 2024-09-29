package org.example.Game;

import org.example.Board.Board;
import org.example.console.Console;
import org.example.playLogic.FillingTheBoard;
import org.example.playLogic.PlayLogic;
import org.example.player.Player;

import java.util.Random;

public class Game {
    private Console console;
    private PlayLogic playLogic;

    public void gameStart() {
        Board board1 = new Board();
        Board board2 = new Board();
        FillingTheBoard fillingTheBoard = new FillingTheBoard();

        fillingTheBoard.Start(board1);
        fillingTheBoard.Start(board2);

        Player firstPlayer = new Player(board1);
        Player secondPlayer = new Player(board2);

        Random random = new Random();
        boolean turn = random.nextBoolean();

        PlayLogic playLogic = new PlayLogic(turn, firstPlayer, secondPlayer);
    }

    public void game() {
        console = new Console();

        while (!playLogic.endOfGame()) {
            int[] turn = console.cell();
            playLogic.shot(turn[0], turn[1]);
        }
    }
}
