package Model.Cards;

public interface IDeckOfCards {
    void showDeck();
    void shuffle();
    void discardCard(Card card);
    Card drawCard();
    DiscardPile getDiscardPile();
    void returnDiscardPile();
}
