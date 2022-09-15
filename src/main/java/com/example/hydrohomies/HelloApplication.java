package com.example.hydrohomies;

import Model.Cards.DeckOfCards;
import Model.Cards.IDeckOfCards;
import Model.Game.HigherLowerGame;
import Model.CardGames.Cards.DeckOfCards;
import Model.CardGames.Cards.IDeckOfCards;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("base-layer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("HydroHomie");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("Starting Program.");
        DeckOfCards deck = new DeckOfCards();
        deck.ShowDeck();
        launch();
        tests();
        //launch();
    }

    public static void tests(){
       /* IDeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        System.out.println("----------Shuffled deck----------");
        deck.showDeck();
        for(int i = 0; i < 40; i++)
            deck.discardCard(deck.drawCard());
        System.out.println("Removed 40 cards from the deck.");
        deck.showDeck();
        deck.returnDiscardPile();
        System.out.println("Returned the discard pile to the deck.");
        deck.showDeck();*/


    }
}