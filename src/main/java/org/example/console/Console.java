package org.example.console;

import org.example.player.Player;

import java.util.Scanner;

public class Console {

    public int[] cell() {
        int x;
        int y;
        System.out.println("Write x, y: ");

        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        y = scanner.nextInt();
        return new int[]{x, y};
    }

    public void write(Player firstPlayer, Player secondPlayer) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

            }
        }
    }
}
