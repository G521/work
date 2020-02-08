package lesson.logIn;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        GridPane gr =new GridPane();
        gr.setStyle("-fx-background-color:#E0FFFF");
        Label l_name = new Label("名字");
//      l_name.setFont(Font.font(30));
        TextField uname = new TextField();
        Label l_pwd = new Label("密码");
        PasswordField pwd =new PasswordField();
        Button clear =new Button("清除");
        Button login = new Button("登录");
        gr.add(l_name,0,0);
        gr.add(uname,1,0);
        gr.add(l_pwd,0,1);
        gr.add(pwd,1,1);
        gr.add(clear,0,2);
        gr.add(login,1,2);
        gr.setMargin(login,new Insets(0,0,0,100));
        uname.setTooltip(new Tooltip("请输入用户名"));//
        pwd.setTooltip(new Tooltip("请输入密码"));//设置提示！
        gr.setHgap(10);//设置水平间距
        gr.setVgap(2);  // 设置垂直间距
        gr.setAlignment(Pos.CENTER);
        Scene scene =new Scene(gr);
        stage.setScene(scene);
        stage.setTitle("登录");
        stage.setResizable(false);
        stage.setHeight(500);
        login.setTextFill(Color.BLUE);//设置字体颜色
        stage.setWidth(500);
        uname.setUserData("张三");
        pwd.setUserData("123");
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.seconds(0.51));
        fade.setNode(gr);
        fade.setFromValue(0);
        fade.setToValue(1);
        clear.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                uname.setText("");
                pwd.setText("");
            }
        });
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                uname.getProperties().put("a","b");//自定义属性
                String name = uname.getText();
                String p = pwd.getText();
                if (name.equals(uname.getUserData())&& p.equals(pwd.getUserData())) {
                    new window("登录成功！");
                    stage.close();
                }else{
                    fade.play();
                }
            }
        });
        stage.show();
    }
}
class  window {
    private final  Stage stage = new Stage();
    public window(String text){
        stage.setWidth(500);
        stage.setHeight(300);
        stage.setTitle(text);
        stage.show();
    }
}
