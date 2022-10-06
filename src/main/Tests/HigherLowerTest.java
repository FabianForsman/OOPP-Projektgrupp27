import Model.CardGames.Cards.Card;
import Model.CardGames.Cards.DeckOfCards;

import Model.CardGames.HigherLower.HigherLowerGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HigherLowerTest {


    @Test
    void testSetBoard(){
        HigherLowerGame game = new HigherLowerGame();
        game.setBoard();
        assertTrue(game.getStartingBoard().size() == 4);
        assertTrue(game.getStartingBoard().get(0).size() == 1);
        assertTrue(game.getStartingBoard().get(1).size() == 1);
        assertTrue(game.getStartingBoard().get(2).size() == 1);
        assertTrue(game.getStartingBoard().get(3).size() == 1);
    }

    @Test
    void testPlaceCard(){
        HigherLowerGame game = new HigherLowerGame();
        game.setBoard();
    }

}
