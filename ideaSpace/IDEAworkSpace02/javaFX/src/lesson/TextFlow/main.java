package lesson.TextFlow;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text t1 = new Text("zhangzhangzang");
        t1.setFill(Paint.valueOf("red"));
        Text t2 = new Text("yunyunyunyun");
        Text t3 = new Text("xiaoxiaoxiaoxiao");
        TextFlow tf = new TextFlow();

        t2.setFill(Paint.valueOf("red"));
        tf.setLineSpacing(5);//设置行间距
        t3.setFill(Paint.valueOf("red"));
        t1.setFont(Font.font(12));
        tf.setStyle("-fx-background-color: black");
        tf.getChildren().addAll(t1,t2,t3);
        TextFlow tf2 = new TextFlow();
        Text t4 = new Text("hello world! hello world hello world");
        tf2.getChildren().addAll(t4);
        AnchorPane an = new AnchorPane();
        an.setBorder(Border.EMPTY);
        AnchorPane.setBottomAnchor(tf,20.00);
        AnchorPane.setRightAnchor(tf,20.00);
        an.setStyle("-fx-background-color: blue");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        an.getChildren().addAll(tf,tf2);
        Scene scene =new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                System.out.println("这是an");
                System.out.println("an.getWidth() = " + an.getWidth());
                System.out.println("tf.getWidth() = " + tf.getWidth());
                System.out.println("tf2.getWidth() = " + tf2.getWidth());
                tf.setPrefWidth(newValue.doubleValue());
                tf2.setPrefWidth(newValue.doubleValue());
            }

        });
        primaryStage.show();
    }
}
