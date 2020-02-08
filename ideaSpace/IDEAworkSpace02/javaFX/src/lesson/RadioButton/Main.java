package lesson.RadioButton;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton radioButton1 = new RadioButton("radio1");
        RadioButton radioButton2 = new RadioButton("radio2");
        RadioButton radioButton3 = new RadioButton("radio3");
        RadioButton radioButton4 = new RadioButton("radio4");
        RadioButton radioButton5 = new RadioButton("radio5");
        RadioButton radioButton6 = new RadioButton("radio6");
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        radioButton3.setToggleGroup(toggleGroup);
        radioButton4.setToggleGroup(toggleGroup);
        radioButton5.setToggleGroup(toggleGroup);
        radioButton6.setToggleGroup(toggleGroup);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(radioButton1,radioButton2,radioButton3,radioButton4,radioButton5,radioButton6);
        an.getChildren().addAll(hBox);
//        radioButton1.setSelected(true);
//        radioButton2.setSelected(true);//设置默认选择，以最后一个为准

        /**
         * 设置事件监听事件～
         */
        radioButton1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

            }
        });
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
