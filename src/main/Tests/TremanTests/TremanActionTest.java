package TremanTests;

import Model.DiceGames.Treman.Actions.ChallengeAction;
import Model.DiceGames.Treman.Actions.EqualsAction;
import Model.DiceGames.Treman.TremanModel;
import Model.Player.IPlayer;
import Model.Player.Player;
import Model.Player.Players;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TremanActionTest {
    Player p1 = new Player("p1");
    Player p2 = new Player("p2");


    @BeforeEach
    public void init() {
        Players.getInstance().addPlayer(p1);
        Players.getInstance().addPlayer(p2);
    }

    @AfterEach
    public void teardown() {
        Players.getInstance().getPlayersList().clear();
    }

    @Test
    public void testChallengeAction() {
        ArrayList<Integer> values = new ArrayList<>(2);
        TremanModel model = new TremanModel();
        values.add(1);
        values.add(2);
        model.getDice().setDiceValue(values);
        ChallengeAction action = new ChallengeAction();
        action.setChallengedPlayer(p1);
        assertEquals(p1, action.getChallengedPlayer());
    }

    @Test
    public void testEqualsAction() {
        Players.getInstance().addPlayer(new Player("p3"));
        ArrayList<Integer> values = new ArrayList<>(2);
        TremanModel model = new TremanModel();
        values.add(1);
        values.add(2);
        model.getDice().setDiceValue(values);
        EqualsAction action = new EqualsAction();
        ArrayList<IPlayer> currentlyChosenPlayers = new ArrayList<>();

        action.choosePlayer(p1);
        currentlyChosenPlayers.add(p1);
        assertEquals(currentlyChosenPlayers, action.getChosenPlayers());

        action.choosePlayer(p2);
        currentlyChosenPlayers.add(p2);
        assertEquals(currentlyChosenPlayers, action.getChosenPlayers());
    }
}
