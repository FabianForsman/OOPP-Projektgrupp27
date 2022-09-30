package Model;

import Model.Player.IPlayer;

public interface IGame {

    void nextTurn();

    void restartGame();

    void quitGame();

    void startGame();

    void startRound();

}
