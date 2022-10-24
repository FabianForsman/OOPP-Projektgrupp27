package Model.Audio;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class SongPlayer {

    /**
     * Pre-made constructor for playing music.
     * @param audioFileLocation
     */
    public void playSong(String audioFileLocation) {

        File songLocation = new File(audioFileLocation);

        try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(songLocation);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();

        }
        catch (Exception ignored) {

        }

    }



}
