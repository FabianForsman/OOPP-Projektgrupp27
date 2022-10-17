package Model.DiceGames.Treman.Actions;

import Model.Player.IPlayer;

import java.util.ArrayList;

public class EqualsAction implements IAction {
    private final ArrayList<IPlayer> playerList = new ArrayList<>(2);

    public EqualsAction() {

    }

    public void choosePlayer(IPlayer player) {
        playerList.add(player);
    }

    public ArrayList<IPlayer> getChosenPlayers() {
        return playerList;
    }

    @Override
    public String getRuleString() {
        return "Choose 2 players to give the dice to.";
    }
}
