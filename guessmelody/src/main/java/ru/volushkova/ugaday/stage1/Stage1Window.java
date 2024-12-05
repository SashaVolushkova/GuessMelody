package ru.volushkova.ugaday.stage1;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import ru.volushkova.ugaday.CurrentPlayer;
import ru.volushkova.ugaday.StageChangeButton;
import ru.volushkova.ugaday.stage2.Stage2Window;

import java.net.URISyntaxException;
import java.util.*;

public class Stage1Window {
    private final Stage1 stage1;
    private final Scene scene;
    public Stage1Window(CurrentPlayer currentPlayer, Scene scene) throws URISyntaxException {
        //stage1
        this.scene = scene;
        java.util.List<Map<String, Integer>> categories = new ArrayList<>();
        LinkedHashMap<String, Integer> c1 = new LinkedHashMap<>();
        c1.put("file:///c:/ugaday/n_1/1.mp3", 50);
        c1.put("file:///c:/ugaday/n_1/2.mp3", 30);
        c1.put("file:///c:/ugaday/n_1/3.mp3", 15);
        c1.put("file:///c:/ugaday/n_1/4.mp3", 40);

        LinkedHashMap<String, Integer> c2 = new LinkedHashMap<>();
        c2.put("file:///c:/ugaday/n_2/1.mp3", 30);
        c2.put("file:///c:/ugaday/n_2/2.mp3", 75);
        c2.put("file:///c:/ugaday/n_2/3.mp3", 40);
        c2.put("file:///c:/ugaday/n_2/4.mp3", 50);

        LinkedHashMap<String, Integer> c3 = new LinkedHashMap<>();
        c3.put("file:///c:/ugaday/n_3/1.mp3", 50);
        c3.put("file:///c:/ugaday/n_3/2.mp3", 60);
        c3.put("file:///c:/ugaday/n_3/3.mp3", 30);
        c3.put("file:///c:/ugaday/n_3/4.mp3", 30);

        LinkedHashMap<String, Integer> c4 = new LinkedHashMap<>();
        c4.put("file:///c:/ugaday/n_4/1.mp3", 30);
        c4.put("file:///c:/ugaday/n_4/2.mp3", 50);
        c4.put("file:///c:/ugaday/n_4/3.mp3", 75);
        c4.put("file:///c:/ugaday/n_4/4.mp3", 15);

        categories.add(c1);
        categories.add(c2);
        categories.add(c3);
        categories.add(c4);

        List<String> cNames = new ArrayList<>();
        cNames.add("С новым годом!");
        cNames.add("Кругом вода");
        cNames.add("Главней всего погода в доме");
        cNames.add("Города");

        this.stage1 = new Stage1(categories, cNames, currentPlayer);
        Stage2Window stage2Window = new Stage2Window(currentPlayer, scene);
        StageChangeButton stageChangeButton = new StageChangeButton(scene, stage2Window.getPane(), currentPlayer);
        this.stage1.getGridPane().add(stageChangeButton.getButton(), 0, cNames.size());
        this.stage1.getGridPane().setId("pane");
        this.stage1.getGridPane().setGridLinesVisible(true);
        this.stage1.getGridPane().setPrefSize(scene.getWidth(), scene.getHeight());
        scene.getStylesheets().addAll(getClass().getResource("/paneStyle.css").toExternalForm());
    }
    public Pane getPane() {
        return stage1.getGridPane();
    }
}
