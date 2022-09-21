package Model.DiceGames.Opus;

import Model.CardGames.Cards.Card;
import Model.Game;
import Model.DiceGames.Dice.Dice;
import Model.Player.Player;

import java.util.ArrayList;
import java.util.Random;

public class OpusGamePanel extends Game{
    ArrayList<Player> playerList;
    Dice dice;
    final int amountOfCurrentPlayers = 2;
    Player currentPlayer;
    Random random = new Random();
    boolean drop = false;
    int playerPos = playerList.indexOf(currentPlayer);      //position of the current player in the list of players
    int listSize = playerList.size();

    public OpusGamePanel(String rules){
        super(rules);
        playerList = new ArrayList<>();
    }


    /*public void startGame(){
        populatePlayers();


    }
*/

    public void setCurrentPlayer(Player player){
        this.currentPlayer = player;
    }



    public void passDiceLeft() {
        if (playerPos == 0) {
            this.currentPlayer = playerList.get(listSize); //currentPlayer blir den sista spelaren i listan
        }
        else
            this.currentPlayer = playerList.get(playerPos - 1);      //indexed element one step to the left is the new current player
        }


    public void passDiceRight() {
        if (playerPos == listSize) {
            this.currentPlayer = playerList.get(0);
        }
        else
            this.currentPlayer = playerList.get(playerPos + 1);      //indexed element one step to the left is the new current player
    }


    public void giveDice(Player player, int faceValue, int numberOfRolls) {
        if (numberOfRolls == 1 && (faceValue == 1 || faceValue == 6)){
            setCurrentPlayer(player);
        }
    }


    public void populatePlayers() {
        this.currentPlayer = playerList.get(random.nextInt(playerList.size()));
    }

    public void displayDrinkMessage() {
        if (drop) {
            System.out.println("DRINK");
        }
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    @Override
    public void nextTurn() {

    }

    @Override
    public void nextRound() {

    }
    @Override
    public void quitGame() {

    }
    @Override
    public void startGame() {

    }
    @Override
    public void startRound() {
    }


}
