import Model.DiceGames.Opus.OpusGamePanel;
import Model.Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OpusTest {

    @Test
    void addPlayerToPlayerList() {
        OpusGamePanel testPanel= new OpusGamePanel("test");
        Player player1 = new Player("player1");
        testPanel.addPlayer(player1);
        assertEquals(testPanel.getPlayerList().size(), 1);
    }

    @Test
    void setCurrentPlayer() {
        OpusGamePanel testPanel = new OpusGamePanel("test");
        Player p1 = new Player("p1");
        testPanel.addPlayer(p1);
        testPanel.setCurrentPlayer(p1);
        assertSame(p1, testPanel.getCurrentPlayer());
    }

    @Test
    void testPassDiceLeft() {
        OpusGamePanel testPanel = new OpusGamePanel("test");
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        testPanel.addPlayer(p1);
        testPanel.addPlayer(p2);
        testPanel.setCurrentPlayer(p1);
        testPanel.passDiceLeft();
        assertSame(p2, testPanel.getCurrentPlayer());
    }

    @Test
    void testPassDiceRight() {
        OpusGamePanel testPanel = new OpusGamePanel("test");
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        testPanel.addPlayer(p1);
        testPanel.addPlayer(p2);
        testPanel.setCurrentPlayer(p2);
        testPanel.passDiceRight();
        assertSame(p1, testPanel.getCurrentPlayer());
    }

    @Test
    void testGiveDiceWhen6Or1IsRolled() {
        OpusGamePanel testPanel = new OpusGamePanel("test");
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        testPanel.addPlayer(p1);
        testPanel.addPlayer(p2);
        testPanel.setCurrentPlayer(p1);
        testPanel.giveDice(p2, 6, 1);
        assertSame(p2, testPanel.getCurrentPlayer());
    }

    @Test
    void displayDrinkMessageAfter3Minutes45Seconds(){
        OpusGamePanel testPanel = new OpusGamePanel("test");
        testPanel.startGame();

    }

}


