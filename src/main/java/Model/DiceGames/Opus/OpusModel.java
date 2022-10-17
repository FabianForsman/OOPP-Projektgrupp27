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
    Timer timer = new Timer();
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

    public void checkIfOneOrSix() {
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
        startDropTimer();

    }
    @Override
    public void startRound() {
    }


}
