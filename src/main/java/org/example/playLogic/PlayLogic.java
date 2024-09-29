package org.example.playLogic;

import lombok.AllArgsConstructor;
import org.example.player.Player;

@AllArgsConstructor
public class PlayLogic {
    private boolean counter;
    private Player firstPlayer;
    private Player secondPlayer;

    public boolean endOfGame() {
        if (firstPlayer.getHealth() == 0 || secondPlayer.getHealth() == 0) {
            return true;
        }
        return false;
    }

    public void shot(int x, int y) {
        Player player;

        if (counter) {
            player = firstPlayer;
        } else {
            player = secondPlayer;
        }

        if (player.getBoard().getBoard()[x][y] == '!') {
            player.getBoard().getBoard()[x][y] = '#';
            player.minusHealth();
        } else if (player.getBoard().getBoard()[x][y] == '.') {
            player.getBoard().getBoard()[x][y] = '_';
            counter = false;
        } else if (player.getBoard().getBoard()[x][y] == '#') {
            throw new SeaBattleException("You have already shot there");
        }
    }
}

