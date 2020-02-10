package lesson.ComboBox;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import lesson.Student;

import javax.crypto.spec.PSource;
import java.util.function.Predicate;

public class Main extends Application {
    ObservableList<Student> oblist =null;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        ComboBox<Student> cbb = new ComboBox();
        Student student1 = new Student("Java",1,14);
        Student student2 = new Student("Jack",2,18);
        Student student = new Student("Tom",3,18);
        cbb.setValue(student);//设置默认值
        Button add = new Button("添加");
        oblist = cbb.getItems();
        cbb.getItems().addAll(student,student1,student2);
        /**
         * 中间环节处理
         */
        cbb.setConverter(new StringConverter<Student>() {
            @Override
            public String toString(Student object) {
                if (object==null)
                    return "";
                if (!cbb.getItems().contains(object))cbb.getItems().addAll(object);
                return object.getName()+"++"+object.getAge();
            }
                //用户输入的值会传到下面
            @Override
            public Student fromString(String string)
            {
                return null;
            }
        });
        cbb.setEditable(true);//是否可编辑
        cbb.setPromptText("请输入XXXX"); //失去焦点后显示的单行文本提示！
        add.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            }
        });/**/
        cbb.setPlaceholder(new Label("没有找到"));//设置占位符             ！！
        cbb.getEditor().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue == null || newValue.equals("")) return;
                ObservableList<Student> newlist = oblist.filtered(new Predicate<Student>() {
                    @Override
                    public boolean test(Student student) {
                        return student.getName().contains(newValue);
                    }
                });
                if (newlist.isEmpty() || newlist == null) {
                } else {
                    cbb.setItems(newlist);
                }
                cbb.show();
            }
        });
        AnchorPane.setTopAnchor(cbb,100.0);
        an.getChildren().addAll(add,cbb);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}