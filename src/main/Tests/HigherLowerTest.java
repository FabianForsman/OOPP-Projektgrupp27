import Model.CardGames.Game.HigherLowerGame;
import Model.Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HigherLowerTest {
    @Test
    void testAddPlayer(){
        HigherLowerGame testGame = new HigherLowerGame("Just a test");
        Player player1 = new Player("player1");
        testGame.addPlayer(player1);
        assertEquals(testGame.getPlayerList().size(), 1);
    }

    @Test
    void testSetCurrentPlayerAndGetCurrentPlayer(){
        HigherLowerGame testGame = new HigherLowerGame("Just a test");
        Player player1 = new Player("player1");
        testGame.setCurrentPlayer(player1);
        assertTrue(testGame.getCurrentPlayer() == player1);
    }
    @Test
    void testSetNextPlayer(){
        HigherLowerGame testGame = new HigherLowerGame("Just a test");
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Player player3 = new Player("player3");
        testGame.addPlayer(player1);
        testGame.addPlayer(player2);

        testGame.setCurrentPlayer(player1);
        testGame.setNextPlayer();
        assertTrue(testGame.getCurrentPlayer() == player2);
        testGame.addPlayer(player3);
        testGame.setNextPlayer();
        assertTrue(testGame.getCurrentPlayer() == player3);
    }

}
