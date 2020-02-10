package lesson.Pagination;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        Pagination pagination= new Pagination();
        pagination.setStyle("-fx-background-color: green");
        pagination.setPageCount(34);//设置页数
        pagination.setMaxPageIndicatorCount(15);//设置导航显示的页数多
//        pagination.setPageCount(Pagination.INDETERMINATE);
        pagination.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer param) {

                return new Button(param+"");
            }
        });


        an.getChildren().addAll(pagination);



        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
