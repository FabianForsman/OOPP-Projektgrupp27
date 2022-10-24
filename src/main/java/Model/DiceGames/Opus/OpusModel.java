package Model.DiceGames.Opus;
//import Model.Audio.SongPlayer;
import Model.DiceGames.Dice.Dice;
import Model.DiceGames.Dice.Die;
import Model.Game;
import Model.Player.IPlayer;
import Model.Player.Player;
import Model.Player.Players;

import java.util.Timer;
import java.util.TimerTask;

public class OpusModel extends Game{
    Die die = new Die();
    private static Dice dice;

    boolean drop = false;
    boolean running = false;
    //SongPlayer songPlayer = new SongPlayer();
    IPlayer opusCurrentPlayer;


    public OpusModel(){
        super();
        dice = new Dice(2);

    }

    public boolean checkIfOneSixFirstTry(int faceValue, int numberOfRolls) {
        if (numberOfRolls == 1 && (faceValue == 1 || faceValue == 6)){
            return true;
        }
        return false;
    }



    public void checkIfOneOrSix() {
        if (die.getVal() == 6 ) {
            Players.getInstance().passTurnRight();
        }
        else if (die.getVal() == 1) {
            Players.getInstance().passTurnLeft();
        }
    }

    public void setOpusCurrentPlayerOppositeSide(){
        int listsize = Players.getInstance().getPlayersList().size();
        int indexOfCurrentPlayer = Players.getInstance().getPlayerIndex(Players.getInstance().getCurrentPlayer());
        int OpusCurrentPlayerindex = indexOfCurrentPlayer + ((listsize/2)-1);
        setOpusCurrentPlayer(Players.getInstance().getPlayer(OpusCurrentPlayerindex));

    }


    public String getCurrentPlayerDrinkText() {
        return Players.getInstance().getCurrentPlayer().getName().toUpperCase() +" " + "DRINKS THEIR ENTIRE GLASS";

    }

    public void setOpusCurrentPlayer(IPlayer player){
        opusCurrentPlayer = player;

    }

    public IPlayer getOpusCurrentPlayer(){
        return opusCurrentPlayer;
    }

    public String getOpusCurrentPlayerName(){
        return opusCurrentPlayer.getName();
    }



    @Override
    public void restartGame() {

    }


    @Override
    public void quitGame() {

    }

}
