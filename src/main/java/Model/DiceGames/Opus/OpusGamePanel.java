package Model.DiceGames.Opus;
import Model.CardGames.Cards.Card;
import Model.DiceGames.Dice.Die;
import Model.Game;
import Model.DiceGames.Dice.Dice;
import Model.Player.IPlayer;
import Model.Player.Player;
import Model.Player.Players;

import javax.print.attribute.standard.Media;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class OpusGamePanel extends Game{
    Die die = new Die();
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
    }

    public void setRandomCurrentPlayer() {
        int randomIndex = random.nextInt(Players.getInstance().getListSize());
        IPlayer randomPlayer = Players.getInstance().getPlayer(randomIndex);
        Players.getInstance().setCurrentPlayer(randomPlayer);
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
        drop = true;
    }

    public void checkOneOrSix() {
        if (die.getVal() == 6 ) {
            Players.getInstance().passTurnRight();
        }
        else if (die.getVal() == 1) {
            Players.getInstance().passTurnLeft();
        }
    }

    private static void playSound(String sound) {
        ClassLoader cl = OpusGamePanel.class.getClassLoader();
        URL file = cl.getResource(sound);
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
