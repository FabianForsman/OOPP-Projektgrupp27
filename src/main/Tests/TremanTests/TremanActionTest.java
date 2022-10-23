package TremanTests;

import Model.DiceGames.Treman.Actions.*;
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
        ChallengeAction action = new ChallengeAction();
        action.setChallengedPlayer(p1);
        assertEquals(p1, action.getChallengedPlayer());
        assertEquals("Challenge! Give the right die to another player and have them roll it.", action.getRuleString());
    }

    @Test
    public void testEqualsAction() {
        Players.getInstance().addPlayer(new Player("p3"));
        EqualsAction action = new EqualsAction();
        ArrayList<IPlayer> currentlyChosenPlayers = new ArrayList<>();

        action.addPlayerToPlayerList(p1);
        currentlyChosenPlayers.add(p1);
        assertEquals(currentlyChosenPlayers, action.getPlayerList());

        action.addPlayerToPlayerList(p2);
        currentlyChosenPlayers.add(p2);
        assertEquals(currentlyChosenPlayers, action.getPlayerList());
        assertEquals("Choose 2 players to give the dice to.", action.getRuleString());
    }

    @Test
    public void testNewTreManAction() {
        TremanModel model = new TremanModel();
        NewTremanAction action = new NewTremanAction();
        action.setNewTreman(p1);
        assertEquals(p1, model.getTreman());
        assertEquals("New treman! Pick another player to be Treman.", action.getRuleString());
    }

    @Test
    public void testNoAction() {
        NoAction action = new NoAction("Do nothing.");
        assertEquals("Do nothing.", action.getRuleString());
    }

    @Test
    public void testPassAction() {
        TremanModel model = new TremanModel();
        PassAction action = new PassAction("Reason for passing.");
        assertEquals("Reason for passing.", action.getRuleString());
    }
}
