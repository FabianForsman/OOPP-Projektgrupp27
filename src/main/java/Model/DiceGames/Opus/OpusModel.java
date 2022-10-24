package Model.DiceGames.Opus;
//import Model.Audio.SongPlayer;
import Model.DiceGames.Dice.Dice;
import Model.DiceGames.Dice.Die;
import Model.Game;
import Model.Player.IPlayer;
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

    /**
     * Constructor for OpusModel
     */
    public OpusModel(){
        super();
        dice = new Dice(2);

    }

    /**
     * Checks if the roll was either a 1 or 6 (correct rolls) on the first try.
     * @param faceValue
     * @param numberOfRolls
     * @return
     */
    public boolean checkIfOneSixFirstTry(int faceValue, int numberOfRolls) {
        if (numberOfRolls == 1 && (faceValue == 1 || faceValue == 6)){
            return true;
        }
        return false;
    }

    /**
     * Checks if the die roll is 1 or 6. If not, do nothing.
     */
    public void checkIfOneOrSix() {
        if (die.getVal() == 6 ) {
            Players.getInstance().passTurnRight();
        }
        else if (die.getVal() == 1) {
            Players.getInstance().passTurnLeft();
        }
    }

    /**
     * Sets the 2nd player (If the project continued with multi-threading) to the person the furthest
     * away from the current player. This enables simultaneous multiplayer.
     */
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

}
