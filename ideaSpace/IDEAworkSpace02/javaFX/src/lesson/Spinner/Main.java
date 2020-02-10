package lesson.Spinner;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.print.Collation;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import lesson.Student;

import java.util.LinkedList;

public class Main extends Application {
    double index;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        Spinner<Student> spinner = new Spinner<Student>(0,10,5,0.2);
        Student s1 = new Student("Tom",1,18);
        Student s2 = new Student("JAVA",2,18);
        Student s3 = new Student("C++",3,19);
        ObservableList<Student> list = FXCollections.observableList(new LinkedList<>());
        list.addAll(s1,s2, s3);
        spinner.setValueFactory(new SpinnerValueFactory<Student>() {

            @Override
            public void decrement(int steps) {
                System.out.println("decrement index = " + index);
                index-=steps;
                if (index<=0)index=2;
                this.setValue(list.get((int) index));
            }
            @Override
            public void increment(int steps) {
                System.out.println("increment index = " + index);
                index+=steps;
                if (index>=3)index=0;
                this.setValue(list.get((int) index));
            }
        });

        spinner.getValueFactory().setConverter(new StringConverter<Student>() {
            @Override
            public String toString(Student object) {
                System.out.println("TOSTRING");
                return object.getName()+"-"+object.getAge();
            }

            @Override
            public Student fromString(String string) {
                return null;
            }
        });
        an.getChildren().addAll(spinner);



        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
