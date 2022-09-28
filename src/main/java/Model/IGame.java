package Model;

import Model.Player.IPlayer;

public interface IGame {

    void addPlayer(IPlayer player);

    void setCurrentPlayer();

    void nextTurn();

    void nextRound();

    void quitGame();

    void startGame();

    void startRound();

}
