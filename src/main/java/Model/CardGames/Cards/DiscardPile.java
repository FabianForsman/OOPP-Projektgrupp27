package Model.CardGames.Cards;

import java.util.ArrayList;
import java.util.List;

public class DiscardPile {
    private List<Card> cards = new ArrayList<>();

    public DiscardPile() {

    }
    void discardCard(Card card) {
        cards.add(card);
    }

    public List<Card> returnCardsToDeck() {
        List<Card> returnList = new ArrayList<>(cards);
        cards.clear();
        return returnList;
    }
}
