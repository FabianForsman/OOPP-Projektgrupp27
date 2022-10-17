package Model.CardGames.Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards implements IDeckOfCards {
    private final List<Card> cards = new ArrayList<>();
    private final DiscardPile discardPile;

    public DeckOfCards() {
        createDeck();
        this.discardPile = new DiscardPile();
    }

    private void createDeck() {
        for (Suits s : Suits.values()) {
            for (Ranks r : Ranks.values()) {
                Card card = new Card(s, r); //Instantiate a Card
                this.cards.add(card); //Adding card to the Deck
            }
        }
    }

    public void showDeck() {
        for(Card c : this.cards) {
            c.DisplayCard();
        }
    }

    public void shuffle() { //Shuffles the deck
        Collections.shuffle(this.cards);
    }

    public void discardCard(Card card) {
        discardPile.discardCard(card); //Add card to discard pile
        this.cards.remove(card); //Remove card from deck
    }

    public Card drawCard(){
        return cards.remove(cards.size() - 1 );
    }

    public DiscardPile getDiscardPile() {
        return discardPile;
    }

    public void returnDiscardPile(){
        cards.addAll(0, discardPile.returnCardsToDeck());
    }

    public void returnCardToDeck(Card card){
        this.cards.add(card);
    }
}
