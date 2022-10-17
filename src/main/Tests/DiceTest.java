import Controllers.Treman.TremanController;
import Model.DiceGames.Treman.TremanModel;
import org.junit.jupiter.api.Test;

public class DiceTest {

    @Test
    void testImage(){
        TremanModel model = new TremanModel();
        TremanController controller = new TremanController(model);
        model.getDie(1).rollDie();
        controller.setFirstDieImage();


    }
}
