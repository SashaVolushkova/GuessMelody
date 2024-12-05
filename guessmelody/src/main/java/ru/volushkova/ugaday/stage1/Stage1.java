package ru.volushkova.ugaday.stage1;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import lombok.Getter;
import ru.volushkova.ugaday.CurrentPlayer;

import java.util.List;
import java.util.Map;

@Getter
public class Stage1 {
    private final List<Map<String, Integer>> categories;
    private final CurrentPlayer currentPlayer;
    private final GridPane gridPane;
    public Stage1(List<Map<String, Integer>> categories, List<String> names, CurrentPlayer currentPlayer) {
        this.categories = categories;
        this.currentPlayer = currentPlayer;
        this.gridPane = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(30);
        gridPane.getColumnConstraints().add(column1);

        for (Map<String, Integer> ignored : categories) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 - 15.0/categories.size());
            gridPane.getRowConstraints().add(row);
            row.setValignment(VPos.CENTER);
        }
        for (Map.Entry<String, Integer> ignored : categories.get(0).entrySet()) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth((100.0 - 30.0) / categories.get(0).entrySet().size());
            gridPane.getColumnConstraints().add(column);
            column.setHalignment(HPos.CENTER);
        }
        RowConstraints row = new RowConstraints();
        row.setPercentHeight(15);
        row.setValignment(VPos.CENTER);
        gridPane.getRowConstraints().add(row);
        int i = 0;
        for (Map<String, Integer> category : categories) {
            Stage1Category stage1Category = new Stage1Category(names.get(i), category, currentPlayer, i, gridPane);
            i++;
        }
    }
}
