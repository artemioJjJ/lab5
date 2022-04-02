package ru.itmo.p3131.student18.collection;

import java.time.LocalDateTime;
import java.util.Stack;

public class CustomStack<T> extends Stack<T> {
    private final LocalDateTime initTime;

    public CustomStack() {
        this.initTime = LocalDateTime.now();
    }

    public LocalDateTime getInitTime() {
        return initTime;
    }
}


