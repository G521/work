package com;
//stage.setFullScreen(true);//设置全屏
//        stage.setScene(new Scene(new Group()));//添加画布
//        stage.setOpacity(0.5);//设置透明度
//        stage.show();
//        Stage s1=new Stage();
//        s1.setTitle("s1");
//        s1.initStyle(StageStyle.DECORATED);  //设置窗口样式
//            s1.initModality(Modality.APPLICATION_MODAL);//窗口置顶，此窗口打开时不能点击其他窗口
//        s1.show();
//stage.setMaximized(true);//设置可以最大化
//        stage.getIcons().add(new Image("/img/monster_4.png"));//设置图标
//
//        stage.setIconified(true);//设置可以最小化
//HostServices services=getHostServices();
//        stage.getIcons();
//        services.showDocument("www.baidu.com");//打开网站
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseListener;
import java.net.URL;

import static javax.imageio.ImageIO.read;

public class main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Group group=new Group();
        Scene scene=new Scene(group);
        Button b1=new Button("按钮");
        b1.setLayoutX(20);
        b1.setLayoutY(20);
        group.getChildren().add(b1);
        b1.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mouseEvent.getButton();
                System.out.println(mouseEvent.getButton().name());
            }
        });
        b1.setFont(Font.font("微软雅黑",12));
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("点击了按钮！");
            }
        });
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void init() throws Exception {
    }
    @Override
    public void stop() throws Exception {
    }
}
