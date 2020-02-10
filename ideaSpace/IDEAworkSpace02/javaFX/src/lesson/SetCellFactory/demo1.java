package lesson.SetCellFactory;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import lesson.Student;

public class demo1 extends Application {
    int index;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        Student s1 = new Student("Tom", 1, 26);
        Student s2 = new Student("Jack", 2, 18);
        Student s3 = new Student("John", 3, 18);
        ComboBox<Student> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(s1, s2, s3);
        Button b1 =new Button("修改");
        b1.setContentDisplay(ContentDisplay.CENTER);//设置   Graphy  的位置
        /**
         * 设置选择后展示状态 根据索引选择数据 并根据下面的方式显示
         *
         */
        b1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                index = comboBox.getSelectionModel().getSelectedIndex();
                if (index<0)return;
                System.out.println("index = " + index);
                comboBox.getItems().get(index).setName("text");
                comboBox.getSelectionModel().clearSelection(); // 清除选择
                comboBox.getSelectionModel().select(index); //恢复选择  实现刷新
            }
        });

        comboBox.setPromptText("hello world");//设置初始时显示文本
        comboBox.setConverter(new StringConverter<Student>() {
            @Override
            public String toString(Student object) {
                if (object==null)return null;
                return object.getName()+"---"+object.getAge()+"--"+object.getId();
            }

            @Override
            public Student fromString(String string) {
                return null;
            }
        });
        /**
         * 设置在列表显示状态 点击时获得索引，
         */
//        comboBox.setCellFactory(new Callback<ListView<Student>, ListCell<Student>>() {
//            @Override
//            public ListCell<Student> call(ListView<Student> param) {
//                myListCell listCell = new myListCell();
//                return listCell;
//            }
//        });

        AnchorPane.setTopAnchor(b1, 100.0);
        AnchorPane.setTopAnchor(comboBox, 200.0);
        an.getChildren().addAll(comboBox, b1);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}

class myListCell extends ListCell<Student> {
    @Override
    protected void updateItem(Student item, boolean empty) {
        super.updateItem(item, empty);// 不能删除，   删除后不能选择
        if (empty == false) {
            HBox hBox = new HBox(10);
            hBox.setAlignment(Pos.CENTER);
            hBox.setStyle("-fx-background-color: #FF82Ab");
            hBox.getChildren().addAll(new Button(item.getName()), new Button(item.getName()));
            this.setGraphic(hBox);
        }
    }
}