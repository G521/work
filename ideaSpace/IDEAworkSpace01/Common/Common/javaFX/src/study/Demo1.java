package study;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Demo1 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label label=new Label("HEllo world!");
        Scene scene=new Scene(label,56,56);
        stage.setScene(scene);
        stage.setTitle("else Window");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}