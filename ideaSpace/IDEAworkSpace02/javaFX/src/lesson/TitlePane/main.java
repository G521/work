package lesson.TitlePane;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        TitledPane tp1 = new TitledPane("TitlePane1",new Button("Button1"));
        TitledPane tp2 = new TitledPane();
        TitledPane tp3 = new TitledPane();
        tp2.setText("TitlePane2");
        tp2.setContent(new Button("Button2"));
        tp3.setText("TitlePane3");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(new Button("button3"),new Button("button4"),new Button("button5"));
        tp3.setContent(hBox);
        AnchorPane.setTopAnchor(tp1,100.0);
        AnchorPane.setTopAnchor(tp2,200.0);
        AnchorPane.setTopAnchor(tp3,300.0);
        ImageView img = new ImageView("img/monster_4.png");
        img.setFitHeight(10);
        img.setFitWidth(10);
        tp1.setGraphic(img);//可以添加图片
        tp1.setAnimated(false);//折叠时是否有动画
//        tp1.setCollapsible(false);//是否可折叠
        tp1.setExpanded(false);//设置初始时是否展开
        tp1.expandedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue);
            }
        });

        an.getChildren().addAll(tp1,tp2,tp3);




        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
