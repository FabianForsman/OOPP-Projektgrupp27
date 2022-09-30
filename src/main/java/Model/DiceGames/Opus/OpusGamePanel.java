package Model.DiceGames.Opus;
import Model.CardGames.Cards.Card;
import Model.DiceGames.Dice.Die;
import Model.Game;
import Model.DiceGames.Dice.Dice;
import Model.Player.IPlayer;
import Model.Player.Player;
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

    public OpusGamePanel(String rules){
        super(rules);
    }


    public void passDiceLeft(){
        if (getPlayerList().indexOf(getCurrentPlayer()) == 0){ //checks if the current player is the first element of the list
            setCurrentPlayer(getPlayerList().get(( getPlayerList().size())-1)); //sets the last player in the list as the current player
        }
        else {
            int index = (getPlayerList().indexOf(getCurrentPlayer()) - 1) % getPlayerList().size();
            setCurrentPlayer(getPlayerList().get(index)); //sets the previous person in the player list as the current player
        }
    }//TEMPLATE METHOD

    public void passDiceRight(){
        setCurrentPlayer(getPlayerList().get((getPlayerList().indexOf(getCurrentPlayer())+1) % getPlayerList().size())); //sets the next person in the player list as the current player
    }

    public void giveDice(Player player, int faceValue, int numberOfRolls) {
        if (numberOfRolls == 1 && (faceValue == 1 || faceValue == 6)){
            setCurrentPlayer(player);
        }
    }//TEMPLATE METHOD

    public void setRandomCurrentPlayer() {
        setCurrentPlayer(getPlayerList().get(random.nextInt(getPlayerList().size()))); //chooses a random player from the playerlist as the current player
    }

    public void startDropTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(getCurrentPlayer().getName().toUpperCase() + "DRINKS THEIR ENTIRE GLASS");
            }
        };
        long delay = 225;
        timer.schedule(task, delay);
    }


    public void checkOneOrSix() {
        if (die.getVal() == 6 ) {
            passDiceRight();
        }
        else if (die.getVal() == 1) {
            passDiceLeft();
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
        setRandomCurrentPlayer();
        startDropTimer();

    }
    @Override
    public void startRound() {
    }


}
