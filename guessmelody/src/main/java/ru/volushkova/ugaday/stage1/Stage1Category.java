package ru.volushkova.ugaday.stage1;

import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import lombok.Getter;
import ru.volushkova.ugaday.CurrentPlayer;

import java.util.Map;

@Getter
public class Stage1Category {
    private final Map<String, Integer> melodyWithPrice;

    public Stage1Category(String name, Map<String, Integer> melodyWithPrice, CurrentPlayer currentPlayer, int i, GridPane gridPane) {
        this.melodyWithPrice = melodyWithPrice;
        Label nameLabel = new Label();
        nameLabel.setText(name);
        nameLabel.setWrapText(true);
        gridPane.add(nameLabel, 0 , i);

        int j = 1;
        for (Map.Entry<String, Integer> melody : this.melodyWithPrice.entrySet()) {
            VBox cellBox =  new VBox();
            MelodyButton melodyButton = new MelodyButton(melody.getKey(), melody.getValue(), currentPlayer);

            gridPane.add(cellBox, j ,i);
            cellBox.getChildren().addAll(melodyButton.getButtonWithLabel());
            melodyButton.getButtonWithLabel().setAlignment(Pos.CENTER);
            Bounds cellBounds = gridPane.getCellBounds(j, i);
            melodyButton.getButtonWithLabel().prefHeightProperty().bind(cellBox.prefHeightProperty());
            melodyButton.getButtonWithLabel().prefWidthProperty().bind(cellBox.prefWidthProperty());
            j++;
        }
    }
}
