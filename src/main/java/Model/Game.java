
package Model;
import Model.Player.IPlayer;
import Model.Player.Player;
import Model.Player.Players;

import java.util.ArrayList;

public abstract class Game implements IGame {
    private int playerAmount;
    private final int maxPlayers = 5;
    private final int minPlayers = 2;
    private Players players;

    public Game() {
        players = new Players();
    }

    public Players getPlayers() {
        return players;
    }

    public abstract void nextTurn();

    public abstract void restartGame();

    public abstract void quitGame();

    public abstract void startGame();

    public abstract void startRound();


}

