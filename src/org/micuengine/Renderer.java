package org.micuengine;

import java.awt.*;

public class Renderer {
    Graphics2D g;
    MicuEngine micuEngine;

    public Renderer(Graphics2D g, MicuEngine micuEngine) {
        this.g = g;
        this.micuEngine = micuEngine;
    }

    public void fill(int r, int g, int b) {
        this.g.setColor(new Color(r, g, b));
    }

    public void image(Texture texture, int x, int y) {
        g.drawImage(texture.i, x, y, micuEngine);
    }

    public void setFont(Font font) {
        g.setFont(font.font);
    }

    public void text(float x, float y, String string) {
        g.drawString(string, x, y);
    }

    public void rect(float x, float y, int width, int height) {
        g.fillRect((int) x, (int) y, width, height);
    }
}
