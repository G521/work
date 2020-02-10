package lesson.Others;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.plaf.basic.BasicBorders;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();

        Button b1 = new Button("button1");
        b1.setPrefSize(50,40);
        VBox vBox = new VBox();
        vBox.setPrefSize(200,200);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(b1);
        an.getChildren().addAll(vBox);
        vBox.setStyle("-fx-background-color: DeepPink");
        an.setStyle("-fx-background-color:MediumSlateBlue");

        AnchorPane.setLeftAnchor(vBox,100.0);
        AnchorPane.setTopAnchor(vBox,100.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
        Bounds bounds =b1.getLayoutBounds();
        System.out.println("b1.getHeight() = " + b1.getHeight());
        System.out.println("b1.getWidth() = " + b1.getWidth());
        System.out.println("bounds.getWidth() = " + bounds.getWidth());
        System.out.println("bounds.getHeight() = " + bounds.getHeight());
        System.out.println("bounds.getMinX() = " + bounds.getMinX());
        System.out.println("bounds.getMinY() = " + bounds.getMinY());
        System.out.println("bounds.getMaxX() = " + bounds.getMaxX());
        System.out.println("bounds.getMaxY() = " + bounds.getMaxY());
        System.out.println("b1.getLayoutX() = " + b1.getLayoutX());
        System.out.println("b1.getLayoutY() = " + b1.getLayoutY());
        System.out.println("b1.localToParent(bounds.getMinX(),bounds.getMinY()) = " + b1.localToParent(bounds.getMinX(), bounds.getMinY()));
        System.out.println("vBox.localToParent(b1.localToParent(bounds)) = " + vBox.localToParent(b1.localToParent(bounds)));
    }

}
