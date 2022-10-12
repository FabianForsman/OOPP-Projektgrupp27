package Model.DiceGames.Treman.Actions;

import Model.DiceGames.Treman.TremanModel;
import Model.Player.IPlayer;

public class NewTremanAction implements IAction{
    private final String returnString = "New treman! Pick another player to be Treman.";

    public NewTremanAction() {

    }

    public void setNewTreman(IPlayer player) {
        TremanModel.setNewTreman(player);
    }

    @Override
    public String getRuleString() {
        return returnString;
    }
}
