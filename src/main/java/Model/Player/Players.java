package Model.Player;

import java.util.ArrayList;
public class Players {
    ArrayList<IPlayer> players;
    IPlayer currentPlayer;

    private static Players single_instance = null;

    private Players() {
        players = new ArrayList<>();
    }

    public static Players getInstance() {
        if (single_instance == null) {
            single_instance = new Players();
        }
        return single_instance;
    }

    public void addPlayer(IPlayer player) {
        if (players.size() < 5)
            this.players.add(player);
    }

    public void removePlayer(IPlayer player) {
        if (players.size() > 0)
            this.players.remove(player);
    }

    public void passTurnRight() {
        int index = getPlayerIndex(getCurrentPlayer());
        IPlayer nextPlayer = getPlayer((index + 1) % getListSize());
        setCurrentPlayer(nextPlayer);
    }

    public void passTurnLeft() {
        int index = getPlayerIndex(getCurrentPlayer());
        if (index == 0) {
            setCurrentPlayer(getPlayer(getListSize() - 1));
        } else {
            setCurrentPlayer(getPlayer(index - 1));
        }
    }

    public IPlayer getPlayer(int i) {
        return players.get(i);
    }

    public IPlayer getPlayer(String name) {
        for (IPlayer player : players) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }

    public void setCurrentPlayer(IPlayer player) {
        currentPlayer = player;
    }

    public IPlayer getCurrentPlayer() {
        return currentPlayer;
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