package com.example.hydrohomies;

import Model.CardGames.Cards.DeckOfCards;
import Model.CardGames.Cards.IDeckOfCards;
import Model.DiceGames.Dice.Dice;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("Starting Program.");
        diceTests();
        launch();
    }

    public static void deckTests(){
        IDeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        System.out.println("----------Shuffled deck----------");
        deck.showDeck();
        for(int i = 0; i < 40; i++)
            deck.discardCard(deck.drawCard());
        System.out.println("Removed 40 cards from the deck.");
        deck.showDeck();
        deck.returnDiscardPile();
        System.out.println("Returned the discard pile to the deck.");
        deck.showDeck();
    }

    public static void diceTests(){
        Dice dice = new Dice(5); // Create 5 die
        System.out.println(dice.getDiceValues());
        dice.rollAllDice();
        System.out.println(dice.getDiceValues());

    }
}