package module7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleStyleApp extends Application {

    @Override
    public void start(Stage stage) {

        Circle c1 = new Circle(50);
        Circle c2 = new Circle(50);
        Circle c3 = new Circle(50);
        Circle c4 = new Circle(50);

        c1.getStyleClass().add("plaincircle");
        c2.getStyleClass().add("plaincircle");
        c3.setId("redcircle");
        c4.setId("greencircle");

        HBox root = new HBox(20);
        root.getChildren().addAll(c1, c2, c3, c4);

        Scene scene = new Scene(root, 500, 150);
        scene.getStylesheets().add(getClass().getResource("/mystyle.css").toExternalForm());

        stage.setTitle("Module 7.2 Assignment");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}