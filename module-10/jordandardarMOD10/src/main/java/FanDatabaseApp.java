package com.example.assignmentcards.jordandardar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class FanDatabaseApp extends Application {

    private TextField idField;
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField favoriteTeamField;
    private Label messageLabel;

    private final String DB_URL = "jdbc:mysql://localhost:3306/databasedb";
    private final String DB_USER = "student1";
    private final String DB_PASSWORD = "pass";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fan Database");

        Label idLabel = new Label("ID:");
        Label firstNameLabel = new Label("First Name:");
        Label lastNameLabel = new Label("Last Name:");
        Label favoriteTeamLabel = new Label("Favorite Team:");

        idField = new TextField();
        firstNameField = new TextField();
        lastNameField = new TextField();
        favoriteTeamField = new TextField();

        Button displayButton = new Button("Display");
        Button updateButton = new Button("Update");

        messageLabel = new Label();

        displayButton.setOnAction(e -> displayFan());
        updateButton.setOnAction(e -> updateFan());

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(idLabel, 0, 0);
        grid.add(idField, 1, 0);

        grid.add(firstNameLabel, 0, 1);
        grid.add(firstNameField, 1, 1);

        grid.add(lastNameLabel, 0, 2);
        grid.add(lastNameField, 1, 2);

        grid.add(favoriteTeamLabel, 0, 3);
        grid.add(favoriteTeamField, 1, 3);

        grid.add(displayButton, 0, 4);
        grid.add(updateButton, 1, 4);

        grid.add(messageLabel, 0, 5, 2, 1);

        Scene scene = new Scene(grid, 400, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    private void displayFan() {
        String sql = "SELECT * FROM fans WHERE ID = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            int id = Integer.parseInt(idField.getText());
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                firstNameField.setText(result.getString("firstname"));
                lastNameField.setText(result.getString("lastname"));
                favoriteTeamField.setText(result.getString("favoriteteam"));
                messageLabel.setText("Record displayed successfully.");
            } else {
                clearFieldsExceptId();
                messageLabel.setText("No record found with that ID.");
            }

        } catch (NumberFormatException ex) {
            messageLabel.setText("Please enter a valid numeric ID.");
        } catch (SQLException ex) {
            messageLabel.setText("Database error: " + ex.getMessage());
        }
    }

    private void updateFan() {
        String sql = "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            int id = Integer.parseInt(idField.getText());

            stmt.setString(1, firstNameField.getText());
            stmt.setString(2, lastNameField.getText());
            stmt.setString(3, favoriteTeamField.getText());
            stmt.setInt(4, id);

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                messageLabel.setText("Record updated successfully.");
            } else {
                messageLabel.setText("No record found to update.");
            }

        } catch (NumberFormatException ex) {
            messageLabel.setText("Please enter a valid numeric ID.");
        } catch (SQLException ex) {
            messageLabel.setText("Database error: " + ex.getMessage());
        }
    }

    private void clearFieldsExceptId() {
        firstNameField.clear();
        lastNameField.clear();
        favoriteTeamField.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}