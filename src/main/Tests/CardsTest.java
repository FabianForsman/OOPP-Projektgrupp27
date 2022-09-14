import Model.CardGames.Cards.DeckOfCards;
import Model.CardGames.Cards.IDeckOfCards;
import org.junit.jupiter.api.Test;

public class CardsTest {
    @Test
    public static void tests(){ //Wrong way of doing tests. Will be changed into functional decomposition.
        IDeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        System.out.println("----------Shuffled deck----------");
        deck.showDeck();
        for(int i = 0; i < 40; i++)
            deck.discardCard(deck.drawCard());
        System.out.println("Removed 40 cards from the deck.");
        deck.showDeck();
        deck.returnDiscardPile();
        System.out.println("Returned the discard pile to the deck.");
        deck.showDeck();
    }
}
