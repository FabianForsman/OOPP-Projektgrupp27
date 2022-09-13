package Model.Cards;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards implements IDeckOfCards {
    private final List<Card> cards = new ArrayList<>();

    public DeckOfCards() {
        for (Suits s : Suits.values())
            for (Ranks r : Ranks.values()){
            Card card = new Card(s,r); //Instantiate a Card
            this.cards.add(card); //Adding card to the Deck
        }
    }

    public void ShowDeck() {
        for(Card c : cards){
            c.DisplayCard();
        }
    }
}
