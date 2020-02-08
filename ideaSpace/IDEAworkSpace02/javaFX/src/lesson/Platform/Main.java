package lesson.Platform;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
//        Platform.setImplicitExit(true);//  程序窗口关闭后是否结束程序
        Platform.isSupported(ConditionalFeature.SCENE3D);//检测电脑是否支持某些功能
        BorderPane root = new BorderPane();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
//        stage.close();
//        Platform.exit();// 关闭全部窗口
    }

}
