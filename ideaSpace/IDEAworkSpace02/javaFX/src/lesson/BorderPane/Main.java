package lesson.BorderPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp1 =new BorderPane();
        BorderPane bp2 =new BorderPane();
        BorderPane bp3 =new BorderPane();
        BorderPane bp4 =new BorderPane();
        BorderPane bp5 =new BorderPane();
        bp1.setStyle("-fx-background-color: black");
        bp2.setStyle("-fx-background-color: red");
        bp3.setStyle("-fx-background-color: green");
        bp4.setStyle("-fx-background-color: yellow");
        bp5.setStyle("-fx-background-color: blue");
        bp1.setPrefSize(100,100);
        bp2.setPrefSize(100,100);
        bp3.setPrefSize(100,100);
        bp4.setPrefSize(100,100);
        bp5.setPrefSize(100,100);
        BorderPane pane =new BorderPane();
        pane.setCenter(bp1);
        pane.setBottom(bp2);
        pane.setLeft(bp3);
        pane.setRight(bp4);
        pane.setTop(bp5);
        Scene scene =new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}
