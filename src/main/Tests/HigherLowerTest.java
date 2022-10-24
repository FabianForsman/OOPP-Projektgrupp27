import Model.CardGames.Cards.Card;
import Model.CardGames.Cards.DeckOfCards;
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
        Card card = new DeckOfCards().drawCard();
        int rightIndex = 0;
        game.placeCard(card, 0, HigherLowerModel.Direction.LEFT);
        assertTrue(game.getStartingBoard().get(0).get(game.getStartingBoard().get(0).size()-1) == card);
        Card newCard = new DeckOfCards().drawCard();
        game.placeCard(newCard, 0, HigherLowerModel.Direction.RIGHT);
        assertTrue(game.getStartingBoard().get(0).get(rightIndex) == newCard);
        Card newNewCard = new DeckOfCards().drawCard();
        game.placeCard(newNewCard, 3, HigherLowerModel.Direction.LEFT);
        assertTrue(game.getStartingBoard().get(3).get(game.getStartingBoard().get(3).size()-1) == newNewCard);
    }


    @Test
    void testResetRow(){
        HigherLowerModel game = new HigherLowerModel();
        game.setBoard();
        Card card = new DeckOfCards().drawCard();
        game.placeCard(card, 0, HigherLowerModel.Direction.LEFT);
        Card newCard = new DeckOfCards().drawCard();
        game.placeCard(newCard, 0, HigherLowerModel.Direction.RIGHT);
        game.resetRow(0);
        assertTrue(game.getStartingBoard().get(0).size() == 0);
    }

    @Test
    void testplayerChoice(){
        HigherLowerModel game = new HigherLowerModel();
        game.setBoard();
        Card card = new DeckOfCards().drawCard();
        game.placeCard(card, 0, HigherLowerModel.Direction.LEFT);
        Card chosenCard = game.playerChoice(0, HigherLowerModel.Direction.LEFT);
        assertTrue(chosenCard == card);
        Card newCard = new DeckOfCards().drawCard();
        game.placeCard(newCard, 0, HigherLowerModel.Direction.RIGHT);
        chosenCard = game.playerChoice(0, HigherLowerModel.Direction.RIGHT);
        assertTrue(chosenCard == newCard);

    }

    @Test
    void testGetTotalCardsInRow(){
        HigherLowerModel game = new HigherLowerModel();
        game.setBoard();
        assertTrue(game.getTotalCardsInRow(0) == 1);
        Card card = new DeckOfCards().drawCard();
        game.placeCard(card, 0, HigherLowerModel.Direction.LEFT);
        assertTrue(game.getTotalCardsInRow(0) == 2);
        game.placeCard(card, 1, HigherLowerModel.Direction.LEFT);
        game.placeCard(card, 1, HigherLowerModel.Direction.LEFT);
        assertTrue(game.getTotalCardsInRow(1) == 3);
        game.resetRow(1);
        assertTrue(game.getTotalCardsInRow(1) == 0);

    }


    @Test
    void testCheckIfHigher(){
        HigherLowerModel game = new HigherLowerModel();
        game.setBoard();
        Card card = new DeckOfCards().drawCard();
        Card drawnCard = new DeckOfCards().drawCard();
        game.checkIfHigher(drawnCard.getRankValue(), card.getRankValue());
        if (card.getRankValue() < drawnCard.getRankValue()) {
            assertTrue(game.checkIfHigher(card.getRankValue(), drawnCard.getRankValue()));
        } else{
            assertTrue(game.checkIfHigher(card.getRankValue(), drawnCard.getRankValue()) == false);
        }
    }


    @Test
    void testProcessPlayerChoice(){
        HigherLowerModel game = new HigherLowerModel();
        game.setBoard();
        DeckOfCards deck = new DeckOfCards();
        Card card = deck.drawCard();
        game.placeCard(card, 0, HigherLowerModel.Direction.LEFT);
        Card placedCard = deck.drawCard();
        String result = game.processPlayerChoice(placedCard, 0, HigherLowerModel.Direction.LEFT);
        if (game.checkIfHigher(card.getRankValue(), placedCard.getRankValue())){
            assertTrue(result == "Correct, make your next choice");
        } else {
            String test = game.sendLossMessage(game.getStartingBoard().get(0).size());
            assertEquals(test, result);
        }
    }

}
