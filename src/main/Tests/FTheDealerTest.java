import Model.CardGames.Cards.Card;
import Model.CardGames.Cards.DeckOfCards;
import Model.CardGames.FTheDealer.FTheDealerBoard;
import Model.CardGames.FTheDealer.FTheDealerModel;
import Model.Player.Player;
import Model.Player.Players;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FTheDealerTest {

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
    void testSelectTableSpot(){
        FTheDealerModel game = new FTheDealerModel();
        game.selectTableSpot(7);
        assertEquals(game.getGuessedSpot(), 7);
    }

    @Test
    void testDrinkCalculator(){
        FTheDealerModel game = new FTheDealerModel();
        Card card = game.getDealerCard();
        game.selectTableSpot(7);
        game.setIncorrectGuesses(2);

        assertEquals("Too many incorrect guesses. " + Players.getInstance().getCurrentPlayerName() +" takes " + game.getDrinkCalculatorPlayer() + ".", game.drinkCalculator(card));
        }





    @Test
    void testIfFourCards() {
        FTheDealerModel game = new FTheDealerModel();
        FTheDealerBoard board = new FTheDealerBoard();
        game.selectTableSpot(7);
        game.placeCardOnBoard();
        game.placeCardOnBoard();
        game.placeCardOnBoard();
        game.placeCardOnBoard();
        assertEquals(game.checkIfFourCards(), "4 of the same! Turning " + game.getDealerCard().getRankValue() + " of " + game.getDealerCard().getSuit() + " over.");

    }

    @Test
    void testPlaceOnBoard() {
        FTheDealerModel game = new FTheDealerModel();
        FTheDealerBoard board = new FTheDealerBoard();
        Card card = game.getDealerCard();
        game.selectTableSpot(7);
        game.placeCardOnBoard();

        assertEquals(card, board.getBoard().);
    }

    @Test
    void testLowerCard(){
        FTheDealerModel game = new FTheDealerModel();
        Card card = game.getDealerCard();
        game.selectTableSpot(7);

        if (card.getRankValue() < game.getGuessedSpot()) {
            assertSame("Correct card is lower!", game.higherOrLower());
        } else if (card.getRankValue() > game.getGuessedSpot()) {
            assertSame("Correct card is higher!", game.higherOrLower());
        } else{
            assertSame("Correct!  " + Players.getInstance().getCurrentPlayerName() + " hands out 5 drinks", game.higherOrLower());

        }
    }
}










