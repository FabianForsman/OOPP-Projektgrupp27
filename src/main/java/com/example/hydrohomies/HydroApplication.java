package com.example.hydrohomies;

import Controllers.Treman.TremanController;
import Model.Player.Player;
import Model.Player.Players;
import com.example.hydrohomies.SceneBuilderRunLogic.HydroHomieDataHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
        Players.getInstance().addPlayer(new Player("p1"));
        Players.getInstance().addPlayer(new Player("p2"));
        launch(args);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                HydroHomieDataHandler.getInstance().shutDown();
            }
        }));
    }



}