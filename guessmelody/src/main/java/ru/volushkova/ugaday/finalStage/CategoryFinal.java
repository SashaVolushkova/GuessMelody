package ru.volushkova.ugaday.finalStage;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import lombok.Getter;
import ru.volushkova.ugaday.CurrentPlayer;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class CategoryFinal {
    public static final String FAIL_MUSIC = "/music/ugadaj-melodiju-1995-neugadannaja-melodija.mp3";
    private final Media failMedia = new Media(getClass().getResource(FAIL_MUSIC).toURI().toString());

    private final String categoryName;
    private final List<String> minusList;
    private final AtomicInteger i = new AtomicInteger(-1);
    IntegerProperty propertyI = new SimpleIntegerProperty(i.get());

    private final Timeline timeline;
    private final Label timerLabel = new Label();
    private final DoubleProperty timeSeconds = new SimpleDoubleProperty();
    private Duration time = Duration.ZERO;
    private final CurrentPlayer currentPlayer;
    AtomicBoolean started = new AtomicBoolean(false);


    private final HBox hb;
    private final VBox vb;
    private final List<Integer> skip;
    private final Scene scene;

    public CategoryFinal(String categoryName, Scene scene, List<String> minusList, CurrentPlayer currentPlayer) throws URISyntaxException {
        this.scene = scene;
        this.skip = new ArrayList<>();
        for(int i = 0; i < minusList.size(); i++) {
            skip.add(i);
        }
        this.currentPlayer = currentPlayer;
        this.categoryName = categoryName;
        this.minusList = minusList;
        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.RED);
        timerLabel.setStyle("-fx-font-size: 4em;");
        timerLabel.setId("timer");
        // Create and configure the Button
        Button startButton = new Button();
        //startButton.setText("Начать");
        timeline = new Timeline(
                new KeyFrame(Duration.millis(100),
                        t -> {
                            Duration duration = ((KeyFrame) t.getSource()).getTime();
                            timeSeconds.set(time.toSeconds());
                            time = time.add(duration);
                        })
        );
        timeline.setCycleCount(301);
        timeline.setOnFinished(event -> {
            currentPlayer.stop();
            timeline.stop();
            startButton.setDisable(true);
            MediaPlayer player = new MediaPlayer(failMedia);
            player.play();
        });
        Image img = new Image("audio_music_14019.png");
        Image img_green = new Image("audio_sound_music_13939.png");
        Image imgBlue = new Image("sound_audio_music_13979.png");

        HBox pictures = new HBox();
        pictures.setAlignment(Pos.CENTER);

        List<ImageView> images = new ArrayList<>();
        for(int i = 0; i < minusList.size(); i++) {
            ImageView v = new ImageView(img);
            v.setFitHeight(64);
            v.setPreserveRatio(true);
            images.add(v);
            pictures.getChildren().add(v);
        }

        startButton.setOnAction(event -> {
            if (!started.get()) {
                int j = i.get() + 1;
                if(j >= minusList.size()) {
                    j = 0;
                }
                for(; j < minusList.size(); j++) {
                    if(skip.contains(j)) {
                        break;
                    }
                }
                if(j >= minusList.size()) {
                    return;
                }
                if(skip.contains(i.get())) {
                    images.get(i.get()).setImage(img);
                }
                i.set(j);
                images.get(i.get()).setImage(imgBlue);
                currentPlayer.playAndSetMelody(this.minusList.get(i.get()));
                timeline.play();
                startButton.setId("stop");

            } else {
                currentPlayer.stop();
                timeline.pause();
                startButton.setId("start");
            }
            started.set(!started.get());
        });

        hb = new HBox();
        hb.getChildren().addAll(startButton, timerLabel);
        startButton.setId("start");

        vb = new VBox();
        Button ok = new Button();
        ok.setId("ok");
//        ok.setText("Угадано");
        ok.setOnAction(e -> {
            images.get(i.get()).setImage(img_green);
            skip.remove(Integer.valueOf(i.get()));
            if(skip.isEmpty()) {
                startButton.setDisable(true);
            }
        });
        hb.getChildren().add(ok);
        vb.getChildren().addAll(pictures, hb);
        vb.setId("pane");
        vb.setAlignment(Pos.CENTER);
        hb.setAlignment(Pos.CENTER);
        startButton.setMaxSize(40,40);
        ok.setMaxSize(40,40);
        startButton.setBackground(Background.EMPTY);
        ok.setBackground(Background.EMPTY);
    }
}
