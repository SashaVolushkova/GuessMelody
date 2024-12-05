package ru.volushkova.ugaday.stage2;

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
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import lombok.Getter;
import ru.volushkova.ugaday.CurrentPlayer;
import ru.volushkova.ugaday.buttons.FailButton;
import ru.volushkova.ugaday.buttons.OkButton;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Category {

    private final String categoryName;
    private final List<String> minusList;
    private AtomicInteger i = new AtomicInteger(0);
    IntegerProperty propertyI = new SimpleIntegerProperty(i.get());

    private Timeline timeline;
    private final Label timerLabel = new Label();
    private final Label splitTimerLabel = new Label();
    private final DoubleProperty timeSeconds = new SimpleDoubleProperty();
    private final DoubleProperty splitTimeSeconds = new SimpleDoubleProperty();
    private Duration time = Duration.ZERO, splitTime = Duration.ZERO;


    private final FailButton failButton = new FailButton();
    private final OkButton okButton = new OkButton();
    private final CurrentPlayer currentPlayer;
    private final List<Integer> length;
//    @Getter
//    private final HBox vb;

    public Category(String categoryName, Scene scene, List<String> minusList, CurrentPlayer currentPlayer, GridPane gridPane, int i, List<Integer> length) throws URISyntaxException {
        this.currentPlayer = currentPlayer;
        this.categoryName = categoryName;
        this.minusList = minusList;
        this.length = new ArrayList<>(length);
        timerLabel.textProperty().bind(timeSeconds.asString());
        splitTimerLabel.textProperty().bind(splitTimeSeconds.asString());
        splitTimerLabel.setTextFill(Color.BLUE);
        // Create and configure the Button
        Button startSplitButton = new Button();
        startSplitButton.setBackground(Background.EMPTY);
        //startSplitButton.setText("Start");
        Button stopButton = new Button();
        startSplitButton.setOnAction(event -> {
            if (timeline != null) {
                splitTime = Duration.ZERO;
                splitTimeSeconds.set(splitTime.toSeconds());
                failButton.getFailButton().setDisable(true);
                okButton.getOkButton().setDisable(true);
                assert this.i.get() < minusList.size();
                timeline.setCycleCount(this.length.get(this.i.get()) * 10);
                timeline.play();
            } else {
                okButton.getOkButton().setDisable(true);
                failButton.getFailButton().setDisable(true);
                this.i.set(0);
                timeline = new Timeline(
                        new KeyFrame(Duration.millis(100),
                                t -> {
                                    Duration duration = ((KeyFrame)t.getSource()).getTime();
                                    time = time.add(duration);
                                    splitTime = splitTime.add(duration);
                                    timeSeconds.set(50 + time.toSeconds() * 10);
                                    splitTimeSeconds.set(splitTime.toSeconds());
                                })
                );
                timeline.setCycleCount(this.length.get(this.i.get()) * 10);
                timeline.play();
                timeline.setOnFinished(event1 -> {
                    currentPlayer.stop();
                    Media failMedia = failButton.getFailMedia();
                    MediaPlayer player = new MediaPlayer(failMedia);
                    player.play();
                    this.i.incrementAndGet();
                    propertyI.set(this.i.get());
                    if(this.i.get() >= minusList.size()) {
                        startSplitButton.setDisable(true);
                        stopButton.setDisable(true);
                    }
                });
            }

            assert this.i.get() < minusList.size();
            currentPlayer.playAndSetMelody(this.minusList.get(this.i.get()));
        });

        //stopButton.setText("stop");
        stopButton.setOnAction(event -> {
            currentPlayer.stop();
            timeline.stop();
            failButton.getFailButton().setDisable(false);
            okButton.getOkButton().setDisable(false);
            this.i.incrementAndGet();
            propertyI.set(this.i.get());
            if(this.i.get() >= minusList.size()) {
                startSplitButton.setDisable(true);
                stopButton.setDisable(true);
            }
        });


        Label category = new Label(this.categoryName);
        category.setTextFill(Color.BLACK);
        category.setWrapText(true);
//        category.setStyle("-fx-font-size: 4em;");

        Label iLabel = new Label();

        iLabel.textProperty().bind(propertyI.asString());
        gridPane.add(category,0, i);
        startSplitButton.setId("start");
        stopButton.setId("stop");
        gridPane.add(startSplitButton, 1, i);
        gridPane.add(stopButton, 2, i);
        gridPane.add(timerLabel, 3, i);
        timerLabel.setId("timer");
        stopButton.setBackground(Background.EMPTY);
        gridPane.add(okButton.getOkButton(), 4, i);
        gridPane.add(failButton.getFailButton(), 5, i);
        //gridPane.add(splitTimerLabel, 5, i);
    }
}
