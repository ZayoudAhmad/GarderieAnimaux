package Controllers;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class music {   
    public static void playSound(String filePath) {
       try {
            File soundFile = new File(music.class.getResource(filePath).toURI());
            Media media = new Media(soundFile.toURI().toString());
            MediaPlayer MP = new MediaPlayer(media);
            MP.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
}
