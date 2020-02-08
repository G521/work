package lesson.Accordion;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
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
        Accordion acc = new Accordion();
        TitledPane tp1 = new TitledPane("TitlePane1",new Button("Button1"));
        TitledPane tp2 = new TitledPane();
        TitledPane tp3 = new TitledPane();
        tp2.setText("TitlePane2");
        tp2.setContent(new Button("Button2"));
        tp3.setText("TitlePane3");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(new Button("button3"),new Button("button4"),new Button("button5"));
        tp3.setContent(hBox);
        acc.getPanes().addAll(tp1,tp2,tp3);
        an.getChildren().addAll(acc);
        acc.expandedPaneProperty().addListener(new ChangeListener<TitledPane>() {
            /**
             * 缩起来的时候newValue 为 null
             * @param observable
             * @param oldValue
             * @param newValue
             */
            @Override
            public void changed(ObservableValue<? extends TitledPane> observable, TitledPane oldValue, TitledPane newValue) {
                if (newValue==null) {
                    System.out.println("oldValue = " + oldValue.getText());
                    return;
                }
                System.out.println("newValue = " + newValue.getText());
            }
        });



        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
