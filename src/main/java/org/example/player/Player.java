package org.example.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.board.Board;


@Getter
@Setter
@AllArgsConstructor
public class Player {
    private final Board board;
    private int health;

    public void minusHealth() {
        health--;
    }
}
