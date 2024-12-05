package ru.volushkova.ugaday.start;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import ru.volushkova.ugaday.CurrentPlayer;
import ru.volushkova.ugaday.MainWindow;
import ru.volushkova.ugaday.stage1.Stage1Window;

import java.net.URISyntaxException;

public class StartWindow {
    static final String START_MUSIC = "/music/opening2013.mp3";
    private final Media startMedia = new Media(getClass().getResource(START_MUSIC).toURI().toString());
    private final Image img = new Image("start.png");
    private final ImageView view = new ImageView(img);
    private final Button startButton = new Button();
    private final StackPane root;
    private final Scene scene;
    private final Stage1Window stage1Window;
    public StartWindow(CurrentPlayer currentPlayer) throws URISyntaxException {

        root = new StackPane();
        scene = new Scene(root);
        stage1Window = new Stage1Window(currentPlayer, scene);
        startButton.setGraphic(view);
        root.getChildren().addAll(startButton);
        root.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #dc143c, #661a33)");
        startButton.setBackground(Background.EMPTY);
        startButton.setOnAction(event -> {
            try {
                currentPlayer.playAndSetMelody(getClass().getResource(START_MUSIC).toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            currentPlayer.getCurrentPlayer().setOnEndOfMedia(() -> {
                scene.setRoot(stage1Window.getPane());
            });
        });
    }

    public Scene getScene() {
        return scene;
    }
}
