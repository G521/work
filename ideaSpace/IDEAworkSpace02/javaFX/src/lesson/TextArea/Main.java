package lesson.TextArea;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextArea textArea = new TextArea();
//        textArea.setFont(Font.font(16));
////        textArea.setText("Hello world!");
//        textArea.setPrefColumnCount(10);
//        textArea.setPrefRowCount(10);
//        an.getChildren().addAll(textArea);
//        textArea.setPrefSize(200,200);
//        textArea.appendText("hello world ");//追加文本
//        textArea.insertText(2,"insert");//插入文本 index 代表第几个字符
//        textArea.selectAll();
//        textArea.copy();

        textArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                textArea.setTextFormatter(new TextFormatter<String>(new StringConverter<String>() {
                    @Override
                    public String toString(String object) {
                        System.out.println("object = " + object);
                        return object;
                    }

                    /**
                     * 用户输入的值首先进入fromString（） 然后从这个函数返回进入totring（）然后在返回进入窗口
                     * @param string
                     * @return
                     */
                    @Override
                    public String fromString(String string) {
                        System.out.println("string = " + string);
                        return ""+string;
                    }
                }));
                textArea.commitValue();//提交
            }
        });
        textArea.requestFocus();//获得焦点
        VBox vBox = new VBox();
        vBox.getChildren().addAll(textArea);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
