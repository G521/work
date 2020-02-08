package lesson.StackPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");
        Button b4 = new Button("b4");
        Button b5 = new Button("b5");
        StackPane root =new StackPane();
        root.getChildren().addAll(b1,b2,b3,b4,b5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.BASELINE_CENTER);
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
