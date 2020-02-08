import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {
    public static void main(String[] args) {
        System.out.printf("Hellow World!");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
    }
}
