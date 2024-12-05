package ru.volushkova.ugaday.stage2;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import ru.volushkova.ugaday.CurrentPlayer;
import ru.volushkova.ugaday.StageChangeButton;
import ru.volushkova.ugaday.stage3.Stage3Window;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Map;

public class Stage2Window {
    GridPane gridPane;
    public Stage2Window(CurrentPlayer currentPlayer, Scene scene) throws URISyntaxException {
        this.gridPane = new GridPane();
        gridPane.setId("pane");
        gridPane.setGridLinesVisible(true);
        gridPane.setPrefSize(scene.getWidth(), scene.getHeight());
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(30);
        gridPane.getColumnConstraints().add(column1);

        for (int i = 0; i <4; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight((100.0 - 15.0)/4);
            gridPane.getRowConstraints().add(row);
            row.setValignment(VPos.CENTER);
        }
        for (int i = 0 ; i < 5; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100.0 / 6);
            gridPane.getColumnConstraints().add(column);
            column.setHalignment(HPos.CENTER);
        }
        RowConstraints row = new RowConstraints();
        row.setPercentHeight(15);
        row.setValignment(VPos.CENTER);
        gridPane.getRowConstraints().add(row);

        scene.getStylesheets().addAll(getClass().getResource("/paneStyle.css").toExternalForm());

        Category category0 = new Category("Братья наши меньшие", scene, Arrays.asList(
                "file:///c:/ugaday/c_1/1.mp3",
                "file:///c:/ugaday/c_1/2.mp3",
                "file:///c:/ugaday/c_1/3.mp3",
                "file:///c:/ugaday/c_1/4.mp3"
        ), currentPlayer, gridPane, 0, Arrays.asList(23,24,16,17));
        Category category1 = new Category("Женская тема", scene, Arrays.asList(
                "file:///c:/ugaday/c_2/1.mp3",
                "file:///c:/ugaday/c_2/2.mp3",
                "file:///c:/ugaday/c_2/3.mp3",
                "file:///c:/ugaday/c_2/4.mp3"
        ), currentPlayer, gridPane, 1, Arrays.asList(14,22,32,35));
        Category category2 = new Category("Народные", scene, Arrays.asList(
                "file:///c:/ugaday/c_3/1.mp3",
                "file:///c:/ugaday/c_3/2.mp3",
                "file:///c:/ugaday/c_3/3.mp3",
                "file:///c:/ugaday/c_3/4.mp3"
        ), currentPlayer, gridPane, 2, Arrays.asList(20,20,20,20));
        Category category3 = new Category("Мульти-пульти", scene, Arrays.asList(
                "file:///c:/ugaday/c_4/1.mp3",
                "file:///c:/ugaday/c_4/2.mp3",
                "file:///c:/ugaday/c_4/3.mp3",
                "file:///c:/ugaday/c_4/4.mp3"
        ), currentPlayer, gridPane, 3, Arrays.asList(26,26,20,20));

//        vbox = new VBox();
//        vbox.getChildren().addAll(category0.getVb(), category1.getVb(), category2.getVb(), category3.getVb());
        Stage3Window stage3Window = new Stage3Window(currentPlayer, scene);
        StageChangeButton stageChangeButton = new StageChangeButton(scene, stage3Window.getPane(), currentPlayer);
        gridPane.add(stageChangeButton.getButton(), 0, 4);
    }

    public Pane getPane() {
        return gridPane;
    }
}
