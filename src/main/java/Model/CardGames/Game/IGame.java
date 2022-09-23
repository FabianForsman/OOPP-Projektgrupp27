package Model.CardGames.Game;

public interface IGame {

    void setPlayerAmount(int amount);

    void setCurrentPlayer();

    void nextTurn();

    void nextRound();

    void quitGame();

    void startGame();

    void startRound();


}
