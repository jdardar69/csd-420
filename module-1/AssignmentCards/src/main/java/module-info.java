module com.example.assignmentcards {
    requires javafx.controls;
    requires javafx.graphics;

    opens com.example.assignmentcards to javafx.graphics;
    exports com.example.assignmentcards;
}