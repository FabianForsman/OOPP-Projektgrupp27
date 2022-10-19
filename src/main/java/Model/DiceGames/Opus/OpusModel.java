package Model.DiceGames.Opus;
import Model.Audio.SongPlayer;
import Model.DiceGames.Dice.Die;
import Model.Game;
import Model.Player.Players;

import java.util.Timer;
import java.util.TimerTask;

public class OpusModel extends Game{
    Die die = new Die();
    boolean drop = false;
    boolean running = false;
    OpusKeyAdapter adapter = new OpusKeyAdapter();
    SongPlayer songPlayer = new SongPlayer();

    public OpusModel(){
        super();
    }

    public boolean checkIfOneSixFirstTry(int faceValue, int numberOfRolls) {
        if (numberOfRolls == 1 && (faceValue == 1 || faceValue == 6)){
        }
        return true;
    }



    public void checkIfOneOrSix() {
        if (die.getVal() == 6 ) {
            Players.getInstance().passTurnRight();
        }
        else if (die.getVal() == 1) {
            Players.getInstance().passTurnLeft();
        }
    }

    public String getCurrentPlayerDrinkText() {
        return Players.getInstance().getCurrentPlayer().getName().toUpperCase() + "DRINKS THEIR ENTIRE GLASS";

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

    }
    @Override
    public void startRound() {
    }


}
