package com.example.hydrohomies;

import Model.CardGames.Cards.Card;
import Model.CardGames.Cards.DeckOfCards;
import Model.CardGames.Cards.IDeckOfCards;
import Model.CardGames.Game.HigherLowerGame;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HydroApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HydroApplication.class.getResource("base-layer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("HydroHomie");
        stage.setScene(scene);
        stage.show();*/
    }

    public static void main(String[] args) {
        System.out.println("Starting Program.");
        //launch();
    }

    public void onStartCardGameButtonClick(ActionEvent event) {
    }

    public void onStartDiceGameButtonClick(ActionEvent event) {
    }

    public void closeProgram(ActionEvent event) {
    }
}