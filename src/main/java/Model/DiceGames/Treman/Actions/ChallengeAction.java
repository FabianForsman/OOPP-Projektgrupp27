package Model.DiceGames.Treman.Actions;

import Model.Player.IPlayer;
import Model.Player.Players;

public class ChallengeAction {
    ChallengeAction() {

    }

    private IPlayer getChallengedPlayer() {
        // list of players, click on players to get the correct one.
        return Players.getInstance().getCurrentPlayer();
    }

}
