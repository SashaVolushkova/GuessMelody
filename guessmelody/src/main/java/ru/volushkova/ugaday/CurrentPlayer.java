package ru.volushkova.ugaday;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import lombok.Getter;

/**
 * один на приложение!!!!!
 */
@Getter
public class CurrentPlayer {
    private MediaPlayer currentPlayer;

    public void stop() {
        if(currentPlayer != null) {
            currentPlayer.stop();
        }
    }

    public void playAndSetMelody(String path, Integer stopTime) {
        stop();
        Media media = new Media(path);
        currentPlayer = new MediaPlayer(media);
        if(stopTime != null) {
            currentPlayer.setStopTime(Duration.seconds(stopTime));
        }
        currentPlayer.play();
        currentPlayer.setOnError(() -> {
            System.out.println("Error : " + currentPlayer.getError().toString());
        });
    }
    public void playAndSetMelody(String path) {
        playAndSetMelody(path, null);
    }
}
