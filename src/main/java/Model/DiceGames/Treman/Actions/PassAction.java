package Model.DiceGames.Treman.Actions;

import Model.Player.Players;

public class PassAction implements IAction{
    private final String returnString;

    public PassAction(String reasonForPassing) {
        returnString = reasonForPassing;
    }

    @Override
    public String getRuleString() {
        return returnString;
    }

    public void passTurn() {
        Players.getInstance().passTurnLeft();
    }
}
