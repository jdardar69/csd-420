package module7;

import javafx.scene.shape.Circle;

public class CircleStyleAppTest {

    public static void main(String[] args) {

        Circle c1 = new Circle();
        Circle c2 = new Circle();
        Circle c3 = new Circle();
        Circle c4 = new Circle();

        c1.getStyleClass().add("plaincircle");
        c2.getStyleClass().add("plaincircle");
        c3.setId("redcircle");
        c4.setId("greencircle");

        if (
                c1.getStyleClass().contains("plaincircle") &&
                        c2.getStyleClass().contains("plaincircle") &&
                        "redcircle".equals(c3.getId()) &&
                        "greencircle".equals(c4.getId())
        ) {
            System.out.println("All tests passed.");
        } else {
            System.out.println("Test failed.");
        }
    }
}