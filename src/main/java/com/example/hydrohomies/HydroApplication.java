package com.example.hydrohomies;

import Model.Player.Player;
import Model.Player.Players;
import com.example.hydrohomies.SceneBuilderRunLogic.HydroHomieDataHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class HydroApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("base-layer.fxml"));
        stage.setTitle("HydroApp");
        stage.setScene(new Scene(root, 610, 410));
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        Players.getInstance().addPlayer(new Player("p1"));
        Players.getInstance().addPlayer(new Player("p2"));
        launch(args);

    }

}