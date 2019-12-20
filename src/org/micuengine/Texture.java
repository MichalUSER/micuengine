package org.micuengine;

import java.awt.*;

public class Texture {
    Image i;

    public Texture(String path) {
        Toolkit t = Toolkit.getDefaultToolkit();
        i = t.getImage(path);
    }
}
