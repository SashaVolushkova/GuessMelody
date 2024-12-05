package ru.volushkova.ugaday.stage3;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import lombok.Getter;
import ru.volushkova.ugaday.CurrentPlayer;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
public class MelodyStage3 {
    private final List<TreeMap<Integer, String>> melodies;
    private final GridPane gridPane;
    private final CurrentPlayer currentPlayer;

    public MelodyStage3(List<TreeMap<Integer, String>> melodies, CurrentPlayer currentPlayer) {
        this.melodies = melodies;
        this.currentPlayer = currentPlayer;
        gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        for (TreeMap<Integer, String> ignored : melodies) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 - 30.0/melodies.size());
            gridPane.getRowConstraints().add(row);
            row.setValignment(VPos.CENTER);
        }
        ColumnConstraints сс = new ColumnConstraints();
        сс.setPercentWidth(10);
        gridPane.getColumnConstraints().add(сс);
        сс.setHalignment(HPos.CENTER);

        for (Map.Entry<Integer, String> ignored : melodies.get(0).entrySet()) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(90.0 / melodies.get(0).entrySet().size());
            gridPane.getColumnConstraints().add(column);
            column.setHalignment(HPos.CENTER);
        }
        RowConstraints rowC = new RowConstraints();
        rowC.setPercentHeight(30);
        rowC.setValignment(VPos.CENTER);
        gridPane.getRowConstraints().add(rowC);

        int column = 0;
        int row = 0;
        for (TreeMap<Integer, String> melody : melodies) {
            Label rr = new Label();
            rr.setText(String.valueOf(row + 1));
            gridPane.add(rr, 0, row);
            for (Map.Entry<Integer, String> m : melody.entrySet()) {
                MButton mButton = new MButton(m.getKey(), m.getValue(), currentPlayer);
                gridPane.add(mButton.getMB(), column + 1, row);
                column++;
            }
            column = 0;
            row++;
        }
    }
}
