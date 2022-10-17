import Model.Player.Player;
import Model.Player.Players;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PlayersTest {


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
    void addPlayerToPlayerList() {
        assertEquals(2, Players.getInstance().getListSize());
    }

    @Test
    void testSetCurrentPlayer() {
        Players.getInstance().setCurrentPlayer(p1);
        assertSame(p1, Players.getInstance().getCurrentPlayer());
    }

    @Test
    void testPassTurnLeft() { //works
        Players.getInstance().setCurrentPlayer(p2);
        Players.getInstance().passTurnLeft();
        assertSame(p1, Players.getInstance().getCurrentPlayer());
    }

    @Test
    void testPassTurnLeftAsCircularArray() {

        Players.getInstance().setCurrentPlayer(p1);
        Players.getInstance().passTurnLeft();
        assertSame(p2, Players.getInstance().getCurrentPlayer());
    }

    @Test
    void testPassTurnRightAsCircularArray() {
        Players.getInstance().setCurrentPlayer(p2);
        Players.getInstance().passTurnRight();
        assertSame(p1, Players.getInstance().getCurrentPlayer());
    }

    @Test
    void testPassTurnRight() {
        Players.getInstance().setCurrentPlayer(p1);
        Players.getInstance().passTurnRight();
        assertSame(p2, Players.getInstance().getCurrentPlayer());
    }



}

