import Model.DiceGames.Treman.TremanGamePanel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TremanTest {

    @Test
    public void testGetRule() {
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                TremanGamePanel currentTest = new TremanGamePanel();
                ArrayList<Integer> values = new ArrayList<>();
                values.add(i);
                values.add(j);
                currentTest.getDice().setDiceValue(values);
                System.out.println("For dice: " + currentTest.getDice().getDiceValues());
                System.out.println(currentTest.getRule());
            }
        }
    }
}
