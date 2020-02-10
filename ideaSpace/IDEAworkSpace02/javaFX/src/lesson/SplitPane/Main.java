package lesson.SplitPane;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * 可拖动面板
 * 使用控件的setMaxSize()
 *         setMinSize()
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        SplitPane splitPane = new SplitPane();
        Button b1 =new Button("button1");
        Button b2 =new Button("button2");
        Button b3 =new Button("button3");
        Button b4 =new Button("button4");
        splitPane.setPrefSize(800,500);
        splitPane.setOrientation(Orientation.VERTICAL);// 设置垂直或者水平
        splitPane.setDividerPosition(1,0.25);//手动划分。positioon 为位置，不是距离
        splitPane.setDividerPosition(2,0.5);
        splitPane.setDividerPosition(3,0.75);
        splitPane.setDividerPosition(4,1.0);

        System.out.println("splitPane.getDividerPositions() = " + splitPane.getDividerPositions());
        StackPane stackPane1 =new StackPane();
        StackPane stackPane2 =new StackPane();
        StackPane stackPane3 =new StackPane();
        StackPane stackPane4 =new StackPane();
        stackPane1.getChildren().add(b1);
        stackPane1.setMinSize(100,100);
        stackPane2.getChildren().add(b2);
        stackPane3.getChildren().add(b3);
        stackPane4.getChildren().add(b4);
        splitPane.getItems().addAll(stackPane1,stackPane2,stackPane3,stackPane4);
        an.getChildren().add(splitPane);




        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
