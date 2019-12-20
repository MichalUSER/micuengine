package org.micuengine;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
    MicuEngine micuEngine;

    public MouseInput(MicuEngine micuEngine) {
        this.micuEngine = micuEngine;
    }

    public int getX() {
        return MouseInfo.getPointerInfo().getLocation().x;
    }
    public int getY() {
        return MouseInfo.getPointerInfo().getLocation().y;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == 1) {
            micuEngine.isRightButtonPressed = true;
        } else if(e.getButton() == 2) {
            micuEngine.isMiddleButtonPressed = true;
        } else if(e.getButton() == 3) {
            micuEngine.isLeftButtonPressed = true;
        }
    }
}
