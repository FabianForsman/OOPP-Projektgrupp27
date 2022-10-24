package Model;

/**
 * Josef Jakbson
 */
public abstract class Game {
    private static final int maxPlayers = 5;
    private static final int minPlayers = 1;

    public static int getMaxPlayers() {
        return maxPlayers;
    }

    public static int getMinPlayers() {
        return minPlayers;
    }
}

