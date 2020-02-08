package lesson.Checkbox;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Main2 extends Application {
    Student student =null;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane an = new AnchorPane();
        ChoiceBox<Student> choiceBox = new ChoiceBox();
        VBox vBox =new VBox(50);
        HBox hBox =new HBox(50);
        Student s1 = new Student("Tom",1,16);
        Student s2 = new Student("John",2,16);
        Student s3 = new Student("Jack",3,56);

        choiceBox.getItems().addAll(s1,s2,s3);
//        an.getChildren().addAll(choiceBox);
        choiceBox.setConverter(new StringConverter<Student>() {
            @Override
            public String toString(Student object) {
                return object.getName()+"-"+object.getAge();
            }
            @Override
            public Student fromString(String string) {
                return null;
            }
        });
        Button button =new Button("modify");
        TextField textField =new TextField();
        hBox.getChildren().addAll(textField,button);
        vBox.getChildren().addAll(hBox,choiceBox);
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (choiceBox.getSelectionModel().isEmpty()||student==null||textField.getText()==null)return;
                int index = choiceBox.getItems().indexOf(student);
                Student student=choiceBox.getItems().remove(index);
                student.setName(textField.getText());
                choiceBox.getItems().add(index,student);

            }
        });
        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                student = newValue;
            }
        });
        an.getChildren().addAll(vBox);
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
class Student {
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleIntegerProperty ind = new SimpleIntegerProperty();
    private SimpleIntegerProperty age = new SimpleIntegerProperty( );

    public Student(String name, int ind, int age) {
       this.setName(name);
       this.setInd(ind);
       this.setAge(age);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        System.out.println("name = " + name);
        this.name.set(name);
    }

    public int getInd() {
        return ind.get();
    }

    public SimpleIntegerProperty indProperty() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind.set(ind);
    }

    public int getAge() {
        return age.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }
}