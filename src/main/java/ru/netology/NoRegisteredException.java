package ru.netology;

public class NoRegisteredException extends RuntimeException {
    public NoRegisteredException(String playerName) {
        super("Игрок с именем" + playerName + "не найден");
    }
}
