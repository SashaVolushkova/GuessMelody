package ru.volushkova.ugaday;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.volushkova.ugaday.start.StartWindow;

import java.net.URISyntaxException;
import java.util.Locale;
import java.util.TreeMap;

public class GuessApplication extends Application {


    @Override
    public void start(Stage primaryStage) throws URISyntaxException {
        CurrentPlayer currentPlayer = new CurrentPlayer();
        StartWindow startWindow = new StartWindow(currentPlayer);
        //Setting the stage
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Угадай мелодию");
        primaryStage.setScene(startWindow.getScene());
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Locale.setDefault(new Locale("ru"));
        launch(args);
    }
}
