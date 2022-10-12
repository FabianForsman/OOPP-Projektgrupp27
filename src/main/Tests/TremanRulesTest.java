import Model.DiceGames.Treman.TremanGamePanel;
import Model.Player.Players;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TremanRulesTest {

    @Test
    public void testGetRule() {
        for (int i = 1; i < 7; i++) { // First dies values
            for (int j = 1; j < 7; j++) { // Second dies values
                TremanGamePanel currentTest = new TremanGamePanel();
                ArrayList<Integer> values = new ArrayList<>(); // dice.setDiceValues() takes an arraylist as argument
                values.add(i);
                values.add(j);
                currentTest.getDice().setDiceValue(values); // Force dice to show a value so that all combinations can be tested
                System.out.println("For dice: " + currentTest.getDice().getDiceValues()); // Show dice combination being tested
                System.out.println(currentTest.getRule()); // Show the rule for the current dice combination
            }
        }
    }
}
