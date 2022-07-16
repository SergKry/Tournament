package ru.netology.Tournament.game;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.Collections;
import ru.netology.Tournament.service.NotRegisteredException;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(2, "Sergey", 99);
    Player player2 = new Player(5, "Kirill", 85);
    Player player3 = new Player(10, "Olay", 99);
    Player player4 = new Player(15, "Nik", 105);

    @Test
    public void checkAddlistMax() {
        game.registration(player2);
        game.registration(player4);
        game.registration(player3);
        game.registration(player1);
        ArrayList<Player> actual = game.getPlayers();
        ArrayList<Player> expected = new ArrayList<>();
        Collections.addAll(expected, player2, player4, player3, player1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkAddlistMidlle() {
        game.registration(player1);
        game.registration(player3);
        ArrayList<Player> actual = game.getPlayers();
        ArrayList<Player> expected = new ArrayList<>();
        Collections.addAll(expected, player1, player3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkAddlistMin() {
        game.registration(player2);
        ArrayList<Player> actual = game.getPlayers();
        ArrayList<Player> expected = new ArrayList<>();
        Collections.addAll(expected, player2);
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void checkVictoryFirstPlayer() {
        game.registration(player2);
        game.registration(player4);
        game.registration(player3);


        int actual = game.battle("Olay", "Kirill");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void checkVictorySecondPlayer() {
        game.registration(player2);
        game.registration(player4);
        game.registration(player3);


        int actual = game.battle("Olay", "Nik");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void checkDrawBetweenPlayers() {
        game.registration(player2);
        game.registration(player1);
        game.registration(player3);


        int actual = game.battle("Olay", "Sergey");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkNotRegisteredExceptionFirstPlayer() {
        game.registration(player2);
        game.registration(player1);
        game.registration(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.battle("", "Olay");
        });
    }
    @Test
    public void checkNotRegisteredExceptionSecondPlayer() {
        game.registration(player2);
        game.registration(player1);
        game.registration(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.battle("Sergey", "");
        });
    }
}


