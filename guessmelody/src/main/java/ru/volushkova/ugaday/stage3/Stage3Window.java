package ru.volushkova.ugaday.stage3;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import ru.volushkova.ugaday.CurrentPlayer;
import ru.volushkova.ugaday.StageChangeButton;
import ru.volushkova.ugaday.finalStage.FinalWindow;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Stage3Window {
    private final GridPane gridPane;
    private final Scene scene;
    public Stage3Window(CurrentPlayer currentPlayer, Scene scene) throws URISyntaxException {
        this.scene = scene;
        TreeMap<Integer, String> melody1 = getMelody(1);
        TreeMap<Integer, String> melody2 = getMelody(2);
        TreeMap<Integer, String> melody3 = getMelody(3);
        TreeMap<Integer, String> melody4 = getMelody(4);
        TreeMap<Integer, String> melody5 = getMelody(5);
        TreeMap<Integer, String> melody6 = getMelody(6);
        TreeMap<Integer, String> melody7 = getMelody(7);
        TreeMap<Integer, String> melody8 = getMelody(8);
        TreeMap<Integer, String> melody9 = getMelody(9);
        TreeMap<Integer, String> melody10 = getMelody(10);
        TreeMap<Integer, String> melody11 = getMelody(11);

        List<TreeMap<Integer, String>> l = Arrays.asList(melody1, melody2, melody3, melody4, melody5, melody6, melody7, melody8, melody9, melody10, melody11);
        MelodyStage3 melodyStage3 = new MelodyStage3(l, currentPlayer);
        FinalWindow finalWindow = new FinalWindow(currentPlayer,this.scene);
        StageChangeButton stageChangeButton = new StageChangeButton(this.scene, finalWindow.getPane(), currentPlayer);
        melodyStage3.getGridPane().setId("pane");
        melodyStage3.getGridPane().add(stageChangeButton.getButton(), 0, 11);
        gridPane = melodyStage3.getGridPane();
//        vBox.getChildren().addAll(melodyStage3.getGridPane(), stageChangeButton.getButton());
    }

    public static TreeMap<Integer, String> getMelody(int n) {
        String path = "file:///c:/ugaday/s_3/";
        path = path + n + "/";
        TreeMap<Integer, String> map = new TreeMap<>();
        for(int i = 3; i <= 7; i++) {
            map.put(i, path + i + ".wav");
        }
        return map;
    }

    public Pane getPane() {
        return gridPane;
    }

}
