package lesson.Checkbox;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main3 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        ObservableList list=FXCollections.observableArrayList();
        ObservableList<Integer> nums = FXCollections.observableArrayList();
        ObservableList<String> words = FXCollections.observableArrayList();
        nums.addAll(1,2,3,45,4,6);
        words.addAll("sd","sdf","sdf","fsd");
        list.addAll("数字","字母");
        ChoiceBox choiceBox1 = new ChoiceBox();
        ChoiceBox choiceBox2 = new ChoiceBox();
        choiceBox1.getItems().addAll(list);
        choiceBox1.setPrefWidth(50);
        choiceBox2.setPrefWidth(50);
        HBox h = new HBox(20);
//        choiceBox1.show(); 是否展示数据
        choiceBox1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                choiceBox2.getItems().clear();
                switch (newValue.toString()){
                    case "数字": choiceBox2.getItems().addAll(nums);break;
                    case "字母": choiceBox2.getItems().addAll(words);break;
                }
            }
        });
        h.getChildren().addAll(choiceBox1,choiceBox2);
        an.getChildren().addAll(h);







        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
