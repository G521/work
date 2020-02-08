package lesson.TabPane_____Bg;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        ImageView imageView = new ImageView("img/monster_4.png");
        imageView.setFitWidth(10);
        imageView.setFitHeight(10);
        TabPane tp = new TabPane();
        Tab tab1 = new Tab("tab1",new Button("button1"));
        Tab tab2 = new Tab("tab2");
        Tab tab3 = new Tab("tab3");
        tp.getTabs().addAll(tab1,tab2,tab3);
//        tp.setStyle("-fx-background-color:  \t#FFEC8B");
        tp.setPrefSize(300,300);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(new Button("hbox"));
        hBox.setStyle("-fx-background-color: #F0FFFF");
        hBox.setPrefSize(100,200);
        tab2.setContent(hBox);
        tab2.setClosable(false);//是否可以点X 关闭
        tab1.setDisable(true);//设置是否禁用
        VBox box = new VBox();
        tab1.setGraphic(imageView);
        box.setStyle("-fx-background-color: #F4F4F4");
        box.setPrefSize(100,300);
//        tp.getSelectionModel().select(tab3);//设置默认选择
//        tp.getSelectionModel().selectLast();
//        tp.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);//统一设置关闭选项
        tab3.setContent(box);
        tp.setSide(Side.LEFT);
        tp.setRotateGraphic(false);//设置图片是否选择  false是使图片一直为正
        AnchorPane.setTopAnchor(tp,100.00);
        Background bg = new Background(new BackgroundFill(Paint.valueOf("#FFC1C1"),new CornerRadii(10),new Insets(10)));
        tp.setBackground(bg);
        Border border = new Border(new BorderStroke(Paint.valueOf("#FFC1C1"),BorderStrokeStyle.SOLID,new CornerRadii(10),new BorderWidths(5)));
        tp.setBorder(border);
        tp.getTabs().addAll(new Tab("tab4"));
        an.getChildren().addAll(tp);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
