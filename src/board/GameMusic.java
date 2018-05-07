package board;

import javax.sound.sampled.*;
import java.io.File;

public class GameMusic {
    private Clip buttonSound;
    private int i = 5;
    public void play(String filename) {
        try {
            AudioInputStream aIn = AudioSystem.getAudioInputStream(new File(filename).getAbsoluteFile());
            buttonSound = AudioSystem.getClip();
            buttonSound.open(aIn);
            buttonSound.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void playCont(String filename) {
        try {
            AudioInputStream aIn = AudioSystem.getAudioInputStream(new File(filename).getAbsoluteFile());
            buttonSound = AudioSystem.getClip();
            buttonSound.open(aIn);
            buttonSound.loop(i++);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void stop(){
        buttonSound.stop();
    }
}