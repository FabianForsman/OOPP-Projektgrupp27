package Model.DiceGames.Treman.Actions;

import Model.Player.IPlayer;
import Model.Player.Players;

import java.util.ArrayList;

public class EqualsAction implements IAction {
    private final ArrayList<IPlayer> playerList = new ArrayList<>(2);
    private final String returnString = "Choose 2 players to give the dice to.";


    public EqualsAction() {

    }

    public void choosePlayer(IPlayer player) {
        playerList.add(player);
    }

    public ArrayList<IPlayer> getPlayerList() {
        return playerList;
    }

    @Override
    public String getRuleString() {
        return returnString;
    }
}
