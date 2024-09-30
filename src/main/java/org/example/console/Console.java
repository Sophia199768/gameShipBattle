package org.example.console;

import lombok.AllArgsConstructor;
import org.example.playLogic.PlayLogic;
import org.example.playLogic.SeaBattleException;
import org.example.player.Player;

import java.util.Scanner;

@AllArgsConstructor
public class Console {
    private int boardSize;

    public int[] cell() {
        int firstCoordinate = 1;
        int x;
        int y;
        System.out.println("Write x, y: ");

        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        y = scanner.nextInt();

        if ((x > boardSize || y > boardSize) || (x < firstCoordinate || y < firstCoordinate)) {
            throw new SeaBattleException("You can choose only from 1 to 10");
        }

        return new int[]{x, y};
    }


    public void writeMessage(String m) {
        System.out.println(m);
    }

    public void write(PlayLogic playLogic) {
        Player firstPlayer;
        Player secondPlayer;

        if (playLogic.isCounter()) {
            firstPlayer = playLogic.getFirstPlayer();
            secondPlayer = playLogic.getSecondPlayer();
        } else {
            secondPlayer = playLogic.getFirstPlayer();
            firstPlayer = playLogic.getSecondPlayer();
        }

        System.out.println("Your desk");

        for (int i = 1; i <= boardSize; i++) {
            for (int j = 1; j <= boardSize; j++) {
                if (firstPlayer.getBoard().getBoard()[i][j] == '|') {
                    System.out.print('.');
                } else {
                    System.out.print(firstPlayer.getBoard().getBoard()[i][j]);
                }
            }
            System.out.println();
        }

        System.out.println("Your partner desk");


        for (int i = 1; i <= boardSize; i++) {
            for (int j = 1; j <= boardSize; j++) {
                if (secondPlayer.getBoard().getBoard()[i][j] == '!' ||
                        secondPlayer.getBoard().getBoard()[i][j] == '|') {
                    System.out.print('.');
                } else {
                    System.out.print(secondPlayer.getBoard().getBoard()[i][j]);
                }
            }
            System.out.println();
        }

    }
}
