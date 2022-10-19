import Controllers.Treman.TremanController;
import Model.DiceGames.Treman.TremanModel;
import Model.Player.Player;
import Model.Player.Players;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiceTest {

    @Test
    void testImage(){
        TremanModel model = new TremanModel();
        model.getDie(1).rollDie();
    }
}
