package edu.fiuba.algo3;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

import static javafx.scene.media.MediaPlayer.INDEFINITE;

public class MusicPlayer {

    public static MediaPlayer reproducirCancion(String cancion){
        String musicFile = "Musica/".concat(cancion);
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        mediaPlayer.setVolume(0.7);
        mediaPlayer.setCycleCount(INDEFINITE);
        return mediaPlayer;
    }
}
