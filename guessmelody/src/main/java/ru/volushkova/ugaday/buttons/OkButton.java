package ru.volushkova.ugaday.buttons;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import lombok.Getter;

import java.net.URISyntaxException;

@Getter
public class OkButton {
    static final String OK_MUSIC = "/music/um_right.mp3";
    private final Media okMedia = new Media(getClass().getResource(OK_MUSIC).toURI().toString());
    private final Button okButton;
    public OkButton() throws URISyntaxException {
        okButton = new Button();
        okButton.setId("ok");
        okButton.setBackground(Background.EMPTY);
       // okButton.setText("Угадано!");
        okButton.setDisable(true);
        okButton.setOnAction(event -> {
            MediaPlayer ok = new MediaPlayer(okMedia);
            ok.play();
        });
    }

}
