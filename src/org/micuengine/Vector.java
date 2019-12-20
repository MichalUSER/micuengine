package org.micuengine;

public class Vector {
    public float x;
    public float y;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void add(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void substract(float x, float y) {
        this.x -= x;
        this.y -= y;
    }
}
