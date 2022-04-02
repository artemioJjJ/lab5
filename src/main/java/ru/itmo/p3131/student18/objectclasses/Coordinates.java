package ru.itmo.p3131.student18.objectclasses;

public class Coordinates {
    private long x;
    private long y;

    public Coordinates(Long x, Long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public String toString() {
        return "x: " + x + ", y:" + y;
    }
}