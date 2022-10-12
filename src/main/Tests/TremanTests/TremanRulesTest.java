package TremanTests;

import Model.DiceGames.Treman.TremanModel;
import Model.Player.Player;
import Model.Player.Players;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class TremanRulesTest {

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
    public void testGetRule() {
        for (int i = 1; i < 7; i++) { // First dies values
            for (int j = 1; j < 7; j++) { // Second dies values
                TremanModel model = new TremanModel();
                ArrayList<Integer> values = new ArrayList<>(); // dice.setDiceValues() takes an arraylist as argument
                values.add(i);
                values.add(j);
                model.getDice().setDiceValue(values); // Force dice to show a value so that all combinations can be tested
                System.out.println("For dice: " + model.getDiceValues()); // Show dice combination being tested
                System.out.println(model.getRule()); // Show the rule for the current dice combination
            }
        }
    }

    @Test
    public void testChallenge() {
        ArrayList<Integer> values = new ArrayList<>(2);
        TremanModel model = new TremanModel();
        values.add(1);
        values.add(2);
        model.getDice().setDiceValue(values);
        assertEquals("Challenge! Give one dice to another player and have them roll it.", model.getRule());
    }

    @Test
    public void testCheers() {
        ArrayList<Integer> values = new ArrayList<>(2);
        TremanModel model = new TremanModel();
        values.add(4);
        values.add(6);
        model.getDice().setDiceValue(values);
        assertEquals("Cheers! Everyone takes one.", model.getRule());
    }

    @Test
    public void testHell() {
        ArrayList<Integer> values = new ArrayList<>(2);
        TremanModel model = new TremanModel();
        values.add(5);
        values.add(6);
        model.getDice().setDiceValue(values);
        assertEquals("Hell! Pass the dice along.", model.getRule());
    }

    @Test
    public void testNewTreman() {
        ArrayList<Integer> values = new ArrayList<>(2);
        TremanModel model = new TremanModel();
        values.add(3);
        values.add(3);
        model.getDice().setDiceValue(values);
        assertEquals("New treman! Pick another player to be Treman.", model.getRule());
    }

    @Test
    public void testNineBehind() {
        ArrayList<Integer> values = new ArrayList<>(2);
        TremanModel model = new TremanModel();
        values.add(4);
        values.add(5);
        model.getDice().setDiceValue(values);
        assertEquals("Nine behind. Person behind you takes one.", model.getRule());
    }

    @Test
    public void testNoRuleFound() {
        ArrayList<Integer> values = new ArrayList<>(2);
        TremanModel model = new TremanModel();
        values.add(7);
        values.add(8);
        model.getDice().setDiceValue(values);
        assertEquals("No rule found.", model.getRule());
    }

    @Test
    public void testNoseTouch() {
        ArrayList<Integer> values = new ArrayList<>(2);
        TremanModel model = new TremanModel();
        values.add(1);
        values.add(4);
        model.getDice().setDiceValue(values);
        assertEquals("Touch your nose! Last one to do it takes one.", model.getRule());
    }

    @Test
    public void testNotSix() {
        ArrayList<Integer> values = new ArrayList<>(2);
        TremanModel model = new TremanModel();
        values.add(2);
        values.add(4);
        model.getDice().setDiceValue(values);
        assertEquals("Six is good, but not here.", model.getRule());
    }

    @Test
    public void testSevenAhead() {
        ArrayList<Integer> values = new ArrayList<>(2);
        TremanModel model = new TremanModel();
        values.add(1);
        values.add(6);
        model.getDice().setDiceValue(values);
        assertEquals("Seven ahead! Person in front of you takes one.", model.getRule());
    }

    @Test
    public void testTreman() {
        ArrayList<Integer> values = new ArrayList<>(2);
        TremanModel model = new TremanModel();
        values.add(1);
        values.add(3);
        model.getDice().setDiceValue(values);
        assertEquals("Treman! Treman takes one.", model.getRule());
    }
}
