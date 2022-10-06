import Model.DiceGames.Opus.OpusGamePanel;
import Model.Player.Player;
import Model.Player.Players;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OpusTest {

    @Test
    void testGiveDiceWhen6Or1IsRolled() {
        OpusGamePanel testPanel = new OpusGamePanel();
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Players.getInstance().addPlayer(p1);
        Players.getInstance().addPlayer(p2);
        Players.getInstance().setCurrentPlayer(p1);
        testPanel.giveDice(p2, 6, 1);
        assertSame(p2, Players.getInstance().getCurrentPlayer());
    }

    @Test
    void displayDrinkMessageAfter3Minutes45Seconds(){
        OpusGamePanel testPanel = new OpusGamePanel();
        Player p2 = new Player("p2");
        Players.getInstance().addPlayer(p2);
        testPanel.startDropTimer();
        //assertEquals("p2 DRINKS THEIR ENTIRE GLASS",);
    }

    @Test
    void shouldSetRandomCurrentPlayerFromList() {
        OpusGamePanel testPanel = new OpusGamePanel();
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Players.getInstance().addPlayer(p1);
        Players.getInstance().addPlayer(p2);
        testPanel.setRandomCurrentPlayer();
        assertSame(p2, Players.getInstance().getCurrentPlayer());

    }



}


