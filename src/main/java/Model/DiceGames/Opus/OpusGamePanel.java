package Model.DiceGames.Opus;
import Model.CardGames.Cards.Card;
import Model.DiceGames.Dice.Die;
import Model.Game;
import Model.DiceGames.Dice.Dice;
import Model.Player.IPlayer;
import Model.Player.Player;
import Model.Player.Players;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class OpusGamePanel extends Game{
    Die die = new Die();
    final int amountOfCurrentPlayers = 2;
    Random random = new Random();
    boolean drop = false;
    boolean running = false;
    Timer timer = new Timer();
    OpusKeyAdapter adapter = new OpusKeyAdapter();

    public OpusGamePanel(){
        super();
    }

    public void giveDice(Player player, int faceValue, int numberOfRolls) {
        if (numberOfRolls == 1 && (faceValue == 1 || faceValue == 6)){
            Players.getInstance().setCurrentPlayer(player);
        }
    }//TEMPLATE METHOD


    /*
    public void setRandomCurrentPlayer() {
        setCurrentPlayer(getPlayerList().get(random.nextInt(getPlayerList().size()))); //chooses a random player from the playerlist as the current player
    }
    */
    public void startDropTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(Players.getInstance().getCurrentPlayer().getName().toUpperCase() + "DRINKS THEIR ENTIRE GLASS");
            }
        };
        long delay = 225;
        timer.schedule(task, delay);
    }


    public void checkOneOrSix() {
        if (die.getVal() == 6 ) {
            Players.getInstance().passTurnRight();
        }
        else if (die.getVal() == 1) {
            Players.getInstance().passTurnLeft();
        }
    }


    @Override
    public void nextTurn() {

    }

    @Override
    public void restartGame() {

    }


    @Override
    public void quitGame() {


    }
    @Override
    public void startGame() {
        //setRandomCurrentPlayer();
        startDropTimer();

    }
    @Override
    public void startRound() {
    }


}
