package Model.DiceGames.Treman.Actions;

import Model.Player.IPlayer;

public class ChallengeAction implements IAction {
    private IPlayer challengedPlayer;
    private final String returnString = "Challenge! Give one dice to another player and have them roll it.";

    public ChallengeAction() {

    }

    public void setChallengedPlayer(IPlayer player) {
        challengedPlayer = player;
    }

    public IPlayer getChallengedPlayer() {
        return challengedPlayer;
    }

    @Override
    public String getRuleString() {
        return returnString;
    }
}
