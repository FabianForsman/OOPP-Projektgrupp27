package Model;

public abstract class Game implements IGame {
    private static final int maxPlayers = 5;
    private static final int minPlayers = 2;

    public Game() {
    }

    public abstract void restartGame();

    public abstract void quitGame();

    public static int getMaxPlayers() {
        return maxPlayers;
    }

    public static int getMinPlayers() {
        return minPlayers;
    }
}

