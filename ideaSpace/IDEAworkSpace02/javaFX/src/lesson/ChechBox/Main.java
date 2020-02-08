package lesson.ChechBox;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.function.Consumer;

/**
 * 复选框
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        HBox hBox = new HBox();
        CheckBox c1 = new CheckBox("check1");
        CheckBox c2 = new CheckBox("check2");
        CheckBox c3 = new CheckBox("check3");
        CheckBox c4 = new CheckBox("check4");
        c1.setSelected(true);
        c1.setIndeterminate(true);//设置不确定状态
        c1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println("c1   newValue = " + newValue);
            }
        });
        an.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Object[] o = hBox.getChildren().toArray();
//                for (Object o1 : o) {
//                    CheckBox c = (CheckBox) o1;
//                    System.out.println(c.getText() + " " + c.isSelected());
//                }



//                hBox.getChildren().forEach(new Consumer<Node>() {
//                    @Override
//                    public void accept(Node node) {
//                        CheckBox c = (CheckBox) node;
//                        System.out.println(c.getText() + "  " + c.isSelected());
//                    }
//                });


                hBox.getChildren().stream();
            }
        });



        hBox.getChildren().addAll(c1,c2,c3,c4);
        an.getChildren().addAll(hBox);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
