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
        Card card = new DeckOfCards().drawCard();
        int leftIndex = game.getStartingBoard().get(0).size()-1;
        int rightIndex = 0;
        game.placeCard(card, 0, HigherLowerGame.Direction.LEFT);
        assertTrue(game.getStartingBoard().get(0).get(leftIndex) == card);
        Card newCard = new DeckOfCards().drawCard();
        game.placeCard(newCard, 0, HigherLowerGame.Direction.RIGHT);
        assertTrue(game.getStartingBoard().get(0).get(rightIndex) == newCard);
        Card newNewCard = new DeckOfCards().drawCard();
        game.placeCard(newNewCard, 3, HigherLowerGame.Direction.LEFT);
        assertTrue(game.getStartingBoard().get(3).get(leftIndex) == newNewCard);
    }


    @Test
    void testResetRow(){
        HigherLowerGame game = new HigherLowerGame();
        game.setBoard();
        Card card = new DeckOfCards().drawCard();
        int leftIndex = game.getStartingBoard().get(0).size()-1;
        int rightIndex = 0;
        game.placeCard(card, 0, HigherLowerGame.Direction.LEFT);
        Card newCard = new DeckOfCards().drawCard();
        game.placeCard(newCard, 0, HigherLowerGame.Direction.RIGHT);
        game.resetRow(0);
        assertTrue(game.getStartingBoard().get(0).size() == 0);
    }

    @Test
    void testplayerChoice(){
        HigherLowerGame game = new HigherLowerGame();
        game.setBoard();
        Card card = new DeckOfCards().drawCard();

    }

}
