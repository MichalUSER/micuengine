package org.micuengine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    MicuEngine micuEngine;

    public KeyInput(MicuEngine micuEngine) {
        this.micuEngine = micuEngine;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            micuEngine.isEnterKeyPressed = true;
        } else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            micuEngine.isEscapeKeyPressed = true;
        } else if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
            micuEngine.isControlKeyPressed = true;
        } else if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
            micuEngine.isShiftKeyPressed = true;
        }
        micuEngine.key = String.valueOf(e.getKeyChar());
    }
}
