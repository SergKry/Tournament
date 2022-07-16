package ru.netology.Tournament.game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import ru.netology.Tournament.service.NotRegisteredException;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public ArrayList<Player> getPlayers() {
        return players;
    }
    public void registration(Player player) {
        players.add(player);
    }

    public int battle(String playerName1, String playerName2) {
        Player n1 = null;
        Player n2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                n1 = player;
            }
            if (player.getName().equals(playerName2)) {
                n2 = player;
            }
        }
        if (n1 == null) {
            throw new NotRegisteredException("Игрок" + playerName1 + "не зарегистрирован");
        }
        if (n2 == null) {
            throw new NotRegisteredException("Игрок" + playerName2 + "не зарегистрирован");
        }
        if (n1.getStrength() == n2.getStrength()) {
            return 0;
        }
        if (n1.getStrength() > n2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }
}
