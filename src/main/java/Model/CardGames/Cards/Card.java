package Model.CardGames.Cards;

/**
 * Enum for the suit a card has.
 */
enum Suits {
    HEARTS,
    DIAMONDS,
    SPADES,
    CLUBS
}

/**
 * Enum for the rank a card has.
 */
enum Ranks {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING
}


public class Card {

    private final Suits suit;
    private final Ranks rank;

    /**
     * Constructor of a card.
     * @param suit
     * @param rank
     */
    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    //Temp function to display a card in console.
    public void DisplayCard() {
        System.out.println(suit + " " + rank + " " + (rank.ordinal() + 1));
    }

    public Suits getSuit() {
        return suit;
    }

    public Ranks getRank() {
        return rank;
    }

    public int getRankValue() {return rank.ordinal()+1;}

}
