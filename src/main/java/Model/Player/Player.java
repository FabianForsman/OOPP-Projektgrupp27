package Model.Player;

public class Player implements IPlayer {
    private String playerName;

    public Player(String name) {
        playerName = name;
    }

    public void setName(String name) {
        this.playerName = name;
    }

    @Override
    public String getName() {
        return playerName;
    }

    @Override
    public void getScore() {

    }
    @Override
    public void takeTurn() {

    }

    @Override
    public void passTurn() {

    }

    @Override
    public void joinGame() {

    }

    @Override
    public void leaveGame() {

    }
}
