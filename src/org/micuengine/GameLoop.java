package org.micuengine;

public class GameLoop extends Thread {
    MicuEngine micuEngine;

    public boolean render = false;
    private boolean running = false;
    private double updateCap = 1.0/60.0;

    public GameLoop(double fps, MicuEngine micuEngine) {
        this.micuEngine = micuEngine;
        updateCap = 1.0/fps;
    }

    public void run() {
        running = true;

        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        int fps = 0;

        while(running) {
            render = false;

            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while(unprocessedTime >= updateCap) {
                unprocessedTime -= updateCap;
                render = true;

                if(frameTime >= 1.0) {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                }
            }

            if(render) {
                frames++;
                micuEngine.currentFps = fps;
                micuEngine.mouseX = micuEngine.mouseInput.getX();
                micuEngine.mouseY = micuEngine.mouseInput.getY();
                micuEngine.repaint();
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
