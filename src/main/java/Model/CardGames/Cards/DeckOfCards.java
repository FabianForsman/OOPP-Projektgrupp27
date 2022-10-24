package Model.CardGames.Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: Fabian Forsman
 */
public class DeckOfCards implements IDeckOfCards {
    private final List<Card> cards = new ArrayList<>();
    private final DiscardPile discardPile;

    /**
     * Constructor for the deck of cards.
     */
    public DeckOfCards() {
        createDeck();
        this.discardPile = new DiscardPile();
    }

    /**
     * Generates the deck with all 52 different cards.
     */
    private void createDeck() {
        for (Suits s : Suits.values()) {
            for (Ranks r : Ranks.values()) {
                Card card = new Card(s, r); //Instantiate a Card
                this.cards.add(card); //Adding card to the Deck
            }
        }
    }

    // Temp method for displaying all cards in console.
    public void showDeck() {
        for(Card c : this.cards) {
            c.DisplayCard();
        }
    }

    /**
     * Shuffles the deck.
     */
    public void shuffle() { //Shuffles the deck
        Collections.shuffle(this.cards);
    }

    /**
     * Discards a card from the deck and adds it to a discard-pile.
     * @param card
     */
    public void discardCard(Card card) {
        discardPile.discardCard(card); //Add card to discard pile
        this.cards.remove(card); //Remove card from deck
    }

    /**
     * Draws the top card.
     * @return
     */
    public Card drawCard(){
        return cards.remove(cards.size() - 1 );
    }

    public DiscardPile getDiscardPile() {
        return discardPile;
    }

    /**
     * Returns the discard-pile to the deck.
     */
    public void returnDiscardPile(){
        cards.addAll(0, discardPile.returnCardsToDeck());
    }

    /**
     * Returns a specific card to the deck.
     * @param card
     */
    public void returnCardToDeck(Card card){
        this.cards.add(card);
    }
}
