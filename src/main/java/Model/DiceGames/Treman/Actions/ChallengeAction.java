package Model.DiceGames.Treman.Actions;

import Model.DiceGames.Dice.Dice;
import Model.Player.IPlayer;
import Model.Player.Players;

public class ChallengeAction implements IAction {
    private IPlayer challengedPlayer;

    public ChallengeAction() {}

    public void setChallengedPlayer(IPlayer player) {
        challengedPlayer = player;
    }

    public IPlayer getChallengedPlayer() {
        return challengedPlayer;
    }

    /**
     * Gets the resulting string of how any drinks a player will take. It will either be the challenged player
     * or the current player.
     * @param val1
     * @param val2
     * @return
     */
    public String getDrinkingCalculation(int val1, int val2) {
        int nrOfDrinks = val2 - val1;
        if (nrOfDrinks > 0) {
            return challengedPlayer.getName() + " takes " + nrOfDrinks;
        } else if (nrOfDrinks < 0) {
            return Players.getInstance().getCurrentPlayerName() + " takes " + Math.abs(nrOfDrinks);
        }
        return "Both are the same! Neither has to take one.";
    }

    @Override
    public String getRuleString() {
        return "Challenge! Give the right die to another player and have them roll it.";
    }
}
