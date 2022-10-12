import Model.DiceGames.Dice.Die;
import Model.DiceGames.Opus.OpusModel;
import Model.Player.Player;
import Model.Player.Players;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OpusTest {


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
    void testGiveDiceWhen6Or1IsRolled() {
        OpusModel testPanel = new OpusModel();
        Players.getInstance().setCurrentPlayer(p1);
        testPanel.giveDice(p2, 6, 1);
        assertSame(p2, Players.getInstance().getCurrentPlayer());
    }

    @Test
    void displayDrinkMessageAfter3Minutes45Seconds() {
        OpusModel testPanel = new OpusModel();
        testPanel.startDropTimer();
        //assertEquals("p2 DRINKS THEIR ENTIRE GLASS",);
    }

    @Test
    void shouldSetRandomCurrentPlayerFromList() {
        OpusModel testPanel = new OpusModel();
        Players.getInstance().setRandomCurrentPlayer();
        assertSame(p2, Players.getInstance().getCurrentPlayer());
    }

    @Test
    void shouldPassTurnRightWhenSixIsRolled() {
        OpusModel testPanel = new OpusModel();
        Die die = new Die();
        die.setFaceValue(6);
        Players.getInstance().setCurrentPlayer(p1);
        testPanel.checkOneOrSix();
        assertSame(p2, Players.getInstance().getCurrentPlayer());
    }

    @Test
    void shouldPassTurnLeftWhenOneIsRolled() {
        OpusModel testPanel = new OpusModel();
        Die die = new Die();
        die.setFaceValue(1);
        Players.getInstance().setCurrentPlayer(p1);
        testPanel.checkOneOrSix();
        assertSame(p2, Players.getInstance().getCurrentPlayer());
    }
}





