package ru.netology.Tournament.service;
public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String a) {
        super(a);
    }
}