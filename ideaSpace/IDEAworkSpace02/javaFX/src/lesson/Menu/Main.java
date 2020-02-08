package lesson.Menu;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        MenuBar menuBar = new MenuBar();
        Menu menu =new Menu("menu1");
        Menu menu1 = new Menu("menu2");
        SeparatorMenuItem separ1 = new SeparatorMenuItem();//分割线
        MenuItem item1 = new MenuItem("item1");
        MenuItem item2 = new MenuItem("item2");
        MenuItem item3 = new MenuItem("item3");
        MenuItem item4 = new MenuItem("item4");
        MenuItem item5 = new MenuItem("item5");
        MenuItem item6 = new MenuItem("item6");
        MenuItem item7 = new MenuItem("item7");
        menuBar.setStyle("-fx-background-color: pink");

        menuBar.getMenus().addAll(menu,menu1);
        menu.getItems().addAll(item1,separ1,item2,item3);
        menu1.getItems().addAll(item4,item5,separ1,item6,item7);

        //单选菜单按钮
        ToggleGroup toggleGroup = new ToggleGroup();

        RadioMenuItem radItem1 = new RadioMenuItem("radio 1");
        RadioMenuItem radItem2 = new RadioMenuItem("radio 2");
        RadioMenuItem radItem3 = new RadioMenuItem("radio 3");

        radItem1.setToggleGroup(toggleGroup);
        radItem2.setToggleGroup(toggleGroup);
        radItem2.setSelected(true);//设置默认选择
        radItem3.setToggleGroup(toggleGroup);//设置组

        Menu menu2 =new Menu("多选");
        menu2.getItems().addAll(radItem1,radItem2,radItem3);//将按钮加入到munue组件中
        menuBar.getMenus().addAll(menu2);
        /**
         * 为单选按钮添加事件方法1
         */
        menu2.setOnHidden(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println(toggleGroup.getSelectedToggle());
            }
        });
        /**
         * 方法2
         */
        radItem1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(radItem1.isSelected()){
                    System.out.println("radItem1.  is selected!");
                }
            }
        });
        /**
         * 多选菜单按钮
         */
        CheckMenuItem checkMenuItem1 = new CheckMenuItem("check  item 1");
        CheckMenuItem checkMenuItem2 = new CheckMenuItem("check  item 2");
        CheckMenuItem checkMenuItem3 = new CheckMenuItem("check  item 3");
        Menu menu3 = new Menu("check menu");
        menu3.getItems().addAll(checkMenuItem1,checkMenuItem2,checkMenuItem3);
        menuBar.getMenus().addAll(menu3);
        menu3.setOnHidden(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                if (checkMenuItem1.isSelected()) System.out.println("check item1  is selected");
                if (checkMenuItem2.isSelected()) System.out.println("check item2  is selected");
                if (checkMenuItem3.isSelected()) System.out.println("check item3  is selected");

            }
        });
        //自定义菜单按钮
        Menu cutommenuItem = new Menu("cutommenuItem");
        CustomMenuItem cmitem1 = new CustomMenuItem();
        Button button1 = new Button("button1");
        cmitem1.setContent(button1);

        CustomMenuItem cmitem2 = new CustomMenuItem();
        ProgressBar progressBar = new ProgressBar(0.5);
        cmitem2.setContent(progressBar);

        CustomMenuItem cmitem3 = new CustomMenuItem();
        HBox hBox = new HBox();
        hBox.setPrefHeight(50);
        hBox.setPrefWidth(20);
        cmitem3.setContent(hBox);
        hBox.getChildren().add(new Button("hbox "));

        cutommenuItem.getItems().addAll(cmitem1,cmitem2,cmitem3);
        menuBar.getMenus().add(cutommenuItem);


        /**
         * MenuButton
         * 菜单按钮
         */
        MenuButton menuButton = new MenuButton("menuButton");
        AnchorPane.setTopAnchor(menuButton,200.0);
        MenuItem menuItem1 = new MenuItem("mbutton1");
        MenuItem menuItem2 = new MenuItem("mbutton2");
        MenuItem menuItem3 = new MenuItem("mbutton3");
        menuButton.getItems().addAll(menuItem1,menuItem2,menuItem3);
        menuItem1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("menuItem1  is Acting!");
            }
        });                    //设置快捷键！
        menuItem1.setAccelerator(KeyCombination.valueOf("ctrl+k"));

        /**
         * SplitMenuButton  按钮菜单，多了箭头而已
         */

        SplitMenuButton smb = new SplitMenuButton();
        smb.setText("SpliMenuButton");
        MenuItem smitem1 = new MenuItem("smitem1");
        MenuItem smitem2 = new MenuItem("smitem2");
        MenuItem smitem3 = new MenuItem("smitem3");
        MenuItem smitem4 = new MenuItem("smitem4");
        smb.getItems().addAll(smitem2,smitem1,smitem3,smitem4);
        AnchorPane.setRightAnchor(smb,100.00);
        AnchorPane.setTopAnchor(smb,100.00);


        /**
         *ContextMenu  右键弹出的菜单
         */
        ContextMenu contextMenu = new ContextMenu();
        MenuItem conItem1 = new MenuItem("conItem1");
        MenuItem conItem2 = new MenuItem("conItem2");
        MenuItem conItem3 = new MenuItem("conItem3");
        MenuItem conItem4 = new MenuItem("conItem4");
        contextMenu.getItems().addAll(conItem1,conItem2,conItem3,conItem4);
        Button button = new Button("contextMenu");
        button.setContextMenu(contextMenu);
        AnchorPane.setTopAnchor(button,150.00);


        an.getChildren().addAll(menuBar,menuButton,smb,button);
        Scene scene =new Scene(an);
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
