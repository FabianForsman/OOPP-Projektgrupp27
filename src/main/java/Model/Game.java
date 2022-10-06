package Model;

public abstract class Game implements IGame {
    private int playerAmount;
    private final int maxPlayers = 5;
    private final int minPlayers = 2;

    public Game() {
    }

    public abstract void nextTurn();

    public abstract void restartGame();

    public abstract void quitGame();

    public abstract void startGame();

    public abstract void startRound();


}

