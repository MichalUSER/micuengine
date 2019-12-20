package com.company;

import org.micuengine.MicuEngine;

public class EngineTester extends MicuEngine {

    public static void main(String[] args) {
        new EngineTester();
    }

    int x = 500;
    int y = 330;

    @Override
    public void setup() {
        background(0, 0, 0);
        setSize(1300, 750);
        setTitle("MicuEngine V. 1.0");
    }

    @Override
    public void draw() {
        switch (key) {
            case "w":
                y -= 8;
                break;
            case "s":
                y += 8;
                break;
            case "a":
                x -= 8;
                break;
            case "d":
                x += 8;
                break;
        }

        r.fill(255, 255, 255);
        r.rect(x, y, 50, 50);
        String fps = String.valueOf(currentFps);
        r.fill(255, 255, 255);
        r.text(10, 10, fps);
    }
}
