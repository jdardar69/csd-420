import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.security.SecureRandom;

public class ThreeThreads extends Application {
    private final SecureRandom random = new SecureRandom();
    private TextArea textArea;

    private static final int COUNT = 10000;
    private static final char[] LETTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] DIGITS = "0123456789".toCharArray();
    private static final char[] SYMBOLS = "!@#$%&*".toCharArray();

    @Override
    public void start(Stage primaryStage) {
        textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setEditable(false);

        Button startButton = new Button("Start Threads");
        Button clearButton = new Button("Clear");

        startButton.setOnAction(e -> runThreads());
        clearButton.setOnAction(e -> textArea.clear());

        HBox buttons = new HBox(10, startButton, clearButton);

        BorderPane root = new BorderPane();
        root.setTop(buttons);
        root.setCenter(textArea);

        Scene scene = new Scene(root, 900, 600);
        primaryStage.setTitle("ThreeThreads - Module 8.2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void runThreads() {
        textArea.clear();

        Thread lettersThread = new Thread(() -> generateCharacters(LETTERS));
        Thread digitsThread = new Thread(() -> generateCharacters(DIGITS));
        Thread symbolsThread = new Thread(() -> generateCharacters(SYMBOLS));

        lettersThread.setDaemon(true);
        digitsThread.setDaemon(true);
        symbolsThread.setDaemon(true);

        lettersThread.start();
        digitsThread.start();
        symbolsThread.start();
    }

    private void generateCharacters(char[] characters) {
        for (int i = 0; i < COUNT; i++) {
            char value = characters[random.nextInt(characters.length)];

            Platform.runLater(() -> textArea.appendText(String.valueOf(value)));

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}