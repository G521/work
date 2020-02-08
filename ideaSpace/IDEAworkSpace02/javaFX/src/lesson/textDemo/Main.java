package lesson.textDemo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class Main extends Application {
    int index = 0;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        TextField find_f = new TextField();
        Button find_bu = new Button("查找");
        Button sort_bu= new Button("替换");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(find_f,find_bu,sort_bu);
        TextArea textArea = new TextArea();
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox,textArea);
        AnchorPane.setTopAnchor(vBox,10.0);
        AnchorPane.setLeftAnchor(vBox,10.0);
        an.getChildren().add(vBox);
        textArea.setMaxWidth(400);
        textArea.setText("hello world hello world hello world hello world hell");
        find_bu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setTitle("");
                String find_value = find_f.getText();
                textArea.getParagraphs().forEach(new Consumer<CharSequence>() {
                    @Override
                    public void accept(CharSequence charSequence) {
                        String text = charSequence.toString();
                        if (text.contains(find_value)){
                            int i = text.indexOf(find_value,index);
                            index=i+find_value.length();
                            textArea.selectRange(i,index);
                            textArea.requestFocus();
                            System.out.println("i = " + i);
                            System.out.println("index = " + index);
                            primaryStage.setTitle("");
                        }else
                        primaryStage.setTitle("已经查找完毕！");
                    }
                });
            }
        });
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
