package ru.volushkova.ugaday.stage3;

import javafx.scene.control.Button;
import lombok.Getter;
import ru.volushkova.ugaday.CurrentPlayer;

@Getter
public class MButton {
    private final Button mB;
    private final CurrentPlayer currentPlayer;
    MButton(int i, String path, CurrentPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
        this.mB = new Button();
        this.mB.setId("mb");
        this.mB.setText(String.valueOf(i));
        this.mB.setOnAction(event -> this.currentPlayer.playAndSetMelody(path));
        this.mB.setMaxSize(40,40);
    }
}
