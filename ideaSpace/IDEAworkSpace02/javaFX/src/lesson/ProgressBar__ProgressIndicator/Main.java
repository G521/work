package lesson.ProgressBar__ProgressIndicator;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    double i=0;
    ScheduledService<Double> sche;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        ProgressBar progressBar = new ProgressBar(0);
        ProgressIndicator progressIndicator = new ProgressIndicator(0.1);
        progressBar.setPrefWidth(600);
        progressBar.setPrefHeight(200);
        an.getChildren().add(progressBar);
        AnchorPane.setTopAnchor(progressBar,200.0);
//        progressBar.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
        sche = new ScheduledService<Double>() {
            @Override
            protected Task<Double> createTask() {

                Task task =new Task<Double>() {
                    @Override
                    protected Double call() throws Exception {
                        return i=i+0.00005;
                    }

                    @Override
                    protected void updateValue(Double value) {
                        super.updateValue(value);
                        progressBar.setProgress(value);
                        progressIndicator.setProgress(value);
                        System.out.println("value = " + value);
                        if (value>1) sche.cancel();

                    }
                };
                return task;
            }
        };
        sche.start();
        an.getChildren().add(progressIndicator);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
