
package Model;
import Model.Player.IPlayer;
import java.util.ArrayList;

public abstract class Game implements IGame {
    private int playerAmount;
    private final int maxPlayers = 5;
    private final int minPlayers = 2;
    private ArrayList<IPlayer> playerList;
    private IPlayer currentPlayer;
    private String rules;

    public Game(String rules) {
        this.rules = rules;
        playerList = new ArrayList<>();
    }

    public void addPlayer(IPlayer player){
        if (playerList.size() < 5)
            this.playerList.add(player);
    }

    public void removePlayer(IPlayer player) {
        if (playerList.size() > 0)
            this.playerList.remove(player);
    }

    public void setCurrentPlayer(IPlayer player){
        this.currentPlayer = player;
    }

    public ArrayList<IPlayer> getPlayerList(){
        return this.playerList;
    }

    public IPlayer getCurrentPlayer(){
        return this.currentPlayer;
    }

    public void setNextPlayer() {
        int currentIndex = this.playerList.indexOf(this.currentPlayer);
        setCurrentPlayer(this.playerList.get((currentIndex + 1) % this.playerList.size()));
    }

    public abstract void nextTurn();

    public abstract void nextRound();

    public abstract void quitGame();

    public abstract void startGame();

    public abstract void startRound();


}

