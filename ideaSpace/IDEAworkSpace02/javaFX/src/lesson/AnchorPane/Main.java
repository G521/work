package lesson.AnchorPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pane=new AnchorPane();
        Scene scene=new Scene(pane);
        Button button1=new Button("按钮一");
        Button button2=new Button("按钮二");
        Button button3=new Button("按钮三");
        Button button4=new Button("按钮四");
        button1.setStyle("-fx-background-color: brown");
        Group group1=new Group();
        group1.getChildren().addAll(button1,button2);
        Group group2=new Group();
        pane.setPrefHeight(100);// 设置高
        AnchorPane.setLeftAnchor(group1,100.0);  // 设置距离边缘的距离
        AnchorPane.setRightAnchor(group1,500.0);
        AnchorPane.setRightAnchor(group2,100.0);
        AnchorPane.setLeftAnchor(group2,600.0);
        group1.setStyle("-fx-background-color: black");
        button3.setLayoutY(50);//设置元素相对父类  的距离
        button1.setLayoutX(100);    // 设置位置
        group2.getChildren().addAll(button3,button4);//Group  添加nodes
        pane.getChildren().addAll(group1,group2);   //AnchorPane添加nodes
        pane.setStyle("-fx-background-color: green");//使用CSS 设置样式
        pane.setPadding(new Insets(0,0,0,0));//设置内边距
        stage.setHeight(800);
        stage.setWidth(800);
        stage.setScene(scene);
        stage.show();
    }
}