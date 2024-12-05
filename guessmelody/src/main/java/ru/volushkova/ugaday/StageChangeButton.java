package ru.volushkova.ugaday;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URISyntaxException;

public class StageChangeButton {
    private final String CHANGE_STAGE = "/music/um_endround.mp3";
    private final Scene scene;
    private final Pane root;
    private final Button button;
    Media media = new Media(getClass().getResource(CHANGE_STAGE).toURI().toString());

    public StageChangeButton(Scene scene, Pane root, CurrentPlayer currentPlayer) throws URISyntaxException {
        this.scene = scene;
        this.root = root;
        this.button = new Button();
        this.button.setText("Следующий раунд");
        this.button.setStyle("-fx-font: 10px Tahoma;");
        this.button.setOnAction(event -> {
                MediaPlayer player = new MediaPlayer(media);
                player.play();
                player.setOnEndOfMedia(() -> this.scene.setRoot(root));
                //currentPlayer.playAndSetMelody(getClass().getResource(CHANGE_STAGE).toURI().toString());

        });
    }

    public Button getButton() {
        return button;
    }
}
