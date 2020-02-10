package lesson.ColorPicker;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.time.LocalDate;

/**
 * 颜色选择器
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        ColorPicker picker =new ColorPicker(Color.BLUE);
        an.getChildren().addAll(picker);
        picker.valueProperty().addListener(new ChangeListener<Color>() {
            @Override
            public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
                an.setStyle("-fx-background-color:#"+picker.getValue().toString().substring(2));
            }
        });
        DatePicker datePicker =new DatePicker();
        datePicker.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                primaryStage.setTitle(datePicker.getValue().toString());
                 }
        });
//        picker.getStyleClass().add(ColorPicker.STYLE_CLASS_BUTTON);//设置样式
        /**
         *
         */
        datePicker.setConverter(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate object) {
                if (object==null)return "";
                return object.getDayOfWeek()+"";
            }

            @Override
            public LocalDate fromString(String string) {
                return null;
            }
        });
        /**
         *
         */
        datePicker.setDayCellFactory(new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(DatePicker param) {
                DateCell cell =new DateCell(){
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        this.setGraphic(new Label(""+item.getDayOfWeek()));
                    }
                };
                return cell;
            }
        });
        an.getChildren().addAll(datePicker);
        AnchorPane.setTopAnchor(datePicker,100.0);
        an.setPadding(new Insets(100));
        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
