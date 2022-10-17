package Model.DiceGames.Treman.Actions;

import Model.Player.Players;

public class PassAction implements IAction{
    private final String returnString;

    public PassAction(String reasonForPassing) {
        returnString = reasonForPassing;
        Players.getInstance().passTurnLeft();
    }

    @Override
    public String getRuleString() {
        return returnString;
    }
}
