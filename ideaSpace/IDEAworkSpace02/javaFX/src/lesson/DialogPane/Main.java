package lesson.DialogPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button b1 = new Button( "按钮");
        BorderPane root = new BorderPane();
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DialogPane dialogPane = new DialogPane();
                Scene sc = new Scene(dialogPane);
                Stage stage1 = new Stage();
                dialogPane.setHeaderText("Header text");//
                dialogPane.getButtonTypes().add(ButtonType.CLOSE);//
                ImageView img = new ImageView("img/monster_4.png");
                img.setFitWidth(10);
                img.setFitHeight(10);
                dialogPane.setGraphic(img);//加载图片
                dialogPane.setExpandableContent(new Text("这是扩展内容！"));
                dialogPane.getButtonTypes().add(ButtonType.APPLY);//添加几种固定类型的按钮
                dialogPane.getButtonTypes().add(ButtonType.CANCEL);
                Button close = (Button)dialogPane.lookupButton(ButtonType.CLOSE);
                stage1.setScene(sc);
                stage1.initOwner(stage);
                close.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        stage1.close();
                    }
                });

                stage1.initStyle(StageStyle.UTILITY);
                stage1.initModality(Modality.WINDOW_MODAL);
                stage1.setTitle("弹出的窗口");
                stage1.alwaysOnTopProperty();
                stage1.show();
            }
        });
        root.setCenter(b1);
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(500);
        stage.show();
    }
}
