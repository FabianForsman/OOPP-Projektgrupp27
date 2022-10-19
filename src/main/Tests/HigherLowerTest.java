import Model.CardGames.HigherLower.HigherLowerModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HigherLowerTest {


    @Test
    void testSetBoard(){
        HigherLowerModel game = new HigherLowerModel();
        game.setBoard();
        assertTrue(game.getStartingBoard().size() == 4);
        assertTrue(game.getStartingBoard().get(0).size() == 1);
        assertTrue(game.getStartingBoard().get(1).size() == 1);
        assertTrue(game.getStartingBoard().get(2).size() == 1);
        assertTrue(game.getStartingBoard().get(3).size() == 1);
    }

    @Test
    void testPlaceCard(){
        HigherLowerModel game = new HigherLowerModel();
        game.setBoard();
    }

}
