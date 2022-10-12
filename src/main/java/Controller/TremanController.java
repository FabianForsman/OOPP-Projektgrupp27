package Controller;

import Model.Player.IPlayer;
import Model.Player.Players;

public class TremanController {

    private IPlayer chooseChallengedPlayer() {
        return Players.getInstance().getCurrentPlayer(); //temp
    }
}
