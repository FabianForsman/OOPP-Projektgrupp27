package Model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Players {
    ArrayList<IPlayer> players;
    private HashMap<String, IPlayer> playerMap;
    IPlayer currentPlayer;
    Random random = new Random();

    private static Players single_instance = null;

    /**
     * Private constructor for Player. Used internally in the class as done with the singleton-pattern.
     */
    private Players() {
        players = new ArrayList<>();
        playerMap = new HashMap<>();
    }

    /**
     * Singleton static lazy-initialization of Players.
     * @return
     */
    public static Players getInstance() {
        if (single_instance == null) {
            single_instance = new Players();
        }
        return single_instance;
    }

    /**
     * Adds a player to the list of IPlayers.
     * @param player
     */
    public void addPlayer(IPlayer player) {
        if (players.size() < 5) {
            this.players.add(player);
            this.playerMap.put(player.getName(), player);
        }
    }

    /**
     * Removes a player from the list of IPlayers.
     * @param player
     */
    public void removePlayer(IPlayer player) {
        if (players.size() > 0)
            this.players.remove(player);
    }

    /**
     * Sets the current player to the person to the right.
     */
    public void passTurnRight() {
        int index = getPlayerIndex(currentPlayer);
        IPlayer nextPlayer = getPlayer((index + 1) % getListSize());
        setCurrentPlayer(nextPlayer);
    }

    /**
     * Sets the current player to the person to the left.
     */
    public void passTurnLeft() {
        int index = getPlayerIndex(currentPlayer);
        if (index == 0) {
            setCurrentPlayer(getPlayer(getListSize() - 1));
        } else {
            setCurrentPlayer(getPlayer(index - 1));
        }
    }

    /**
     * Sets the current player to a random player in the list of players."
     */
    public void setRandomCurrentPlayer() {
        int randomIndex = random.nextInt(getListSize());
        IPlayer randomPlayer = getPlayer(randomIndex);
        setCurrentPlayer(randomPlayer);
    }

    public IPlayer getRandomPlayer() {
        int randomIndex = random.nextInt(getListSize());
        return players.get(randomIndex);
    }

    public IPlayer getPlayer(int i) {
        return players.get(i);
    }

    public IPlayer getPlayer(String name) {
        return playerMap.get(name);
    }

    public void setCurrentPlayer(IPlayer player) {
        currentPlayer = player;
    }

    public IPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public String getCurrentPlayerName() {
        return currentPlayer.getName();
    }

    public int getPlayerIndex(IPlayer player) {
        return players.indexOf(player);
    }

    public ArrayList<IPlayer> getPlayersList() {
        return players;
    }

    public int getListSize() {
        return players.size();
    }

}