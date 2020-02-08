import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloWorld extends Application {
    private  static AtomicInteger atomicInteger=new AtomicInteger(0);
    @Override
    public void start(Stage stage) throws Exception {
        Button button=new Button("Say ‘Hello World!'");

    }
}
