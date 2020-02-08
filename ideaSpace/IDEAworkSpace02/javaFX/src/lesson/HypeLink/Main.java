package lesson.HypeLink;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root =new AnchorPane();
        Hyperlink link = new Hyperlink("www.baidu.com");
        root.getChildren().add(link);
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HostServices host = Main.this.getHostServices();
                host.showDocument(link.getText());
            }
        });
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("menu1");
        Menu menu2 = new Menu("menu2");
        Menu menu3 = new Menu("menu3");
        Menu menu4 = new Menu("menu4");
        ImageView img =new ImageView("img/monster_4.png");
        img.setFitHeight(10);
        img.setFitWidth(10);//设置图标大小
        Button b1 =new Button();
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("b1");
            }
        });
        MenuItem item1 = new MenuItem("item1",img);
        MenuItem item2 = new MenuItem("item2");
        MenuItem item3 = new MenuItem("item3");
        MenuItem item4 = new MenuItem("item4");
        item1.setAccelerator(KeyCombination.valueOf("alt+l"));             //设置快捷键
        menu1.getItems().add(item1);
        menu1.setOnShown(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println("onshown!");
            }
        });
        menu1.setOnHidden(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println("ONHidden");
            }
        });
        menu1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("sdfsdfsdfas");
            }
        });
        menu1.setOnHiding(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println("onHiding");
            }
        });
        menu1.setOnShowing(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println("on SHowing!");
            }
        });
        menu2.getItems().addAll(item2,item3);
        menu3.getItems().addAll(item4);
        menuBar.getMenus().addAll(menu1,menu3,menu2,menu4);
        menuBar.setPrefHeight(10);
        root.getChildren().add(menuBar);
        Scene scene = new Scene(root);
        KeyCombination key =KeyCombination.valueOf("alt+k");// 设置快捷键
        Mnemonic mnemonic =new Mnemonic(b1,key);//
        scene.addMnemonic(mnemonic);//
        stage.setScene(scene);
        stage.setHeight(300);
        stage.setWidth(500);
        stage.show();
    }
}
