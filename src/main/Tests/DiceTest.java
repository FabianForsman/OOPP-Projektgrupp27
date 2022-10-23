import Model.DiceGames.Treman.TremanModel;
import Model.Player.Player;
import Model.Player.Players;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiceTest {

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
    void testImage(){
        TremanModel model = new TremanModel();
        model.getDie(1).rollDie();
    }
}
