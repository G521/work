package lesson.ButtonBar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        ButtonBar bar = new ButtonBar();
        Button b1 = new Button("Button1");
        Button b2 = new Button(" Button2");
        Button b3 = new Button("Button3");
        b1.setPrefHeight(50);
        ButtonBar.setButtonData(b1, ButtonBar.ButtonData.APPLY);
        ButtonBar.setButtonData(b2, ButtonBar.ButtonData.FINISH);
        ButtonBar.setButtonData(b3, ButtonBar.ButtonData.NO);
        bar.getButtons().addAll(b1,b2,b3);
        bar.setButtonOrder(ButtonBar.BUTTON_ORDER_LINUX);//设置按钮模式
        ButtonBar.setButtonUniformSize(b1,false);//设置按钮的宽度是否统一为b1;
        System.out.println("ButtonBar.getButtonData(b1).getTypeCode() = " + ButtonBar.getButtonData(b1).isDefaultButton());


        an.getChildren().addAll(bar);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
