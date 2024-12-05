package ru.volushkova.ugaday;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import ru.volushkova.ugaday.finalStage.FinalWindow;
import ru.volushkova.ugaday.stage1.Stage1Window;
import ru.volushkova.ugaday.stage2.Stage2Window;
import ru.volushkova.ugaday.stage3.Stage3Window;

import java.net.URISyntaxException;

public class MainWindow {
    private final StackPane root;
  //  private final Scene scene;
    public MainWindow(CurrentPlayer currentPlayer, Scene scene) throws URISyntaxException {
        root = new StackPane();
//
//        Stage2Window stage2Window = new Stage2Window(currentPlayer, scene);
//        Stage1Window stage1Window = new Stage1Window(currentPlayer, scene);
//        FinalWindow finalWindow = new FinalWindow(currentPlayer, scene);
//        Stage3Window stage3Window = new Stage3Window(currentPlayer, scene);
//
//        TabPane tabPane = new TabPane();
//        Tab stage3 = new Tab("Третий тур", stage3Window.getPane());
//        Tab stage1 = new Tab("Первый тур", stage1Window.getPane());
//        Tab stage2 = new Tab("Второй тур", stage2Window.getPane());
//        Tab finalStage = new Tab("Финал", finalWindow.getPane());
//        tabPane.getTabs().addAll(stage1, stage2, stage3, finalStage);
//        root.getChildren().addAll(tabPane);
    }
    public Pane getPane() {
        return root;
    }
}
