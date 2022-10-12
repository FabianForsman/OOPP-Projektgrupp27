package Model.DiceGames.Treman.Actions;

import Model.Player.IPlayer;

public class NewTremanAction implements IAction{
    private final String returnString = "New treman! Give the hat to someone else.";

    public NewTremanAction() {

    }

    public void setNewTreman(IPlayer player) {
    }

    @Override
    public String getRuleString() {
        return returnString;
    }
}
