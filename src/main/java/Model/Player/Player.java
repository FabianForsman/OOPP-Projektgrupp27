package Model.Player;

public class Player implements IPlayer {
    private String playerName;

    public Player(String name) {
        playerName = name;
    }

    @Override
    public void setName(String name) {
        this.playerName = name;
    }

    @Override
    public String getName() {
        return playerName;
    }
}
