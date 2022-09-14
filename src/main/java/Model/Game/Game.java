
package Model.Game;
import Model.Player.Player;
import java.util.ArrayList;

public abstract class Game {
    private int playerAmount;
    private ArrayList<Player> playerList;
    private String rules;
    private Player currentPlayer;

    public Game(String rules){
        playerList = new ArrayList<Player>();
        this.rules = rules;
    }


    public void setPlayerAmount(int amount) {
        this.playerAmount = amount;
    }

    public void addPlayer(Player player){
        this.playerList.add(player);
    }

    public void setCurrentPlayer(Player player){
        this.currentPlayer = player;
    }

    public ArrayList<Player> getPlayerList(){
        return this.playerList;
    }

    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    public void setNextPlayer() {
        int currentIndex = this.playerList.indexOf(this.currentPlayer);
        setCurrentPlayer(this.playerList.get((currentIndex + 1) % this.playerList.size()));
    }
    abstract void nextTurn();

    abstract void nextRound();

    abstract void quitGame();

    abstract void startGame();

    abstract void startRound();

}

