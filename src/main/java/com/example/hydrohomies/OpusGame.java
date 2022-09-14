package com.example.hydrohomies;

import java.util.ArrayList;

public class OpusGame {
    ArrayList<Player> playerList = new ArrayList<Player>();
    final int amountOfCurrentPlayers = 2;
    Player currentPlayer;
    boolean drop = false;
    int playerPos = playerList.indexOf(currentPlayer);      //position of the current player in the list of players
    int listSize = playerList.size();


    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }


    public void passDiceLeft(Player player) {
        if (playerList.indexOf(playerPos) == 0) {
            currentPlayer = playerList.get(listSize);
        }
        else
            currentPlayer = playerList.get(playerPos - 1);      //indexed element one step to the left is the new current player
        }


    public void passDiceRight(Player player) {
        if (playerList.indexOf(playerPos) == listSize) {
            currentPlayer = playerList.get(0);
        }
        else
            currentPlayer = playerList.get(playerPos + 1);      //indexed element one step to the left is the new current player
    }


    public void selectPlayer(Player player){


    }

    public void giveDice(Player player, int faceValue, int numberOfRolls) {
        if (numberOfRolls == 1 && (faceValue == 1 || faceValue == 6)){
            currentPlayer = player;
        }

    }


    public void newPlayers() {


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
