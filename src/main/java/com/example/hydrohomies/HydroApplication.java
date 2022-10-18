package com.example.hydrohomies;

import com.example.hydrohomies.SceneBuilderRunLogic.HydroHomieDataHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HydroApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("base-layer.fxml"));
        primaryStage.setTitle("HydroApp");
        primaryStage.setScene(new Scene(root, 610, 410));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                HydroHomieDataHandler.getInstance().shutDown();
            }
        }));
    }



}