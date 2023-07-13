package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game = new Game();

    Player vasya = new Player(1, "Вася", 100);
    Player petya = new Player(2, "Петя", 110);
    Player sasha = new Player(3, "Саша", 100);

    @Test
    public void firstPlayerShouldWin() {

        game.register(petya);
        game.register(sasha);

        Assertions.assertEquals(1, game.round("Петя", "Саша"));
    }

    @Test
    public void secondPlayerShouldWin() {

        game.register(vasya);
        game.register(petya);

        Assertions.assertEquals(2, game.round("Вася", "Петя"));
    }

    @Test
    public void nobodyShouldWin() {

        game.register(vasya);
        game.register(sasha);

        Assertions.assertEquals(0, game.round("Вася", "Саша"));
    }

    @Test
    public void firstPlayerIsNotExist() {

        game.register(vasya);
        game.register(sasha);

        Assertions.assertThrows(NoRegisteredException.class, () -> game.round("Света", "Саша"));
    }

    @Test
    public void secondPlayerIsNotExist() {

        game.register(petya);
        game.register(sasha);

        Assertions.assertThrows(NoRegisteredException.class, () -> game.round("Петя", "Вася"));
    }
}
