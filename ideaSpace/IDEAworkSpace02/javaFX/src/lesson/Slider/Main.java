package lesson.Slider;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;

/**
 * 刻度尺
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        an.setStyle("-fx-background-color: pink");
        Slider slider =new Slider(0,20,1);
        slider.setPrefHeight(150);
        slider.setPrefWidth(500);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        an.getChildren().add(slider);
        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                return ""+object;
            }
            //不会调用下面的
            @Override
            public Double fromString(String string) {
                return null;
            }
        });
        slider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("slider.getValue() = " + slider.getValue());
            }
        });
        test test = new test(slider);
        test.setDelay(Duration.seconds(1));
        test.setPeriod(Duration.seconds(0.5));
        test.start();
        test.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                System.out.println("newValue = " + newValue);
                System.out.println("oldValue = " + oldValue);
                System.out.println("observable = " + observable);
            }
        });
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
class test extends ScheduledService<Integer>
{
    int i =0;
    Slider s;
    public test(Slider s) {
        this.s = s;
    }
    @Override
    protected Task<Integer> createTask() {
        Task task = new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                if (s.getValue()>s.getMax())s.setValue(0);
                return (int)s.getValue()+1;
            }

            @Override
            protected void updateValue(Integer value) {
                super.updateValue(value);
                s.setValue(value);
            }

        };
        return task;
    }
}
