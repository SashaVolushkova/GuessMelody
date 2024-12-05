package ru.volushkova.ugaday.finalStage;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import ru.volushkova.ugaday.CurrentPlayer;

import java.net.URISyntaxException;
import java.util.Arrays;

public class FinalWindow {
    private final CategoryFinal categoryFinal;
    public FinalWindow (CurrentPlayer currentPlayer, Scene scene) throws URISyntaxException {
        categoryFinal = new CategoryFinal("111", scene, Arrays.asList(
                "file:///c:/ugaday/f/1.mp3",
                "file:///c:/ugaday/f/2.mp3",
                "file:///c:/ugaday/f/3.mp3",
                "file:///c:/ugaday/f/4.mp3",
                "file:///c:/ugaday/f/5.mp3",
                "file:///c:/ugaday/f/6.mp3",
                "file:///c:/ugaday/f/7.mp3"
        ), currentPlayer);
    }

    public Pane getPane() {
        return categoryFinal.getVb();
    }
}
