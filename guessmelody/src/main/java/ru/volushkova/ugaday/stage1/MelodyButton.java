package ru.volushkova.ugaday.stage1;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import lombok.Getter;
import ru.volushkova.ugaday.CurrentPlayer;

@Getter
public class MelodyButton {
    private static final Image img = new Image("music-note-circle.png");
    private final String melody;
    private final VBox buttonWithLabel;
    private final CurrentPlayer currentPlayer;
    private final Integer price;

    public MelodyButton(String melody, Integer price, CurrentPlayer currentPlayer) {
        this.price = price;
        this.melody = melody;
        this.currentPlayer = currentPlayer;
        //Creating a graphic (image)
        ImageView view = new ImageView(img);
        //view.setFitHeight(40);
        view.setPreserveRatio(true);
        //Creating a Button
        Button button = new Button();
        //Setting the size of the button
        //button.setPrefSize(40, 40);
        //Setting a graphic to the button
        button.setGraphic(view);
        button.setBackground(Background.EMPTY);
        buttonWithLabel = new VBox();
        Label priceLabel = new Label();
        IntegerProperty property = new SimpleIntegerProperty(price);
        priceLabel.textProperty().bind(property.asString());
        priceLabel.setVisible(false);
        buttonWithLabel.getChildren().addAll(button, priceLabel);

        button.setOnAction(event -> {
            if(priceLabel.isVisible()) {
                currentPlayer.stop();
            } else {
                currentPlayer.stop();
                priceLabel.setVisible(true);
                currentPlayer.playAndSetMelody(this.melody);
            }
        });
    }
}
