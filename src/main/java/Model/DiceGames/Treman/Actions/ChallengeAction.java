package Model.DiceGames.Treman.Actions;

import Model.Player.IPlayer;

public class ChallengeAction implements IAction {
    private IPlayer challengedPlayer;

    public ChallengeAction() {}

    public void setChallengedPlayer(IPlayer player) {
        challengedPlayer = player;
    }

    public IPlayer getChallengedPlayer() {
        return challengedPlayer;
    }

    @Override
    public String getRuleString() {
        return "Challenge! Give one dice to another player and have them roll it.";
    }
}
