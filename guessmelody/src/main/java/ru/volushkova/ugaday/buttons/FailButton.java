package ru.volushkova.ugaday.buttons;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import lombok.Getter;

import java.net.URISyntaxException;

@Getter
public class FailButton {
    public static final String FAIL_MUSIC = "/music/ugadaj-melodiju-1995-neugadannaja-melodija.mp3";
    private final Media failMedia = new Media(getClass().getResource(FAIL_MUSIC).toURI().toString());
    private final Button failButton;

    public FailButton() throws URISyntaxException {
        this.failButton = new Button();
        failButton.setId("fail");
        failButton.setBackground(Background.EMPTY);
        failButton.setDisable(true);
      //  failButton.setText("Неа :-(!");
        failButton.setOnAction(event -> {
            MediaPlayer fail = new MediaPlayer(failMedia);
            fail.play();
        });
    }
}
