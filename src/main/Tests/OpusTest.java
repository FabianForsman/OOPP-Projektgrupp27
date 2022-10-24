import Model.DiceGames.Dice.Die;
import Model.DiceGames.Opus.OpusModel;
import Model.Player.IPlayer;
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
    void shouldReturnTrueIfOneOrSixFirstRoll(){
        int numberOfRolls = 1;
        int faceValue = 6;
        OpusModel testPanel = new OpusModel();
        assertSame(true, testPanel.checkIfOneSixFirstTry(faceValue, numberOfRolls));
    }

    @Test
    void shouldReturnFalseIfNotOneOrSixFirstRoll(){
        int numberOfRolls = 2;
        int faceValue = 6;
        OpusModel testPanel = new OpusModel();
        assertSame(false, testPanel.checkIfOneSixFirstTry(faceValue,numberOfRolls));
    }

    @Test
    void shouldReturnDrinkMessageWithCurrentPlayersName(){
        OpusModel testPanel = new OpusModel();
        Players.getInstance().setCurrentPlayer(p1);
        assertSame("P1 DRINKS THEIR ENTIRE GLASS", testPanel.getCurrentPlayerDrinkText());
    }

    @Test
    void shouldSetRandomCurrentPlayerFromList() {
        OpusModel testPanel = new OpusModel();
        Players.getInstance().setRandomCurrentPlayer();
        //assertSame(p2, Players.getInstance().getCurrentPlayer());
        assertNotNull(Players.getInstance().getCurrentPlayer());
    }

    @Test
    void shouldPassTurnRightWhenSixIsRolled() {
        OpusModel testPanel = new OpusModel();
        Die die = new Die();
        die.setFaceValue(6);
        Players.getInstance().setCurrentPlayer(p1);
        testPanel.checkIfOneOrSix();
        assertSame(p2, Players.getInstance().getCurrentPlayer());
    }

    @Test
    void shouldPassTurnLeftWhenOneIsRolled() {
        OpusModel testPanel = new OpusModel();
        Die die = new Die();
        die.setFaceValue(1);
        Players.getInstance().setCurrentPlayer(p1);
        testPanel.checkIfOneOrSix();
        assertSame(p2, Players.getInstance().getCurrentPlayer());
    }

    @Test
    void setCurrentOpusPlayer(){
        OpusModel testPanel = new OpusModel();
        testPanel.setOpusCurrentPlayer(p1);
        assertSame(p1, testPanel.getOpusCurrentPlayer());
    }

    @Test
    void shouldSetOpusCurrentPlayerAtOppositeSideOfCurrentPlayer(){
        OpusModel testPanel = new OpusModel();
        Players.getInstance().setCurrentPlayer(p2);
        testPanel.setOpusCurrentPlayerOppositeSide();
        assertSame(1, Players.getInstance().getPlayerIndex(Players.getInstance().getCurrentPlayer()));
    }

    @Test
    void getCurrentOpusPlayerName(){
        OpusModel testPanel = new OpusModel();
        testPanel.setOpusCurrentPlayer(p1);
        assertSame("p1",testPanel.getOpusCurrentPlayerName());
    }


}





