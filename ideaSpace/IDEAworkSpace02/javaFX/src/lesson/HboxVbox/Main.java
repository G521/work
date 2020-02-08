package lesson.HboxVbox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;

/**
 * HBox   水平布局
 * VBox  垂直布局
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button b1 =new Button("b1");
        Button b2 =new Button("b2");
        Button b3 =new Button("b3");
        Button b4 =new Button("b4");
        AnchorPane ap =new AnchorPane();
        HBox hBox =new HBox();
        hBox.setPrefHeight(400);
        hBox.setPrefWidth(200);
        hBox.setStyle("-fx-background-color: green");
        hBox.setPadding(new Insets(50));
        hBox.setMargin(b1,new Insets(10));
        hBox.setAlignment(Pos.CENTER);// 设置对其方式
        hBox.setSpacing(10 );
        ap.setPrefHeight(600);
        ap.setPrefWidth(600);
        ap.getChildren().addAll(hBox);
        ap.setStyle("-fx-background-color: red");
        hBox.getChildren().addAll(b1,b2,b3,b4);
        Scene scene =new Scene(ap);
        stage.setScene(scene);
        stage.show();
    }
}
