package org.example.game;

import lombok.NoArgsConstructor;
import org.example.board.BoardFabric;
import org.example.console.Console;
import org.example.health.HealthCalculator;
import org.example.playLogic.PlayLogic;
import org.example.playLogic.SeaBattleException;
import org.example.player.Player;

import java.util.Random;

@NoArgsConstructor
public class Game {
    private Console console;
    private PlayLogic playLogic;
    private int boardSize = 10;
    private int amountOfShipTypes = 4;
    private int theBiggestDeskShip = 4;

    public Game(int boardSize, int amountOfShipTypes, int theBiggestDeskShip) {
        this.boardSize = boardSize;
        this.amountOfShipTypes = amountOfShipTypes;
        this.theBiggestDeskShip = theBiggestDeskShip;
    }

    public void init() {
        BoardFabric boardFabric = new BoardFabric(boardSize, amountOfShipTypes, theBiggestDeskShip);
        HealthCalculator healthCalculator = new HealthCalculator();

        Player firstPlayer = new Player(boardFabric.boardCreate(), healthCalculator.calculate(amountOfShipTypes, theBiggestDeskShip));
        Player secondPlayer = new Player(boardFabric.boardCreate(), healthCalculator.calculate(amountOfShipTypes, theBiggestDeskShip));

        Random random = new Random();
        playLogic = new PlayLogic(random.nextBoolean(), firstPlayer, secondPlayer);
        console = new Console(boardSize);
    }

    public void start() {
        while (!playLogic.endOfGame()) {

            try {
                console.write(playLogic);
                int[] turn = console.cell();
                playLogic.shot(turn[0], turn[1]);

            } catch (SeaBattleException e) {
                console.writeMessage(e.getMessage());
            }
        }

        if (playLogic.getFirstPlayer().getHealth() == 0) {
            console.writeMessage("First gamer win!");
        } else {
            console.writeMessage("Second gamer win!");
        }
    }

}
