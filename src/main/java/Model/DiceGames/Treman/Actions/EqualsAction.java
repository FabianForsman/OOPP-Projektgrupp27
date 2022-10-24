package Model.DiceGames.Treman.Actions;

import Model.Player.IPlayer;

import java.util.ArrayList;

public class EqualsAction implements IAction {
    private final ArrayList<IPlayer> playerList = new ArrayList<>(2);

    public EqualsAction() {

    }

    public void addPlayerToPlayerList(IPlayer player) {
        playerList.add(player);
    }

    public ArrayList<IPlayer> getPlayerList() {
        return playerList;
    }

    @Override
    public String getRuleString() {
        return "Choose 2 players to give the dice to.";
    }

    /**
     * Gets the resulting string once the 2 players are selected.
     * Either they are different, or they are the same player.
     * @param diceValue
     * @return
     */
    public String getResult(int diceValue){
        if(playerList.get(0) != playerList.get(1)){
             return playerList.get(0).getName() + " and " + playerList.get(1).getName() + " drink " + diceValue;
        } else {
            return playerList.get(0).getName() + " drinks " + diceValue*2;
        }
    }
}
