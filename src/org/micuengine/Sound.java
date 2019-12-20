package org.micuengine;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound extends Thread {
    Clip clip;

    public Sound(String filePath) {
        try {
            clip = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
            clip.open(audioInputStream);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void play(String options) {
        if(options.equals("continuosly")) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } else if(options.length() == 1) {
            int intOptions = Integer.parseInt(options);
            clip.loop(intOptions);
        }
        clip.start();
    }
}
