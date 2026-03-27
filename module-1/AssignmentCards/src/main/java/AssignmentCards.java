package com.example.assignmentcards;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssignmentCards extends Application {

    private final ImageView[] cards = new ImageView[4];

    @Override
    public void start(Stage stage) {
        HBox cardRow = new HBox(10);
        cardRow.setAlignment(Pos.CENTER);

        for (int i = 0; i < 4; i++) {
            cards[i] = new ImageView();
            cards[i].setFitWidth(100);
            cards[i].setPreserveRatio(true);
            cardRow.getChildren().add(cards[i]);
        }

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> showCards());

        VBox root = new VBox(15, cardRow, refreshButton);
        root.setAlignment(Pos.CENTER);

        showCards();

        Scene scene = new Scene(root, 500, 300);
        stage.setTitle("Random Cards");
        stage.setScene(scene);
        stage.show();
    }

    private void showCards() {
        List<Integer> deck = new ArrayList<>();

        for (int i = 1; i <= 52; i++) {
            deck.add(i);
        }

        Collections.shuffle(deck);

        for (int i = 0; i < 4; i++) {
            String imagePath = "/cards/" + deck.get(i) + ".png";
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            cards[i].setImage(image);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}