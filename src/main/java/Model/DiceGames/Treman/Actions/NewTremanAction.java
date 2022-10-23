package Model.DiceGames.Treman.Actions;

import Model.DiceGames.Treman.TremanModel;
import Model.Player.IPlayer;

public class NewTremanAction implements IAction{
    public NewTremanAction() {

    }
    public void setNewTreman(IPlayer player) {
        TremanModel.setNewTreman(player);
    }

    @Override
    public String getRuleString() {
        return "New treman! Pick another player to be Treman.";
    }

    public String getResult() {
        return "New treman is: " + TremanModel.getTreman().getName();
    }
}
