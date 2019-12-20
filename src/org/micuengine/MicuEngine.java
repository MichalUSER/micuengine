package org.micuengine;

import javax.swing.*;
import java.awt.*;

public class MicuEngine extends JFrame {
    public MicuEngine micuEngine;
    MouseInput mouseInput;
    KeyInput keyInput;
    public Graphics2D g = null;
    public Renderer r;

    private GameLoop gl = null;
    public int currentFps = 0;
    private double wantedFps = 60.0;

    public String key = "";
    public int mouseX = 0;
    public int mouseY = 0;
    public boolean isEnterKeyPressed = false;
    public boolean isEscapeKeyPressed = false;
    public boolean isControlKeyPressed = false;
    public boolean isShiftKeyPressed = false;
    public boolean isLeftButtonPressed = false;
    public boolean isMiddleButtonPressed = false;
    public boolean isRightButtonPressed = false;

    public MicuEngine() {
        setup();
        micuEngine = this;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new Draw(), BorderLayout.CENTER);
        this.setVisible(true);
        keyInput = new KeyInput(micuEngine);
        mouseInput = new MouseInput(micuEngine);
        this.addKeyListener(keyInput);
        this.addMouseListener(mouseInput);
        gl = new GameLoop(wantedFps, micuEngine);
        gl.start();
    }

    public void setup() {}
    public void draw() {}

    public void background(int r, int g, int b) {
        this.getContentPane().setBackground(new Color(r, g, b));
    }

    public void setFps(double fps) {
        wantedFps = fps;
    }

    public class Draw extends JComponent {
        public void paint(Graphics graphics) {
            Graphics2D gr = (Graphics2D) graphics;
            gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g = gr;
            r = new Renderer(g, micuEngine);

            mouseX = mouseInput.getX();
            mouseY = mouseInput.getY();
            draw();
            micuEngine.key = "";
        }
    }
}
