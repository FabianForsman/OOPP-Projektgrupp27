
package Model;
import Model.Player.IPlayer;
import Model.Player.Player;
import java.util.ArrayList;

public abstract class Game implements IGame {
    private int playerAmount;
    private final int maxPlayers = 5;
    private final int minPlayers = 2;
    private ArrayList<IPlayer> playerList;
    private String rules;
    private IPlayer currentPlayer;

    public Game(String rules){
        playerList = new ArrayList<>();
        this.rules = rules;
    }

    public void setPlayerAmount(int amount) {
        this.playerAmount = amount;
    }

    public void addPlayer(IPlayer player){
        this.playerList.add(player);
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

