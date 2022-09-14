package com.example.hydrohomies;

import Model.Player.Player;

import java.util.ArrayList;

public class OpusGame {

    final int amountOfCurrentPlayers = 2;
    Player currentPlayer;
    Player notCurrentPlayer;                               //will remove later just here for now
    boolean drop = false;

    ArrayList<Player> playerList = new ArrayList<Player>();


    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }


    public void passDiceLeft(Player player) {
        if (player == currentPlayer) {                      //only the current player can pass the dice
            player = notCurrentPlayer;                      //not current player anymore
            for (int i = 0; i < playerList.size() - 1; i--) {    //goes through list forwards
                currentPlayer = playerList.get(i - 1);      //indexed element one step to the right is current player
            }


        }


    }

    public void passDiceRight(Player player) {
        if (player == currentPlayer) {
            player = notCurrentPlayer;
            for (int i = 0; i < playerList.size() - 1; i++) {    //goes through list backwards
                currentPlayer = playerList.get(i + 1);      //indexed element one step to the left is current player

            }
        }
    }

    public void displayDrinkMessage() {
        if (drop) {
            System.out.println("DRINK");
        }
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
}
