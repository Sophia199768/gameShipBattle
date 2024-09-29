package org.example.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.Board.Board;


@Getter
@Setter
@RequiredArgsConstructor
public class Player {
    private final Board board;
    private int health = 20;

    public void minusHealth() {
        health--;
    }
}
