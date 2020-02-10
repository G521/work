package lesson.Scroll;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        ScrollBar scrollBar =new ScrollBar();

        scrollBar.setOrientation(Orientation.VERTICAL);
        an.getChildren().addAll(scrollBar);
        VBox v1 = new VBox();
        int i=10;
        for (int i1 = 0; i1 < i; i1++) {
            v1.getChildren().addAll(new Button("button"+i1));
        }
        scrollBar.setValue(0.5);//设置初始值
        scrollBar.setUnitIncrement(10);
        an.getChildren().addAll(v1);
        AnchorPane.setLeftAnchor(v1,100.0);
        scrollBar.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("newValue = " + newValue);
                System.out.println("oldValue = " + oldValue);
                v1.setLayoutY(0-newValue.intValue());
            }
        });

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
